package com.anz.securities.common.exception;


/**
 * 
 * @author xanakat
 *
 */
public class SameSourceAndDestinationCurrency extends RuleNotFound {
	
	private static final long serialVersionUID = 1L;
	
	public SameSourceAndDestinationCurrency(final String errorMessage ) {
		super(errorMessage);
	}

}