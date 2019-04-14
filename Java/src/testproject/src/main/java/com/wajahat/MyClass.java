package com.wajahat;

/**
 * Class My  Class
 * Created by wajahat
 */
public class MyClass {

    public void method() {
        System.out.println("method called");
    }

    public void process() {
        System.out.println("process called");
        method();
    }
}
