package com.parking;

public class Vehicle {

	private int ticketNo;
	private int minutesParked;
	private boolean passHolder;

	public Vehicle(int ticketNo, int minutesParked, boolean passHolder) {
		this.ticketNo = ticketNo;
		this.minutesParked = minutesParked;
		this.passHolder = passHolder;
	}

	public int getTicketNo() {
		return ticketNo;
	}

	public double getRatePerHour() {
		return 0;
	}

	public double getDailyCap() {
		return 0;
	}

	public int getBillableHours() {

		if (minutesParked <= 15) {
			return 0;
		}

		int hours = minutesParked / 60;

		if (minutesParked % 60 > 0) {
			hours++;
		}

		return hours;
	}

	public double calculateFee() {

		if (minutesParked <= 15) {
			return 0;
		}

		int totalMinutes = minutesParked;

		int fullDays = totalMinutes / 1440;
		int remainingMinutes = totalMinutes % 1440;

		double fee = fullDays * getDailyCap();

		int remainingHours = remainingMinutes / 60;

		if (remainingMinutes % 60 > 0) {
			remainingHours++;
		}

		double remainingFee = remainingHours * getRatePerHour();

		if (remainingFee > getDailyCap()) {
			remainingFee = getDailyCap();
		}

		fee = fee + remainingFee;

		if (passHolder) {
			fee = fee * 0.50;
		}

		return fee;
	}

	public double calculateFee(boolean lostTicket) {

		double fee = calculateFee();

		if (lostTicket) {
			fee = fee + 200;
		}

		return fee;
	}

	public void printType() {
		System.out.println("Vehicle");
	}

	public void showReceipt(boolean lostTicket) {

		double normalFee = calculateFee();

		double passDiscount = 0;

		if (passHolder) {
			passDiscount = normalFee;
		}

		double lostTicketFine = 0;

		if (lostTicket) {
			lostTicketFine = 200;
		}

		double total = calculateFee(lostTicket);

		System.out.println();
		System.out.println("========= PARKING RECEIPT =========");

		System.out.println("Ticket No              : " + ticketNo);

		System.out.print("Vehicle                : ");
		printType();

		System.out.println("Time Parked            : " + minutesParked + " minutes");

		System.out.println("Billable Hours         : " + getBillableHours());

		System.out.printf("Rate per Hour          : %.2f%n", getRatePerHour());

		System.out.println("-----------------------------------");

		if (passHolder) {

			double originalFee = normalFee * 2;

			System.out.printf("Parking Fee            : %10.2f%n", originalFee);

			System.out.printf("Pass Discount          : %10.2f%n", passDiscount);

		} else {

			System.out.printf("Parking Fee            : %10.2f%n", normalFee);

			System.out.printf("Pass Discount          : %10.2f%n", 0.0);
		}

		System.out.printf("Lost Ticket Fine       : %10.2f%n", lostTicketFine);

		System.out.println("-----------------------------------");

		System.out.printf("Total to Pay           : %10.2f%n", total);

		System.out.println("===================================");
	}
}