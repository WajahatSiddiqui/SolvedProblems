package com.wajahat.design.undoredo;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UndoRedo {
	
	private static void print(AppData data) {
		if (data.undoStack.isEmpty()) {
			for (String s : data.redoStack) {
				System.out.print(s + " ");
			}
		} else {
			for (String s : data.undoStack) {
				System.out.print(s + " ");
			}
		}
	}
	
	public static void main(String[] args) {
		List<Editor> commands = new ArrayList<>();
		File file = new File("./bin/com/wajahat/design/undoredo");
		String []files = file.list();
		for (String f : files) {
			if (f.contains(".class")) {
				try {
					Class<?> c = Class.forName("com.wajahat.design.undoredo."+f.split("\\.")[0]);
					if (!c.isInterface() && Editor.class.isAssignableFrom(c)) {
						commands.add((Editor)c.newInstance());
					}
				} catch (Exception e) {
					System.out.println("Unable to find classes " + e.getMessage());
				}
			}
		}
		AppData appData = new AppData();
		try (Scanner sc = new Scanner(System.in)) {
			String text;
			boolean isPerformed = false;
			while (true) {
				text = sc.next();
				
				for (Editor e: commands) {
					isPerformed = e.perform(text, text, appData);
					if (isPerformed) {
						break;
					}
				}
				if (!isPerformed) {
					appData.undoStack.push(text);
				}
				System.out.println("Current data:");
				print(appData);
			}
		}
	}

}
