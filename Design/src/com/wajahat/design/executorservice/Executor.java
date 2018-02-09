package com.wajahat.design.executorservice;

import java.util.concurrent.RejectedExecutionException;

public interface Executor {
	void execute(Runnable command) throws NullPointerException, RejectedExecutionException;
}
