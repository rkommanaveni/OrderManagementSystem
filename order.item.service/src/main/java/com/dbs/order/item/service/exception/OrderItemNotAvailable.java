package com.dbs.order.item.service.exception;

public class OrderItemNotAvailable extends RuntimeException {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1518097141316070712L;

	public OrderItemNotAvailable() {
		super();
	}

	public OrderItemNotAvailable(String message) {
		super(message);
	}

}
