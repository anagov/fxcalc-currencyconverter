package com.anz.securities.common.exception;

/**
 * 
 * @author xanakat
 *
 */
public class CurrencyNotConverted extends FxCalculatorException {
	private static final long serialVersionUID = 1L;
	
	public CurrencyNotConverted(final String errMessage) {
		super(errMessage);
	}

}
