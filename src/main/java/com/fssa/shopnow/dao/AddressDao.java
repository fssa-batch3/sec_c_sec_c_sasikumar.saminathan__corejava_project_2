package com.fssa.shopnow.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fssa.shopnow.errors.ProductErrors;
import com.fssa.shopnow.errors.UserErrors;
import com.fssa.shopnow.exception.InvalidAddressException;
import com.fssa.shopnow.exception.InvalidProductException;
import com.fssa.shopnow.exception.InvalidUserException;
import com.fssa.shopnow.model.Address;
import com.fssa.shopnow.model.Product;
import com.fssa.shopnow.model.User;
import com.fssa.shopnow.util.ConnectionUtil;
import com.fssa.shopnow.util.Logger;

public class AddressDao {

	  private AddressDao() {
		    throw new IllegalStateException("Utility class");
		  }
	  
	  static Logger logger = new Logger();
	  
		public static boolean addAddress(Address address) throws InvalidAddressException, SQLException, DAOException{
			try(Connection connection = ConnectionUtil.getConnection()){
				// Create insert statement
				String query = "INSERT INTO address (name,phone_number,user_id,area,house_number,landmark,pincode) VALUES (?,?,?,?,?,?,?)";
				// Execute insert statement
				try (PreparedStatement pst = connection.prepareStatement(query)) {

					pst.setString(1, address.getName());
					pst.setString(2, address.getPhoneNumber());
					pst.setInt(3, address.getUserId());
					pst.setString(4, address.getArea());
					pst.setString(5, address.getHouseNumber());
					pst.setString(6, address.getLandMark());
					pst.setString(7, address.getPincode());
					
					int rows = pst.executeUpdate();

					logger.info("number of rows inserterd:" + rows);

				}
			} catch (SQLException e) {
				throw new DAOException("Error in creating Address");
			}
			
			return true;
		}
		
		// this method for updating the table
		public static boolean updateAddress(Address address,int id)
				throws DAOException, InvalidAddressException, ClassNotFoundException {
			
			try {
				
				String query = "UPDATE address SET name = ?, phone_number = ?,area = ?,house_number = ?,landmark=? ,pincode=? WHERE id = ?";
				try (Connection connection = ConnectionUtil.getConnection()) {

					// Execute update statement using task id
					try (PreparedStatement pst = connection.prepareStatement(query)) {
						pst.setString(1, address.getName());
						pst.setString(2, address.getPhoneNumber());
						pst.setString(3, address.getArea());
						pst.setString(4, address.getHouseNumber());
						pst.setString(5, address.getLandMark());
						pst.setString(6, address.getPincode());
						
						pst.setInt(7, id);

						int row = pst.executeUpdate();

						logger.info("number of rows updated : " + row);

					}
				}
			}
			catch (SQLException e) {
				throw new DAOException("Error in updating address", e);
			}
			return true;
		}
		
		// this method for deleting product row from table
		public static boolean deleteAddress(int id) throws DAOException, ClassNotFoundException {

			try {
				//Query for delete row from address table
				String query = "DELETE FROM address WHERE id = ?";
				try (Connection connection = ConnectionUtil.getConnection()) {

					try (PreparedStatement pst = connection.prepareStatement(query)) {
						pst.setInt(1, id);
						int row = pst.executeUpdate();
						logger.info("number of rows deleted : " + row);
					}
				}
			} catch (SQLException e) {
				throw new DAOException("Error in delete address", e);
			}

			return true;
		}
		
		public static List<Address> getAllAddress(int userId) throws DAOException, ClassNotFoundException, SQLException {
			try(Connection connection = ConnectionUtil.getConnection()){
				String query = "SELECT * from address WHERE user_id = ?";
				
				try (PreparedStatement pst = connection.prepareStatement(query)) {
					pst.setInt(1, userId);
					try (ResultSet resultSet = pst.executeQuery()) {
						// Create an ArrayList for get and insert all from database
						List<Address> AddressList = new ArrayList<Address>();
						
						while(resultSet.next()){
							int id = resultSet.getInt("id");
							String name = resultSet.getString("name");
							String phoneNumber = resultSet.getString("phone_number");
							String area = resultSet.getString("area");
							String houseNumber = resultSet.getString("house_number");
							String landmark = resultSet.getString("landmark");
							String pincode = resultSet.getString("pincode");
							int sqlUserId = resultSet.getInt("user_id");
							
							Address address = new Address(name,phoneNumber,area,houseNumber,landmark,pincode);
							address.setId(id);
							address.setUserId(sqlUserId);
							AddressList.add(address);
							
						}
						return AddressList;
					}
				}
			}
			catch (SQLException e) {
				throw new DAOException("Error in get Address");
			}
			
		}
		
		public static Address getAddressById(int addressId) throws DAOException, ClassNotFoundException, SQLException {
			try(Connection connection = ConnectionUtil.getConnection()){
				String query = "SELECT * from address WHERE id = ?";
				
				try (PreparedStatement pst = connection.prepareStatement(query)) {
					pst.setInt(1, addressId);
					try (ResultSet resultSet = pst.executeQuery()) {
						
						if(resultSet.next()){
							int id = resultSet.getInt("id");
							String name = resultSet.getString("name");
							String phoneNumber = resultSet.getString("phone_number");
							String area = resultSet.getString("area");
							String houseNumber = resultSet.getString("house_number");
							String landmark = resultSet.getString("landmark");
							String pincode = resultSet.getString("pincode");
							int sqlUserId = resultSet.getInt("user_id");
							
							Address address = new Address(name,phoneNumber,area,houseNumber,landmark,pincode);
							address.setId(id);
							address.setUserId(sqlUserId);
							return address;
						}
						return null;
					}
				}
			}
			catch (SQLException e) {
				throw new DAOException("Error in get Address");
			}
			
		}
}
