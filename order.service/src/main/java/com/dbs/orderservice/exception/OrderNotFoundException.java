package com.dbs.orderservice.exception;

public class OrderNotFoundException extends RuntimeException {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1561065920302739998L;

	public OrderNotFoundException() {
		
	}
	
	public OrderNotFoundException(String message) {
		super(message);
	}

}
