package com.wajahat.ratelimiter;

import java.util.concurrent.atomic.AtomicLong;

public class TokenBucketRateLimiter {
    private final long capacity;          // Maximum tokens (burst capacity)
    private final double refillRate;      // Tokens per millisecond
    private final AtomicLong tokens;      // Current available tokens (scaled by 1000)
    private final AtomicLong lastRefillTime;
    
    /**
     * @param capacity Maximum burst size
     * @param tokensPerSecond Rate of token generation
     */
    public TokenBucketRateLimiter(long capacity, double tokensPerSecond) {
        this.capacity = capacity;
        this.refillRate = tokensPerSecond / 1000.0; // Convert to per millisecond
        this.tokens = new AtomicLong(capacity * 1000); // Scale up for precision
        this.lastRefillTime = new AtomicLong(System.currentTimeMillis());
    }
    
    public boolean allowRequest() {
        return allowRequest(1);
    }
    
    public boolean allowRequest(long requestTokens) {
        refillTokens();
        
        // Try to consume tokens atomically
        long currentTokens = tokens.get();
        long requiredTokens = requestTokens * 1000; // Scale up
        
        while (currentTokens >= requiredTokens) {
            if (tokens.compareAndSet(currentTokens, currentTokens - requiredTokens)) {
                return true; // Successfully consumed tokens
            }
            currentTokens = tokens.get(); // Retry with updated value
        }
        
        return false; // Not enough tokens
    }
    
    private void refillTokens() {
        long now = System.currentTimeMillis();
        long lastRefill = lastRefillTime.get();
        long elapsedTime = now - lastRefill;
        
        if (elapsedTime > 0) {
            // Calculate tokens to add based on elapsed time
            long tokensToAdd = (long) (elapsedTime * refillRate * 1000);
            
            if (tokensToAdd > 0 && lastRefillTime.compareAndSet(lastRefill, now)) {
                long currentTokens = tokens.get();
                long maxTokens = capacity * 1000;
                long newTokens = Math.min(maxTokens, currentTokens + tokensToAdd);
                tokens.set(newTokens);
            }
        }
    }
    
    public double getAvailableTokens() {
        refillTokens();
        return tokens.get() / 1000.0;
    }
    
    public long getCapacity() {
        return capacity;
    }


    public static void main(String[] args) {
        TokenBucketRateLimiter tokenBucketRateLimiter = new TokenBucketRateLimiter(5, 0.6);

        for (int i = 0; i < 10; i++) {
            if (tokenBucketRateLimiter.allowRequest()) {
                System.out.println("Request # " + i + " allowed !");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.err.println("Thread interrupted: " + e.getMessage());
                }
            } else {
                System.out.println("Request Denied -> Too many requests");

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.err.println("Thread interrupted: " + e.getMessage());
                }
            }
        }
    }
    
}
