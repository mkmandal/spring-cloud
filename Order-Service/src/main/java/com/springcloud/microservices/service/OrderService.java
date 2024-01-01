package com.springcloud.microservices.service;

import java.util.List;

import org.springframework.data.domain.jaxb.SpringDataJaxb.OrderDto;

import com.springcloud.microservices.controller.dto.OrderDTO;
import com.springcloud.microservices.controller.dto.OrderResponse;

public interface OrderService {
	
	long saveOrder(OrderDTO orderDto);
	
	List<OrderDTO> getOrderList();

	OrderResponse getOrderDetails(long orderId);

}
