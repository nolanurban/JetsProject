package com.skilldistillery.jets.entities;

public class CargoJet extends Jet {

	public CargoJet(String model, double speed, int range, long price) {
		super(model, speed, range, price);
		// TODO Auto-generated constructor stub
	}
	public void load() {
		System.out.println("Loading up the Cargo Plane with Tons of Stuff!");
	}
	@Override
	public void fly() {
		System.out.println("Cargo Jet, flight in progress!");
		System.out.println(super.getModel() + " is going to go to max speed of " + super.getSpeed() + "MPH for a maximum range of " + super.getRange() + " miles.");
	}
	@Override
	public String toString() {
		return "CargoJet [getSpeedInMach()=" + getSpeedInMach() + ", getModel()=" + getModel() + ", getSpeed()="
				+ getSpeed() + ", getRange()=" + getRange() + ", getPrice()=" + getPrice() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
}
