package com.wajahat.lrucache;

import org.junit.Test;

/**
 * Testing MultiThreaded LRU Cache
 * Created by Wajahat
 **/
public class MultiThreadedLruCacheTest {
    private static final int NUM_THREADS = 10;
    private static final int CAPACITY = 4;
    private static class Runner implements Runnable {
        private MultiThreadedLruCache<Integer, String> cache;
        private int id;
        public Runner(int id, MultiThreadedLruCache<Integer, String> cache) {
            this.cache = cache;
            this.id = id;
        }
        @Override
        public void run() {
            System.out.println("Running inside ThreadId: " + id);
            int i = 0;
            while (i < 4) {
                cache.put(i, "a");
                i++;
            }
        }
    }

    @Test
    public void testMultiThreadedLRU() throws InterruptedException {
        // Shared memory for all the threads !
        MultiThreadedLruCache<Integer, String> cache = new MultiThreadedLruCache<>(CAPACITY);

        Thread []t = new Thread[NUM_THREADS];
        for (int i = 0; i < NUM_THREADS; i++) {
            t[i] = new Thread(new Runner(i+1, cache));
            t[i].start();
        }

        // wait for the threads to work !
        for (int i = 0; i < NUM_THREADS; i++) {
            t[i].join();
        }

        System.out.println(cache);
    }
}
