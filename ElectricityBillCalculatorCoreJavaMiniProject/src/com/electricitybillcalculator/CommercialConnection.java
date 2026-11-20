package com.electricitybillcalculator;

public class CommercialConnection extends Connection {

	public CommercialConnection(int consumerNo, int units) {
		super(consumerNo, units);
	}

	@Override
	public double getEnergyCharge() {

		double charge;

		if (getUnits() <= 200) {
			charge = getUnits() * 7;
		} else {
			charge = (200 * 7) + ((getUnits() - 200) * 10);
		}

		return charge;
	}

	@Override
	public double getFixedCharge() {
		return 150;
	}

	@Override
	public void printType() {
		System.out.println("Commercial");
	}
}
