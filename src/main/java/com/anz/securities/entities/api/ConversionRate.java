package com.anz.securities.entities.api;
/**
 * 
 * @author ANAGOV
 *
 */
public interface ConversionRate extends Comparable<ConversionRate> {

	/**
	 * 
	 * @return
	 */
	public String getSourceCurrency();

	/**
	 * 
	 * @return
	 */
	public String getDestinationCurrency();

	/**
	 * 
	 * @return
	 */
	public double getConversionRate();
}
