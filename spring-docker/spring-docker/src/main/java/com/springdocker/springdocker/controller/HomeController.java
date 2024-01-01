package com.springdocker.springdocker.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/docker/home")
public class HomeController {
	
	 Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@GetMapping(value="/greet")
	String greet() {
		logger.debug("Request {}", "Hello this msg from logger !!!");
		logger.trace("A TRACE Message");
        logger.debug("A DEBUG Message");
        logger.info("An INFO Message");
        logger.warn("A WARN Message");
        logger.error("An ERROR Message");
		return "Hello From Docker !!";
	}

}
