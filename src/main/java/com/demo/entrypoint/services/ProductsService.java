package com.demo.entrypoint.services;

import java.util.List;

import com.demo.entrypoint.entity.Product;

public interface ProductsService {
	List<Product> listProducts();

	List<Product> listSortedProducts(String sortAttribute);
}
