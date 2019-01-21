package com.wajahat.hackerrank.learn.synchronization;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPoolNew {
	
	private static class Task implements Runnable {
		private String name;
		
		public Task(String name) {
			this.name = name;
		}
		@Override
		public void run() {
			try {
				System.out.println("Running task: " + name);
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
			System.out.println(name + " completed");
		}
	}
	
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		long start = System.currentTimeMillis();
		System.out.println("Submitting all tasks in executor");
		for (int i = 0; i < 5; i++) {
			executorService.submit(new Task("task " + (i+1)));
		}
		executorService.shutdown();
		
		try {
			executorService.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		System.out.println("All tasks completed in : " + (end-start) + " msecs");
	}
}
