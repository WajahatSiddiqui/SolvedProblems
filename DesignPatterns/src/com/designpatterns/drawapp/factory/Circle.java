package com.designpatterns.drawapp.factory;

import java.util.Scanner;

public class Circle implements Shape {

	private int cx;
	private int cy;
	private int radius;

	@Override
	public void input() {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.print("Enter cx: ");
			sc.nextInt();
			System.out.print("Enter cy: ");
			sc.nextInt();
			System.out.print("Enter radius: ");
			sc.nextInt();
		}
	}

	@Override
	public void draw() {
		System.out.println("Circle: " + cx + " " + cy + " " + radius);
	}
}
