package com.fssa.shopnow.service;

import java.sql.SQLException;
import java.util.List;

import com.fssa.shopnow.dao.DAOException;
import com.fssa.shopnow.dao.ShopDao;
import com.fssa.shopnow.dao.UserDao;
import com.fssa.shopnow.exception.InvalidShopException;
import com.fssa.shopnow.model.Shop;
import com.fssa.shopnow.model.User;
import com.fssa.shopnow.validator.ValidateShop;

public class ShopService {
	
	ShopDao shopDao;
	ValidateShop validator;
	
	//Creating constructor for intialize objects
	public ShopService(ShopDao dao,ValidateShop validator) {
		this.shopDao = dao;
		this.validator = validator;
	}
	
	public ShopService(){};
	
	public boolean addShop(Shop shop) throws InvalidShopException, ClassNotFoundException, DAOException, SQLException {
		if(validator.validate(shop)){
			return shopDao.addShop(shop);
		}
		else {
		return false;
		}
	}
	
	public List<Shop> getShops() throws ClassNotFoundException, DAOException, SQLException {
		List<Shop> shopList = shopDao.getAllShops();
		return shopList;
	}
	
	public List<Shop> getShopsByProduct(String[] shopIdList) throws SQLException, DAOException{
		List<Shop> shopList = shopDao.getShopsbyProduct(shopIdList);
		return shopList;
	}
	
}
