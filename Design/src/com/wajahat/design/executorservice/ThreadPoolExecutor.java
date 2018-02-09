package com.wajahat.design.executorservice;

import java.util.HashSet;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadPoolExecutor implements ExecutorService {

	private BlockingQueue<Runnable> queue;
	private int corePoolSize;
	private ReentrantLock lock;
	private final HashSet<Worker> workers = new HashSet<Worker>();
	private final Condition termination = lock.newCondition();

	public ThreadPoolExecutor(int nThreads) {
		this.corePoolSize = nThreads;
		queue = new LinkedBlockingQueue<Runnable>(nThreads);
		lock = new ReentrantLock();
	}

	@Override
	public void execute(Runnable command) throws NullPointerException, RejectedExecutionException {
		if (command == null) {
			throw new NullPointerException("command is null");
		}

		if (workers.size() < corePoolSize) {
			try {
				addWorker(command);
			} catch (InterruptedException e) {

			}
		} else {
			for (Worker w : workers) {
				if (!w.isRunning()) {
					queue.remove(w.task);
				}
			}
		}
	}

	@Override
	public void shutdown() {
		lock.lock();
		for (Worker w : workers) {
			Thread t = w.thread;
			try {
				if (!t.isInterrupted())
					t.interrupt();
			} finally {
				lock.unlock();
			}
		}
	}

	@Override
	public List<Runnable> shutdownNow() {
		return null;
	}

	@Override
	public boolean isShutdown() {
		return !isRunning();
	}

	private boolean isRunning() {
		return false;				
	}

	@Override
	public boolean awaitTermination(long timeout, TimeUnit unit)
			throws InterruptedException {
        long nanos = unit.toNanos(timeout);
        final ReentrantLock mainLock = this.lock;
        mainLock.lock();
        try {
            for (;;) {
                if (runStateAtLeast(ctl.get(), TERMINATED))
                    return true;
                if (nanos <= 0)
                    return false;
                nanos = termination.awaitNanos(nanos);
            }
        } finally {
            mainLock.unlock();
        }
	}

	@Override
	public void submit(Runnable task) throws NullPointerException {
		if (task == null) {
			throw new NullPointerException("task is null");
		}
		execute(task);
	}

	private void addWorker(Runnable command) throws InterruptedException {
		Worker w = new Worker(command);
		workers.add(w);
		w.run();
	}
	
	private final class Worker {
		private Thread thread;
		private Runnable task;
		private ThreadState state = ThreadState.NEW;
		public Worker(Runnable task) {
			this.task = task;
			if (queue.offer(task)) {
				thread = new Thread(task);
			}
		}

		public void run() {
			if (thread == null) { throw new RejectedExecutionException("cannot run"); }
			thread.start();
			state = ThreadState.RUNNING;
			try {
				thread.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				workers.remove(this);
				state = ThreadState.STOP;
			}
		}
		
		public boolean isRunning() {
			return state.equals(ThreadState.RUNNING);
		}
	}

}
