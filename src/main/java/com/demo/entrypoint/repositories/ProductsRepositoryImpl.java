package com.demo.entrypoint.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.demo.entrypoint.entity.Product;

@Repository
@Component("productsRepositoryImpl")
public class ProductsRepositoryImpl implements ProductsRepository{

	@Override
	public List<String> getAllProducts() {
		List<String> productsList = new ArrayList<String>(); 
		
		Product firstProduct = new Product(1, "asd", "asd", "asd", 10.0, 1, "asd", "asd");
		Product secondProduct = new Product(2, "asd", "asd", "asd", 10.0, 1, "asd", "asd");
		
		productsList.add(firstProduct.toString());
		productsList.add(secondProduct.toString());
		
		return productsList;
	}

}