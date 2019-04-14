package com.wajahat.synchronization;
import java.util.Scanner;

class Processor extends Thread {
    // On some systems the thread will cache this variable
    // in order to avoid caching and guaranteed running properly
    // use volatile.
    private volatile boolean running  = true;
    @Override
    public void run() {
        while (running) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Hello");
        }
    }

    public void shutdown() {
        running = false;
    }
}

public class ThreadSyncronization {

    public static void main(String[] args) {
        Processor processor = new Processor();
        processor.start();

        System.out.println("Hit return to stop this thread !");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine(); // wait for return

        processor.shutdown();
        scanner.close();

    }
}
