package com.wajahat.logger;
public enum LogLevel {
    INFO(0), DEBUG(1), WARN(2), ERROR(3), FATAL(4);

    private final int priority;

    LogLevel(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }
}
