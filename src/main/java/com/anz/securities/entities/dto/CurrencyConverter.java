package com.anz.securities.entities.dto;

import java.util.List;
import java.util.Map;

import com.anz.securities.entities.api.ConversionRate;
import com.anz.securities.entities.api.Currency;

/**
 * Type representing entity composition required for the conversion. This
 * includes currencies and the rates
 * 
 * @author Anand Katti
 *
 */
public class CurrencyConverter {

	private Map<String, Currency> mapCurrecy;
	private List<ConversionRate> listRates;

	public Map<String, Currency> getMapCurrecy() {
		return mapCurrecy;
	}

	public void setMapCurrecy(Map<String, Currency> mapCurrecy) {
		this.mapCurrecy = mapCurrecy;
	}

	public List<ConversionRate> getListRates() {
		return listRates;
	}

	public void setListRates(List<ConversionRate> listRates) {
		this.listRates = listRates;
	}

	public void addCurrencyToMap(Currency cur) {
		this.mapCurrecy.put(cur.getName(), cur);
	}

	public Currency getCurrency(String name) {
		return this.mapCurrecy.get(name);
	}

	public boolean isCurrencySupported(final String currencyName) {
		return this.mapCurrecy.containsKey(currencyName);
	}
}
