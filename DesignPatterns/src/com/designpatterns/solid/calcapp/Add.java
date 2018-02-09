package com.designpatterns.solid.calcapp;

class Add implements Calc {
	@Override
	public boolean perform(String command, String value, AppData data) {
		if (command.equalsIgnoreCase("add")) {
			data.value += Double.parseDouble(value);
			return true;
		} else {
			return false;
		}
	}

}
