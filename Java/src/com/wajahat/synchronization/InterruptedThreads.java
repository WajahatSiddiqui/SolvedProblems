package com.wajahat.synchronization;

import java.util.Random;

public class InterruptedThreads {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Random random = new Random();

                for (int i = 0; i < 1E8; i++) {
                    /*if (Thread.currentThread().isInterrupted()) {
                        System.out.println("Interrupted!");
                        break;
                    }*/
                    Math.sin(random.nextDouble());
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        System.out.println("Interrupted ! " + e.getMessage());
                        break;
                    }
                }
            }
        });
        thread.start();
        System.out.println("Started.");
        thread.interrupt();
        Thread.sleep(500);
        thread.join();
        System.out.println("Finished.");
    }
}
