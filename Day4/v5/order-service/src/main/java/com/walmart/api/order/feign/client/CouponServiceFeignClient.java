package com.walmart.api.order.feign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.walmart.api.order.rest.response.CouponResponse;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@FeignClient(name = "api-gateway") // The name here mentioned is logical name of coupon service as registered with eureka
public interface CouponServiceFeignClient {
	
	//@CircuitBreaker(name = "cs", fallbackMethod = "findDiscountByCouponCodeFallback")
	@GetMapping("coupon-service/api/coupon/code/{couponCode}")
	public CouponResponse findDiscountByCouponCode(@PathVariable String couponCode);
	
//	default CouponResponse findDiscountByCouponCodeFallback(@PathVariable String couponCode,Throwable t) {
//		System.out.println("In fallback method");
//		CouponResponse c = new CouponResponse();
//		c.setDiscount(0);
//		return c;
//	}

}
