package com.designpatterns.builder;

public class Clock {

    // canvas as the data member
    private ClockBuilder cb;

    Clock(ClockBuilder cb) {
        // Start 1 sec timer to create clock
        this.cb = cb;
    }

    public void create() {
        cb.drawFace();
        cb.drawNumbers();
        cb.drawTime();
    }
}
