package com.designpattern.notepadapp.state;

public class Notepad extends UIComposite {

	Button newButton = new Button("New");
	Button openButton = new Button("Open");
	Button saveButton = new Button("Save");
	Button closeButton = new Button("Close");
	
	State state;
	
	NewFileState nfs;
	ExistingFileState efs;
	
	
	public Notepad() {
		super("Notepad");
		nfs = new NewFileState(this);
		efs = new ExistingFileState(this);
		state = nfs; // nodepad starts with new file state
		// make the button child of notepad
		this.add(closeButton);
		this.add(newButton);
		this.add(openButton);
		this.add(saveButton);
		
		newButton.click.add(this::onNew);
		openButton.click.add(this::onOpen);
		saveButton.click.add(this::onSave);
		closeButton.click.add(this::onClose);
	}
	
	private void onNew(Object sender, Object data) {
		
	}
	
	private void onOpen(Object sender, Object data) {
		
	}
	
	private void onSave(Object sender, Object data) {
		
	}
	
	private void onClose(Object sender, Object data) {
		state.close();
		/*// if data is typed by the user && yet not saved in file
		{
			// show the prompt with save, dont-cancel, cancel
			// if cancel, dismiss the prompt go back to notepad window
			// if dont-save, dismiss the prompt and close notepad window with saving data
			// if save
			{
				
			}
		}*/
	}
	
	public void changeToExistingFileState() {
		state = efs;
	}
	
	public void changeToNewFileState() {
		state = nfs;
	}
}
