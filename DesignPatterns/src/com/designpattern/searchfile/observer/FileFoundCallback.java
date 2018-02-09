package com.designpattern.searchfile.observer;

@FunctionalInterface
public interface FileFoundCallback {
	void found(String path);
}
