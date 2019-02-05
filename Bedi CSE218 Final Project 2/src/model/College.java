package model;

import java.io.Serializable;

public class College implements Serializable{
	
	private String name;
	private String id;
	private String zip;
	private String city;
	private String state;
	private String inCost;
	private String outCost;
	private String mathLow;
	private String mathHi;
	private String readLow;
	private String readHi;
	private String chance;
	
	public College(String name, String id, String zip, String city, String state, String inCost, String outCost,
			String mathLow, String mathHi, String readLow, String readHi) {
		super();
		this.name = name;
		this.id = id;
		this.zip = zip;
		this.city = city;
		this.state = state;
		this.inCost = inCost;
		this.outCost = outCost;
		this.mathLow = mathLow;
		this.mathHi = mathHi;
		this.readLow = readLow;
		this.readHi = readHi;
		this.chance = null;
	}
	
	public String getChance() {
		return chance;
	}

	public void setChance(String chance) {
		this.chance = chance;
	}

	public College(College college) {
		super();
		this.name = college.name;
		this.id = college.id;
		this.zip = college.zip;
		this.city = college.city;
		this.state = college.state;
		this.inCost = college.inCost;
		this.outCost = college.outCost;
		this.mathLow = college.mathLow;
		this.mathHi = college.mathHi;
		this.readLow = college.readLow;
		this.readHi = college.readHi;
		this.chance = null;
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getInCost() {
		return inCost;
	}
	public void setInCost(String inCost) {
		this.inCost = inCost;
	}
	public String getOutCost() {
		return outCost;
	}
	public void setOutCost(String outCost) {
		this.outCost = outCost;
	}
	public String getMathLow() {
		return mathLow;
	}
	public void setMathLow(String mathLow) {
		this.mathLow = mathLow;
	}
	public String getMathHi() {
		return mathHi;
	}
	public void setMathHi(String mathHi) {
		this.mathHi = mathHi;
	}
	public String getReadLow() {
		return readLow;
	}
	public void setReadLow(String readLow) {
		this.readLow = readLow;
	}
	public String getReadHi() {
		return readHi;
	}
	public void setReadHi(String readHi) {
		this.readHi = readHi;
	}
	@Override
	public String toString() {
		return "College [name=" + name + ", id=" + id + ", zip=" + zip + ", city=" + city + ", state=" + state
				+ ", inCost=" + inCost + ", outCost=" + outCost + ", mathLow=" + mathLow + ", mathHi=" + mathHi
				+ ", readLow=" + readLow + ", readHi=" + readHi + "]";
	}
	
}
