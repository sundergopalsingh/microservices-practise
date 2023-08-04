package com.walmart.api.coupon.aggregate;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import com.walmart.api.coupon.command.CreateCouponCommand;
import com.walmart.api.coupon.event.CouponCreatedEvent;

@Aggregate
public class CouponAggregate {

	@AggregateIdentifier
	private String id;
	private String couponCode;
	private int discount;

	@CommandHandler // It is automatically invoked when a specific type of command was dispatched
	public CouponAggregate(CreateCouponCommand command) {
		super();
		// Raise the event
		CouponCreatedEvent createEvent = new CouponCreatedEvent();
		createEvent.setId(command.getId()); // to be completed TODO
		createEvent.setCouponCode(command.getCouponCode());
		createEvent.setDiscount(command.getDiscount());
		
		// Once event object is ready dispatch it to all event handlers.
		AggregateLifecycle.apply(createEvent);

	}

	public CouponAggregate() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCouponCode() {
		return couponCode;
	}

	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	@EventSourcingHandler
	public void on(CouponCreatedEvent event) {
		this.id = event.getId();
		this.couponCode = event.getCouponCode();
		this.discount = event.getDiscount();
	}
	
}
