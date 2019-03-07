package com.designpatterns.decorator;

// abstract class Reader implements stream
public abstract class FileDecorator implements Component {
    protected Component component;

    public FileDecorator(Component component) {
        this.component = component;
    }
}
