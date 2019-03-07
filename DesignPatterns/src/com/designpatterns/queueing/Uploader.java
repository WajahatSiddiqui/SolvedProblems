package com.designpatterns.queueing;

import java.util.ArrayDeque;
import java.util.Queue;

// Any operation > 50 ms is called long running operation

public class Uploader {
    private Queue<String> queue = new ArrayDeque<String>();
    private Thread uploadThread;
    private Object waitObj = new Object();
    public Uploader() {
        // if its a static method used class name
        uploadThread = new Thread(this::uploadToServer);
        uploadThread.start();
    }


    // main thread
    public void uploadToQueue(String filename) {
        queue.add(filename);
        System.out.println(filename + " queued");
        // signalling object to come out of wait state
        synchronized (waitObj) {
            waitObj.notify();
        }
    }

    // secondary thread
    // when the funtion ends secondary thread will die
    public void uploadToServer() {
        // to keep the secondary thread alive
        while(true) {
            // when queue is empty
            if (queue.isEmpty()) {
                synchronized (waitObj) {
                    try {
                        // secondary thread goes to efficient wait state
                        waitObj.wait();
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
                String filename = queue.poll();
                // ToDo: Start upload the file to the server
                System.out.println("Uploading the file " + filename+ " in progress...");
                try {
                    // Simulation of upload
                    Thread.sleep(5000);
                    System.out.println(filename+ " uploaded");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
