package com.demo.entrypoint.controllers;

import java.util.List;
import javax.inject.Inject;
import com.demo.entrypoint.entity.Product;
import com.demo.entrypoint.services.ProductsService;
import com.demo.entrypoint.services.ProductsServiceImpl;

public class BestCommerceController {

	@Inject
	private final ProductsService productsService;
	
	public BestCommerceController() {
		this.productsService = new ProductsServiceImpl();
	}
	
	public List<Product> allProducts(){
		return productsService.listProducts();
	}
	
	public List<Product> sortedProducts(String sortAttribute){
		System.out.println(sortAttribute);
		return productsService.listSortedProducts(sortAttribute);
	}
	
}
