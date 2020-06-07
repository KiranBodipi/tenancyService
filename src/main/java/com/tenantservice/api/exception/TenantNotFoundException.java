package com.tenantservice.api.exception;

public class TenantNotFoundException extends Exception{
	/**
	 *  
	 */
	private static final long serialVersionUID = 1L;

	public TenantNotFoundException(String message) {
		
		super(message);
	}
}
