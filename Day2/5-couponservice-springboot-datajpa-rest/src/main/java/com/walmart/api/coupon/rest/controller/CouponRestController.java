package com.walmart.api.coupon.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.walmart.api.coupon.dao.CouponDao;
import com.walmart.api.coupon.model.Coupon;

@RestController
public class CouponRestController {

	@Autowired // this is used for dependency injection
	private CouponDao couponDao; 
	
	@GetMapping("/api/coupon/{id}")
	public Coupon findById(@PathVariable String id) {
		return couponDao.findById(id).get();
	}
	

}
