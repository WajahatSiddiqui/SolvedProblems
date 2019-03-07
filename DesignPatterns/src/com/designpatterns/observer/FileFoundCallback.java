package com.designpatterns.observer;

@FunctionalInterface
public interface FileFoundCallback {
    void found(String path);
}
