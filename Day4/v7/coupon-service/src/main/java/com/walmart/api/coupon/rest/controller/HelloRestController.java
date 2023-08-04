package com.walmart.api.coupon.rest.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController {
	
	@Value("${organization}")
	private String company;

	@GetMapping("/hello") // This URI is used by client application
	public String helloRest() {
		return "Welcome to Spring REST, company"+company;
	}
}
