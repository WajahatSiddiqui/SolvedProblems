package com.designpatterns.adapter;

public class Line extends Shape {

    public void draw() {
        gl.drawLine(10, 10, 100, 100);
    }
}
