package com.chainsys.model;

public class RealEstateUserRegister
{
	String name;
	String designation;
	String emailID;
	long phoneNumber;
	String password;
	String address;
	String district;
	String state;
	String generatedUserID;
	
	
	public RealEstateUserRegister() 
	{
		
	}
	public RealEstateUserRegister(String selectId) {
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getEmailID() {
		return emailID;
	}
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getGeneratedUserID() {
		return generatedUserID;
	}
	public void setGeneratedUserID(String generatedUserID) {
		this.generatedUserID = generatedUserID;
	}
	@Override
	public String toString() {
		return "RealEstateUserRegister [name=" + name + ", designation=" + designation + ", emailID=" + emailID
				+ ", phoneNumber=" + phoneNumber + ", password=" + password + ", address=" + address + ", district="
				+ district + ", state=" + state + ", generatedUserID=" + generatedUserID + "]";
	}
	
	
}
