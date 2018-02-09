package com.designpatterns.solid.calcapp;


// Abstraction doesnt perform specific task
// someone will implement this perform method
public interface Calc {
	boolean perform(String command, String value, AppData data);
}
