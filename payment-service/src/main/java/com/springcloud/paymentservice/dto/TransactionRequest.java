package com.springcloud.paymentservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransactionRequest {
	
	private long orderId;
    private long amount;
    private String referenceNumber;
    private PaymentMode paymentMode;

}
