package com.fssa.shopnow.service;
import java.sql.SQLException;
import java.util.List;

import com.fssa.shopnow.dao.*;
import com.fssa.shopnow.model.*;
import com.fssa.shopnow.validator.*;
import com.fssa.shopnow.exception.*;

//In this service we validate the product object after validated object will be connected with DAO layer

public class ProductService {
	
	ProductDao productDao;
	ValidateProduct validator;
	 
	//Creating constructor for intialize objects
	public ProductService(ProductDao productDao,ValidateProduct validator) {
		this.productDao = productDao;
		this.validator = validator;
	}
	
 
	public ProductService() { 
		// TODO Auto-generated constructor stub
	}

 
	public boolean addProduct(Product product) throws DAOException,InvalidProductException, ClassNotFoundException, SQLException {
		if(ValidateProduct.validate(product)){ 
			return ProductDao.addProduct(product);
		}
		else {
			return false;
		}
	}
	
	public boolean updateProduct(Product product) throws DAOException,InvalidProductException, ClassNotFoundException {
		if(ValidateProduct.validate(product)){
			return ProductDao.updateProduct(product);
		}
		else {
			return false;
		}
	}
	
	public boolean deleteProduct(String name) throws DAOException,InvalidProductException, ClassNotFoundException {
		if(ValidateProduct.validateName(name)){
			return ProductDao.deleteProduct(name);
		}
		else {
			return false;
		} 
	}
	
	public boolean addImageUrls(List<String> imageURLs,String name) throws InvalidProductException, DAOException, ClassNotFoundException {
		if(ValidateProduct.validateImageURL(imageURLs) && ValidateProduct.validateName(name)) {
			return ProductDao.addImageUrls(imageURLs, name);
		}
		else {
			return false;
		}
	}
	
	public List<Product> getProducts() throws ClassNotFoundException, DAOException{
		List<Product> products =  ProductDao.getAllProducts();
		return products;
	}
	
	public String getProductNamebyId(int id) throws DAOException{
		if(ValidateProduct.validateID(id)){
			return ProductDao.getproductNamebyId(id);
		}
		else {
			return null;
		}
	}
	
	public List<Integer> getShopListbyProductName(String name) throws DAOException{
		if(ValidateProduct.validateName(name)) {
			List<Integer> shopList = ProductDao.getShopListByProductName(name);
			return shopList;
		}
		return null;
	}
	
	public Product getProuctById(int id) throws ClassNotFoundException, DAOException {
		if(ValidateProduct.validateID(id)) {
			return ProductDao.getProductById(id);
		}
		return null;
	}
	
}
