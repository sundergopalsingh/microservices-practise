package com.walmart.api.order.feign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.walmart.api.order.rest.response.CouponResponse;

@FeignClient(name = "api-gateway") // The name here mentioned is logical name of coupon service as registered with eureka
public interface CouponServiceFeignClient {
	@GetMapping("coupon-service/api/coupon/code/{id}")
	public CouponResponse findDiscountByCouponId(@PathVariable String id);

}
