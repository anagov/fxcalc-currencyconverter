package com.anz.securities.converter.impl;

import com.anz.securities.common.exception.CurrencyNotConverted;
import com.anz.securities.common.exception.FxCalculatorException;
import com.anz.securities.common.exception.RuleNotFound;
import com.anz.securities.common.exception.InvalidData;
import com.anz.securities.converter.api.Converter;
import com.anz.securities.converter.dto.UserInputDto;
import com.anz.securities.entities.dto.CurrencyConverter;

public abstract class AbstractConverter implements Converter {
	protected CurrencyConverter converter;

	public AbstractConverter(CurrencyConverter convert) {
		this.converter = convert;
	}

	@Override
	public void convert(UserInputDto userInput) throws FxCalculatorException {
		validateUserInput(userInput);
		determinePath(userInput);
		convertAmount(userInput);
	}

	/**
	 * template method to validate user input
	 * 
	 * @param userInput
	 * @throws InvalidData
	 */
	protected abstract void validateUserInput(final UserInputDto userInput) throws InvalidData;

	/**
	 * template method to determine path from source currency to destination
	 * currency
	 * 
	 * @param userInput
	 */
	protected abstract void determinePath(final UserInputDto userInput) throws RuleNotFound;

	/**
	 * Template method to convert the amount from source currency to destination
	 * currency
	 * 
	 * @param userInput
	 * @throws CurrencyNotConverted
	 */
	protected abstract void convertAmount(final UserInputDto userInput) throws CurrencyNotConverted;

}
