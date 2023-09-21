package com.fssa.shopnow.model;

/*
 * This code for User object
 * Attributes :-
 * 
 * 1.id
 * 2.name
 * 3.email
 * 4.mobileNumber
 * 5.password
 */
public class User {

	private int id;
	private String name;
	private String email;
	private String mobileNumber;
	private String password;

	// Creating constructors for intializeing value
	public User(String name, String email, String mobileNumber) {
		this.name = name;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.password = password;
	}

	// getters and setters for intialize and change the value
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
	
	public int getId() {
		return id;
	}
	
	public void setId(int id){
		this.id = id;
	}
}
