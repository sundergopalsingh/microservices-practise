package com.walmart.api.coupon.dao.impl;

import com.walmart.api.coupon.dao.CouponDao;
import com.walmart.api.coupon.model.Coupon;

public class CouponJpaDaoImpl implements CouponDao{
	public Coupon saveCoupon(Coupon coupon) {
		System.out.println("Inserting Coupon object to DB using JPA");
		return coupon;
	}
}
