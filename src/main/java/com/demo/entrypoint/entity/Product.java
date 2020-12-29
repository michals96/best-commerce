package com.demo.entrypoint.entity;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
public class Product {
	private long id;
	private String category;
	private String name;
	private String description;
	private Double unitprice;
	private Integer inventory;
	private String paymentoption;
	private String deliverymethod;
	
    @Override
    public String toString() {
        return name;
    }
}
