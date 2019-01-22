package com.wajahat.synchronization;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class CountdownLatch {
	
	private static class Processor implements Runnable {
		private CountDownLatch latch;
		private int id;
		
		public Processor(CountDownLatch latch, int id) {
			this.latch = latch;
			this.id = id;
		}
		
		@Override
		public void run() {
			System.out.println("Started : " + id);
			
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Completed : " + id);
			latch.countDown();
		}
		
	}
	
	public static void main(String[] args) {
		CountDownLatch latch = new CountDownLatch(3);
		ExecutorService executor = Executors.newFixedThreadPool(3);
		System.out.println("All tasks submitted.");		
		for (int i = 0; i < 3; i++) {
			executor.submit(new Processor(latch, i));
		}
		executor.shutdown();
		
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("All tasks completed.");
	}

}
