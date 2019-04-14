package lock;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;

/**
 * Class Using MyLock Class
 * Created by wajahat
 */
public class MyLockApp {

    private static final int MAX_SIZE = 10;

    private static class Producer implements Runnable {

        private Queue<Integer> queue;
        private MyLock lock;
        private Random random = new Random();
        Producer(Queue<Integer> queue, MyLock lock) {
            this.queue = queue;
            this.lock = lock;
        }

        @Override
        public void run() {
            while(true) {
                while (queue.size() == MAX_SIZE) lock.lock();
                int val = random.nextInt(100);
                System.out.println("Producer: " + val);
                queue.add(val);
                lock.unLock();
            }
        }
    }

    private static class Consumer implements Runnable {
        private Queue<Integer> queue;
        private MyLock lock;
        Consumer(Queue<Integer> queue, MyLock lock) {
            this.queue = queue;
            this.lock = lock;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                while (queue.isEmpty()) lock.lock();
                System.out.println("Consumer: " + queue.poll());
                lock.unLock();
            }
        }
    }

    public static void main(String args[]) throws InterruptedException {
        Queue<Integer> queue = new ArrayDeque<>(MAX_SIZE);
        MyLock lock = new MyLock();

        Thread producer = new Thread(new Producer(queue, lock));
        Thread consumer = new Thread(new Consumer(queue, lock));

        producer.start();
        consumer.start();

        producer.join();
        consumer.join();
    }
}
