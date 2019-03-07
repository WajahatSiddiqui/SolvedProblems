package com.designpatterns.decorator;


// Subclassing
public class Encryption extends FileDecorator {
    public Encryption(Component component) {
        super(component);
    }

    @Override
    public String read() {
        return "encrypt " + component.read();
    }
}
