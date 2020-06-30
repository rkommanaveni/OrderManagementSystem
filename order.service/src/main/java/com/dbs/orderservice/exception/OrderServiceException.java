package com.dbs.orderservice.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class OrderServiceException {

	@ExceptionHandler(InvalidInPutPayloadException.class)
	public ResponseEntity<ErrorResponse> handleCustomException(final InvalidInPutPayloadException exception,
			final HttpServletRequest request) {

		ErrorResponse error = new ErrorResponse();
		error.setErrorMessage(exception.getMessage());
		error.callerURL(request.getRequestURI());

		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(OrderNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleCustomException(final OrderNotFoundException exception,
			final HttpServletRequest request) {

		ErrorResponse error = new ErrorResponse();
		error.setErrorMessage(exception.getMessage());
		error.callerURL(request.getRequestURI());

		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(ErrorCreatingOrderService.class)
	public ResponseEntity<ErrorResponse> handleCustomException(final ErrorCreatingOrderService exception,
			final HttpServletRequest request) {

		ErrorResponse error = new ErrorResponse();
		error.setErrorMessage(exception.getMessage());
		error.callerURL(request.getRequestURI());

		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleSuperNotFound(final Exception exception,
			final HttpServletRequest request) {

		ErrorResponse error = new ErrorResponse();
		error.setErrorMessage(exception.getMessage());
		error.callerURL(request.getRequestURI());

		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

}
