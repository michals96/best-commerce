package com.demo.entrypoint.services;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import com.demo.entrypoint.entity.Product;
import com.demo.entrypoint.repositories.ProductsRepository;
import com.demo.entrypoint.repositories.ProductsRepositoryImpl;


@Service("productsServiceImpl")
public class ProductsServiceImpl implements ProductsService{
	
	final List<String> sortingParameters = Arrays.asList("price", "inventory");
	
	@Inject
	private final ProductsRepository productsRepository;
	
	public ProductsServiceImpl() {
		this.productsRepository = new ProductsRepositoryImpl();
	}
	
	public List<Product> filterListByInventory(List<Product> list) {
		// Products with inventory lower than 5 cannot be listed.
		return list.stream().filter(product -> product.getInventory() >= 5).collect(Collectors.toList());
	}
	
	@Override
	public List<Product> listProducts() {
		return filterListByInventory(productsRepository.getAllProducts());
	}
	
	@Override
	public List<Product> listSortedProducts(String sortAttribute){
		
		if(sortingParameters.contains(sortAttribute) == false) System.out.println("INVALID SORTING ATTRIBUTE!");
		
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
		
		return filterListByInventory(productsList);
	}
}
