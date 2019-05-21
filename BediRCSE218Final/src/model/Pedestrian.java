package model;

public class Pedestrian extends Person
{
	private double cost;

	public Pedestrian(String ssn, String name, double cost) {
		super(ssn, name);
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
		return "Pedestrian [cost=" + cost + "]";
	}
	
	

}
