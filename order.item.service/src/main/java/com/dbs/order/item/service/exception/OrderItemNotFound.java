package com.dbs.order.item.service.exception;


public class OrderItemNotFound extends RuntimeException {


	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2639624064333370447L;

	public OrderItemNotFound() {
	}

	public OrderItemNotFound(String message) {
		super(message);
	}
}
