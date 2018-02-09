package com.wajahat.design.undoredo;

public class Undo implements Editor {
	@Override
	public boolean perform(String command, String value, AppData data) {
		if (command.equals("undo") && !data.undoStack.isEmpty()) {
			String undo = data.undoStack.pop();
			System.out.println("Undo: " + undo);
			data.redoStack.push(undo);
			return true;
		}
		return false;
	}
}
