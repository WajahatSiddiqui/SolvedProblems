package com.wajahat.logger;

public class ConsoleAppender implements LogAppender {

    private final LogFormatter logFormatter;
    public ConsoleAppender(LogFormatter logFormatter) {
        this.logFormatter = logFormatter;
    }

    @Override
    public void append(LogEntry entry) {
        System.out.println(this.logFormatter.format(entry));
    }

    @Override
    public void close() {
        // Nothing to close
    }
    
}
