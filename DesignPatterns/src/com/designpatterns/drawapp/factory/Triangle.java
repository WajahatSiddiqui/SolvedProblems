package com.designpatterns.drawapp.factory;

import java.util.Scanner;

public class Triangle implements Shape {
	
	private static class Point {
		private int x;
		private int y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		@Override
		public String toString() {
			return "Point: x = " + x + " y = " + y;
		}
	}
	
	private Point p1;
	private Point p2;
	private Point p3;

	@Override
	public void input() {
		int x, y;
		try (Scanner sc = new Scanner(System.in)) {
			System.out.print("Enter point1: ");
			x = sc.nextInt();
			y = sc.nextInt();
			p1 = new Point(x, y);
			
			System.out.print("Enter point2: ");
			x = sc.nextInt();
			y = sc.nextInt();
			p2 = new Point(x, y);
			
			System.out.print("Enter point3: ");
			x = sc.nextInt();
			y = sc.nextInt();
			p3 = new Point(x, y);
		}
	}

	@Override
	public void draw() {
		System.out.println("Triangle: " + p1 + " " + p2 + " " + p3);
	}
}
