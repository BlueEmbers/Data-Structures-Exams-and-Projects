package data;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.TreeSet;

@SuppressWarnings("serial")
public class Users implements Serializable, Comparable<Users> {
	
	private String name;
	private String email;
	private double gpa;
	private int mathSAT;
	private int readingSAT;
	private String username;
	private String password;
	
	public Users(String name, String email, double gpa, int mathSAT, int readingSAT) {
		super();
		this.name = name;
		this.email = email;
		this.gpa = gpa;
		this.mathSAT = mathSAT;
		this.readingSAT = readingSAT;
	}
	
	public Users( String username, String password) {
		this.username = username;
		this.password = password;
		
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

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public double getGpa() {
		return gpa;
	}
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	public int getMathSAT() {
		return mathSAT;
	}
	public void setMathSAT(int mathSAT) {
		this.mathSAT = mathSAT;
	}
	public int getReadingSAT() {
		return readingSAT;
	}
	public void setReadingSAT(int readingSAT) {
		this.readingSAT = readingSAT;
	}
	
	

	@Override
	public String toString() {
		return "Users [name=" + name + ", email=" + email + ", gpa=" + gpa + ", mathSAT=" + mathSAT + ", readingSAT="
				+ readingSAT + ", username=" + username + ", password=" + password + "]";
	}

	@Override
	public int compareTo(Users us) {
		
		return this.getUsername().compareTo(us.getUsername());
	}

	
	
	

}
