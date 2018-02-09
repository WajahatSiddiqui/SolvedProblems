package com.designpatterns.drawapp.extensible;

import java.util.Scanner;

public class Circle implements Shape {

	private int cx;
	private int cy;
	private int radius;
	
	@Override
	public String getShape() {
		return Circle.class.getSimpleName();
	}
	
	@Override
	public void input(Scanner sc) {
		System.out.println("Enter cx: ");
		cx = sc.nextInt();
		System.out.println("Enter cy: ");
		cy = sc.nextInt();
		System.out.println("Enter radius: ");
		radius = sc.nextInt();
	}

	@Override
	public void draw() {
		System.out.println("Circle: " + cx + " " + cy + " " + radius);
	}
}
