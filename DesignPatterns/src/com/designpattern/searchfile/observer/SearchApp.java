package com.designpattern.searchfile.observer;

import java.util.Scanner;

// Client App - Console Application / GUI Application
public class SearchApp {
	// JVM calls main() using a thread called main thread
	public static void main(String[] args) {

		Search s = new Search();
		// main thread starts the search and returns immediately
		s.startSearch("C:\\test", "data.txt");

		s.fileFoundEvent.add((sender, path) -> { System.out.println(" File found: " + path); });
		//s.folderEnteredEvent.add(folder -> {});
		
		try (Scanner scanner = new Scanner(System.in)) {
			while (true) {
				String input = scanner.next();
				if (input.equalsIgnoreCase("stop")) {
					s.stopSearch();
				} 
			}
		}

		// Main thread / GUI App - UI thread is used to call search
		// can be a long running operation
		//s.search("C:\\test", "data.txt", path -> { System.out.println(" File found: " + path); });
	}
}
