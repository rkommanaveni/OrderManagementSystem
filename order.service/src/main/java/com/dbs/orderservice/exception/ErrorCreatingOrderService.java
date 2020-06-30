package com.dbs.orderservice.exception;

public class ErrorCreatingOrderService extends RuntimeException {


	/**
	 * 
	 */
	private static final long serialVersionUID = -4373318787008178504L;

	public ErrorCreatingOrderService() {
		super();
	}

	public ErrorCreatingOrderService(String message) {
		super(message);
	}

}
