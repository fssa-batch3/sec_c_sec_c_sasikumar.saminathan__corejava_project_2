package com.fssa.shopnow.model;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class TestShop {
	// Sample data for creating a Shop instance
	 int id = 1;
	 String name = "SRI SAI MOBILES";
	 String image = "https://lh5.googleusercontent.com/p/AF1QipOi7r9XakmIbf7cHIVtMu-Km-K0-xeRhud9RQaS=w390-h262-n-k-no";
	 String address = "No#4, MGR Salai, Tharamani, Chennai, Tamil Nadu";
	 String area = "tharamani";
	 double lat = 12.978622;
	 double lon = 80.243273;
	 String phoneNumber = "6374523897";
	 String pincode = "614810";
	 int sellerId = 2; 
	 String license = "2384uojflkls";
	 
	// Create a Shop instance for testing
	 Shop shop = new Shop(id, name, image, address, area, lat, lon, phoneNumber, pincode, sellerId, license);
	 
	 // Test getters
	 @Test
	 public void testGetters() {
		// Assert that the getters return the expected values
		 Assertions.assertEquals(id,shop.getId());
		 Assertions.assertEquals(name,shop.getName());
		 Assertions.assertEquals(image,shop.getImage());
		 Assertions.assertEquals(address,shop.getAddress());
		 Assertions.assertEquals(area,shop.getArea());
		 Assertions.assertEquals(lat,shop.getLat());
		 Assertions.assertEquals(lon,shop.getLon());
		 Assertions.assertEquals(phoneNumber,shop.getPhoneNumber());
		 Assertions.assertEquals(pincode,shop.getPincode());
		 Assertions.assertEquals(sellerId,shop.getSellerId());
		 Assertions.assertEquals(license,shop.getLicense());
	 }
	 
	// Test setter for ID
	 @Test
	 public void testIdSet(){
	        int newID = 5;
	        shop.setId(newID);
	     // Assert that the setter correctly updates the ID
	        Assertions.assertEquals(newID, shop.getId());
	 }
	 
	// Test setter for Name
	 @Test
	 public void testNameSet(){
	        String newName = "Kv Mobiles";
	        shop.setName(newName);
	     // Assert that the setter correctly updates the Name
	        Assertions.assertEquals(newName, shop.getName());
	 }
	 
	// Test setter for image
	 @Test
	 public void testImageSet(){
	        String newImage = "https://lh5.googleusercontent.com/p/AF1QipOi7r9XakmIbf7cHIVtMu-Km-K0-xeRhud9RQaS=w390-h262-n-k-no";
	        shop.setImage(newImage);
	     // Assert that the setter correctly updates the image
	        Assertions.assertEquals(newImage, shop.getImage());
	 }
	 
	 @Test
	 public void testAddressSet(){
	        String newAddress = "157, Pollachi Main Road, Sundarapuram, Kurichi, Coimbatore";
	        shop.setAddress(newAddress);
	     // Assert that the setter correctly updates the address
	        Assertions.assertEquals(newAddress, shop.getAddress());
	 }
	 
	 @Test
	 public void testAreaSet(){
	        String newArea = "Sundarapuram";
	        shop.setArea(newArea);
	     // Assert that the setter correctly updates the area
	        Assertions.assertEquals(newArea, shop.getArea());
	 }
	 
	// Test setter for latitude
	 @Test
	 public void testlatSet(){
	        double newLat = 12.978423;
	        shop.setLat(newLat);
	     // Assert that the setter correctly updates the latitude
	        Assertions.assertEquals(newLat, shop.getLat());
	 }
	 
	// Test setter for longitude
	 @Test
	 public void testlonSet(){
	        double newLon = 80.978423;
	        shop.setLon(newLon);
	     // Assert that the setter correctly updates the longitude
	        Assertions.assertEquals(newLon, shop.getLon());
	 }
	 
	// Test setter for phoneNumber
	 @Test
	 public void testPhoneNumberSet(){
	        String newPhoneNumber = "9188345674";
	        shop.setPhoneNumber(newPhoneNumber);
	     // Assert that the setter correctly updates the phoneNumber
	        Assertions.assertEquals(newPhoneNumber, shop.getPhoneNumber());
	 }
	 
	 @Test
	 public void testPincodeSet(){
	        String newPincode = "612348";
	        shop.setPincode(newPincode);
	     // Assert that the setter correctly updates the pincode
	        Assertions.assertEquals(newPincode, shop.getPincode());
	 }
	 
	// Test setter for sellerId
	 @Test
	 public void testSellerIdSet(){
	        int newSellerId = 3;
	        shop.setSellerId(newSellerId);
	     // Assert that the setter correctly updates the sellerId
	        Assertions.assertEquals(newSellerId, shop.getSellerId());
	 }
	 
	// Test setter for license
	 @Test
	 public void testLicenseSet(){
	        String newLicense = "892jdouuw";
	        shop.setLicense(newLicense);
	     // Assert that the setter correctly updates the license
	        Assertions.assertEquals(newLicense, shop.getLicense());
	 }
}
