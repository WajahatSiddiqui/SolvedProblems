package com.designpatterns.multable;

import java.util.Scanner;

public class MultableApp {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter a number: ");
            int number = sc.nextInt();

            Utilities.generateMulTable(number, (n, i, result) -> {System.out.println(result); });
        }
    }
}
