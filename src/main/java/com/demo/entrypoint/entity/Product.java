package com.demo.entrypoint.entity;
import javax.persistence.*;

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

	@Override
    public String toString() {
        return name;
    }
}
