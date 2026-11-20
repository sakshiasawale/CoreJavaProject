package com.parking;

public class Car extends Vehicle {

	public Car(int ticketNo, int minutesParked, boolean passHolder) {

		super(ticketNo, minutesParked, passHolder);
	}

	@Override
	public double getRatePerHour() {
		return 20;
	}

	@Override
	public double getDailyCap() {
		return 150;
	}

	@Override
	public void printType() {
		System.out.println("Car");
	}
}