package com.skilldistillery.jets.entities;
// This should build our jets

public abstract class Jet {
	
	private String type;
	private String model;
	private double speed;
	private int range;
	private long price;
	
	
	public double getSpeedInMach() {
		return speed / 767.269148;  // calculate roughly to Mach without an altitude.
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public double getSpeed() {
		return speed;
	}
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	public int getRange() {
		return range;
	}
	public void setRange(int range) {
		this.range = range;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getType() {
		return type;
	}
	public Jet(String type, String model, double speed, int range, long price) {
		super();
		this.type = type;
		this.model = model;
		this.speed = speed;
		this.range = range;
		this.price = price;
	}
	
	public abstract void fly();

	
}
