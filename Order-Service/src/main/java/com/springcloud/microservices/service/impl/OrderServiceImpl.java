package com.springcloud.microservices.service.impl;

import java.time.Instant;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.springcloud.microservices.Entity.Order;
import com.springcloud.microservices.controller.dto.OrderDTO;
import com.springcloud.microservices.controller.dto.OrderResponse;
import com.springcloud.microservices.controller.dto.PaymentResponse;
import com.springcloud.microservices.controller.dto.ProductResponse;
import com.springcloud.microservices.dao.OrderDao;
import com.springcloud.microservices.external.client.PaymentService;
import com.springcloud.microservices.external.client.ProductService;
import com.springcloud.microservices.external.client.PaymentRequest.PaymentRequest;
import com.springcloud.microservices.service.OrderService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderDao orderDao;

	@Autowired
	ProductService productService;

	@Autowired
	PaymentService paymentService;
	
	@Autowired
    private RestTemplate restTemplate;

	@Override
	public long saveOrder(OrderDTO orderDto) {

		productService.updateProductQuantity(orderDto.getProductId(), orderDto.getQuantity());

		Order order = new Order();

		order.setAmount(orderDto.getAmount());
		order.setDate(Instant.now());
		order.setOrderStatus(orderDto.getOrderStatus());
		order.setAmount(orderDto.getAmount());
		order.setProductId(orderDto.getProductId());
		order.setQuantity(orderDto.getQuantity());

		log.info("calling payment service api");

		PaymentRequest paymentRequest = PaymentRequest.builder().orderId(order.getId())
				.paymentMode(orderDto.getPaymentMode()).amount(orderDto.getAmount()).build();

		String orderStatus = null;
		try {
			paymentService.saveTransactionDetail(paymentRequest);
			log.info("Payment done Successfully. Changing the Oder status to PLACED");
			orderStatus = "PLACED";
		} catch (Exception e) {
			log.error("Error occurred in payment. Changing order status to PAYMENT_FAILED");
			orderStatus = "PAYMENT_FAILED";
		}

		order.setOrderStatus(orderStatus);

		return orderDao.saveOrder(order);
	}

	@Override
	public List<OrderDTO> getOrderList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderResponse getOrderDetails(long orderId) {
		// TODO Auto-generated method stub
		Order order= orderDao.getOrderByOrderId(orderId);
		
		log.info("Get order details for Order Id : {}", orderId);

        
        
        log.info("Invoking Product service to fetch the product for id: {}", order.getProductId());
        ProductResponse productResponse = restTemplate.getForObject(
                        "http://PRODUCT-SERVICE/product/getProductById/" + order.getProductId(),
                ProductResponse.class
        );

        log.info("Getting payment information form the payment Service");
        PaymentResponse paymentResponse
                = restTemplate.getForObject(
                        "http://PAYMENT-SERVICE/payment/order/" + order.getId(),
                PaymentResponse.class
                );

        OrderResponse.ProductDetails productDetails
                = OrderResponse.ProductDetails
                .builder()
                .productName(productResponse.getProductName())
                .productId(productResponse.getProductId())
                .build();

        OrderResponse.PaymentDetails paymentDetails
                = OrderResponse.PaymentDetails
                .builder()
                .paymentId(paymentResponse.getPaymentId())
                .paymentStatus(paymentResponse.getStatus())
                .paymentDate(paymentResponse.getPaymentDate())
                .paymentMode(paymentResponse.getPaymentMode())
                .build();

        OrderResponse orderResponse
                = OrderResponse.builder()
                .orderId(order.getId())
                .orderStatus(order.getOrderStatus())
                .amount(order.getAmount())
                .orderDate(order.getDate())
                .productDetails(productDetails)
                .paymentDetails(paymentDetails)
                .build();

        return orderResponse;
    }
	

}
