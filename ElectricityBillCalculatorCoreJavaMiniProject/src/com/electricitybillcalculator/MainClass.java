package com.electricitybillcalculator;

import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int choice;

		int billCount = 0;
		double totalRevenue = 0;

		double highestBill = -1;
		int highestConsumerNo = 0;

		do {

			System.out.println();
			System.out.println("===== ELECTRICITY BILL CALCULATOR =====");
			System.out.println("1. Domestic Bill");
			System.out.println("2. Commercial Bill");
			System.out.println("3. Agricultural Bill");
			System.out.println("4. Show Summary");
			System.out.println("0. Exit");

			System.out.print("Enter your choice: ");
			choice = sc.nextInt();

			if (choice == 1 || choice == 2 || choice == 3) {

				int consumerNo;

				do {

					System.out.print("Enter Consumer Number: ");
					consumerNo = sc.nextInt();

					if (consumerNo <= 0) {
						System.out.println("Consumer number must be greater than zero.");
					}

				} while (consumerNo <= 0);

				int units;

				do {

					System.out.print("Enter Units: ");
					units = sc.nextInt();

					if (units < 0) {
						System.out.println("Units cannot be negative.");
					}

				} while (units < 0);

				System.out.println();
				System.out.println("Payment Status:");
				System.out.println("1. Paid Late");
				System.out.println("2. Not Late");

				System.out.print("Enter choice: ");

				int lateChoice = sc.nextInt();

				if (lateChoice == 1) {

					boolean paidLate = true;

					Connection connection;

					if (choice == 1) {

						connection = new Connection(consumerNo, units);

					} else if (choice == 2) {

						connection = new CommercialConnection(consumerNo, units);

					} else {

						connection = new AgriConnection(consumerNo, units);
					}

					connection.showBill(paidLate);

					double billAmount = connection.calculateBill(paidLate);

					billCount++;

					totalRevenue += billAmount;

					if (billAmount > highestBill) {

						highestBill = billAmount;

						highestConsumerNo = connection.getConsumerNo();
					}

				}

				else if (lateChoice == 2) {

					boolean paidLate = false;

					Connection connection;

					if (choice == 1) {

						connection = new Connection(consumerNo, units);

					} else if (choice == 2) {

						connection = new CommercialConnection(consumerNo, units);

					} else {

						connection = new AgriConnection(consumerNo, units);
					}

					connection.showBill(paidLate);

					double billAmount = connection.calculateBill(paidLate);

					billCount++;

					totalRevenue += billAmount;

					if (billAmount > highestBill) {

						highestBill = billAmount;

						highestConsumerNo = connection.getConsumerNo();
					}

				}

				else {

					System.out.println("Invalid payment choice.");

					System.out.println("Returning to Main Menu...");
				}
			}

			else if (choice == 4) {

				System.out.println();
				System.out.println("========== BILL SUMMARY ==========");

				System.out.println("Number of Bills      : " + billCount);

				System.out.printf("Total Revenue        : %.2f%n", totalRevenue);

				if (billCount > 0) {

					System.out.println("Highest Bill Consumer: " + highestConsumerNo);

					System.out.printf("Highest Bill Amount  : %.2f%n", highestBill);

				} else {

					System.out.println("No bills generated.");
				}

				System.out.println("==================================");
			}

			else if (choice == 0) {

				System.out.println();
				System.out.println("Thank you. Program ended.");
			}

			else {

				System.out.println("Invalid choice. Please enter 0 to 4.");
			}

		} while (choice != 0);

		sc.close();
	}
}