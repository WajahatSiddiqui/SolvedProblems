package com.designpatterns.drawapp.extensible;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DrawApp {

	public static void main(String[] args) {
		Map<Integer, Shape> shapes = new HashMap<>();
		// Use Reflections to create objects of implementations
		// using reflections to discover implementations of calc command and create their objects
		File file = new File("./bin/com/designpatterns/solid/drawapp");
		String[] files = file.list();

		int i = 1;
		for (String f: files) {
			//System.out.println(f);
			//System.out.println(f.split("\\.")[0]);
			try {
				// discover classes which has implemented Calc
				Class<?> cl = Class.forName("com.designpatterns.solid.drawapp." + f.split("\\.")[0]);
				//System.out.println(cl.toString());
				if (!cl.isInterface() && Shape.class.isAssignableFrom(cl)) {
					//System.out.println(cl.toString());
					shapes.put(i++, (Shape) cl.newInstance()); // creating objects
				}
			} catch (Exception ex) {
				//System.out.println(ex.getMessage());
			}
		}

		try (Scanner sc = new Scanner(System.in)) {
			Shape shape = null;
			while (true) {
				System.out.println("M E N U"); 
				System.out.println("0. REDRAW");

				for (Map.Entry<Integer, Shape> entry : shapes.entrySet()) {
					System.out.println(entry.getKey() + " " + entry.getValue().getShape());
				}
				System.out.println("Enter choice : ");
				int choice = sc.nextInt();
				if (choice > 0) {
					if (shapes.containsKey(choice)) {
						shape = shapes.get(choice);
						shape.input(sc);
						shape.draw();
					} else {
						System.out.println("Shape not supported, Pl. buy from www.xyz.com");
					}
				} else if (choice == 0) {
					if (shape != null) {
						shape.draw();
					} else {
						System.out.println("Draw a shape first.");
					}
				}
			}
		}
	}
}
