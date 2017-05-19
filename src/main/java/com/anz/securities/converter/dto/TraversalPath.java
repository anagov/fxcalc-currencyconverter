package com.anz.securities.converter.dto;

/**
 * 
 * @author xanakat
 *
 */
public class TraversalPath {
	private String fromCurrency;
	private String toCurrency;
	private String conversionType;

	public String getConversionType() {
		return conversionType;
	}

	public void setConversionType(String conversionType) {
		this.conversionType = conversionType;
	}

	public TraversalPath(final String from, final String to) {
		this.fromCurrency = from;
		this.toCurrency = to;
	}

	public String getFromCurrency() {
		return fromCurrency;
	}

	public String getToCurrency() {
		return toCurrency;
	}

}
