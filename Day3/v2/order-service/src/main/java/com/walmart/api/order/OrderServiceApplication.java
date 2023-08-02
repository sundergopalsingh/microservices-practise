package com.walmart.api.order;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;

import com.walmart.api.order.dao.OrderDao;

@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
public class OrderServiceApplication {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ConfigurableApplicationContext container = SpringApplication.run(OrderServiceApplication.class, args);
		OrderDao couponDao = container.getBean(OrderDao.class);

	}

}
