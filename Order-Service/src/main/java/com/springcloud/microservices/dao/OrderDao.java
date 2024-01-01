package com.springcloud.microservices.dao;

import java.util.List;

import com.springcloud.microservices.Entity.Order;
import com.springcloud.microservices.controller.dto.OrderResponse;

public interface OrderDao {
	
	long saveOrder(Order order);
	
	List<Order> getOrderList();

	Order getOrderByOrderId(long orderId);

}
