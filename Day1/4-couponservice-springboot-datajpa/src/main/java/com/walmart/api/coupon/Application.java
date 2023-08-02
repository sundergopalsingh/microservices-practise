package com.walmart.api.coupon;

import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.walmart.api.coupon.dao.CouponDao;
import com.walmart.api.coupon.model.Coupon;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ConfigurableApplicationContext container = SpringApplication.run(Application.class, args);
		CouponDao couponDao = container.getBean(CouponDao.class);
		
//		Coupon coupon = new Coupon();
//		coupon.setCouponCode("c1");
//		coupon.setDiscount(100);
//		coupon.setId("1");
		
		
	//	couponDao.save(coupon);
		//Write switch case with 5 options
		// 1.  Create
		// 2.  findById
		// 3.  findAll
		// 4.  update
		// 5.  delete
		while(true) {
			System.out.println("// 1.  Create\n"
					+ "		// 2.  findById\n"
					+ "		// 3.  findAll\n"
					+ "		// 4.  update\n"
					+ "		// 5.  delete\nEnter operation to perform :- ");
			int option = scanner.nextInt();
			
			String id = "";
			switch (option) {
			case 1:
				System.out.println("Enter coupon 3 values");
				
				Coupon couponToSave = new Coupon();
				couponToSave.setId(scanner.next());
				couponToSave.setCouponCode(scanner.next());
				couponToSave.setDiscount(scanner.nextInt());
				Coupon savedCoupon = couponDao.save(couponToSave);
				System.out.println(savedCoupon);
				
				break;
			case 2:
				System.out.println("Enter id to search");
				Coupon foundCoupon = couponDao.findById(scanner.next()).get();
				System.out.println(foundCoupon);
				break;
			case 3:
				List<Coupon> couponList = couponDao.findAll();
				System.out.println(couponList);
				break;
			case 4:
				System.out.println("Enter id to update coupon");
				Coupon couponToUpdate = couponDao.findById(scanner.next()).get();
				System.out.println(couponToUpdate);
				System.out.println("Enter coupon code and discount code to update coupon");
				couponToUpdate.setCouponCode(scanner.next());
				couponToUpdate.setDiscount(scanner.nextInt());
				savedCoupon = couponDao.save(couponToUpdate);
				System.out.println(savedCoupon);
				break;
			case 5:
				System.out.println("Enter id to delete coupon");
				couponDao.deleteById(scanner.next());
				break;
			default:
				break;
			}
		}
		
		
		
		
	}

}
