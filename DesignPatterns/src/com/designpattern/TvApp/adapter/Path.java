package com.designpattern.TvApp.adapter;

public class Path extends Shape {
	public void draw() {
		gl.drawPath(10, 10, 20, 20, 30, 30, 40, 40, 10, 10);
	}
}
