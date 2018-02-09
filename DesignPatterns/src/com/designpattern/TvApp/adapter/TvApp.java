package com.designpattern.TvApp.adapter;

// Stefan shalloway design patterns explained pdf
// UML Distill - Martin Fowler developers should follow interface but they are good at implementation
// David chapel - any problem can be solved by adding one more layer.
public class TvApp {
	
	public static void main(String[] args) {
		TV tv = new TV();
		Shape.setAdapter(new OpenGLAdapter());
		tv.start();
		
		Shape.setAdapter(new DirectXAdapter());
		tv.start();
	}

}
