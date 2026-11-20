package com.student;

public class ScienceStudent extends Student {

	private int practicalMarks;

	// Constructor
	public ScienceStudent(int rollNo, int marks1, int marks2, int marks3, int practicalMarks) {

		super(rollNo, marks1, marks2, marks3);

		this.practicalMarks = practicalMarks;
	}

	@Override
	public int getTotal() {

		return super.getTotal() + practicalMarks;
	}

	@Override
	public int getMaxTotal() {

		return 400;
	}

	@Override
	public boolean isPass() {

		return super.isPass() && practicalMarks >= 40;
	}

	@Override
	public void showResultCard() {

		System.out.println();

		System.out.println("======= SCIENCE RESULT CARD =======");

		System.out.println("Roll No     : " + getRollNo());

		System.out.println("Subject 1   : " + getSubject1());

		System.out.println("Subject 2   : " + getSubject2());

		System.out.println("Subject 3   : " + getSubject3());

		System.out.println("Practical   : " + practicalMarks);

		System.out.println("Total       : " + getTotal() + " / " + getMaxTotal());

		System.out.printf("Percentage  : %.2f%n", getPercentage());

		System.out.println("Grade       : " + getGrade());

		if (isPass()) {

			System.out.println("Result      : PASS");

		} else {

			System.out.println("Result      : FAIL");
		}

		System.out.println("===================================");
	}
}