package com.designpattern.fileapp.decorator;

// Class file input stream
public class FileReader implements Component {
	private String fileName;
	public FileReader(String fileName) {
		this.fileName = fileName;
	}
	
	@Override
	public String read() {
		return "hello "; // hard coding for ease
	}
}
