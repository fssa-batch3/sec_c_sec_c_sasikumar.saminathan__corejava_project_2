package com.fssa.shopnow.service;

import java.sql.SQLException;
import java.util.List;

import com.fssa.shopnow.dao.AddressDao;
import com.fssa.shopnow.dao.DAOException;
import com.fssa.shopnow.exception.InvalidAddressException;
import com.fssa.shopnow.model.Address;
import com.fssa.shopnow.validator.ValidateAddress;

public class AddressService {

	AddressDao addressdao;
	ValidateAddress validate;
	
	//Creating constructor for intialize objects
	public AddressService(AddressDao dao,ValidateAddress validator) {
		this.addressdao = dao;
		this.validate = validator;
	}
	
	public AddressService() {
		
	}
	
	public boolean addAddress(Address address) throws InvalidAddressException, SQLException, DAOException {
		if(ValidateAddress.isValidObj(address)){
			return AddressDao.addAddress(address);
		}
		else {
			return false;
		}
	}
	
	public boolean updateAddress(Address address,int id) throws InvalidAddressException, ClassNotFoundException, DAOException {
		if(ValidateAddress.isValidObj(address) && ValidateAddress.isvalidId(id)) {
			return AddressDao.updateAddress(address,id);
		}
		else {
			return false;
		}
	}
	
	public boolean deleteAddress(int id) throws InvalidAddressException, ClassNotFoundException, DAOException {
		if(ValidateAddress.isvalidId(id)) {
			return AddressDao.deleteAddress(id);
		}
		else {
			return false;
		}
	}
	
	public List<Address> getAddressbyUser(int userId) throws ClassNotFoundException, DAOException, SQLException {
		List<Address> addressList = AddressDao.getAllAddress(userId);
		return addressList;
	}
	
	public Address getAddressById(int id) throws ClassNotFoundException, DAOException, SQLException {
		Address address = AddressDao.getAddressById(id);
		return address;
	}
}
