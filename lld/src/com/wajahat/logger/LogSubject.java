package com.wajahat.logger;

import java.util.ArrayList;

public class LogSubject {
    private final List<LogObserver> observers;

    public LogSubject() {
        observers = new ArrayList<>();
    }
    public void addObserver(LogObserver observer) {
        this.observers.add(observer);
    }
    public void removeObserver(LogObserver observer) {
        this.observers.remove(observer);
    }
    public void notify(LogLevel level, String message) {
        for (LogObserver observer : this.observers) {
            observer.log(message);
        }
    }
}
