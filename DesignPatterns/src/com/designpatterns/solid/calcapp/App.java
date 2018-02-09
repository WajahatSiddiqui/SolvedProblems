// http://leadows2.azurewebsites.net/paste/itemview

package com.designpatterns.solid.calcapp;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Implement extensible app
 * @author wajahat.s
 */
public class App {

	public static void main(String[] args) {

		List<Calc> commands = new ArrayList<>();
		// Use Reflections to create objects of implementations
		// using reflections to discover implementations of calc command and create their objects
		File file = new File("./bin/com/designpatterns/solid/calcapp");
		String[] files = file.list();

		for (String f: files) {
			//System.out.println(f);
			//System.out.println(f.split("\\.")[0]);
			if (f.contains(".class")) {
				try {
					// discover classes which has implemented Calc
					Class<?> cl = Class.forName("com.designpatterns.solid.calcapp." + f.split("\\.")[0]);
					//System.out.println(cl.toString());
					if (!cl.isInterface() && Calc.class.isAssignableFrom(cl)) {
						//System.out.println(cl.toString());
						commands.add((Calc) cl.newInstance()); // creating objects
					}
				} catch (Exception ex) {
					//System.out.println(ex.getMessage());
				}
			}
		}
		try (Scanner sc = new Scanner(System.in)) {
			AppData data = new AppData();

			while (true) {
				System.out.println(data.value);
				String line = sc.nextLine();

				StringTokenizer st = new StringTokenizer(line);
				String command = st.nextToken();
				String value = st.nextToken();


				boolean isPerformed = false;
				for (Calc c : commands) {
					isPerformed = c.perform(command, value, data);
					if (isPerformed) {
						break;
					}
				}

				if (!isPerformed) {
					System.out.println("Operation not supported !!! Please visit www.xyz.com");
				}
			}
		}
	}
}
