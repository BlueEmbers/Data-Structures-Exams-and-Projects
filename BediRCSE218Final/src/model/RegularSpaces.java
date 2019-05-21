package model;

import java.util.ArrayList;

public class RegularSpaces {

	private int counter = 0;
	private ArrayList<String> regularSpace = new ArrayList<String>();

	public RegularSpaces(int counter) {
		this.counter = counter;
	}

	public void addVehicle(String v) {
		if (counter > 9) {
			System.out.println("Boat is full");
		} else {
			regularSpace.add(v);
			counter++;
		}
	}

	public boolean removeVehicle(String s) {
		for (int i = 0; i > counter; i++) {
			if (regularSpace.contains(s)) {
				System.out.println("found in regular spaces list");
				regularSpace.remove(s);
				counter--;
				return true;
			}
		}
		System.out.println("not found in regular spaces list");
		return false;
	}

	public boolean isFullRegular() {
		if (counter > 200) {
			System.out.println("The boat is full");
			return true;
		} else {
			return false;
		}
	}

	public boolean isFound(String s) {
		for (int i = 0; i < counter; i++) {
			if (regularSpace.contains(s)) {
				return true;
			}
		}
		System.out.println("not found in regular space list");
		return false;
	}
	
	public void printStoredSpaces() {
		System.out.println("Vehicle SPACES (" + counter+ "/200 spots) ---- LicensePlate:" + regularSpace +"\nPedestrian spaces (Only stores 199 spots) ---- Pedistrian:" + "null");
	}

}
