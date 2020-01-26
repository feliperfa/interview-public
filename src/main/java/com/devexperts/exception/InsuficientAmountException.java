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
@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Ops! Insuficient amount in the source account.")
public class InsuficientAmountException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4610509136087497021L;

}
