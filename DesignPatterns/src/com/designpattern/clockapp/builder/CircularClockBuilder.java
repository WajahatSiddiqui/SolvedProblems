package com.designpattern.clockapp.builder;

public class CircularClockBuilder implements ClockBuilder {
	
	public void drawFace() {
		CircularFace cf = new CircularFace();
		cf.drawFace();
	}
	public void drawNumbers() {
		DecimalNumber dn = new DecimalNumber();
		dn.drawNumbers();
	}
	
	public void drawTime() {
		LineHands lh = new LineHands();
		lh.drawTime();
	}
}
