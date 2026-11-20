package com.electricitybillcalculator;

public class Connection {

	private int consumerNo;
	private int units;

	public Connection(int consumerNo, int units) {
		this.consumerNo = consumerNo;
		this.units = units;
	}

	public int getConsumerNo() {
		return consumerNo;
	}

	public int getUnits() {
		return units;
	}


	public double getEnergyCharge() {

		double charge;

		if (units <= 100) {
			charge = units * 3;
		} else if (units <= 300) {
			charge = (100 * 3) + ((units - 100) * 5);
		} else {
			charge = (100 * 3) + (200 * 5) + ((units - 300) * 8);
		}

		return charge;
	}

	public double getFixedCharge() {
		return 50;
	}

	public double getDutyRate() {
		return 0.05;
	}

	public double getDuty() {
		return (getEnergyCharge() + getFixedCharge()) * getDutyRate();
	}

	public double calculateBill(boolean paidLate) {

		double amountAfterDuty = getEnergyCharge() + getFixedCharge() + getDuty();

		double fine = 0;

		if (paidLate) {
			fine = amountAfterDuty * 0.02;
		}

		return amountAfterDuty + fine;
	}

	public void printType() {
		System.out.println("Domestic");
	}

	public void showBill(boolean paidLate) {

		double energyCharge = getEnergyCharge();
		double fixedCharge = getFixedCharge();
		double duty = getDuty();

		double amountAfterDuty = energyCharge + fixedCharge + duty;

		double fine = 0;

		if (paidLate) {
			fine = amountAfterDuty * 0.02;
		}

		double total = amountAfterDuty + fine;

		System.out.println();
		System.out.println("========= ELECTRICITY BILL =========");
		System.out.println("Consumer No          : " + consumerNo);

		System.out.print("Connection           : ");
		printType();

		System.out.println("Units Used           : " + units);
		System.out.println("------------------------------------");

		System.out.printf("Energy Charge        : %12.2f%n", energyCharge);

		System.out.printf("Fixed Charge         : %12.2f%n", fixedCharge);

		System.out.printf("Duty (%.0f%%)          : %12.2f%n", getDutyRate() * 100, duty);

		System.out.printf("Late Fine            : %12.2f%n", fine);

		System.out.println("------------------------------------");

		System.out.printf("Total Bill           : %12.2f%n", total);

		System.out.println("====================================");
	}

}
