package com.springdocker.springdocker.service;

import java.util.List;

import com.springdocker.springdocker.dto.ProductDTO;
import com.springdocker.springdocker.model.Product;

public interface ProductService {
	
	List<Product> getAllProduct();

	long saveProduct(ProductDTO productDto);

	ProductDTO getProductById(long id);

	long updateQuantity(long id, int quantity);

}
