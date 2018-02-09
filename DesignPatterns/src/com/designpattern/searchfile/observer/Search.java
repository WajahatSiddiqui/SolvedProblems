package com.designpattern.searchfile.observer;

import java.io.File;
import java.util.Stack;

// Reusable Library
public class Search {
	
	private boolean isSearchRunning = false;
	private Thread st = null;
	
	// these are called events as they are supporting registration and deregistration
	/*private List<FileFoundCallback> fileFoundCallbacks = new ArrayList<FileFoundCallback>();
	private List<FolderEnteredCallback> folderEnterCallbacks = new ArrayList<FolderEnteredCallback>();*/
	
	public Event fileFoundEvent = new Event();
	public Event folderEnteredEvent = new Event();
	
	public Search() {}
	public void startSearch(String startingFolder, String fileName) throws RuntimeException {
		if (st == null) {
			isSearchRunning = true;
			st = new Thread(() -> {
				searchHelper(startingFolder, fileName);
			}); // starts a secondary thread
			st.start();
		} else {
			throw new RuntimeException("Search is Running");
		}
	}
	
	// will be called in main thread
	// in multi threaded environment, we need to take care of synchronization 
	/*public void addFileFoundCallback(FileFoundCallback fileFoundCallback) {
		// handle sync
		if (!fileFoundCallbacks.contains(fileFoundCallback)) {
			fileFoundCallbacks.add(fileFoundCallback);
		}
	}
	
	public void removeFileFoundCallback(FileFoundCallback fileFoundCallback) {
		if (fileFoundCallbacks.contains(fileFoundCallback)) {
			fileFoundCallbacks.remove(fileFoundCallback);
		}
	}
	
	public void addFolderFoundCallback(FolderEnteredCallback folderEnteredCallback) {
		if (!folderEnterCallbacks.contains(folderEnteredCallback)) {
			folderEnterCallbacks.add(folderEnteredCallback);
		}
	}
	
	public void removeFolderFoundCallback(FolderEnteredCallback folderEnteredCallback) {
		if (folderEnterCallbacks.contains(folderEnteredCallback)) {
			folderEnterCallbacks.remove(folderEnteredCallback);
		}
	}*/
	
	public void stopSearch() {
		if (isSearchRunning) {
			isSearchRunning = false;
			st = null;
		}
		System.out.println("Search is stopped");
	}

	// Search for this file name in all sub folders of this folder
	// when file is found inform the caller with the file path
	// continue the search operation till the end.
	/*public static void search(String folder, String file, FileFoundCallback callback) {

		File dir = new File(folder);
		//search(dir, file, callback);
		searchIterative(folder, file, callback);
	}*/

	/*private static void search (File file, String fileName, FileFoundCallback callback) {
		File [] files = file.listFiles();
		for (File f : files) {
			if (f.isDirectory()) {
				search(f, fileName, callback);
			} else {
				if (f.isFile() && f.getName().contains(fileName)) {
					callback.found(f.getPath());
				}
			}
		}
	}*/
	
	
	// Multi Instance design
	private void searchHelper(String startingFolder, String fileName) {
		Stack<String> folders = new Stack<>();
		folders.push(startingFolder);
		
		// can be long running, if search is stopped the thread finishes and dies 
		while (folders.size() > 0 && isSearchRunning) {
			String folder = folders.pop();
			folderEnteredEvent.raise(this, folder);
			File ff = new File(folder);
			File [] fflist = ff.listFiles();
			
			for (File f : fflist) {
				if (f.isFile() && f.getName().equalsIgnoreCase(fileName)) {
					fileFoundEvent.raise(this, f.getPath());
					break;
				}
			}
			
			for (int i = fflist.length - 1; i >= 0; i--) {
				if (fflist[i].isDirectory()) {
					folders.push(fflist[i].getAbsolutePath());
				}
			}
		}
	}
}
