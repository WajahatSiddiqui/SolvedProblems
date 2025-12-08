package com.wajahat.lld;
import java.util.concurrent.atomic.AtomicInteger;

public class SimpleRateLimiter {
    // State tracking
    private AtomicInteger requestCount;
    private long windowStartTime;

    // Configuration
    private final int maxRequest;
    private final long timeWindowMillis;

    public SimpleRateLimiter(int maxRequest, long timeWindowMillis) {
        this.maxRequest = maxRequest;
        this.timeWindowMillis = timeWindowMillis;
        this.requestCount =  new AtomicInteger(0);
        this.windowStartTime = System.currentTimeMillis();
    }

    public synchronized boolean allowedRequest() {
        long now = System.currentTimeMillis();

        // Check if window expired -> reset the count
        if (now-windowStartTime > this.timeWindowMillis) {
            requestCount.set(0);
            windowStartTime = now;
        }

        // check if its under limit
        if (requestCount.get() < maxRequest) {
            requestCount.incrementAndGet();
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        SimpleRateLimiter simpleRateLimiter = new SimpleRateLimiter(5, 600);

        for (int i = 0; i < 10; i++) {
            if (simpleRateLimiter.allowedRequest()) {
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
