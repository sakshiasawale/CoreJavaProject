package com.student;

import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("===== STUDENT RESULT SYSTEM =====");

		System.out.print("Enter number of students: ");
		int n = sc.nextInt();

		int passCount = 0;
		int failCount = 0;

		double sumOfPercentages = 0;

		double highestPercentage = -1;
		int topperRoll = 0;

		for (int i = 1; i <= n; i++) {

			System.out.println();
			System.out.println("----- Student " + i + " -----");

			System.out.print("Enter student type ");
			System.out.print("(1 = General, 2 = Science): ");

			int type = sc.nextInt();

			int rollNo;

			do {
				System.out.print("Enter Roll Number: ");
				rollNo = sc.nextInt();

				if (rollNo <= 0) {
					System.out.println("Roll number must be greater than zero.");
				}

			} while (rollNo <= 0);

			int marks1 = getValidMarks(sc, "Subject 1");
			int marks2 = getValidMarks(sc, "Subject 2");
			int marks3 = getValidMarks(sc, "Subject 3");

			Student student;

			if (type == 1) {

				student = new Student(rollNo, marks1, marks2, marks3);

			} else if (type == 2) {

				int practicalMarks = getValidMarks(sc, "Practical");

				student = new ScienceStudent(rollNo, marks1, marks2, marks3, practicalMarks);

			} else {

				System.out.println("Invalid student type.");
				i--;
				continue;
			}

			// Runtime polymorphism
			student.showResultCard();

			double percentage = student.getPercentage();

			sumOfPercentages = sumOfPercentages + percentage;

			if (student.isPass()) {

				passCount++;

				if (percentage > highestPercentage) {

					highestPercentage = percentage;
					topperRoll = student.getRollNo();
				}

			} else {

				failCount++;
			}
		}

		double averagePercentage = sumOfPercentages / n;

		System.out.println();
		System.out.println("======= CLASS SUMMARY =======");

		System.out.println("Total students : " + n);
		System.out.println("Passed         : " + passCount);
		System.out.println("Failed         : " + failCount);

		System.out.printf("Average percent: %.2f%n", averagePercentage);

		if (passCount > 0) {

			System.out.println("Topper roll no : " + topperRoll);

			System.out.printf("Topper percent : %.2f%n", highestPercentage);

		} else {

			System.out.println("Topper         : No topper");
		}

		System.out.println("=============================");

		sc.close();
	}

	// Method to validate marks
	public static int getValidMarks(Scanner sc, String subject) {

		int marks;

		do {

			System.out.print("Enter " + subject + " marks (0-100): ");

			marks = sc.nextInt();

			if (marks < 0 || marks > 100) {

				System.out.println("Marks must be between 0 and 100.");
			}

		} while (marks < 0 || marks > 100);

		return marks;
	}
}
