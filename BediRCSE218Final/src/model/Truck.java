package model;
public class Truck extends Vehicle{
	
	private double cost;
	
	public Truck(String licensePLate, String color, double cost) {
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
		return "Truck [cost=" + cost + "]";
	}
	
}
