package com.designpatterns.solid.calcapp;


// Extension for Div
public class Div implements Calc {

    @Override
    public boolean perform(String command, String value, AppData data) {
        if (command.equalsIgnoreCase("div")) {
            data.value /= Double.parseDouble(value);
            return true;
        }
        return false;
    }

}
