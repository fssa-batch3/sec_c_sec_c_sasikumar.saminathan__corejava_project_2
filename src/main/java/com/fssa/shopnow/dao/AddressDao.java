package com.fssa.shopnow.dao;

import com.fssa.shopnow.model.Address;
import com.fssa.shopnow.util.Logger;

public class AddressDao {

	  private AddressDao() {
		    throw new IllegalStateException("Utility class");
		  }
	  
	  static Logger logger = new Logger();
	  
	  public static boolean addAddress(Address address){
		  return true;
	  }
}
