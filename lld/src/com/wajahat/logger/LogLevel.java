package com.wajahat.logger;

public enum LogLevel {
    INFO(1), DEBUG(2), WARNING(3), ERROR(4);
    private final int level;
    
    LovelLevel(int value) {
        this.level = value;
    }

    public int getLevel() {
        return this.level;
    }
}
