package com.designpatterns.drawapp.factory;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Uses Factory pattern
 * @author wajahat.s
 * Extensible App
 */
public class App {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {

			// Load classes
			File folder = new File("./bin/com/designpatterns/factory");
			String[] files = folder.list();

			for (String f : files) {
				try {
					if (f.contains(".class")) {
						Class.forName("com.designpatterns.factory." + f.split("\\.")[0]);
					}
				} catch (Exception ex) {
					System.out.println(ex.getMessage());
				}
			}

			if (ShapeFactory.factories.isEmpty()) {
				System.out.println("Factories are not loaded");
				return;
			}

			List<Shape> shapes = new ArrayList<>();
			while (true) {
				System.out.println("0: Redraw");
				int index = 1;
				// Display the menu
				for (ShapeFactory sf : ShapeFactory.factories) {
					System.out.println(index++ + ": " +sf.getName());
				}

				System.out.print("Select a shape: ");
				int choice = sc.nextInt();

				if (choice == 0) {
					for (Shape shape: shapes) {
						shape.draw();
					}
				} else {
					Shape shape = ShapeFactory.factories.get(choice - 1).create();
					shape.input();
					shape.draw();
					shapes.add(shape);
				}
			}
		}
	}
}
