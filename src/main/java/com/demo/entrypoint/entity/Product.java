package com.demo.entrypoint.entity;
import javax.persistence.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Entity
public class Product {
	private long id;
	private String category;
	private String name;
	private String description;
	private Double unitprice;
	private Integer inventory;
	private String paymentoption;
	private String deliverymethod;
	
    public Product(long id, String category, String name, String description, Double unitprice, Integer inventory, String paymentoption, String deliverymethod) {
    	this.id = id;
    	this.category = category;
    	this.name = name;
    	this.description = description;
    	this.unitprice = unitprice;
    	this.inventory = inventory;
    	this.paymentoption = paymentoption;
    	this.deliverymethod = deliverymethod;
	}
    
    public long getId() {
    	return id;
    }
    
    public void setId(long id) {
    	this.id = id;
    }
    
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getUnitprice() {
		return unitprice;
	}

	public void setUnitprice(Double unitprice) {
		this.unitprice = unitprice;
	}

	public Integer getInventory() {
		return inventory;
	}

	public void setInventory(Integer inventory) {
		this.inventory = inventory;
	}

	public String getPaymentoption() {
		return paymentoption;
	}

	public void setPaymentoption(String paymentoption) {
		this.paymentoption = paymentoption;
	}

	public String getDeliverymethod() {
		return deliverymethod;
	}

	public void setDeliverymethod(String deliverymethod) {
		this.deliverymethod = deliverymethod;
	}
    
	@Override
    public String toString() {
		ObjectMapper objectmapper = new ObjectMapper();
		
		try {
			return objectmapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		return "Empty JSON";
    }
}
