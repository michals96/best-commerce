package com.demo.entrypoint.repositories;

import java.util.List;

import com.demo.entrypoint.entity.Product;

public interface ProductsRepository {
	List<Product> getAllProducts();
}
