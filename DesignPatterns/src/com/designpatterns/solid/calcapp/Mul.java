package com.designpatterns.solid.calcapp;

public class Mul implements Calc {

	@Override
	public boolean perform(String command, String value, AppData data) {
		if (command.equalsIgnoreCase("mul")) {
			data.value *= Double.parseDouble(value);
			return true;
		} else {
			return false;
		}
	}
}
