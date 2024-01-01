package com.springdocker.springdocker.dao;

import java.util.List;

import com.springdocker.springdocker.model.Product;

public interface ProductDao {
	
	List<Product> getAllProduct();

	long saveProduct(Product product);

	Product getProductById(long id);

	long updateQuantity(long id, int quantity);

}
