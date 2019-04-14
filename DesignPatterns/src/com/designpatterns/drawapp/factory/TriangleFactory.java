package com.designpatterns.drawapp.factory;

class TriangleFactory extends ShapeFactory {
    static {
        new TriangleFactory();
    }

    @Override
    public String getName() {
        return "Triangle";
    }

    @Override
    public Shape create() {
        return new Triangle();
    }
}
