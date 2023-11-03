package com.fssa.shopnow.model;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class TestUser {

	// Creating attributes for user object
	int id = 1;
	String name = "sasikumar";
	String email = "abc@gmail.com";
	String mobileNumber = "6398939499";
	String password = "839209#Sdk";
	
	User user1 = new User(name, email, mobileNumber);
	

	@Test
	public void testUserGetters() {
		user1.setId(id);
		user1.setPassword(password);
		Assertions.assertEquals(name, user1.getName());
		Assertions.assertEquals(email, user1.getEmail());
		Assertions.assertEquals(mobileNumber, user1.getMobileNumber());
		Assertions.assertEquals(password, user1.getPassword());
		Assertions.assertEquals(id, user1.getId());
		Assertions.assertEquals(password, user1.getPassword());
	}

	@Test
	public void testIdSetter() {
		int newId = 2;
		user1.setId(newId);
		Assertions.assertEquals(newId,user1.getId());
	}
	
	@Test
	public void testNameSetter() {
		String newName = "SkKumar";
		user1.setName(newName);
		Assertions.assertEquals(newName, user1.getName());
	}

	@Test
	public void testEmailSetter() {
		String newEmail = "xyz@gmail.com";
		user1.setEmail(newEmail);
		Assertions.assertEquals(newEmail, user1.getEmail());
	}

	@Test
	public void testMobileNumberSetter() {
		String newMobileNumber = "6398348943";
		user1.setMobileNumber(newMobileNumber);
		Assertions.assertEquals(newMobileNumber, user1.getMobileNumber());
	}

	@Test
	public void testPasswordSetter() {
		String newPassword = "93842334#Wk";
		user1.setPassword(newPassword);
		Assertions.assertEquals(newPassword, user1.getPassword());
	}

}
