package com.anz.securities.common.exception;

/**
 * This exception represents uninitialized application
 * 
 * @author xanakat
 *
 */
public class ApplicationUnInitialized extends FxCalculatorException {
	private static final long serialVersionUID = 1L;

	public ApplicationUnInitialized(final String errMessage) {
		super(errMessage);
	}

	public ApplicationUnInitialized(final String errMessage, final Throwable exception) {
		super(errMessage, exception);
	}

	public ApplicationUnInitialized(final String errMessage, final String errCode) {
		super(errMessage, errCode);
	}
}
