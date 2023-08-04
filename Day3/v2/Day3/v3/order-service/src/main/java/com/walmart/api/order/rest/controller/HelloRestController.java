package com.walmart.api.order.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController {

	@Autowired
	private Environment env;
	
	@GetMapping("/hello") // This URI is used by client application
	public String helloRest() {
		return "Welcome to Spring REST " + env.getProperty("local.server.port");
	}
}
