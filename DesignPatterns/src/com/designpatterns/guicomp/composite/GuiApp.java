package com.designpatterns.guicomp.composite;

public class GuiApp {
	
	public static void main(String[] args) {
		Panel p1 = new Panel("Panel1");
		Button b1 = new Button("Button1");
		Label l1 = new Label("Label1");
		p1.add(b1);
		p1.add(l1);
		
		Panel p2 = new Panel("Panel2");
		Button b2 = new Button("Button2");
		Label l2 = new Label("Label2");
		p2.add(b2);
		p2.add(l2);
		
		p2.add(p1);
		
		p1.hide(); // p1 hide, b1 hide l1 hide
		p1.show(); // p1 show, b1 show l1 show
		
		p2.hide(); // p2 hide b2 hide l2 hide, p1 hide, b1 hide l1 hide 
		p2.show(); // p2 show b2 show l2 show, p1 show, b1 show l1 show
	}

}
