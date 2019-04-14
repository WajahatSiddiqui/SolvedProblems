package com.designpatterns.drawapp.factory;

import java.util.Scanner;

public class Rectangle implements Shape {
    private int left;
    private int top;
    private int width;
    private int height;

    @Override
    public void input() {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter left: ");
            left = sc.nextInt();
            System.out.print("Enter top: ");
            top = sc.nextInt();
            System.out.print("Enter width: ");
            width = sc.nextInt();
            System.out.print("Enter height: ");
            height = sc.nextInt();
        }
    }

    @Override
    public void draw() {
        System.out.println("Rectangle: " + left + " " + top + " " + width + " " + height );
    }
}
