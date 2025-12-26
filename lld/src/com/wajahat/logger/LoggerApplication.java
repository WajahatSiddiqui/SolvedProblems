package com.wajahat.logger;
public class LoggerApplication {
    public static void main(String[] args) throws InterruptedException {
        // Initialize LogManager
        LogManager logManager = LogManager.getInstance();
        
        // Configure: INFO level, async enabled, drop on backpressure
        logManager.configure(LogLevel.INFO, true, true);
        
        // Add appenders with different formatters
        logManager.addAppender(new ConsoleAppender(new DefaultLogFormat()));
        logManager.addAppender(new FileAppender("app.log", new JsonLogFormat()));
        logManager.addAppender(new RemoteAppender("http://logs.example.com", new JsonLogFormat()));
        
        // Get loggers
        Logger logger1 = logManager.getLogger("OrderService");
        Logger logger2 = logManager.getLogger("PaymentService");
        Logger logger3 = logManager.getLogger("UserService");
        
        // Log messages
        logger1.info("Processing order #12345");
        logger1.debug("Debug message (filtered out)");
        logger1.warn("Low inventory for product ABC");
        logger1.error("Failed to process payment");
        
        logger2.info("Payment initiated for $500");
        logger2.fatal("Critical: Database connection lost");

        logger3.info("User : Wajahat trying out more logs");
        
        // Simulate high load
        System.out.println("\n=== Simulating High Load ===");
        for (int i = 0; i < 100; i++) {
            logger1.info("High load message #" + i);
        }
        
        // Allow async processing to complete
        Thread.sleep(2000);
        
        // Shutdown
        logManager.shutdown();
        System.out.println("\n=== Logging Framework Shutdown Complete ===");
    }
}