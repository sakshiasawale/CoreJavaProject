package com.parking;

import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		ParkingLot parkingLot = new ParkingLot();

		int choice;

		do {

			System.out.println();
			System.out.println("===== PARKING FEE SYSTEM =====");

			System.out.println("1. Park Vehicle");
			System.out.println("2. Exit Vehicle and Pay");
			System.out.println("3. Show Free Slots");
			System.out.println("4. Collection Report");
			System.out.println("0. Exit");

			System.out.print("Enter your choice: ");

			choice = sc.nextInt();

			

			if (choice == 1) {

				int type;

				do {

					System.out.println();
					System.out.println("--- Vehicle Type ---");

					System.out.println("1. Bike");
					System.out.println("2. Car");
					System.out.println("3. Truck");

					System.out.print("Enter vehicle type: ");

					type = sc.nextInt();

					if (type < 1 || type > 3) {

						System.out.println("Invalid vehicle type.");
					}

				} while (type < 1 || type > 3);

				parkingLot.parkVehicle(type);
			}

			// =================================
			// EXIT VEHICLE
			// =================================

			else if (choice == 2) {

				int type;

				do {

					System.out.println();
					System.out.println("--- Vehicle Type ---");

					System.out.println("1. Bike");
					System.out.println("2. Car");
					System.out.println("3. Truck");

					System.out.print("Enter vehicle type: ");

					type = sc.nextInt();

					if (type < 1 || type > 3) {

						System.out.println("Invalid vehicle type.");
					}

				} while (type < 1 || type > 3);

				int ticketNo;

				System.out.print("Enter Ticket Number: ");

				ticketNo = sc.nextInt();

				int minutesParked;

				do {

					System.out.print("Enter Minutes Parked: ");

					minutesParked = sc.nextInt();

					if (minutesParked <= 0) {

						System.out.println("Minutes must be greater than zero.");
					}

				} while (minutesParked <= 0);

			
				int passChoice;

				do {

					System.out.println();
					System.out.println("Pass Holder?");

					System.out.println("1. Yes");
					System.out.println("2. No");

					System.out.print("Enter choice: ");

					passChoice = sc.nextInt();

					if (passChoice != 1 && passChoice != 2) {

						System.out.println("Invalid choice.");
					}

				} while (passChoice != 1 && passChoice != 2);

				boolean passHolder = passChoice == 1;

				// Lost Ticket
				int lostChoice;

				do {

					System.out.println();
					System.out.println("Lost Ticket?");

					System.out.println("1. Yes");
					System.out.println("2. No");

					System.out.print("Enter choice: ");

					lostChoice = sc.nextInt();

					if (lostChoice != 1 && lostChoice != 2) {

						System.out.println("Invalid choice.");
					}

				} while (lostChoice != 1 && lostChoice != 2);

				boolean lostTicket = lostChoice == 1;

				

				Vehicle vehicle;

				switch (type) {

				case 1:

					vehicle = new Bike(ticketNo, minutesParked, passHolder);

					break;

				case 2:

					vehicle = new Car(ticketNo, minutesParked, passHolder);

					break;

				default:

					vehicle = new Truck(ticketNo, minutesParked, passHolder);

					break;
				}

				// Show Receipt
				vehicle.showReceipt(lostTicket);

				// Calculate Final Fee
				double amount = vehicle.calculateFee(lostTicket);

				// Release Slot
				boolean released = parkingLot.releaseSlot(type);

				if (released) {

					parkingLot.addCollection(amount);

					System.out.println();
					System.out.println("Vehicle exited successfully.");

				} else {

					System.out.println();
					System.out.println("Error: No vehicle of this type is parked.");

					System.out.println("No amount charged.");
				}
			}

			// =================================
			// SHOW FREE SLOTS
			// =================================

			else if (choice == 3) {

				parkingLot.showAvailability();
			}

			// =================================
			// COLLECTION REPORT
			// =================================

			else if (choice == 4) {

				parkingLot.showReport();
			}

			// =================================
			// EXIT
			// =================================

			else if (choice == 0) {

				System.out.println();
				System.out.println("Thank you. Program ended.");
			}

			// =================================
			// INVALID CHOICE
			// =================================

			else {

				System.out.println();
				System.out.println("Invalid choice. Please enter 0 to 4.");
			}

		} while (choice != 0);

		sc.close();
	}
}