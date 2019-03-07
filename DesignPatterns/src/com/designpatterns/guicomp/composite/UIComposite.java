package com.designpatterns.guicomp.composite;

import java.util.ArrayList;
import java.util.List;

// Every composite is a UI Component
abstract class UIComposite extends UIComponent {

    private List<UIComponent> components = new ArrayList<>();

    protected UIComposite(/* UI Composite */ String title) {
        super(title);
    }

    public void add(UIComponent component) {
        components.add(component);
    }

    public void remove(UIComponent component) {
        components.remove(component);
    }

    @Override
    public void show() {
        super.show();
        for (UIComponent component : components) {
            component.show();
        }
    }

    @Override
    public void hide() {
        super.hide();
        for (UIComponent component : components) {
            component.hide();
        }
    }
}
