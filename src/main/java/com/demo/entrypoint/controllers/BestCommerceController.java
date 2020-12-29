package com.demo.entrypoint.controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.demo.entrypoint.entity.Product;
import com.demo.entrypoint.services.ProductsService;
import com.demo.entrypoint.services.ProductsServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;

public class BestCommerceController {

	@Inject
	private final ProductsService productsService;
	
	public BestCommerceController() {
		this.productsService = new ProductsServiceImpl();
	}
	
	public List<Product> listProducts(){
		return productsService.listProducts();
	}
}
