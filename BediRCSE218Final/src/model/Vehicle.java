package model;

public class Vehicle {

	private String licensePLate;
	private String color;
	
	public Vehicle(String licensePlate, String color) {
		this.licensePLate = licensePlate;
		this.color = color;
	}

	public String getLicensePLate() {
		return licensePLate;
	}

	public void setLicensePLate(String licensePLate) {
		this.licensePLate = licensePLate;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Vehicle [licensePLate=" + licensePLate + ", color=" + color + "]";
	}
	
	
	
}
