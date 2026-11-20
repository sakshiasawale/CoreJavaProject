package com.parking;

public class Bike extends Vehicle {

	public Bike(int ticketNo, int minutesParked, boolean passHolder) {

		super(ticketNo, minutesParked, passHolder);
	}

	@Override
	public double getRatePerHour() {
		return 10;
	}

	@Override
	public double getDailyCap() {
		return 80;
	}

	@Override
	public void printType() {
		System.out.println("Bike");
	}
}