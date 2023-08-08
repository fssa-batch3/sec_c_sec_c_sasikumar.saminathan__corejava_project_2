package com.fssa.shopnow.dao;
import java.util.*;
import com.fssa.shopnow.connectionUtil.*;
import com.fssa.shopnow.validator.*;
import com.fssa.shopnow.model.*;
import com.fssa.shopnow.errors.ProductErrors;
import com.fssa.shopnow.exception.*;
import com.mysql.cj.x.protobuf.MysqlxCrud.Delete;
import java.sql.*;

public class ProductDao {

//	public static Connection getConnection() throws DAOException {
//
//		Connection connection = null;
//		String url = "jdbc:mysql://localhost:3306/shopnow"; // url for to connect local database
//		String userName = "root";
//		String passWord = "123456"; 
//		try {  
////	            Class.forName("com.mysql.cj.jdbc.Driver"); 
//			connection = DriverManager.getConnection(url, userName, passWord);
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw new DAOException(ProductErrors.CONNECTION_ISSUE);
//		}
//		return connection;
//	}

	public static boolean addProduct(Product product) throws DAOException,InvalidProductException {
				
		// Write code here to get connection
		Connection connection = null;
		try {
			// Create insert statement
			String query = "INSERT INTO products (product_name,product_price,product_ram,product_storage,product_highlights,product_quantity,product_brand) VALUES (?,?,?,?,?,?,?)";
			connection = ConnectionUtil.getConnection();

			// Execute insert statement
			PreparedStatement pst = connection.prepareStatement(query);

			pst.setString(1, product.getName());
			pst.setDouble(2, product.getPrice());
			pst.setInt(3, product.getRam());
			pst.setInt(4, product.getStorage());
			pst.setString(5, product.getDescription());
			pst.setInt(6, product.getQuantity());
			pst.setString(7, product.getBrand());
			int rows = pst.executeUpdate();

			System.out.println("number of rows affected:" + rows);
		} catch (SQLException e) {
			throw new DAOException(ProductErrors.CREATE_ERROR, e);
		} finally {
			// close connection
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new DAOException(ProductErrors.CLOSE_ERROR, e);
			}
		}

