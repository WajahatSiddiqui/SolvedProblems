package com.wajahat.design.undoredo;

public interface Editor {
	boolean perform(String command, String value, AppData data);
}
