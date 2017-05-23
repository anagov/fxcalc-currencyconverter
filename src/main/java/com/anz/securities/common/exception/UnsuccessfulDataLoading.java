package com.anz.securities.common.exception;

/**
 * Represents exception during the data load
 * 
 * @author Anand Katti
 *
 */
public class UnsuccessfulDataLoading extends ApplicationUnInitialized {
	private static final long serialVersionUID = 1L;

	public UnsuccessfulDataLoading(final String errorMsg) {
		super(errorMsg);
	}

	public UnsuccessfulDataLoading(final String errMessage, final Throwable exception) {
		super(errMessage, exception);
	}

	public UnsuccessfulDataLoading(final String errMessage, final String errCode) {
		super(errMessage, errCode);
	}

}