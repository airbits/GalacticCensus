package enlighta.galantic.census.model;

import java.util.Date;

public class Person {
	private String fullName ;
	private Date dob;
	private String planetOfResidence;
	private String gender;
	private String localAddress;
	private double anualIncome;
	
	public Person(String fullName, Date dob, String planetOfResidence, String gender, String localAddress,
			double anualIncome) {
		super();
		this.fullName = fullName;
		this.dob = dob;
		this.planetOfResidence = planetOfResidence;
		this.gender = gender;
		this.localAddress = localAddress;
		this.anualIncome = anualIncome;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getPlanetOfResidence() {
		return planetOfResidence;
	}
	public void setPlanetOfResidence(String planetOfResidence) {
		this.planetOfResidence = planetOfResidence;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getLocalAddress() {
		return localAddress;
	}
	public void setLocalAddress(String localAddress) {
		this.localAddress = localAddress;
	}
	public double getAnualIncome() {
		return anualIncome;
	}
	public void setAnualIncome(double anualIncome) {
		this.anualIncome = anualIncome;
	}
	@Override
	public String toString() {
		return "Person [fullName=" + fullName + ", dob=" + dob + ", planetOfResidence=" + planetOfResidence
				+ ", gender=" + gender + ", localAddress=" + localAddress + ", anualIncome=" + anualIncome + "]";
	}
	
	
	
	
	

}
