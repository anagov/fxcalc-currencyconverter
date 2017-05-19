package com.anz.securities.common.exception;

/**
 * Exceptions occurred during the data initialization are captured here
 * 
 * @author Anand Katti
 *
 */
public class UnsuccessfulDataLoading extends ApplicationUnInitialized {
	private static final long serialVersionUID = 1L;

	public UnsuccessfulDataLoading(final String errorMsg) {
		super(errorMsg);
	}

}