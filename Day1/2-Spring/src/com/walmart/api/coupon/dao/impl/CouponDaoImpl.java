package com.walmart.api.coupon.dao.impl;

import com.walmart.api.coupon.dao.CouponDao;
import com.walmart.api.coupon.model.Coupon;

public class CouponDaoImpl implements CouponDao {
	
	public Coupon saveCoupon(Coupon coupon) {
		//This method should talk to Database and insert record in Database
		System.out.println("Coupon inserted in the database using JDBC");
		return coupon;
	}

}
