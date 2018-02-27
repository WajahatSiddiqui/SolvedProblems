package com.wajahat.learn.synchronization;

import java.util.HashMap;
import java.util.Map;

public class TwoThreads {

	private static Map<Integer, String> map = new HashMap<>();

	private static class Processor implements Runnable {
		private String name;
		public Processor(String name) {
			this.name = name;
		}
		@Override
		public void run() {
			System.out.println("Running thread " + name);
			int key = Integer.valueOf(name.charAt(1)); 
			map.put(key, name);
			try {
				Thread.sleep(3000);
				
				System.out.println("Value of hashmap: " + map.get(key));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private void printMap() {
		for (Map.Entry<Integer, String> e : map.entrySet()) {
			System.out.println(e.getKey() + " " + e.getValue());
		}
	}

	public static void main(String[] args) {
		TwoThreads obj = new TwoThreads();
		Thread t1 = new Thread(new Processor("t1"));
		Thread t2 = new Thread(new Processor("t2"));

		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch(InterruptedException e) {

		}
		System.out.println("t1 & t2 finished!!!");
		obj.printMap();
		
	}
}
