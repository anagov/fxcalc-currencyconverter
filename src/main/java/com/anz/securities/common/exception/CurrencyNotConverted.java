package com.anz.securities.common.exception;

/**
 * Represents exceptions during currency conversion
 * 
 * @author xanakat
 *
 */
public class CurrencyNotConverted extends FxCalculatorException {
	private static final long serialVersionUID = 1L;

	public CurrencyNotConverted(final String errMessage) {
		super(errMessage);
	}

	public CurrencyNotConverted(final String errMessage, final Throwable exception) {
		super(errMessage, exception);
	}

	public CurrencyNotConverted(final String errMessage, final String errCode) {
		super(errMessage, errCode);
	}
}
