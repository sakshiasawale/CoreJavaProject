package com.parking;

public class Truck extends Vehicle {

	public Truck(int ticketNo, int minutesParked, boolean passHolder) {

		super(ticketNo, minutesParked, passHolder);
	}

	@Override
	public double getRatePerHour() {
		return 40;
	}

	@Override
	public double getDailyCap() {
		return 300;
	}

	@Override
	public void printType() {
		System.out.println("Truck");
	}
}