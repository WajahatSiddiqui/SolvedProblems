package com.designpatterns.state;

public class Button extends UIComponent {

    protected Button(String title) {
        super(title);
    }

    // Observer Pattern
    public Event click = new Event();;

    public void pressed() {
        click.raise(this, null);
    }
}
