package com.anz.securities.converter.dto;

/**
 * Represents a traversal from one currency to another during the conversion
 * 
 * @author Anand Katti
 *
 */
public class TraversalPath {
	private String fromCurrency;
	private String toCurrency;
	private String conversionType;

	public TraversalPath(final String from, final String to) {
		this.fromCurrency = from;
		this.toCurrency = to;
	}

	public void setConversionType(final String conversionType) {
		this.conversionType = conversionType;
	}

	public String getFromCurrency() {
		return fromCurrency;
	}

	public String getConversionType() {
		return conversionType;
	}

	public String getToCurrency() {
		return toCurrency;
	}
}
