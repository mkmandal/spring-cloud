package com.springdocker.springdocker.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.springdocker.springdocker.dao.ProductDao;
import com.springdocker.springdocker.exception.NotFoundException;
import com.springdocker.springdocker.model.Product;
import com.springdocker.springdocker.repository.ProductRepository;

@Service
public class ProductDaoImpl implements ProductDao {

	@Autowired
	private ProductRepository productRepo;

	@Override
	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		return productRepo.findAll();
	}

	@Override
	public long saveProduct(Product product) {
		// TODO Auto-generated method stub
		Product p = productRepo.save(product);
		return p.getId();
	}

	@Override
	public Product getProductById(long id) {
		// TODO Auto-generated method stub
		Optional<Product> findById = productRepo.findById(id);
		Product product = findById.get();

		return product;
	}

	@Override
	public long updateQuantity(long id, int quantity) {

		long saveId = 0;

		Product product = productRepo.findById(id)
				.orElseThrow(() -> new NotFoundException(HttpStatus.NOT_FOUND,HttpStatus.NOT_FOUND.value(),"Product not found with this Id !!"));

		int availableQuantity = product.getQuantity();

		if (availableQuantity < quantity) {

			throw new NotFoundException(HttpStatus.OK,HttpStatus.OK.value(),"Product is out of stock !!");
		}

		if (availableQuantity > quantity) {
			product.setQuantity(availableQuantity - quantity);
			Product save = productRepo.save(product);

			return saveId = save.getId();
		}

		return saveId;

	}

}
