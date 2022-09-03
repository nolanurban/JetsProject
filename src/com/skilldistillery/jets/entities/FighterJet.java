package com.skilldistillery.jets.entities;

public class FighterJet extends Jet implements CombatReady {

	public FighterJet(String type, String model, double speed, int range, long price) {
		super(type, model, speed, range, price);
		// TODO Auto-generated constructor stub
	}


	@Override
	public void fly() {
		System.out.println(super.getModel() + " is going to go to max speed of " + super.getSpeed() + "MPH for a maximum range of " + super.getRange() + " miles.");
	}



	public void fight() {
		System.out.println(getModel() + " is switched off guns and now firing zee Missiles~!");
	}


	@Override
	public String toString() {
		return "FighterJet [getSpeedInMach()=" + getSpeedInMach() + ", getModel()=" + getModel() + ", getSpeed()="
				+ getSpeed() + ", getRange()=" + getRange() + ", getPrice()=" + getPrice() + ", getType()=" + getType()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	// we still need to implement fight() as an interface for CombatReady
}
