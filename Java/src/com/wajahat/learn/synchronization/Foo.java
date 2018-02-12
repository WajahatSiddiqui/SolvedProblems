package com.wajahat.learn.synchronization;
import java.util.concurrent.Semaphore;


public class Foo {
	private static final int MAX_OPR = 1;
	Semaphore s_a, s_b, s_c;
	Foo() {
		s_a = new Semaphore(1);
		s_b = new Semaphore(1);	
		s_c = new Semaphore(1);
	}
	
	private void doOperation(final String method) {
		Runnable R = new Runnable() {
			@Override
			public void run() {
				int count = 0;
				while (count != MAX_OPR) {
					System.out.println("Running "+method+" count: "+count++);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		new Thread(R).start();
	}
	
	public void A() {
		try {
			s_c.acquire(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		doOperation("A");
		s_a.release(1);
	}
	public void B() {
		try {
			s_a.acquire(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		doOperation("B");
		s_b.release(1);
	}
	public void C() {
		try {
			s_b.acquire(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		doOperation("C");
		s_c.release(1);
	}
}
