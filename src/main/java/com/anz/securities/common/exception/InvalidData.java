package com.anz.securities.common.exception;

/**
 * Represents invalid input data
 * 
 * @author Anand Katti
 *
 */
public class InvalidData extends FxCalculatorException {

	private static final long serialVersionUID = 1L;

	public InvalidData(final String errorMessage) {
		super(errorMessage);
	}

	public InvalidData(final String errMessage, final Throwable exception) {
		super(errMessage, exception);
	}

	public InvalidData(final String errMessage, final String errCode) {
		super(errMessage, errCode);
	}
}
