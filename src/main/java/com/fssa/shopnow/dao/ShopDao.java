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
import com.fssa.shopnow.exception.InvalidShopException;
import com.fssa.shopnow.model.Shop;
import com.fssa.shopnow.model.User;
import com.fssa.shopnow.util.ConnectionUtil;
import com.fssa.shopnow.util.Logger;

public class ShopDao {
	
	private ShopDao() {
		throw new IllegalStateException("Utility class");
	}
	
	static Logger logger = new Logger();
	
	public static boolean addShop(Shop shop)
			throws DAOException, InvalidShopException, ClassNotFoundException, SQLException {

		try (Connection connection = ConnectionUtil.getConnection()) {

			// Create insert statement
			String query = "INSERT INTO shop (name,address,area,lat,lon,license_id,phone_number,pincode,seller_id,image) VALUES (?,?,?,?,?,?,?,?,?,?)";
			// Execute insert statement
			try (PreparedStatement pst = connection.prepareStatement(query)) {

				pst.setString(1, shop.getName());
				pst.setString(2, shop.getAddress());
				pst.setString(3, shop.getArea());
				pst.setDouble(4, shop.getLat());
				pst.setDouble(5, shop.getLon());
				pst.setString(6, shop.getLicense());
				pst.setString(7, shop.getPhoneNumber());
				pst.setString(8, shop.getPincode());
				pst.setInt(9, shop.getSellerId());
				pst.setString(10,shop.getImage());
				
				int rows = pst.executeUpdate();

				logger.info("number of rows inserted:" + rows);

			}
		} catch (SQLException e) {
			throw new DAOException("Error in creating shop");
		}

		return true;
	}
	
	public static List<Shop> getShopsbyProduct(String[] shopIdList) throws SQLException, DAOException{
		List<Shop> shopList = new ArrayList<Shop>();
		
		for(String shopId : shopIdList) {
			try(Connection connection = ConnectionUtil.getConnection()){
				String query = "SELECT * FROM shop WHERE id = ?";
				try (PreparedStatement pst = connection.prepareStatement(query)) {
					pst.setInt(1, Integer.parseInt(shopId));
					try (ResultSet resultSet = pst.executeQuery()) {
						Shop shop = new Shop();
						
						if(resultSet.next()) {
							int id = resultSet.getInt("id");
							String name = resultSet.getString("name");
							String address = resultSet.getString("address");
							String area  = resultSet.getString("area");
							String mobileNumber = resultSet.getString("phone_number");
							double lat = resultSet.getDouble("lat");
							double lon = resultSet.getDouble("lon");
							String license = resultSet.getString("license_id");
							String pincode = resultSet.getString("pincode");
							int sellerId = resultSet.getInt("seller_id");
							String imageUrl = resultSet.getString("image");
							
							shop.setId(id);
							shop.setName(name);
							shop.setAddress(address);
							shop.setArea(area);
							shop.setPhoneNumber(mobileNumber);
							shop.setLat(lat);
							shop.setLon(lon);
							shop.setLicense(license);
							shop.setPincode(pincode);
							shop.setSellerId(sellerId);
							shop.setImage(imageUrl);
							
							shopList.add(shop);
						}
					}
				}
			}	
		}
		return shopList;
	}
	
	public static List<Shop> getAllShops() throws DAOException, ClassNotFoundException, SQLException {
		try(Connection connection = ConnectionUtil.getConnection()){
			String query = "SELECT * from shop";
			
			try (Statement statement = connection.createStatement()) {
				try (ResultSet resultSet = statement.executeQuery(query)) {
					// Create an ArrayList for get and insert all from databse
					List<Shop> shopList = new ArrayList<Shop>();
					
					while(resultSet.next()){
						int id = resultSet.getInt("id");
						String name = resultSet.getString("name");
						String address = resultSet.getString("address");
						String area  = resultSet.getString("area");
						String mobileNumber = resultSet.getString("phone_number");
						double lat = resultSet.getDouble("lat");
						double lon = resultSet.getDouble("lon");
						String license = resultSet.getString("license_id");
						String pincode = resultSet.getString("pincode");
						int sellerId = resultSet.getInt("seller_id");
						String imageUrl = resultSet.getString("image");
						
						Shop shop = new Shop();
						shop.setId(id);
						shop.setName(name);
						shop.setAddress(address);
						shop.setArea(area);
						shop.setPhoneNumber(mobileNumber);
						shop.setLat(lat);
						shop.setLon(lon);
						shop.setLicense(license);
						shop.setPincode(pincode);
						shop.setSellerId(sellerId);
						shop.setImage(imageUrl);
						
						shopList.add(shop);
					}
					return shopList;
				}
			}
		}
		catch (SQLException e) {
			throw new DAOException(UserErrors.GET_ERROR);
		}
		
	}

}
