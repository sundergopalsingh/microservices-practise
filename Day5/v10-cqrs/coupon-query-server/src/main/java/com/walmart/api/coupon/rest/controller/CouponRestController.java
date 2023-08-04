package com.walmart.api.coupon.rest.controller;

import java.util.List;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.messaging.responsetypes.ResponseType;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.walmart.api.coupon.command.CreateCouponCommand;
import com.walmart.api.coupon.model.Coupon;
import com.walmart.api.coupon.query.FindCouponQuery;

@RestController
public class CouponRestController {

	@Autowired // this is used for dependency injection
	private QueryGateway queryGateway;

	@GetMapping("/api/coupon")
	public List<Coupon> findAll(){
		
		FindCouponQuery query = new FindCouponQuery();
		return this.queryGateway.query(query, ResponseTypes.multipleInstancesOf(Coupon.class)).join();
	}
	
}
