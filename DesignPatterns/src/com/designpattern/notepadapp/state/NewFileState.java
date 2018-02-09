package com.designpattern.notepadapp.state;

public class NewFileState implements State {
	
	private Notepad np;
	
	public NewFileState(Notepad np) {
		this.np = np;
	}
	
	public void close() {
		// ...
		
		np.changeToExistingFileState();
	}

}
