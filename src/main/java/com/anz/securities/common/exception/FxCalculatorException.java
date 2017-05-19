package com.anz.securities.common.exception;

/**
 * Base exception for the application
 * 
 * @author Anand Katti
 *
 */
public class FxCalculatorException extends Exception {
	private static final long serialVersionUID = 1L;

	public FxCalculatorException(final String errMessage) {
		super(errMessage);
	}
}
