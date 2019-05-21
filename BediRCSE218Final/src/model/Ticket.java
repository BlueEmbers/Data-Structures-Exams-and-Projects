package model;

public class Ticket {

	private int ticketNum;
	private double cost;
	private String licensePlate;

	public Ticket(String licensePlate, int ticketNum, double cost) {
		super();
		this.licensePlate = licensePlate;
		this.cost = cost;
		this.ticketNum = ticketNum;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public int getTicketNum() {
		return ticketNum;
	}

	public void setTicketNum(int ticketNum) {
		this.ticketNum = ticketNum;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	@Override
	public String toString() {
		return "Ticket " + "ticketNum=" + ticketNum + "]";
	}

}
