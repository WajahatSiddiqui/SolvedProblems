package com.wajahat.logger;
public class LogEntry {
    private final LogLevel level;
    private final long timestamp;
    private final String message;
    private final String threadName;
    private final String className;

    public LogEntry(LogLevel level, String message, String className) {
        this.timestamp = System.currentTimeMillis();
        this.level = level;
        this.message = message;
        this.threadName = Thread.currentThread().getName();
        this.className = className;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public LogLevel getLevel() {
        return level;
    }

    public String getMessage() {
        return message;
    }

    public String getThreadName() {
        return threadName;
    }

    public String getClassName() {
        return className;
    }
}
