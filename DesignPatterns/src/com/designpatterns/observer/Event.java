package com.designpatterns.observer;

import java.util.ArrayList;
import java.util.List;

public class Event {
    private List<EventCallback> callbacks = new ArrayList<>();
    private Object sync = new Object();

    // main thread
    public void add(EventCallback callback) {
        synchronized (sync) {
            if (!callbacks.contains(callback)) {
                callbacks.add(callback);
            }
        }
    }

    // main thread
    public void remove(EventCallback callback) {
        synchronized (sync) {
            if (callbacks.contains(callback)) {
                callbacks.remove(callback);
            }
        }
    }

    // may be called in secondary thread
    public void raise(Object sender, Object data) {
        synchronized (sync) {
            for (EventCallback callback : callbacks) {
                callback.send(sender, data);
            }
        }
    }
}
