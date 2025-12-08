package com.wajahat.logger;
public class DebugLogger extends LogHandler {
    
    public DebugLogger() {
        this.level = LogLevel.DEBUG;
    }

    public void publishLog(String message, LogSubject subject) {
        String msg = "Debug " + message;
        subject.notify(LogLevel.DEBUG, msg);
    }
}
