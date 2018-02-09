package com.designpattern.notepadapp.state;

public class ExistingFileState implements State {

	private Notepad np;
	public ExistingFileState(Notepad np) {
		this.np = np;
	}
	
	public void close() {
		
	}

}
