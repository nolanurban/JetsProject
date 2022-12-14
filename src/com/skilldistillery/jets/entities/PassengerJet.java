package com.skilldistillery.jets.entities;

public class PassengerJet extends Jet {

	public PassengerJet(String type, String model, double speed, int range, long price) {
		super(type, model, speed, range, price);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void fly() {
		System.out.print(super.getModel() + " is going to go to max speed of " + super.getSpeed() + "MPH for a maximum range of " + super.getRange() + " miles for a total flight time of : ");
		System.out.printf("%.2f \n", super.getRange()/super.getSpeed());
	// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() {
		return "PassengerJet [getSpeedInMach()=" + getSpeedInMach() + ", getModel()=" + getModel() + ", getSpeed()="
				+ getSpeed() + ", getRange()=" + getRange() + ", getPrice()=" + getPrice() + ", getType()=" + getType()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}




}
