package com.wajahat.hackerrank.learn.synchronization;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


public class ProducerConsumer {
	
	private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
	
	private static class Producer implements Runnable {
		private BlockingQueue<Integer> queue;
		public Producer(BlockingQueue<Integer> queue) {
			this.queue = queue;
		}
		@Override
		public void run() {
			
			Random random = new Random();
			while (true) {
				try {
					queue.put(random.nextInt(100));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}
	}
	
	private static class Consumer implements Runnable {
		private BlockingQueue<Integer> queue;
		public Consumer(BlockingQueue<Integer> queue) {
			this.queue = queue;
		}
		@Override
		public void run() {
			
			Random random = new Random();
			while (true) {
				try {
					Thread.sleep(100);
					if (random.nextInt(10) == 0) {
						Integer value = queue.take();
						System.out.println("Taken value: " + value + "; Queue size = " + queue.size());
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Thread producer = new Thread(new Producer(queue));
		Thread consumer = new Thread(new Consumer(queue));
		
		producer.start();
		consumer.start();
		
		try {
			producer.join();
			consumer.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
