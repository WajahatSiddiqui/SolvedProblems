package com.wajahat.logger;

public abstract class LogHandler {
    private LogHandler nextLogHandler;
    public LogLevel level;

    public void setNextLogHandler(LogHandler nexHandler) {
        this.nextLogHandler = nexHandler;
    }

    public void log(LogLevel level, LogSubject logSubject, String message) {
        if (this.level.getLevel() == level.getLevel()) {
            publishLog(message);
        }

        if (nextLogHandler != null) {
            nextLogHandler.log(level, logSubject, message);
        }
    }

    public abstract void publishLog(String message, LogSubject subject);
}
