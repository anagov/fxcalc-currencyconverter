package com.anz.securities.entities.impl;

import java.util.Objects;

import com.anz.securities.entities.api.ConversionRule;

public class ConversionRuleImpl implements ConversionRule {
	
	private String currencyName;
	private String pointer;
	
	public ConversionRuleImpl(String name, String pointer) {
		this.currencyName = name;
		this.pointer = pointer;
	}

	@Override
	public int compareTo(ConversionRule o) {
		return this.currencyName.compareTo(o.getCurrencyName());
	}

	@Override
	public String getCurrencyName() {
		return this.currencyName;
	}

	@Override
	public String getPointer() {
		return this.pointer;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;

		if (obj == null)
			return false;

		if (getClass() != obj.getClass())
			return false;

		ConversionRule temp = (ConversionRule) obj;

		return Objects.equals(this.currencyName, temp.getCurrencyName());
	}

	@Override
	public int hashCode() {
		return Objects.hash(currencyName);
	}

	@Override
	public String toString() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("Curreny:");
		strBuilder.append(getCurrencyName());
		strBuilder.append("=Linked To:");
		strBuilder.append(getPointer());
		return strBuilder.toString();
	}
}
