package com.wajahat.logger;

public class InfoLogger extends LogHandler {

    public InfoLogger(LogLevel level) {
        this.level = level;
    }

    @Override
    public void publishLog(String message, LogSubject subject) {
        String msg = "Info: " + message;
        subject.notify(LogLevel.INFO, msg);
    }
    
}
