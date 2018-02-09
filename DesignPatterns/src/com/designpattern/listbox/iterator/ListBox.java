package com.designpattern.listbox.iterator;

import java.util.Iterator;

public class ListBox<T> {
	
	public void display(Iterable<T> collection) {
		System.out.println("*** LIST BOX ***");
		// Java for each
		/*for (String item : collection) {
			System.out.println(item);
		}*/
		
		// Java for-each internals
		// iterator() always creates a new object of some class and returns it
		Iterator<T> it = collection.iterator(); 
		while (it.hasNext()) {
			T item = it.next();
			System.out.println(item);
		}
		System.out.println("*** LIST BOX ***");
	}

}
