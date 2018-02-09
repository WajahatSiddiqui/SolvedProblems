package com.designpatterns.drawapp.factory;

import java.util.ArrayList;
import java.util.List;

// Abstraction
abstract class ShapeFactory {
	
	static List<ShapeFactory> factories = new ArrayList<ShapeFactory>();
	
	// Comes in the parameter in
	// ShapeFactory.this
	protected ShapeFactory() {
		factories.add(this);
	}
	
	public abstract String getName();
	
	public abstract Shape create();
}
