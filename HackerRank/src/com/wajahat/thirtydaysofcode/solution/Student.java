package com.wajahat.thirtydaysofcode.solution;

class Student extends Person{
	private int[] testScores;

	/*	
	 *   Class Constructor
	 *   
	 *   @param firstName - A string denoting the Person's first name.
	 *   @param lastName - A string denoting the Person's last name.
	 *   @param id - An integer denoting the Person's ID number.
	 *   @param scores - An array of integers denoting the Person's test scores.
	 */
	// Write your constructor here

	public Student(String firstName, String lastName, int id, int [] testScores) {
		super(firstName, lastName, id);
		this.testScores = testScores;
	}

	/*	
	 *   Method Name: calculate
	 *   @return A character denoting the grade.
	 */
	// Write your method here

	public char calculate() {
		int avg = 0, sum = 0;
		for (int score : testScores) {
			sum += score;
		}
		avg = sum/testScores.length;
		char grade;
		if (avg >= 90 && avg <= 100) {
			grade = 'O';
		} else if (avg >= 80 && avg < 90) {
			grade = 'E';
		} else if (avg >= 70 && avg < 80) {
			grade = 'A';
		} else if (avg >= 55 && avg < 70) {
			grade = 'P';
		} else if (avg >= 40 && avg < 55) {
			grade = 'D';
		} else {
			grade = 'T';
		}
		return grade;
	}
}
