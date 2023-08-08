package com.fssa.shopnow.validator;
import com.fssa.shopnow.model.*;
import com.fssa.shopnow.exception.*;

public class ValidateUser {
	
	public static boolean validate(User user){
		if(user == null){
			throw new InvalidUserException("");
		}
		return true;
	}
}
