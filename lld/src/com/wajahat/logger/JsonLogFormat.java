package com.wajahat.logger;
public class JsonLogFormat implements LogFormatter {
    
    @Override
    public String format(LogEntry entry) {
        return String.format("{\"timestamp\":%d,\"level\":\"%s\",\"thread\":\"%s\",\"class\":\"%s\",\"message\":\"%s\"}",
                entry.getTimestamp(),
                entry.getLevel(),
                entry.getThreadName(),
                entry.getClassName(),
                entry.getMessage());
    }
}
