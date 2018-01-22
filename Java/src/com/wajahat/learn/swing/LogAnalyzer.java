package com.wajahat.learn.swing;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LogAnalyzer {

	private String[] keywords = {"fail", "failure", "fatal", "exception"};

	public boolean analyze(String serviceName) throws FileNotFoundException {
		File logFile = new File("/home/wajahat/Documents/Samsung/b.IoT/Log/ServiceSupervision/ServiceError/Config.log");

		if (!logFile.exists()) {
			System.out.println("analyze - " + logFile + " does not exists.");
			return false;
		}

		Scanner scanner = new Scanner(logFile);
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine().trim();
			for (String keys : keywords) {
				if (line.contains(keys)) {
					scanner.close();
					return true;
				}
			}
		}
		scanner.close();
		return false;
	}
	
	public static void main(String[] args) {
		try {
			System.out.println(new LogAnalyzer().analyze("Config"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
