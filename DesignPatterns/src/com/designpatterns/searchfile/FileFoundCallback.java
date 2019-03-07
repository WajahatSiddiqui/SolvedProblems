package com.designpatterns.searchfile;

@FunctionalInterface
public interface FileFoundCallback {
    void found(String path);
}
