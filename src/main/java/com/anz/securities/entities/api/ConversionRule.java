package com.anz.securities.entities.api;

/**
 * Entity representing conversion rule
 * 
 * @author Anand Katti
 *
 */
public interface ConversionRule extends Comparable<ConversionRule> {

	/**
	 * Returns the currency name
	 * 
	 * @return currencyName
	 */
	public String getCurrencyName();

	/**
	 * Returns the pointer, the currency is linked to
	 * 
	 * @return pointer
	 */
	public String getPointer();
}
