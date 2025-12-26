package com.wajahat.logger;
public class DefaultLogFormat implements LogFormatter {
    @Override
    public String format(LogEntry entry) {
        return String.format("[%d] [%s] [%s] [%s] - %s",
                entry.getTimestamp(),
                entry.getLevel(),
                entry.getThreadName(),
                entry.getClassName(),
                entry.getMessage());
    } 
}
