package com.wajahat.logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LogManager {

    // Singleton - Eager Initialization
    private static final LogManager INSTANCE = new LogManager();

    private final Map<String, Logger> loggers;
    private final List<LogAppender> appenders;
    private AsyncLogProcessor asyncLogProcessor;
    private Thread asyncThread;
    private LogLevel globalMinLevel;
    private boolean asyncEnabled;
    private boolean dropOnBackPressure;

    public static LogManager getInstance() {
        return INSTANCE;
    }

    public LogManager() {
        this.loggers = new ConcurrentHashMap<>();
        this.appenders = new ArrayList<>();
        this.globalMinLevel = LogLevel.INFO;
        this.asyncEnabled = true;
        this.dropOnBackPressure = true; // Default to favor latency
    }

    public void configure(LogLevel minLevel, boolean asyncEnabled, boolean dropOnBackPressure) {
        this.globalMinLevel = minLevel;
        this.asyncEnabled = asyncEnabled;
        this.dropOnBackPressure = dropOnBackPressure;

        if (asyncEnabled && asyncLogProcessor == null) {
            asyncLogProcessor = new AsyncLogProcessor(appenders, dropOnBackPressure);
            asyncThread = new Thread(asyncLogProcessor, "AsyncLogProcessor");
            asyncThread.setDaemon(true);
            asyncThread.start();
        }
    }

    public void addAppender(LogAppender appender) {
        appenders.add(appender);
    }

    public Logger getLogger(String name) {
        return loggers.computeIfAbsent(name, k -> new Logger(name, globalMinLevel, appenders, asyncLogProcessor, asyncEnabled));
    }

    public void shutdown() {
        if (asyncLogProcessor != null) {
            asyncLogProcessor.shutdown();
            try {
                asyncThread.join(5000); // Wait for 5 secs for all threads to complete
            } catch (Exception e) {
                Thread.currentThread().interrupt();
            }
        }

        for (LogAppender appender : appenders) {
            appender.close();
        }
    }
}
