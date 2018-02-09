package com.wajahat.design.undoredo;

import java.util.Stack;

public class AppData {
	Stack<String> undoStack = new Stack<String>();
	Stack<String> redoStack = new Stack<String>();
}
