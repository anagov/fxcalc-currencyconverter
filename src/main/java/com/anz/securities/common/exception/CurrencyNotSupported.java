package com.anz.securities.common.exception;

/**
 * Represents unsupported currency
 * 
 * @author Anand Katti
 *
 */
public class CurrencyNotSupported extends CurrencyNotConverted {

	private static final long serialVersionUID = 1L;

	public CurrencyNotSupported(final String errorMessage) {
		super(errorMessage);
	}

	public CurrencyNotSupported(final String errMessage, final Throwable exception) {
		super(errMessage, exception);
	}

	public CurrencyNotSupported(final String errMessage, final String errCode) {
		super(errMessage, errCode);
	}
}
