package com.anz.securities.common.exception;

/**
 * 
 * @author xanakat
 *
 */
public class LoaderNotSupported extends ApplicationUnInitialized {
	
	private static final long serialVersionUID = 1L;
	
	public LoaderNotSupported( final String errMessage ) {
		super(errMessage);
	}

}
