package com.wajahat.learn.synchronization;

import java.util.LinkedList;
import java.util.Random;

public class LowLevelSyncUsingWaitNotify {
	
	private static class Processor {
		private LinkedList<Integer> list = new LinkedList<Integer>();
		private int LIMIT = 10;
		private Object lock = new Object();
		
		public void produce() throws InterruptedException {
			int value = 0;
			while (true) {
				synchronized (lock) {
					while (list.size() == LIMIT) {
						lock.wait();						
					}
					list.add(value++);
					lock.notify();
				}
			}
		}
		
		public void consume() throws InterruptedException {
			Random random = new Random();
			while (true) {
				synchronized (lock) {
					while (list.isEmpty()) {
						lock.wait();
					}
					System.out.print("List size is: " + list.size());
					int value = list.removeFirst();
					System.out.println("; value is: "+ value);
					lock.notify();
				}
				Thread.sleep(random.nextInt(1000));
			}
		}
	}
	
	public static void main(String[] args) {
		final Processor processor = new Processor();
		Thread producer = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					processor.produce();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		Thread consumer = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					processor.consume();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
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
