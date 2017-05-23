package com.anz.securities.common.exception;

/**
 * Represents same source and destination currency
 * 
 * @author Anand Katti
 *
 */
public class SameSourceAndDestinationCurrency extends RuleNotFound {

	private static final long serialVersionUID = 1L;

	public SameSourceAndDestinationCurrency(final String errorMessage) {
		super(errorMessage);
	}

	public SameSourceAndDestinationCurrency(final String errMessage, final String errCode) {
		super(errMessage, errCode);
	}

	public SameSourceAndDestinationCurrency(final String errMessage, final Throwable exception) {
		super(errMessage, exception);
	}
}