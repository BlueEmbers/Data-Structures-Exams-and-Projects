package model;

import java.io.Serializable;

public class User implements Serializable{
	
	private String firstName;
	private String lastName;
	private int satReading;
	private int satMath;
	private String username;
	private String password;
	
	public User(String firstName, String lastName, String username, String password, int satReading, int satMath) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.satReading = satReading;
		this.satMath = satMath;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getSatReading() {
		return satReading;
	}

	public void setSatReading(int satReading) {
		this.satReading = satReading;
	}

	public int getSatMath() {
		return satMath;
	}

	public void setSatMath(int satMath) {
		this.satMath = satMath;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User: " + firstName + " " + lastName + "\nsatReading: " + satReading + "\nsatMath: "
				+ satMath + "\nUSERID: " + username + "\npassword:" + password;
	}
	
	

}
