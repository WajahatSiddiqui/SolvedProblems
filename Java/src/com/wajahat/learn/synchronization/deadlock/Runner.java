package com.wajahat.learn.synchronization.deadlock;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Runner {

	private Account account1;
	private Account account2;

	private Lock lock1 = new ReentrantLock();
	private Lock lock2 = new ReentrantLock();

	public Runner() {
		account1 = new Account();
		account2 = new Account();
	}

	private void acquireLock(Lock first, Lock second) throws InterruptedException {
		while (true) {
			// acquire lock
			boolean gotFirst = false;
			boolean gotSecond = false;

			try {
				gotFirst = lock1.tryLock();
				gotSecond = lock2.tryLock();	
			} finally {
				if (gotFirst && gotSecond) {
					return;
				}

				if (gotFirst) {
					lock1.unlock();
				}

				if (gotSecond) {
					lock2.unlock();
				}
			}
			
			// locks not acquired
			Thread.sleep(1);
		}
	}

	public void firstThread() throws InterruptedException {
		Random random = new Random();
		for (int i = 0; i < 10000; i++) {
			/*lock1.lock();
			lock2.lock();*/
			acquireLock(lock1, lock2);
			try {
				Account.transfer(account1, account2, random.nextInt(100));
			} finally {
				lock1.unlock();
				lock2.unlock();
			}
		}
	}

	public void secondThread() throws InterruptedException {
		Random random = new Random();
		for (int i = 0; i < 10000; i++) {
			/*lock2.lock();
			lock1.lock();*/
			acquireLock(lock1, lock2);
			try {
				Account.transfer(account2, account1, random.nextInt(100));
			} finally {
				lock1.unlock();
				lock2.unlock();
			}
		}
	}

	public void finished() {
		System.out.println("Account 1 balance: " + account1.getBalance());
		System.out.println("Account 2 balance: " + account2.getBalance());
		System.out.println("Total balance: " + (account1.getBalance() + account2.getBalance()));
	}
}
