package com.anz.securities.entities.api;

/**
 * Entity representing Conversion Rate
 * 
 * @author Anand Katti
 *
 */
public interface ConversionRate extends Comparable<ConversionRate> {

	/**
	 * Returns the source currency
	 * 
	 * @return sourceCurrency
	 */
	public String getSourceCurrency();

	/**
	 * Returns the destination currency
	 * 
	 * @return destinationCurrency
	 */
	public String getDestinationCurrency();

	/**
	 * Returns conversion rate
	 * 
	 * @return rate
	 */
	public double getConversionRate();
}
