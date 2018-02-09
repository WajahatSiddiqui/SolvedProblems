package com.wajahat.design.executorservice;

import java.util.List;
import java.util.concurrent.TimeUnit;

public interface ExecutorService extends Executor {
	void shutdown();
	List<Runnable> shutdownNow();	
	boolean isShutdown();
	boolean awaitTermination(long timeout, TimeUnit unit)
	        throws InterruptedException;
	void submit(Runnable task) throws NullPointerException;
}
