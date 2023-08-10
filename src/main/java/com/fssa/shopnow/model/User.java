package com.fssa.shopnow.model;
/*
 * This code for User object
 * Attributes :-
 * 
 * 1.name
 * 2.email
 * 3.mobileNumber
 * 4.password
 */
public class User {
	
	String name;
	String email;
	String mobileNumber;
	String password;
	Address address;
	
	//Creating constructors for intializeing value
	public User(String name, String email, String mobileNumber, String password) {
		this.name = name;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.password = password;
	}

	//getters and setters for intialize and change the value
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

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
