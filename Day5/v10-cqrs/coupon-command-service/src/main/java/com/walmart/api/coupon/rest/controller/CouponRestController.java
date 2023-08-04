package com.walmart.api.coupon.rest.controller;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.walmart.api.coupon.command.CreateCouponCommand;
import com.walmart.api.coupon.model.Coupon;

@RestController
public class CouponRestController {

	@Autowired // this is used for dependency injection
	private CommandGateway commandGateway;

	@PostMapping("/api/coupon")
	public String createCoupon(@RequestBody Coupon c) {
		// We need to create command object
		CreateCouponCommand command = new CreateCouponCommand();
		command.setId(c.getId());
		command.setCouponCode(c.getCouponCode());
		command.setDiscount(c.getDiscount());

		// When the command object is ready, we need to send the object to CommandBus
		// In order to do this, we need to inject Command Gateway in this controller.
		// To use Command Gateway we need axon dependency
		String returnValue = commandGateway.sendAndWait(command);
		return returnValue;
	}

}
