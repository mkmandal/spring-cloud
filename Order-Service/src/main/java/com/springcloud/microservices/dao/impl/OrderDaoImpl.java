package com.springcloud.microservices.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springcloud.microservices.Entity.Order;
import com.springcloud.microservices.dao.OrderDao;
import com.springcloud.microservices.exception.NotFoundException;
import com.springcloud.microservices.repository.OrderRepository;

@Service
public class OrderDaoImpl implements OrderDao {

	@Autowired
	private OrderRepository orderRepo;

	@Override
	public long saveOrder(Order order) {
		Order save = orderRepo.save(order);
		return save.getId();
	}

	@Override
	public List<Order> getOrderList() {
		return orderRepo.findAll();
	}

	@Override
	public Order getOrderByOrderId(long orderId) {
		Order order = orderRepo.findById(orderId).orElseThrow(
				() -> new NotFoundException("Order not found for the order Id:" + orderId, "NOT_FOUND", 404));

		return order;
	}

}
