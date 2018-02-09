package com.designpattern.fileuploadapp.queueing;

import java.util.Scanner;


// Uploading the file 
public class FileUploadApp {
	
	public static void main(String[] args) {
		Uploader uploader = new Uploader();
		try (Scanner sc = new Scanner(System.in)) {
			while (true) {
				//System.out.print("Enter the filename to upload: ");
				String filename = sc.next();
				
				// long running operation
				// can block the main thread
				uploader.uploadToQueue(filename); 
			}
		}
	}

}
