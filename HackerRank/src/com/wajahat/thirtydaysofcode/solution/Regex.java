package com.wajahat.thirtydaysofcode.solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Regex {
	
	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)) {
			int t = sc.nextInt();
			List<String> gmails = new ArrayList<String>(t);
			Pattern pattern = Pattern.compile("@gmail.com");
			String name, email;
			while (t > 0) {
				name = sc.next();
				email = sc.next();
				if (pattern.matcher(email).find()) {
					gmails.add(name);
				}
				t--;
			}
			Collections.sort(gmails);
			gmails.forEach(System.out::println);
		}
	}

}
