package com.demo.entrypoint.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.demo.entrypoint.entity.Product;

@Repository
public class ProductsRepositoryImpl implements ProductsRepository{

	@Override
	public List<Product> getAllProducts() {
		List<Product> productsList = new ArrayList<Product>(); 
		
		Product firstProduct = new Product(1, "asd", "asd", "asd", 10.0, 1, "asd", "asd");
		Product secondProduct = new Product(2, "asd", "asd", "asd", 10.0, 1, "asd", "asd");
		
		productsList.add(firstProduct);
		productsList.add(secondProduct);
		
		return productsList;
	}

}