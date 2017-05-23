package com.anz.securities.common.exception;

/**
 * Represents undefined rule
 * 
 * @author Anand Katti
 *
 */
public class RuleNotFound extends FxCalculatorException {
	private static final long serialVersionUID = 1L;

	public RuleNotFound(final String errMessage) {
		super(errMessage);
	}

	public RuleNotFound(final String errMessage, final Throwable exception) {
		super(errMessage, exception);
	}

	public RuleNotFound(final String errMessage, final String errCode) {
		super(errMessage, errCode);
	}
}
