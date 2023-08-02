package com.walmart.api.coupon.dao.impl;

import org.springframework.stereotype.Repository;

import com.walmart.api.coupon.dao.CouponDao;
import com.walmart.api.coupon.model.Coupon;

@Repository	//This annotation is used on top of Dao classes, hence DAO classes are also referred to as repository classes
public class CouponJpaDaoImpl implements CouponDao{
	public Coupon saveCoupon(Coupon coupon) {
		System.out.println("Inserting Coupon object to DB using JPA");
		return coupon;
	}
}
