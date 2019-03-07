package com.designpatterns.searchfile;

import java.io.File;
import java.util.Stack;

// Reusable Library
public class Utility {

    // Search for this file name in all sub folders of this folder
    // when file is found inform the caller with the file path
    // continue the search operation till the end.
    public static void search(String folder, String file, FileFoundCallback callback) {

        File dir = new File(folder);
        //search(dir, file, callback);
        searchIterative(folder, file, callback);
    }

    private static void search (File file, String fileName, FileFoundCallback callback) {
        File [] files = file.listFiles();
        for (File f : files) {
            if (f.isDirectory()) {
                search(f, fileName, callback);
            } else {
                if (f.isFile() && f.getName().contains(fileName)) {
                    callback.found(f.getPath());
                }
            }
        }
    }


    private static void searchIterative(String startingFolder, String fileName, FileFoundCallback callback) {
        Stack<String> folders = new Stack<>();
        folders.push(startingFolder);

        while (folders.size() > 0) {
            String folder = folders.pop();
            File ff = new File(folder);
            File [] fflist = ff.listFiles();

            for (File f : fflist) {
                if (f.isFile() && f.getName().equalsIgnoreCase(fileName)) {
                    callback.found(f.getPath());
                    break;
                }
            }

            for (int i = fflist.length - 1; i >= 0; i--) {
                if (fflist[i].isDirectory()) {
                    folders.push(fflist[i].getAbsolutePath());
                }
            }
        }
    }
}
