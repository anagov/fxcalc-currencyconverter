package com.anz.securities.entities.api;

import java.util.List;

/**
 * 
 * @author ANAGOV
 *
 */
public interface Currency {
	
	/**
	 * 
	 * @return
	 */
	public String getName();
	
	/**
	 * 
	 * @return
	 */
	public List<ConversionRule> getRules();
	
	/**
	 * 
	 * @return
	 */
	public int getDecimalSupport();

}
