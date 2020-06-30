package com.dbs.orderservice.exception;

public class InvalidInPutPayloadException extends RuntimeException {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2359810364341322127L;

	public InvalidInPutPayloadException() {
		
	}
	
	public InvalidInPutPayloadException(String message) {
		super(message);
	}

}
