package com.walmart.api.coupon.event.handler;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.walmart.api.coupon.dao.CouponDao;
import com.walmart.api.coupon.event.CouponCreatedEvent;
import com.walmart.api.coupon.model.Coupon;

@Component
public class CouponEventHandler {

	@Autowired
	CouponDao couponDao;

	@EventHandler
	public void on(CouponCreatedEvent event) {
		Coupon c = new Coupon();
		c.setId(event.getId());
		c.setDiscount(event.getDiscount());
		c.setCouponCode(event.getCouponCode());

		couponDao.save(c);
	}
}
