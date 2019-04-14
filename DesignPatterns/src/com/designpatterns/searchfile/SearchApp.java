package com.designpatterns.searchfile;

// Client App - Console Application / GUI Application
public class SearchApp {
    // JVM calls main() using a thread called main thread
    public static void main(String[] args) {
        // Main thread / GUI App - UI thread is used to call search
        // can be a long running operation
        Utility.search("C:\\test", "data.txt", path -> { System.out.println(" File found: " + path); });
    }
}
