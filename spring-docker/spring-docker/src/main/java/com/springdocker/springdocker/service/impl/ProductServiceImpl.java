package com.springdocker.springdocker.service.impl;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springdocker.springdocker.dao.ProductDao;
import com.springdocker.springdocker.dto.ProductDTO;
import com.springdocker.springdocker.exception.NotFoundException;
import com.springdocker.springdocker.model.Product;
import com.springdocker.springdocker.service.ProductService;
import com.springdocker.springdocker.utility.ToolBox;

@Service
public class ProductServiceImpl implements ProductService {

	org.slf4j.Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

	@Autowired
	private ProductDao productDao;

	@Override
	public List<Product> getAllProduct() {
		// log.info(");
		logger.info("getting product List -> {}");
		return productDao.getAllProduct();
	}

	@Override
	public long saveProduct(ProductDTO dto) {
		Product product = new Product();
		try {

			product.setProductName(dto.getProduct());
			product.setPrice(dto.getPrice());
			product.setQuantity(dto.getQuantity());
		} catch (Exception e) {
			logger.info(e.toString());

		}
		productDao.saveProduct(product);

		return product.getId();

	}

	@Override
	public ProductDTO getProductById(long id) {
		Product product = null;
		ProductDTO dto = new ProductDTO();
		try {
			product = productDao.getProductById(id);
			if (!ToolBox.isObjectEmpty(product)) {
				dto.setProduct(product.getProductName());
				dto.setPrice(product.getPrice());
				dto.setQuantity(product.getQuantity());
			}
		} catch (Exception e) {
			logger.info("Product Not Found :-" + e.getMessage() + " with Id {id} " + id);
			throw new NotFoundException("Product Not Found");
		}
		return dto;
	}

	@Override
	public long updateQuantity(long id, int quantity) {

		long productId = productDao.updateQuantity(id, quantity);

		return productId;

	}

}
