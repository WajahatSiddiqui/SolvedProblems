package com.designpattern.TvApp.adapter;

abstract class Shape {
	static GraphicalLibrary gl;
	
	static void setAdapter(GraphicalLibrary gl) {
		Shape.gl = gl;
	}
}
