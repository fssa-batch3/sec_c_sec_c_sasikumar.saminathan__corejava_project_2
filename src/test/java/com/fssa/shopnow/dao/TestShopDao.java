package com.fssa.shopnow.dao;

import com.fssa.shopnow.model.Shop;

public class TestShopDao {
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

	
}