		return true;
	}
	
	public static int getProductIdByName(String name) throws DAOException{
		
		//Write here to get connection
		Connection connection = null;
		
		try {
			String query = "SELECT product_id FROM products WHERE product_name = ?";
			connection = ConnectionUtil.getConnection();
			try( PreparedStatement pst = connection.prepareStatement(query) ){
			pst.setString(1, name);
			
			try( ResultSet resultSet = pst.executeQuery() ){
				
				if(resultSet.next()) {
					int productId = resultSet.getInt("product_id");
					return productId;
				}
				else {
					throw new DAOException("Product not found");
				}
			 }
			}
		}
		catch (SQLException e) {
			throw new DAOException("Cannot get product id by name");
		}
		finally {
			// close connection
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new DAOException(ProductErrors.CLOSE_ERROR, e);
			}
		}
	}
	
	public static boolean addImageUrls(List<String> imageUrls,String productName) throws DAOException,InvalidProductException {
		
		//Get the product id with product name
		int productId = getProductIdByName(productName);
		
		Connection connection = null;
		
		int rows = 0;
		
		try {
			connection = ConnectionUtil.getConnection();
			for(String url : imageUrls) {
				String query = "INSERT INTO Product_images (product_id,image_url) VALUES (?,?)";
				try( PreparedStatement pst = connection.prepareStatement(query) ){
					pst.setInt(1, productId);
					pst.setString(2, url);
					 rows += pst.executeUpdate();
				} 
				
			}
		} catch (SQLException e) {
			throw new DAOException("cannot add image URL's");
		}
		finally {
			System.out.println("number of rows affected:" + rows);
			// close connection
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new DAOException(ProductErrors.CLOSE_ERROR, e);
			}
			
		}
		return true;
	}

	// this method for updating the table
	public static boolean updateProduct(Product product) throws DAOException,InvalidProductException {
		
		Connection connection = null;
		try {
			// Create update statement using task id
			String query = "UPDATE products SET product_name = ?, product_price = ?,product_ram = ?,product_storage = ?,product_highlights = ?,product_quantity=? ,product_brand=? WHERE product_id = ?";
			connection = ConnectionUtil.getConnection();

			// Execute update statement using task id
			PreparedStatement pst = connection.prepareStatement(query);
			pst.setString(1, product.getName());
			pst.setDouble(2, product.getPrice());
			pst.setInt(3, product.getRam());
			pst.setInt(4, product.getStorage());
			pst.setString(5, product.getDescription());
			pst.setInt(6, product.getQuantity());
			pst.setString(7, product.getBrand());
			pst.setInt(8, product.getId());

			int row = pst.executeUpdate();

			System.out.println("number of rows updated : " + row);
		} catch (SQLException e) {
			throw new DAOException(ProductErrors.UPDATE_ERROR, e);
		} finally {
			// close connection
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new DAOException(ProductErrors.CLOSE_ERROR, e);
			}
		}
		return true;
	}

	// this method for deleting product row from table
	public static boolean deleteProduct(int id) throws DAOException {
		
		Connection connection = null;
		try {
			// Create delete statement query product id
			String query = "DELETE FROM products WHERE product_id = ?";
			connection = ConnectionUtil.getConnection();

			// Execute delete statement
			PreparedStatement pst = connection.prepareStatement(query);
			pst.setInt(1, id);
			int row = pst.executeUpdate();
			System.out.println("number of rows deleted : " + row);
		} catch (SQLException e) {
			throw new DAOException(ProductErrors.DELETE_ERROR, e);
		} finally {
			// close connection
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new DAOException(ProductErrors.CLOSE_ERROR, e);
			}
		}

		return true;
	}
	
	//This method for reading all the rows from products table
	public static List<Product> getAllProducts() throws DAOException {
		
		// Write code here to get connection
		Connection connection = null;
		try {
			// Create a Select all query
			String query = "SELECT\r\n"
					+ "    p.*,\r\n"
					+ "    (SELECT GROUP_CONCAT(image_url) FROM product_images pi WHERE pi.product_id = p.product_id) AS imageUrls\r\n"
					+ "FROM products p;";
			connection = ConnectionUtil.getConnection();

			// Execute query
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);

			// Create an ArrayList for get and insert all task from databse  
			List<Product> products = new ArrayList<Product>();
			while (resultSet.next()) {
				
				int id = resultSet.getInt("product_id");
				String name = resultSet.getString("product_name");
				double price = resultSet.getDouble("product_price");
				int ram = resultSet.getInt("product_ram");
				int storage = resultSet.getInt("product_storage");
				String description = resultSet.getString("product_highlights");
				int quantity = resultSet.getInt("product_quantity");
				String brand = resultSet.getString("product_brand");
				String imageUrl = resultSet.getString("imageUrls");
				
				String[] imageArr = imageUrl.split(",");
				
				List<String> imgList = new ArrayList<String>(Arrays.asList(imageArr));
				
				Product product = new Product(id,name,price,ram,storage,description,imgList,quantity,brand);
				products.add(product);
				
			}
			return products;
			
			//closing the opened statements
			//resultSet.close();
			//resultSet2.close();
			//statement.close();
		} catch (SQLException e) {
			throw new DAOException(ProductErrors.GET_ERROR, e);
		} finally {
			// close connection
			try {
				if (connection != null) { 
					connection.close();
				}
			} catch (SQLException e) {
				throw new DAOException(ProductErrors.CLOSE_ERROR, e);
			}
		}
	} 

	public static void main(String[] args) throws InvalidProductException, DAOException {
		
		// Declaring the values for product
		int id = 10; 
		String name = "Mobile Phone";
		double price = 499.99;
		int ram = 8; 
		int storage = 128;
		String description = "A powerful mobile phone.";
		String[] arr = {"https://example.com/image1.jpg","https://example.com/image1.jpg","https://example.com/image1.jpg","https://example.com/image1.jpg"}; 
		List<String> imageURL = new ArrayList<String>(Arrays.asList(arr));
		int quantity = 10;
		String brand = "BrandX";
		
		// Insert the declared values for product via constructor
		Product product = new Product(id, name, price, ram, storage, description, imageURL, quantity, brand);
		
		boolean dataq= addImageUrls(imageURL,name);
		
		if(dataq) {
			System.out.println("success");
			
		}
		else {
			System.out.println("fail");
		}
//		
//		try {
//			addProduct(product);
//		} catch (InvalidProductException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (DAOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
	}

}