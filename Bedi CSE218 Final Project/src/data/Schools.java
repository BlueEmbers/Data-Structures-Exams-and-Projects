package data;

import java.io.Serializable;

public class Schools implements Serializable{
	private String ipedsId;
	private String collegeName;
	private String Address;
	private String city;
	private String zip;
	private String state;
	private String InstitutionWebAddress;
	private String AdminIWA;
	private String costInState;
	private String costOutOfState;

	private String sat25thR;
	private String sat25thM;
	private String sat75thR;
	private String sat75thM;
	
	public Schools(String collegeName, String city) {
		this.ipedsId = ipedsId;
		this.collegeName = collegeName;
		this.city = city;
		
	}
	public Schools(String ipedsId, String collegeName, String address, String city, String zip, String state,
			String institutionWebAddress, String adminIWA, String costInState, String costOutOfState,
			String sat25thR, String sat75thR, String sat25thM, String sat75thM) {
		super();
		this.ipedsId = ipedsId;
		this.collegeName = collegeName;
		Address = address;
		this.city = city;
		this.zip = zip;
		this.state = state;
		InstitutionWebAddress = institutionWebAddress;
		AdminIWA = adminIWA;
		this.costInState = costInState;
		this.costOutOfState = costOutOfState;
		
		this.sat25thR = sat25thR;
		this.sat75thR = sat75thR;
		this.sat25thM = sat25thM;
		this.sat75thM = sat75thM;
	}
	public String getIpedsId() {
		return ipedsId;
	}
	public void setIpedsId(String ipedsId) {
		this.ipedsId = ipedsId;
	}
	public String getCollegeName() {
		return collegeName;
	}
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getInstitutionWebAddress() {
		return InstitutionWebAddress;
	}
	public void setInstitutionWebAddress(String institutionWebAddress) {
		InstitutionWebAddress = institutionWebAddress;
	}
	public String getAdminIWA() {
		return AdminIWA;
	}
	public void setAdminIWA(String adminIWA) {
		AdminIWA = adminIWA;
	}
	public String getCostInState() {
		return costInState;
	}
	public void setCostInState(String costInState) {
		this.costInState = costInState;
	}
	public String getCostOutOfState() {
		return costOutOfState;
	}
	public void setCostOutOfState(String costOutOfState) {
		this.costOutOfState = costOutOfState;
	}
	public String getSat25thR() {
		return sat25thR;
	}
	public void setSat25thR(String sat25thR) {
		this.sat25thR = sat25thR;
	}
	public String getSat25thM() {
		return sat25thM;
	}
	public void setSat25thM(String sat25thM) {
		this.sat25thM = sat25thM;
	}
	public String getSat75thR() {
		return sat75thR;
	}
	public void setSat75thR(String sat75thR) {
		this.sat75thR = sat75thR;
	}
	public String getSat75thM() {
		return sat75thM;
	}
	public void setSat75thM(String sat75thM) {
		this.sat75thM = sat75thM;
	}
	@Override
	public String toString() {
		return "Schools [ipedsId=" + ipedsId + ", collegeName=" + collegeName + ", Address=" + Address + ", city="
				+ city + ", zip=" + zip + ", state=" + state + ", InstitutionWebAddress=" + InstitutionWebAddress
				+ ", AdminIWA=" + AdminIWA + ", costInState=" + costInState + ", costOutOfState=" + costOutOfState
				+ ", sat25thR=" + sat25thR + ", sat25thM=" + sat25thM + ", sat75thR=" + sat75thR + ", sat75thM="
				+ sat75thM + "]";
	}
	
	
	
	

}
