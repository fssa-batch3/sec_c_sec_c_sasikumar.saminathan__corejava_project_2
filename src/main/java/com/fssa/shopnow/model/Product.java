package com.fssa.shopnow.model;

import java.util.List;

/*
 * This model for mobiles it have mobile attributes
 */

public class Product {
	
	private int id;
	private String name;
	private double price;
	private int ram;
	private int storage;
	private String description;
	private List<String> imageURLs;
	private int quantity;
	private String brand;
	
	public Product(int id, String name, double price, int ram, int storage, String description, List<String> imageURLs,int quantity, String brand) {
		this.id = id;
		this.name = name; 
		this.price = price;
		this.ram = ram;
		this.storage = storage;
		this.description = description;
		this.imageURLs = imageURLs;
		this.quantity = quantity;
		this.brand = brand;
	}

	public Product(){}

	public int getId() {
		return id; 
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getRam() {
		return ram;
	}

	public void setRam(int ram) {
		this.ram = ram;
	}

	public int getStorage() {
		return storage;
	}

	public void setStorage(int storage) {
		this.storage = storage;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<String> getImageURL() {
		return imageURLs;
	}

	public void setImageURL(List<String> imageURLs) {
		this.imageURLs = imageURLs;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}
	
}
