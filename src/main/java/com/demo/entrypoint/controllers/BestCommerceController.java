package com.demo.entrypoint.controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.demo.entrypoint.entity.Product;
import com.demo.entrypoint.services.ProductsService;

public class BestCommerceController {
	
	private final ProductsService productsService;
	
	public BestCommerceController(ProductsService productsService) {
		this.productsService = productsService;
	}
	
	public List<Product> listProducts(){
		return productsService.listProducts();
	}
	
	public List<String> allProducts() {
		List<String> productsList = new ArrayList<String>(); 
		
		String url = "jdbc:postgresql://localhost:5432/testdb?user=postgres&password=postgres";
		
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Class not found " + e);
		}
		
		try {
			Connection conn = DriverManager.getConnection(url);
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM products");
			
			while(resultSet.next()){
				System.out.println(resultSet.getString("name"));
				productsList.add(resultSet.getString("name"));
			}
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		return productsList;
	}

}
