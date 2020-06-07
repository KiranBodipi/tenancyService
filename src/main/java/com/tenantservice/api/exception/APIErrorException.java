package com.tenantservice.api.exception;

public class APIErrorException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public APIErrorException(String message) {
		super(message);
	}
}
