package com.wajahat.ratelimiter;

import java.util.LinkedList;
import java.util.Queue;

class SlidingWindowRateLimiter {
    private int maxRequests;
    private long windowSizeMs;
    private Queue<Long> requestLog;
    
    public SlidingWindowRateLimiter(int maxRequests, long windowSizeMs) {
        this.maxRequests = maxRequests;
        this.windowSizeMs = windowSizeMs;
        this.requestLog = new LinkedList<>();
    }
    
    public synchronized boolean allowRequest() {
        long now = System.currentTimeMillis();
        long windowStart = now - windowSizeMs;
        
        // Remove old requests outside window
        while (!requestLog.isEmpty() && requestLog.peek() < windowStart) {
            requestLog.poll();
        }
        
        if (requestLog.size() < maxRequests) {
            requestLog.offer(now);
            return true;
        }
        
        return false;
    }

    public static void main(String[] args) {
        SlidingWindowRateLimiter slidingWindowRateLimiter = new SlidingWindowRateLimiter(5, 600);

        for (int i = 0; i < 10; i++) {
            if (slidingWindowRateLimiter.allowRequest()) {
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