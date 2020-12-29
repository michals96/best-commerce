package com.demo.entrypoint.services;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entrypoint.entity.Product;
import com.demo.entrypoint.repositories.ProductsRepository;
import com.demo.entrypoint.repositories.ProductsRepositoryImpl;
import com.sun.org.apache.xml.internal.resolver.readers.SAXCatalogParser;

@Service("productsServiceImpl")
public class ProductsServiceImpl implements ProductsService{
	
	@Inject
	private final ProductsRepository productsRepository;
	
	public ProductsServiceImpl() {
		this.productsRepository = new ProductsRepositoryImpl();
	}

	@Override
	public List<Product> listProducts() {
		return productsRepository.getAllProducts();
	}
	
	@Override
	public List<Product> listSortedProducts(String sortAttribute){
		
		List<Product> productsList = productsRepository.getAllProducts();
	
		if(sortAttribute.equals("price")) {
			Collections.sort(productsList, (Product p1, Product p2) ->{
				return p1.getUnitprice().compareTo(p2.getUnitprice());
			});
		}
		else if(sortAttribute.equals("inventory")) {
			Collections.sort(productsList, (Product p1, Product p2) ->{
				return p1.getInventory().compareTo(p2.getInventory());
			});
		}
		
		return productsList;
	}
}
