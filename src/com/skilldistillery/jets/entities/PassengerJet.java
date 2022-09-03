package com.skilldistillery.jets.entities;

public class PassengerJet extends Jet {

	public PassengerJet(String model, double speed, int range, long price) {
		super(model, speed, range, price);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void fly() {
		System.out.println("PassengerJet ready to go!");
		System.out.println(super.getModel() + " is going to go to max speed of " + super.getSpeed() + "MPH for a maximum range of " + super.getRange() + " miles.");

		// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() {
		return "PassengerJet [getSpeedInMach()=" + getSpeedInMach() + ", getModel()=" + getModel() + ", getSpeed()="
				+ getSpeed() + ", getRange()=" + getRange() + ", getPrice()=" + getPrice() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}



}
