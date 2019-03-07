package com.designpatterns.state;

@FunctionalInterface
public interface EventListener {
    // for multiple arguments bundle it in one object and pass it
    void send(Object sender, Object data);
}
