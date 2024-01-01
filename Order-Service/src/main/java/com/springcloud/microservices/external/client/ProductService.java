package com.springcloud.microservices.external.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
                    
@FeignClient(name="PRODUCT-SERVICE/product")
public interface ProductService {
	
	@PutMapping(value="/upateQuantity/{id}", consumes = "application/x-www-form-urlencoded")
	public ResponseEntity<Void> updateProductQuantity(@PathVariable long id, @RequestParam int quantity);

}
