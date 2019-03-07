package com.wajahat.synchronization;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPool {

    private static class Processor implements Runnable {
        private int id;
        public Processor(int id) {
            this.id = id;
        }
        @Override
        public void run() {
            System.out.println("Starting: " + id);

            try {
                System.out.println("Processing: " + id);
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            System.out.println("Completed: " + id);
        }
    }

    public static void main(String[] args) {
        // create two factory worker threads
        // ExecutorService executor = Executors.newFixedThreadPool(4);
        ExecutorService executor = Executors.newSingleThreadExecutor();
        long start = System.currentTimeMillis();
        // if one thread is handling assign another thread
        for (int i = 0; i < 5; i++) {
            executor.submit(new Processor(i));
        }

        //  hence forth, no new tasks will be accepted
        executor.shutdown();

        System.out.println("All tasks submitted.");

        try {
            executor.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();

        System.out.println("All tasks completed. Time taken = " + (end-start) + " msecs");
    }
}
