package com.anz.securities.entities.impl;

import java.util.ArrayList;
import java.util.List;

import com.anz.securities.entities.api.ConversionRule;
import com.anz.securities.entities.api.Currency;

public class CurrencyImpl implements Currency {
	private String name;
	private int decimalSupport;
	private List<ConversionRule> ruleList = new ArrayList<>();

	public CurrencyImpl(String name, int decimal, List<ConversionRule> lRule) {
		this.name = name;
		this.decimalSupport = decimal;
		this.ruleList = lRule;
	}

	@Override
	public int getDecimalSupport() {
		return this.decimalSupport;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public List<ConversionRule> getRules() {
		return this.ruleList;
	}

}
