import jdk.nashorn.internal.ir.Block;

import java.util.Random;

/**
 * Class App which will create Producer Consumer using BlockingQueue
 * Created by wajahat
 */
public class BlockingQueueApp {

    private static class Producer implements Runnable {
        private BlockingQueue<Integer> bq;

        Producer(BlockingQueue<Integer> bq) {
            this.bq = bq;
        }

        @Override
        public void run() {
            Random random = new Random();
            while (true) {
                Integer value = random.nextInt(100);
                System.out.println("Producer: " + value + " queue size: " + bq.size());
                bq.add(value);
            }
        }
    }

    private static class Consumer implements Runnable {
        private BlockingQueue<Integer> bq;

        Consumer(BlockingQueue<Integer> bq) {
            this.bq = bq;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Random random = new Random();
            while (true) {
                if (random.nextInt(100) == 0) {
                    System.out.println("Consumer: " + bq.poll() + " queue size: " + bq.size());
                }
            }
        }
    }

    public static void main(String args[]) {
        BlockingQueue<Integer> bq = new BlockingQueue<>(4);

        Thread producer = new Thread(new Producer(bq));
        Thread consumer = new Thread(new Consumer(bq));

        producer.start();
        consumer.start();

        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
