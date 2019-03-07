package com.designpatterns.state;

import java.util.ArrayList;
import java.util.List;

public class Event {

    private List<EventListener> listeners = new ArrayList<>();
    private Object sync = new Object();

    // main thread
    public void add(EventListener callback) {
        synchronized (sync) {
            if (!listeners.contains(callback)) {
                listeners.add(callback);
            }
        }
    }

    // main thread
    public void remove(EventListener callback) {
        synchronized (sync) {
            if (listeners.contains(callback)) {
                listeners.remove(callback);
            }
        }
    }

    // may be called in secondary thread
    public void raise(Object sender, Object data) {
        synchronized (sync) {
            // Iterator
            for (EventListener listener : listeners) {
                listener.send(sender, data);
            }
        }
    }
}
