package com.anz.securities.common.exception;

/**
 * Base exception for the application
 * 
 * @author Anand Katti
 *
 */
public class FxCalculatorException extends Exception {
	private static final long serialVersionUID = 1L;

	private final String errorCode;

	public FxCalculatorException(final String errMessage, final Throwable exception) {
		super(errMessage, exception);
		this.errorCode = "undefined";
	}

	public FxCalculatorException(final String errMsg, final String errCode) {
		super(errMsg);
		this.errorCode = errCode;
	}

	public FxCalculatorException(final String errMessage) {
		this(errMessage, "undefined");
	}

	public String getErrorCode() {
		return errorCode;
	}

}
