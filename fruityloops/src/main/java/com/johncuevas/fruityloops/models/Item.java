package com.johncuevas.fruityloops.models;

public class Item {
	
//	Member Variables
	private String name;
	private double price;
	
//	Constructor
	public Item(String name, double price) {
		super();
		this.name = name;
		this.price = price;
	}
	
//	Getters and setters

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

	
	
	

}
