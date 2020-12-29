package com.demo.entrypoint.services;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entrypoint.entity.Product;
import com.demo.entrypoint.repositories.ProductsRepository;
import com.demo.entrypoint.repositories.ProductsRepositoryImpl;

@Service("productsServiceImpl")
public class ProductsServiceImpl implements ProductsService{
	
	@Inject
	private final ProductsRepository productsRepository;
	
	@Autowired
	ProductsServiceImpl(ProductsRepository productsRepository){
		this.productsRepository = productsRepository;
	}
	
	public ProductsServiceImpl() {
		this.productsRepository = new ProductsRepositoryImpl();
	}

	@Override
	public List<Product> listProducts() {
		return productsRepository.getAllProducts();
	}
	

}
