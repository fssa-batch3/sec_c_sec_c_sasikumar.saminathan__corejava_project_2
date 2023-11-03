package com.fssa.shopnow.dao;
import java.sql.Connection;

import com.fssa.shopnow.errors.UserErrors;
import com.fssa.shopnow.exception.InvalidUserException;
import com.fssa.shopnow.model.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fssa.shopnow.util.ConnectionUtil;
import com.fssa.shopnow.util.Logger;
import com.fssa.shopnow.util.PasswordTool;

public class UserDao {
	
	private UserDao() {
		throw new IllegalStateException("Utility class");
	}
	
	static Logger logger = new Logger();
	
	public static boolean addUser(User user) throws InvalidUserException, SQLException, DAOException{
		try(Connection connection = ConnectionUtil.getConnection()){
			// Create insert statement
			String query = "INSERT INTO users (name,email,password,phone_number) VALUES (?,?,?,?)";
			
			String hashedPassword = PasswordTool.hashPassword(user.getPassword());
			// Execute insert statement
			try (PreparedStatement pst = connection.prepareStatement(query)) {

				pst.setString(1, user.getName());
				pst.setString(2, user.getEmail());
				pst.setString(3, hashedPassword);
				pst.setString(4, user.getMobileNumber());
				
				int rows = pst.executeUpdate();

				logger.info("number of rows inserterd:" + rows);

			}
		} catch (SQLException e) {
			throw new DAOException(UserErrors.CREATE_ERROR);
		}
		
		return true;
	}
	
	public static boolean updateUser(User user,int id) throws InvalidUserException, SQLException, DAOException{
		try(Connection connection = ConnectionUtil.getConnection()){
			
			String query = "UPDATE users SET name = ?, password = ?,phone_number = ? WHERE id = ?";
			// Execute insert statement
			try (PreparedStatement pst = connection.prepareStatement(query)) {
					pst.setString(1, user.getName());
					pst.setString(2, user.getPassword());
					pst.setString(3, user.getMobileNumber());
					pst.setInt(4, id);
					
					int row = pst.executeUpdate();

					logger.info("number of rows updated : " + row);
			}
		}
		catch (Exception e) {
			throw new DAOException(UserErrors.UPDATE_ERROR, e);
		}
		return true;	
	}
	
	public static List<User> getAllUsers() throws DAOException, ClassNotFoundException, SQLException {
		try(Connection connection = ConnectionUtil.getConnection()){
			String query = "SELECT * from users";
			
			try (Statement statement = connection.createStatement()) {
				try (ResultSet resultSet = statement.executeQuery(query)) {
					// Create an ArrayList for get and insert all from databse
					List<User> userList = new ArrayList<User>();
					
					while(resultSet.next()){
						int id = resultSet.getInt("id");
						String name = resultSet.getString("name");
						String email = resultSet.getString("email");
						String password  = resultSet.getString("password");
						String mobileNumber = resultSet.getString("phone_number");
						
						User user = new User(name,email,mobileNumber);
						user.setPassword(password);
						
						user.setId(id);
						
						userList.add(user);
					}
					return userList;
				}
			}
		}
		catch (SQLException e) {
			throw new DAOException(UserErrors.GET_ERROR);
		}
		
	}
	
	public static boolean isEmailExist(String email) throws SQLException, DAOException{
		try(Connection connection = ConnectionUtil.getConnection()){
			String query = "SELECT COUNT(*) FROM users WHERE email = ?";
			try(PreparedStatement preparedStatement = connection.prepareStatement(query);){
				preparedStatement.setString(1, email);
				
				try(ResultSet resultSet = preparedStatement.executeQuery();){
		            if (resultSet.next()) {
		                int count = resultSet.getInt(1);
		                return count > 0;
		            }
				}
			}
		}
		return false;
	}
	
	public static boolean isAccountExist(String email,String password) throws SQLException, DAOException{
		try(Connection connection = ConnectionUtil.getConnection()){
			String query = "SELECT COUNT(*) FROM users WHERE email = ? AND password = ?";
			try(PreparedStatement preparedStatement = connection.prepareStatement(query);){
				preparedStatement.setString(1, email);
				preparedStatement.setString(2,password);
				
				try(ResultSet resultSet = preparedStatement.executeQuery();){
		            if (resultSet.next()) {
		                int count = resultSet.getInt(1);
		                return count > 0;
		            }
				}
			}
		}
		return false;
	}
	
	public static User getUserbyEmail(String userEmail) throws DAOException, ClassNotFoundException, SQLException {
		try(Connection connection = ConnectionUtil.getConnection()){
			String query = "SELECT * from users WHERE email = ?";
			
			try (PreparedStatement pst = connection.prepareStatement(query)) {
				pst.setString(1, userEmail);
				try (ResultSet resultSet = pst.executeQuery()) {

					
					if(resultSet.next()){
						int id = resultSet.getInt("id");
						String name = resultSet.getString("name");
						String email = resultSet.getString("email");
						String mobileNumber = resultSet.getString("phone_number");
						
						User user = new User(name,email,mobileNumber);
						user.setId(id);
						return user;
					}
					return null;
				}
			}
		}
		catch (SQLException e) {
			throw new DAOException("Error in get user");
		}
		
	}
}
