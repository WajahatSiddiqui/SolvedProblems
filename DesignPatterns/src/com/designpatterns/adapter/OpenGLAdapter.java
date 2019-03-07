package com.designpatterns.adapter;

public class OpenGLAdapter implements GraphicalLibrary {
    // use actual OpenGL
    @Override
    public void drawLine(int x1, int y1, int x2, int y2) {
        System.out.println("Call to OpenGL to drawLine");
    }

    @Override
    public void drawPath(int... items) {
        System.out.println("Call to OpenGL to drawPath");
    }
}
