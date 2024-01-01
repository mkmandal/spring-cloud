package com.springcloud.microservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springcloud.microservices.controller.dto.OrderDTO;
import com.springcloud.microservices.controller.dto.OrderResponse;
import com.springcloud.microservices.service.OrderService;
import com.springcloud.microservices.utility.ResponseDTO;
import com.springcloud.microservices.utility.ToolBox;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@PostMapping("/saveOrder")
	public ResponseDTO saveOrder(@RequestBody OrderDTO orderDTO) {

		ResponseDTO response = new ResponseDTO(HttpStatus.BAD_GATEWAY, HttpStatus.BAD_GATEWAY.value(),
				"Request Not Valid !!");

		if (!ToolBox.isObjectEmpty(orderDTO)) {
			long id = orderService.saveOrder(orderDTO);
			response = new ResponseDTO(HttpStatus.CREATED, HttpStatus.CREATED.value(),
					"Order Placed Successfully , Order Id : " + id);
		}
		return response;

	}

	@GetMapping("getDetail/{orderId}")
	public ResponseEntity<OrderResponse> getOrderDetails(@PathVariable long orderId) {
		OrderResponse orderResponse = orderService.getOrderDetails(orderId);

		return new ResponseEntity<>(orderResponse, HttpStatus.OK);
	}

}
