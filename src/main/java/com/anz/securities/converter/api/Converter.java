package com.anz.securities.converter.api;

import com.anz.securities.common.exception.FxCalculatorException;
import com.anz.securities.converter.dto.UserInputDto;
@FunctionalInterface
public interface Converter {
	
	public void convert(UserInputDto userInput) throws FxCalculatorException;;
}
