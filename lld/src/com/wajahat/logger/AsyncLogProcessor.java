package com.wajahat.logger;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class AsyncLogProcessor implements Runnable {

    private final BlockingQueue<LogEntry> logQueue;
    private final List<LogAppender> appenders;
    private volatile boolean running  = true;

    private static final int QUEUE_CAPACITY = 100;
    private final boolean dropOnFull;

    public AsyncLogProcessor(List<LogAppender> appenders, boolean dropOnFull) {
        this.logQueue = new ArrayBlockingQueue<LogEntry>(QUEUE_CAPACITY);
        this.appenders = appenders;
        this.dropOnFull = dropOnFull;
    }

    public boolean enqueue(LogEntry entry) {

        if (dropOnFull) { // Non Blocking - drop log if queue is full (favor latency)
            return logQueue.offer(entry);
        } else {
            try {
                logQueue.put(entry);
                return true;
            } catch (Exception e) {
                Thread.currentThread().interrupt();
                return false;
            }
        }
    }
    
    @Override
    public void run() {
        while (running || !logQueue.isEmpty()) {
            try {
                LogEntry entry = logQueue.poll(100, TimeUnit.MILLISECONDS);
                if (entry != null) {
                    for (LogAppender appender : appenders) {
                        try {
                            appender.append(entry);    
                        } catch (Exception e) {
                            System.err.println("Append failed " + e.getMessage());
                        }
                    }
                }
            } catch (Exception e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

    void shutdown() {
        running = false;
    }

    public int getQueueSize() {
        return logQueue.size();
    }
}
