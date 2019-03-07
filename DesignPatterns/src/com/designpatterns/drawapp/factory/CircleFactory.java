package com.designpatterns.drawapp.factory;


//1. Provide information about the object that it creates
//2. Create the object
public class CircleFactory extends ShapeFactory {
    static {
        new CircleFactory();
        //System.out.println("CircleFactory static block executed");
    }
    public String getName() {
        return "Circle";
    }

    @Override
    public Shape create() {
        return new Circle();
    }
}
