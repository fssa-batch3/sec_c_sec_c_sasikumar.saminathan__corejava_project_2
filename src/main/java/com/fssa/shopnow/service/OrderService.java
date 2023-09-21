package com.fssa.shopnow.service;

import java.sql.SQLException;
import java.util.List;

import com.fssa.shopnow.dao.DAOException;
import com.fssa.shopnow.dao.OrderDao;
import com.fssa.shopnow.exception.InvalidOrderException;
import com.fssa.shopnow.model.Order;
import com.fssa.shopnow.validator.ValidateOrder;

public class OrderService {
	
	OrderDao orderdao;
	ValidateOrder validate;
	
	//Constructor for initialize value
	public OrderService(OrderDao orderdao, ValidateOrder validate) {
		this.orderdao = orderdao;
		this.validate = validate;
	}
	
	public OrderService(){}
	
	public boolean addOrder(Order order) throws InvalidOrderException, SQLException, DAOException {
		if(ValidateOrder.isValidObj(order)){
			return OrderDao.addOrder(order);
		}
		else {
			return false;
		}
	}
	
	public List<Order> getOrdersById(int userId) throws ClassNotFoundException, DAOException, SQLException{
		if(ValidateOrder.isvalidUserId(userId)){
			return OrderDao.getAllOrders(userId);
		}
		else {
			return null;
		}
	}
	
	
}
