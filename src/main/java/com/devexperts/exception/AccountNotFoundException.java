/**
 * 
 */
package com.devexperts.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author feliperamalhofurtadodealmeida
 *
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Ops! There's no account with the requested id")
public class AccountNotFoundException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2586497094581312067L;
	
	/**
	 * @param message
	 */
	public AccountNotFoundException(String message) {
		super(message);
	}
	
	/**
	 * 
	 */
	public AccountNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

}
