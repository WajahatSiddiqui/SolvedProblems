package com.designpatterns.adapter;

public class TV {
    Line line = new Line();
    Path path = new Path();

    public void start() {
        line.draw();
        path.draw();
    }
}
