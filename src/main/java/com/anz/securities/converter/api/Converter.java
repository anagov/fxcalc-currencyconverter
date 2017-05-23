package com.anz.securities.converter.api;

import com.anz.securities.common.exception.FxCalculatorException;
import com.anz.securities.converter.dto.UserInputDto;

/**
 * Type definition for Currency conversion
 * 
 * @author Anand Katti
 *
 */
@FunctionalInterface
public interface Converter {

	/**
	 * Converts source currency amount into destination currency amount in
	 * predefined decimal places
	 * 
	 * @param userInput
	 * @throws FxCalculatorException
	 */
	public void convert(UserInputDto userInput) throws FxCalculatorException;
}
