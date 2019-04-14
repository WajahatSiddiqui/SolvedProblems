package com.designpatterns.multable;

class Utilities {
    // static methods will not have this
    public static void generateMulTable(/*this*/ int n, ResultCallback callback) {
        System.out.println("Multiplication Table for " + n);
        for (int i = 1; i <= 10; i++) {
            int result = n * i;
            // decision is taken by the caller
            callback.send(n, i, result);
        }
    }
}