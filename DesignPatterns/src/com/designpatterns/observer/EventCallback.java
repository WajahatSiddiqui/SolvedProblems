package com.designpatterns.observer;

@FunctionalInterface
public interface EventCallback {
    // for multiple arguments bundle it in one object and pass it
    void send(Object sender, Object data);
}
