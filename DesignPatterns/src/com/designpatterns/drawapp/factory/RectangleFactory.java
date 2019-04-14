package com.designpatterns.drawapp.factory;

//1. Provide information about the object that it creates
//2. Create the object
public class RectangleFactory extends ShapeFactory {
    // executed when the class gets loaded
    static {
        new RectangleFactory();
    }
    public String getName() {
        return "Rectangle";
    }

    @Override
    public Shape create() {
        return new Rectangle();
    }
}
