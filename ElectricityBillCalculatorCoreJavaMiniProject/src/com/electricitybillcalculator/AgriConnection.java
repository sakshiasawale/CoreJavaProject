package com.electricitybillcalculator;

public class AgriConnection extends Connection {

	public AgriConnection(int consumerNo, int units) {
		super(consumerNo, units);
	}

	@Override
	public double getEnergyCharge() {
		return getUnits() * 2;
	}

	@Override
	public double getFixedCharge() {
		return 0;
	}

	@Override
	public double getDutyRate() {
		return 0;
	}

	@Override
	public void printType() {
		System.out.println("Agricultural");
	}
}
