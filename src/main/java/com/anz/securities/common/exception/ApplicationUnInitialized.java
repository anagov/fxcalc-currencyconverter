package com.anz.securities.common.exception;

/**
 * 
 * @author xanakat
 *
 */
public class ApplicationUnInitialized extends FxCalculatorException {
	private static final long serialVersionUID = 1L;
	
	public ApplicationUnInitialized(final String errMessage) {
		super(errMessage);
	}

}
