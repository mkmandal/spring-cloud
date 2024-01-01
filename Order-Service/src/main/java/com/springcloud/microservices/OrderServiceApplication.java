package com.springcloud.microservices;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableFeignClients
public class OrderServiceApplication {
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
	}
	
//	@Autowired
//	private ClientRegistrationRepository clientRegistrationRepository;
//	
	
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		RestTemplate restTemplate
				= new RestTemplate();
//		restTemplate.setInterceptors(
//				Arrays.asList(
//						new RestTemplateInterceptor(
//								clientManager(clientRegistrationRepository
//										,oAuth2AuthorizedClientRepository))));
		return restTemplate;
	}

}
