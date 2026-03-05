package com.sara.ecommerce.model;

import jakarta.persistence.*;

@Entity // this means that the class Product represents a table in the database
public class Product {
//	Initialize all columns
	
	@Id // primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) //  auto-increment
	private Long id; // id is long because I can save many product and it support null, I need null because when I don't save it, it will be null and not 0 which will be in int
	
	private String name;
	private double price;
	private String description;

//	Generate an empty constructor required by JPA
	public Product() {
		
	}
	
//	Generate getters and setters to access all values
	public Long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public double getPrice() {
		return price;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
}
