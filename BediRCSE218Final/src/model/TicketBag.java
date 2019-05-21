package model;

import java.util.ArrayList;

public class TicketBag {

	private int counter = 0;
	private ArrayList<Ticket> tickets = new ArrayList<Ticket>();

	public TicketBag(String ticket) {
		this.tickets = tickets;
	}

	public void addTicket(Ticket t) {
			tickets.add(t);
			counter++;
	}

	public boolean removeTicket(int j) {
		for(int i = 0; i < tickets.size(); i++){
			if(tickets.contains(j)){
				System.out.println("found Ticket");
				tickets.remove(j);
				return true;
			}
		}
		System.out.println("not found in This ticket bag");

		return false;
	}
	
	public boolean isFound(int t) {
		for (int i = 0; i > tickets.size(); i++) {
			if (tickets.contains(t)) {
				System.out.println(t + "found in ticket bag");
				return true;
			}
		}
		System.out.println("not found in ticket bag");
		return false;
	}

	public void printStoredSpaces() {
		System.out.println("Tickets in the bag: " + tickets);
	}

	
	
}
