package com.springcloud.microservices.controller.dto;

import java.time.Instant;

import com.springcloud.microservices.external.client.PaymentRequest.PaymentMode;



public class OrderDTO {
	
	private long id;
	private long productId;
	private double amount;
	private int quantity;
	private Instant date;
	private String orderStatus;
	private PaymentMode paymentMode;
	
	
	public OrderDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderDTO(long id, long productId, double amount, int quantity, Instant date, String orderStatus,
			PaymentMode paymentMode) {
		super();
		this.id = id;
		this.productId = productId;
		this.amount = amount;
		this.quantity = quantity;
		this.date = date;
		this.orderStatus = orderStatus;
		this.paymentMode = paymentMode;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Instant getDate() {
		return date;
	}
	public void setDate(Instant date) {
		this.date = date;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public PaymentMode getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(PaymentMode paymentMode) {
		this.paymentMode = paymentMode;
	}
	
	

}
