package com.anz.securities.common.exception;

/**
 * 
 * @author xanakat
 *
 */
public class RuleNotFound extends FxCalculatorException {
	private static final long serialVersionUID = 1L;

	public RuleNotFound(final String errMessage) {
		super(errMessage);
	}

}
