package com.walmart.api.order.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class HelloRestController {

	@Autowired
	private Environment env;
	
	@Value("${organization}")
	private String company;
	
	@GetMapping("/hello") // This URI is used by client application
	public String helloRest() {
		return "Welcome to Spring REST " + env.getProperty("local.server.port") + "company= "+company;
	}
}
