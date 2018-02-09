package com.designpatterns.guicomp.composite;

// RULE2: All the methods of superclass can work for subclass OBJECT
// RULE3: Reference variable of superclass type: UI p;
// can hold reference of sub class OBJECT  (up casting)
abstract class UIComponent {
	//RULE1: all the data members of the super class always
	// becomes part of the sub class OBJECT
	private String title;
	
	protected UIComponent(/* UI Component this */ String title) {
		this.title = title;
	}
	
	public void show(/* UI Component this */) {
		System.out.println(this.title + " show");
	}
	
	public void hide(/* UI Component this */) {
		System.out.println(this.title + " hide");
	}
}
