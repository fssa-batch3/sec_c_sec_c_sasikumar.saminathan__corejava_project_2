package com.fssa.shopnow.service;

import java.sql.SQLException;
import java.util.List;

import com.fssa.shopnow.dao.DAOException;
import com.fssa.shopnow.dao.UserDao;
import com.fssa.shopnow.exception.InvalidUserException;
import com.fssa.shopnow.model.User;
import com.fssa.shopnow.validator.ValidateUser;

public class UserService {

	UserDao userDao;
	ValidateUser validate;
	
	//Creating constructor for intialize objects
	public UserService(UserDao dao,ValidateUser validator) {
		this.userDao = dao;
		this.validate = validator;
	}
	
	public UserService() {
	}
	
	public boolean addUser(User user) throws InvalidUserException, SQLException, DAOException {
		if(ValidateUser.validate(user)){
			return UserDao.addUser(user);
		}
		else {
			return false;
		}
	}
	
	public boolean updateUser(User user) throws InvalidUserException, SQLException, DAOException {
		if(ValidateUser.validate(user)){
			return UserDao.updateUser(user, user.getId());
		}
		else {
			return false;
		}
	}
	
	public boolean isEmailExist(String email) throws SQLException, DAOException {
		if(ValidateUser.isValidEmail(email)) {
			return userDao.isEmailExist(email);
		}
		else {
			return false;
		}
	}
	
	public boolean isAccountExist(String email,String password) throws SQLException, DAOException {
		if(ValidateUser.isValidEmail(email) && ValidateUser.isValidPassword(password)) {
			return userDao.isAccountExist(email,password);
		}
		else {
			return false;
		}
	}
	
	public List<User> getUsers() throws ClassNotFoundException, DAOException, SQLException {
		List<User> userList = userDao.getAllUsers();
		return userList;
	}
	
	public User getUserbyEmail(String email) throws ClassNotFoundException, DAOException, SQLException {
		if(ValidateUser.isValidEmail(email)) {
			return UserDao.getUserbyEmail(email);
		}
		else {
			return null;
		}
	}
}
