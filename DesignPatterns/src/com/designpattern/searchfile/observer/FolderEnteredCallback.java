package com.designpattern.searchfile.observer;

@FunctionalInterface
public interface FolderEnteredCallback {
	// signature can be different
	void entered(String folder, String time);
}
