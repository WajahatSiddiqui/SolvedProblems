package com.designpatterns.decorator;


public class Compression extends FileDecorator {

    public Compression(Component component) {
        super(component);
    }

    @Override
    public String read() {
        return "compressed " + component.read();
    }
}
