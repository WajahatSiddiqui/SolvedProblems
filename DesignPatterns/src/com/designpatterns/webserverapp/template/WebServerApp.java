package com.designpatterns.webserverapp.template;

import java.util.Scanner;

public class WebServerApp {

	public static void main(String[] args) {
		TomcatWebServer tws = new TomcatWebServer() ;
		try (Scanner scanner = new Scanner(System.in)) {

			while ( true ) {
				
				// MyClass1 GET
				String input = scanner.next();
				String type = scanner.next(); // GET, POST, PUT, DELETE, etc
				tws.httpRequestHandler(input, type);
			} 
		}
	}

}
