package com.walmart.api.order.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.walmart.api.order.dao.OrderDao;
import com.walmart.api.order.feign.client.CouponServiceFeignClient;
import com.walmart.api.order.model.Order;
import com.walmart.api.order.rest.response.CouponResponse;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
public class OrderRestController {

	@Autowired // this is used for dependency injection
	private OrderDao orderDao;
	
	@Autowired
	private CouponServiceFeignClient feignClient;

	
	@Retry(name="cs")
	@PostMapping("/api/order")
	@CircuitBreaker(name = "cs", fallbackMethod = "placeOrderFallback")
	public Order placeOrder(@RequestBody Order order) {
		System.out.println("In place order - circuit closed - Rest calls allowed");
		// Fetch coupon code from order
		String couponCode = order.getCouponCode();
		// From coupon code fetch applicable discount
		// To fetch discount, we must call coupon service
		// This is a REST call
		CouponResponse couponResponse = this.feignClient.findDiscountByCouponCode(couponCode);
		int discount = couponResponse.getDiscount();
		
		// apply discount to the order object
		order.setPrice(order.getPrice() - ((discount * order.getPrice()) / 100));
		// save order object in the DB
		Order savedOrder = orderDao.save(order);

		// return order object
		return savedOrder;

	}
	public Order placeOrderFallback(Order order,Throwable t) {
		System.out.println("In the fallback for place order");
		return order;
		
	}

}
