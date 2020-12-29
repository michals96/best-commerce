package com.demo.entrypoint.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entrypoint.entity.Product;
import com.demo.entrypoint.repositories.ProductsRepository;

@Service
public class ProductsServiceImpl implements ProductsService{
	
	private final ProductsRepository productsRepository;
	
	@Autowired
	ProductsServiceImpl(ProductsRepository productsRepository){
		this.productsRepository = productsRepository;
	}
	
	@Override
	public List<Product> listProducts() {
		return productsRepository.getAllProducts();
	}

}
