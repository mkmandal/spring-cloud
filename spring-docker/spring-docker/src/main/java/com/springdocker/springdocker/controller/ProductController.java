package com.springdocker.springdocker.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springdocker.springdocker.dto.ProductDTO;
import com.springdocker.springdocker.model.Product;
import com.springdocker.springdocker.service.ProductService;
import com.springdocker.springdocker.utility.ResponseDTO;
import com.springdocker.springdocker.utility.ToolBox;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping("/getProduct")
	public ResponseDTO getProductList() {

		ResponseDTO resp = new ResponseDTO(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(), "Bad Request !!");

		List<Product> list = productService.getAllProduct();
		if (!ToolBox.isCollectionEmpty(list)) {

			resp = new ResponseDTO(HttpStatus.OK, HttpStatus.OK.value(), list, "success");

		}
		return resp;
	}
	

	@PostMapping("/saveProduct")
	public ResponseDTO saveProduct(@RequestBody ProductDTO productDto) {

		ResponseDTO resp = new ResponseDTO(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(), "Bad Request !!");

		if (!ToolBox.isObjectEmpty(productDto)) {

			long saveProduct = productService.saveProduct(productDto);

			resp = new ResponseDTO(HttpStatus.OK, HttpStatus.OK.value(), saveProduct, "Success !!");

		}
		
	

		return resp;

	}

	@GetMapping("/getProductById/{id}")
	public ResponseDTO getProductById(@PathVariable(value = "id") long id) {

		ResponseDTO resp = new ResponseDTO(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(), "Bad Request !!");
		if (Objects.isNull(id)) {
			return resp;
		}

		ProductDTO product = productService.getProductById(id);
		if (ToolBox.isObjectEmpty(product)) {
			return resp = new ResponseDTO(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.value(), "PRODUCT_NOT_FOUND !!");
		}

		resp = new ResponseDTO(HttpStatus.OK, HttpStatus.OK.value(), product, "Success !!");
		return resp;

	}

	@PutMapping("/upateQuantity/{productId}")
	public ResponseDTO updateProductQuantity(@PathVariable long productId, @RequestParam int quantity) {
		ResponseDTO resp = new ResponseDTO(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(), "Bad Request !!");
		if (!Objects.isNull(productId) && !Objects.isNull(quantity)) {
			long pId = productService.updateQuantity(productId, quantity);
			if (pId > 0) {
				resp = new ResponseDTO(HttpStatus.OK, HttpStatus.OK.value(), "PRODUCT_QUANTITY_UPDATED !!");
			} else {
				resp = new ResponseDTO(HttpStatus.EXPECTATION_FAILED, HttpStatus.EXPECTATION_FAILED.value(),
						"Somethig went wrong !!");
			}
		}

		return resp;

	}

}
