package com.wajahat.logger;
public class RemoteAppender implements LogAppender {
    private final LogFormatter formatter;
    private final String endpoint;
    
    public RemoteAppender(String endpoint, LogFormatter formatter) {
        this.endpoint = endpoint;
        this.formatter = formatter;
    }
    
    @Override
    public void append(LogEntry entry) {
        // Mock: In real implementation, would use HTTP client or messaging queue
        String formattedLog = formatter.format(entry);
        // Simulate sending to remote endpoint
        System.out.println("REMOTE[" + endpoint + "]: " + formattedLog);
    }
    
    @Override
    public void close() {
        // Close network connections
    }
}