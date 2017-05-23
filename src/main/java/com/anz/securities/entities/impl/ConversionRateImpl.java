package com.anz.securities.entities.impl;

import java.util.Objects;

import com.anz.securities.entities.api.ConversionRate;

/**
 * Type providing implementation to the ConversionRate entity
 * 
 * @author Anand Katti
 *
 */
public class ConversionRateImpl implements ConversionRate {
	private String sourceCurrency;
	private String destinationCurrency;
	private double conversionRate;

	public ConversionRateImpl(String srcCurrency, String destCurrency, double convRate) {
		this.sourceCurrency = srcCurrency;
		this.destinationCurrency = destCurrency;
		this.conversionRate = convRate;
	}

	public ConversionRateImpl(String srcCurrency, String destCurrency) {
		this.sourceCurrency = srcCurrency;
		this.destinationCurrency = destCurrency;
		this.conversionRate = 0;
	}

	@Override
	public double getConversionRate() {
		return this.conversionRate;
	}

	@Override
	public String getDestinationCurrency() {
		return this.destinationCurrency;
	}

	@Override
	public String getSourceCurrency() {
		return this.sourceCurrency;
	}

	@Override
	public int compareTo(ConversionRate o) {
		int temp = this.sourceCurrency.compareToIgnoreCase(o.getSourceCurrency());
		if (temp != 0)
			return temp;
		return this.destinationCurrency.compareToIgnoreCase(o.getDestinationCurrency());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;

		if (obj == null)
			return false;

		if (getClass() != obj.getClass())
			return false;

		ConversionRate temp = (ConversionRate) obj;

		return this.sourceCurrency.equalsIgnoreCase(temp.getSourceCurrency())
				&& this.destinationCurrency.equalsIgnoreCase(temp.getDestinationCurrency());
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.sourceCurrency, this.destinationCurrency);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Source Currency:");
		builder.append(getSourceCurrency());
		builder.append("= Destination Currency:");
		builder.append(getDestinationCurrency());
		builder.append("= Converstion Rate:");
		builder.append(getConversionRate());
		return builder.toString();
	}

}
