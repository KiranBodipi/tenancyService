package com.tenantservice.api.exception;

import javax.validation.ConstraintViolationException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TenantExceptionController extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	@ExceptionHandler( value = TenantNotFoundException.class)
	public ResponseEntity<Object> tenantNotFound(TenantNotFoundException exception){
		return new ResponseEntity<Object>( exception.getMessage() , HttpStatus.NOT_FOUND);
	} 
	
	@ExceptionHandler( value = NoTenantsException.class)
	public ResponseEntity<Object> NoTenantFound(NoTenantsException exception){
		return new ResponseEntity<Object>( exception.getMessage() , HttpStatus.NOT_FOUND);

	}
	
	@ExceptionHandler(value = TenantIdCannotBeModifiedException.class)
	public ResponseEntity<Object> tenantIdCannotBeChanged(TenantIdCannotBeModifiedException exception){
		return new ResponseEntity<Object>(exception.getMessage() , HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = DataIntegrityViolationException.class)
	public ResponseEntity<Object> duplicateException(DataIntegrityViolationException exception){
		return new ResponseEntity<Object>("CompanyName cannot be changed." , HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = ConstraintViolationException.class)
	public ResponseEntity<Object> constraintViolation(ConstraintViolationException exception){
		return new ResponseEntity<Object>(exception.getMessage() , HttpStatus.BAD_REQUEST);
	}
	
}
