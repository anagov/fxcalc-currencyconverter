package com.anz.securities.common.exception;

/**
 * Represents undefined conversion rate
 * 
 * @author Anand Katti
 *
 */
public class UndefinedConversionRate extends CurrencyNotConverted {
	private static final long serialVersionUID = 1L;

	public UndefinedConversionRate(final String errorMessage) {
		super(errorMessage);
	}
	public UndefinedConversionRate(final String errMessage, final Throwable exception) {
		super(errMessage, exception);
	}
	public UndefinedConversionRate(final String errMessage, final String errCode) {
		super(errMessage, errCode);
	}
}