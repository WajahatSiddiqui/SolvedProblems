package com.wajahat.synchronization;

import java.util.Scanner;

public class WaitNotifyUsage {
	
	private static class Processor {
		public void produce() throws InterruptedException {
			synchronized (this) {
				System.out.println("Producer thread running ...");
				wait();
				System.out.println("Resumed.");
				
			}
			
		}
		
		public void consume() throws InterruptedException {
			Scanner scanner = new Scanner(System.in);
			Thread.sleep(2000);
			
			synchronized (this) {
				System.out.println("Waiting for return key");
				scanner.nextLine();
				System.out.println("Return key pressed.");
				notify();
				Thread.sleep(2000);
			}
		}
	}
	
	public static void main(String[] args) {
		final Processor processor = new Processor();
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					processor.produce();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					processor.consume();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
