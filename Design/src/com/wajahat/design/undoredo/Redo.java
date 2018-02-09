package com.wajahat.design.undoredo;

public class Redo implements Editor {
	@Override
	public boolean perform(String command, String value, AppData data) {
		if (command.equalsIgnoreCase("redo") && !data.redoStack.isEmpty()) {
			String redo = data.redoStack.pop();
			System.out.println("Redo: " + redo);
			data.undoStack.push(redo);
			return true;
		}
		return false;
	}
}
