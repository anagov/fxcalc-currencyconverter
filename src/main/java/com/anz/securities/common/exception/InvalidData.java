package com.anz.securities.common.exception;

/**
 * 
 * @author xanakat
 *
 */
public class InvalidData extends FxCalculatorException {
	
	private static final long serialVersionUID = 1L;
	
	public InvalidData(final String errorMessage ) {
		super(errorMessage);
	}

}
