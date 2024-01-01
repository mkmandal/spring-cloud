package com.springdocker.springdocker.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class Product {
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name="PRODUCT_NAME")
	private String productName;
	@Column(name="PRODUCT_PRICE")
	private long price;
	@Column(name="PRODUCT_QUANTITY")
	private int quantity;
	public static ProductBuilder builder() {
		// TODO Auto-generated method stub
		return null;
	}

}
