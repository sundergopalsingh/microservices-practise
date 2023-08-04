package com.walmart.api.coupon.rest.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class HelloRestController {
	
	@Value("${organization}")
	private String company;

	@Value("${coupontype}")
	private String couponType;
	@GetMapping("/hello") // This URI is used by client application
	public String helloRest() {
		return "Welcome to Spring REST, company"+company + " coupontype = "+couponType;
	}
}
