package com.wajahat.logger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileAppender implements LogAppender {
    private final LogFormatter logFormatter;
    private final String filePath;
    private BufferedWriter writer;
    
    public FileAppender(String filePath, LogFormatter logFormatter) {
        this.filePath = filePath;
        this.logFormatter = logFormatter;
        try {
            this.writer = new BufferedWriter(new FileWriter(filePath, true));
        } catch (IOException exception) {
            System.err.print("Failed to initialize FileAppender exception - " + exception);
        }
    }

    @Override
    public synchronized void append(LogEntry logEntry) {
        try {
            if (writer != null) {
                writer.write(logFormatter.format(logEntry));
                writer.newLine();
                writer.flush();
            }
        } catch (IOException exception) {
            System.err.println("Unable to append to the file " + filePath + " exception = " + exception);
        }
    }

    @Override
    public synchronized void close() {

        try {
            if (writer != null) {
                writer.close();
            }    
        } catch (IOException e) {
            System.err.println("Unable to close the file writer exception = " + e);
        }
    }
}
