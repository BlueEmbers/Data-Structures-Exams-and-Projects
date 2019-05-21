package model;

public class Car extends Vehicle{

	private double cost;
	
	public Car(String licensePLate, String color, double cost) {
		super(licensePLate,color);
		this.cost = cost;
	}
	
	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "Car [cost=" + cost + "]";
	}
	
}
