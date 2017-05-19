package com.anz.securities.common.exception;

/**
 * 
 * @author xanakat
 *
 */
public class CurrencyNotSupported extends CurrencyNotConverted {

	private static final long serialVersionUID = 1L;
	
	public CurrencyNotSupported(final String errorMessage) {
		super(errorMessage);
	}
}

