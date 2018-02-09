package com.designpatterns.drawapp.extensible;

import java.util.Scanner;

public interface Shape {
	String getShape();
	void input(Scanner sc);
	void draw();
}
