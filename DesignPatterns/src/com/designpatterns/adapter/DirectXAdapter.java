package com.designpatterns.adapter;

public class DirectXAdapter implements GraphicalLibrary {
    // use actual DirectX
    @Override
    public void drawLine(int x1, int y1, int x2, int y2) {
        System.out.println("Call to DirectX to drawLine");
    }

    @Override
    public void drawPath(int... items) {
        System.out.println("Call to DirectX to drawPath");
    }

}
