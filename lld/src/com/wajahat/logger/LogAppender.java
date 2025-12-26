package com.wajahat.logger;
public interface LogAppender {
    void append(LogEntry entry);
    void close();
}
