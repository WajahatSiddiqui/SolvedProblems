package com.wajahat.logger;
public class ErrorLogger extends LogHandler {
  
    public ErrorLogger() {
        this.level = LogLevel.ERROR;
    }

    public void publishLog(String message, LogSubject subject)
}
