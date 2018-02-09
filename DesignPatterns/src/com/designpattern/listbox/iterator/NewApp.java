package com.designpattern.listbox.iterator;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class NewApp {
	
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			// internally array
			// traversing arraylist uses index
			List<String> arr = new ArrayList<String>(); 
			arr.add("one");
			arr.add("two");
			arr.add("three");
			
			// internally list of nodes
			// connected using ref variables
			// traversing linked list is using next
			List<String> list = new LinkedList<String>(); 
			list.add("one");
			list.add("two");
			list.add("three");
			
			// Traversing tree - inorder, preorder, postorder
			
			ListBox<String> lb = new ListBox<>();
			lb.display(arr);
			lb.display(list);
			
			ListBox<Integer> lb1 = new ListBox<>();
			MyCollection mc = new MyCollection();
			mc.add(1);
			mc.add(2);
			mc.add(3);
			lb1.display(mc);
		}
	}

}
