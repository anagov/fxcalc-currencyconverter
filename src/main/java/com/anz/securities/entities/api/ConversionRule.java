package com.anz.securities.entities.api;

/**
 * 
 * @author ANAGOV
 *
 */
public interface ConversionRule extends Comparable<ConversionRule> {

	/**
	 * 
	 * @return
	 */
	public String getCurrencyName();
	
	/**
	 * 
	 * @return
	 */
	public String getPointer();
}
