package com.student;

public class Student {

	private int rollNo;
	private int marks1;
	private int marks2;
	private int marks3;

	// Constructor
	public Student(int rollNo, int marks1, int marks2, int marks3) {

		this.rollNo = rollNo;
		this.marks1 = marks1;
		this.marks2 = marks2;
		this.marks3 = marks3;
	}

	public int getRollNo() {

		return rollNo;
	}

	// Getter methods for marks
	public int getSubject1() {

		return marks1;
	}

	public int getSubject2() {

		return marks2;
	}

	public int getSubject3() {

		return marks3;
	}

	public int getTotal() {

		return marks1 + marks2 + marks3;
	}

	public int getMaxTotal() {

		return 300;
	}

	public double getPercentage() {

		return ((double) getTotal() * 100) / getMaxTotal();
	}

	public char getGrade() {

		if (!isPass()) {

			return 'F';
		}

		double percentage = getPercentage();

		if (percentage >= 90) {

			return 'A';

		} else if (percentage >= 75) {

			return 'B';

		} else if (percentage >= 60) {

			return 'C';

		} else {

			return 'D';
		}
	}

	public boolean isPass() {

		return marks1 >= 40 && marks2 >= 40 && marks3 >= 40;
	}

	public void showResultCard() {

		System.out.println();

		System.out.println("======= RESULT CARD =======");

		System.out.println("Roll No     : " + rollNo);

		System.out.println("Subject 1   : " + marks1);

		System.out.println("Subject 2   : " + marks2);

		System.out.println("Subject 3   : " + marks3);

		System.out.println("Total       : " + getTotal() + "/" + getMaxTotal());

		System.out.printf("Percentage  : %.2f%n", getPercentage());

		System.out.println("Grade       : " + getGrade());

		if (isPass()) {

			System.out.println("Result      : PASS");

		} else {

			System.out.println("Result      : FAIL");
		}

		System.out.println("===========================");
	}
}