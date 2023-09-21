package com.fssa.shopnow.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fssa.shopnow.errors.UserErrors;
import com.fssa.shopnow.exception.InvalidOrderException;
import com.fssa.shopnow.model.Address;
import com.fssa.shopnow.model.Order;
import com.fssa.shopnow.util.ConnectionUtil;
import com.fssa.shopnow.util.Logger;
import java.sql.Date;

public class OrderDao {

	private OrderDao() {
		throw new IllegalStateException("Utility class");
	}
	
	static Logger logger = new Logger();
	
	public static boolean addOrder(Order order) throws InvalidOrderException, SQLException, DAOException{
		try(Connection connection = ConnectionUtil.getConnection()){
			// Create insert statement
			String query = "INSERT INTO orders (status,product_id,order_date,address_id,quantity,shop_id,user_id,payment_method) VALUES (?,?,?,?,?,?,?,?)";
			// Execute insert statement
			try (PreparedStatement pst = connection.prepareStatement(query)) {

				pst.setString(1, order.getStatus());
				pst.setInt(2, order.getProductId());
				Date sqlDate = Date.valueOf(order.getDate());
				pst.setDate(3, sqlDate);
				pst.setInt(4, order.getAddressId());
				pst.setInt(5, order.getQuantity());
				pst.setInt(6, order.getShopId());
				pst.setInt(7, order.getUserId());
				pst.setString(8, order.getPaymentMethod());
				int rows = pst.executeUpdate();

				logger.info("number of rows inserterd:" + rows);

			}
		} catch (SQLException e) {
			throw new DAOException("Error in add order");
		}
		
		return true;
	}
	
	public static List<Order> getAllOrders(int userId) throws DAOException, ClassNotFoundException, SQLException {
		try(Connection connection = ConnectionUtil.getConnection()){
			String query = "SELECT * from orders WHERE user_id = ?";
			
			try (PreparedStatement pst = connection.prepareStatement(query)) {
				pst.setInt(1, userId);
				try (ResultSet resultSet = pst.executeQuery()) {
					// Create an ArrayList for get and insert all from database
					List<Order> OrderList = new ArrayList<Order>();
					
					while(resultSet.next()){
						int id = resultSet.getInt("id");
						int productId = resultSet.getInt("product_id");
						int userId2 = resultSet.getInt("user_id");
						int addressId = resultSet.getInt("address_id");
						int shopId = resultSet.getInt("shop_id");
						String status = resultSet.getString("status");
						Date orderDate = resultSet.getDate("order_date");
						int quantity = resultSet.getInt("quantity");
						String paymentMethod = resultSet.getString("payment_method");
						
						
						Order order = new Order(orderDate.toLocalDate(), addressId, status, productId, quantity, shopId, userId2, paymentMethod);
						order.setId(id);
						OrderList.add(order);
						
					}
					return OrderList;
				}
			}
		}
		catch (SQLException e) {
			throw new DAOException("Error in get Orders");
		}
		
	}
}
