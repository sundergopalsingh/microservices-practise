package com.walmart.api.eureka.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

	@Bean
	public SecurityFilterChain configure(HttpSecurity httpSecurity) throws Exception {
		
		httpSecurity.csrf()
		.disable()
		.authorizeRequests()
		.antMatchers("/**")
		.authenticated()
		.and()
		.httpBasic();
		return httpSecurity.build();
	}
}
