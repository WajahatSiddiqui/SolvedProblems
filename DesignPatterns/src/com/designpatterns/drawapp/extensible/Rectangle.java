package com.designpatterns.drawapp.extensible;

import java.util.Scanner;

public class Rectangle implements Shape {

	private int left;
	private int top;
	private int width;
	private int height;
	
	@Override
	public String getShape() {
		return Rectangle.class.getSimpleName();
	}

	@Override
	public void input(Scanner sc) {
		System.out.println("Enter left: ");
		left = sc.nextInt();
		System.out.println("Enter top: ");
		top = sc.nextInt();
		System.out.println("Enter width: ");
		width = sc.nextInt();
		System.out.println("Enter height: ");
		height = sc.nextInt();
	}

	@Override
	public void draw() {
		System.out.println("Rectangle: " + left +" " +top+" " + width + " " + height);
	}

}
