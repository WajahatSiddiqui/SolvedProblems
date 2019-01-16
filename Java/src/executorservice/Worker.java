package executorservice;

import java.lang.ref.WeakReference;
import java.util.Objects;

/**
 * Class Worker class
 * Created by wajahat
 */
public class Worker {
    private int numThreads;
    private Thread []threads;
    private BlockingQueue<Callable<?>> queue;
    private boolean active;

    public Worker(int numThreads, int capacity) {
        this.numThreads = numThreads;
        threads = new Thread[numThreads];
        queue = new BlockingQueue<>(capacity);

        for(int i = 0; i < numThreads; i++) {
            threads[i] = new Thread(new Runner(this));
            threads[i].start();
        }
        active = true;
    }

    private BlockingQueue<Callable<?>> getQueue() {
        return queue;
    }

    public void addTask(Callable<?> task) {
        if (active) {
            queue.add(task);
        } else {
            throw new RuntimeException("cannot accept more tasks");
        }
    }

    public void shudown() {
        active = false;
    }

    private static class Runner implements java.lang.Runnable {
        private WeakReference<Worker> workerWeakReference;
        public Runner(Worker worker) {
            workerWeakReference = new WeakReference<>(worker);
        }

        @Override
        public void run() {
            if (workerWeakReference.get() == null) return;
            while (true) {
                try {
                    Callable<?> task = Objects.requireNonNull(workerWeakReference.get()).getQueue().poll();
                    //System.out.println("Runner executing: " + task);
                    System.out.println("TaskId: " + task.call() + " completed");
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
