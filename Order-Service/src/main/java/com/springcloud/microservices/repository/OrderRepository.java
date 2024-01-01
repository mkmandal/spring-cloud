package com.springcloud.microservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springcloud.microservices.Entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
	

}
