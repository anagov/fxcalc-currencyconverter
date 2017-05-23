package com.anz.securities.entities.api;

import java.util.List;

/**
 * Entity representing currency type
 * 
 * @author Anand Katti
 *
 */
public interface Currency {

	/**
	 * Returns the currency name
	 * 
	 * @return currencyName
	 */
	public String getName();

	/**
	 * Returns the rules for a currency
	 * 
	 * @return ruleList
	 */
	public List<ConversionRule> getRules();

	/**
	 * Returns the deimal place support for the currency
	 * 
	 * @return decimalSupport
	 */
	public int getDecimalSupport();

}
