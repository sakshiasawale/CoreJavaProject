package com.parking;

public class ParkingLot {

	private int freeBikeSlots = 5;
	private int freeCarSlots = 3;
	private int freeTruckSlots = 2;

	private int nextTicketNo = 1;

	private double totalCollection = 0;

	private int vehiclesServed = 0;

	public int parkVehicle(int type) {

		int ticketNo = 0;

		switch (type) {

		case 1:

			if (freeBikeSlots > 0) {

				freeBikeSlots--;

				ticketNo = nextTicketNo++;

				System.out.println();
				System.out.println("Bike parked successfully.");

				System.out.println("Ticket No: " + ticketNo);

			} else {

				System.out.println("Parking full for Bikes.");
			}

			break;

		case 2:

			if (freeCarSlots > 0) {

				freeCarSlots--;

				ticketNo = nextTicketNo++;

				System.out.println();
				System.out.println("Car parked successfully.");

				System.out.println("Ticket No: " + ticketNo);

			} else {

				System.out.println("Parking full for Cars.");
			}

			break;

		case 3:

			if (freeTruckSlots > 0) {

				freeTruckSlots--;

				ticketNo = nextTicketNo++;

				System.out.println();
				System.out.println("Truck parked successfully.");

				System.out.println("Ticket No: " + ticketNo);

			} else {

				System.out.println("Parking full for Trucks.");
			}

			break;

		default:

			System.out.println("Invalid vehicle type.");
		}

		return ticketNo;
	}

	public boolean releaseSlot(int type) {

		switch (type) {

		case 1:

			if (freeBikeSlots < 5) {

				freeBikeSlots++;

				return true;
			}

			break;

		case 2:

			if (freeCarSlots < 3) {

				freeCarSlots++;

				return true;
			}

			break;

		case 3:

			if (freeTruckSlots < 2) {

				freeTruckSlots++;

				return true;
			}

			break;

		default:

			return false;
		}

		return false;
	}

	public void addCollection(double amount) {

		totalCollection += amount;

		vehiclesServed++;
	}

	public void showAvailability() {

		System.out.println();
		System.out.println("======= FREE PARKING SLOTS =======");

		System.out.println("Bike Slots  : " + freeBikeSlots);

		System.out.println("Car Slots   : " + freeCarSlots);

		System.out.println("Truck Slots : " + freeTruckSlots);

		System.out.println("==================================");
	}

	public void showReport() {

		System.out.println();
		System.out.println("======= COLLECTION REPORT ========");

		System.out.println("Vehicles Served : " + vehiclesServed);

		System.out.printf("Total Collection: %.2f%n", totalCollection);

		System.out.println("=================================");
	}
}