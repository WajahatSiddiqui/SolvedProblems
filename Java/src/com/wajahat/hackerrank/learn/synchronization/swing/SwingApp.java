package com.wajahat.hackerrank.learn.synchronization.swing;

import javax.swing.*;

public class SwingApp {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new MainFrame("SwingWorker Demo");
			}
		});
	}
}
