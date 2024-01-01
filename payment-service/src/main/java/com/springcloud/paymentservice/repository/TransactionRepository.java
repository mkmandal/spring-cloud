package com.springcloud.paymentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springcloud.paymentservice.dto.TransactionRequest;
import com.springcloud.paymentservice.model.TransactionDetails;
import java.util.List;


@Repository
public interface TransactionRepository extends JpaRepository<TransactionDetails, Long> {
	
	
	TransactionRequest  findByOrderId(long orderId);

}
