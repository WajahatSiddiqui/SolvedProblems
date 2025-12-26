package com.wajahat.logger;

import java.util.List;

public class Logger {

    private final String name;
    private LogLevel minLevel;
    private final List<LogAppender> appenders;
    private final AsyncLogProcessor asyncLogProcessor;
    private boolean isAsync;

    public Logger(String name, LogLevel minLevel, List<LogAppender> appenders, AsyncLogProcessor asyncLogProcessor, boolean isAsync) {
        this.name = name;
        this.minLevel = minLevel;
        this.appenders = appenders;
        this.asyncLogProcessor = asyncLogProcessor;
        this.isAsync = isAsync;
    }

    private void log(LogLevel level, String message) {
        if (level.getPriority() < minLevel.getPriority()) {
            return; // below threshold
        }

        LogEntry entry = new LogEntry(level, message, name);

        if (isAsync && asyncLogProcessor != null) {

            boolean enqueued = asyncLogProcessor.enqueue(entry);
            if (!enqueued) {
                System.err.println("Log Dropped due to queue overflow");
            }

        } else {
            // Synchronous Logging 
            if (appenders != null) {
                for (LogAppender appender : appenders) {
                    appender.append(entry);
                }
            }
        }
    }

    public void info(String message) { log(LogLevel.INFO, message); }
    public void debug(String message) { log(LogLevel.DEBUG, message); }
    public void warn(String message) { log(LogLevel.WARN, message); }
    public void error(String message) { log(LogLevel.ERROR, message); }
    public void fatal(String message) { log(LogLevel.FATAL, message); }

    public void setMinLevel(LogLevel minLevel) {
        this.minLevel = minLevel;
    }
    
}
