package com.designpatterns.builder;

public class ClockApp {

    public static void main(String[] args) {
        Clock clock = new Clock(new CircularClockBuilder());
        clock.create();
    }
}
