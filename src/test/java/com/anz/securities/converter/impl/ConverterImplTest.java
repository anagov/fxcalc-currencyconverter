package com.anz.securities.converter.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;

import com.anz.securities.common.exception.InvalidData;
import com.anz.securities.common.exception.RuleNotFound;
import com.anz.securities.common.exception.SameSourceAndDestinationCurrency;
import com.anz.securities.converter.dto.UserInputDto;
import com.anz.securities.entities.api.ConversionRate;
import com.anz.securities.entities.api.ConversionRule;
import com.anz.securities.entities.api.Currency;
import com.anz.securities.entities.dto.CurrencyConverter;
import com.anz.securities.entities.impl.ConversionRateImpl;
import com.anz.securities.entities.impl.ConversionRuleImpl;
import com.anz.securities.entities.impl.CurrencyImpl;

public class ConverterImplTest {
	
	@InjectMocks
	ConverterImpl objectUnderTest;

	@Mock
	Logger logger;

	private UserInputDto userInput;
	
	private CurrencyConverter converter;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		converter = new CurrencyConverter();
		buildCurrencyConverter();
		objectUnderTest = new ConverterImpl(converter);
		userInput = new UserInputDto();
	}
	

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testValidateUserInput() throws Exception {
		userInput.setSourceCurrency("AUD");
		userInput.setDestinationCurrency("CNY");
		userInput.setConversionAmount("100");
		
		objectUnderTest.validateUserInput(userInput);
	}

	@Test(expected=InvalidData.class)
	public void testValidateUserInputInvalidSourceCurrency() throws Exception {
		userInput.setSourceCurrency("ABC");
		userInput.setDestinationCurrency("CNY");
		userInput.setConversionAmount("100");
		
		objectUnderTest.validateUserInput(userInput);
	}
	
	@Test(expected=InvalidData.class)
	public void testValidateUserInputInvalidDestinationCurrency() throws Exception {
		userInput.setSourceCurrency("CNY");
		userInput.setDestinationCurrency("XYZ");
		userInput.setConversionAmount("100");
		
		objectUnderTest.validateUserInput(userInput);
	}

	@Test(expected=InvalidData.class)
	public void testValidateUserInputInvalidAmount() throws Exception {
		userInput.setSourceCurrency("CNY");
		userInput.setDestinationCurrency("USD");
		userInput.setConversionAmount("XYZ");
		
		objectUnderTest.validateUserInput(userInput);
	}
	
	@Test
	public void testDeterminePath() throws Exception {
		userInput.setSourceCurrency("AUD");
		userInput.setDestinationCurrency("CNY");
		userInput.setConversionAmount("100");
		
		objectUnderTest.determinePath(userInput);
		
	}
	
	@Test(expected=SameSourceAndDestinationCurrency.class)
	public void testDeterminePathSameCurrency() throws Exception {
		userInput.setSourceCurrency("AUD");
		userInput.setDestinationCurrency("AUD");
		userInput.setConversionAmount("100");
		objectUnderTest.determinePath(userInput);
	}

	@Test(expected=RuleNotFound.class)
	public void testDeterminePathInvalidCurrency() throws Exception {
		userInput.setSourceCurrency("AUD");
		userInput.setDestinationCurrency("CBZ");
		userInput.setConversionAmount("100");
		objectUnderTest.determinePath(userInput);
	}

	@Test(expected=RuleNotFound.class)
	public void testDeterminePathInvalidRule() throws Exception {
		List<ConversionRule> lRule = new ArrayList<>();
		lRule.add(getConversionRule("CNY", "USD"));
		lRule.add(getConversionRule("EUR", "USD"));
		lRule.add(getConversionRule("USD", "CNY"));
		Currency temmpCur = new CurrencyImpl("USD",0,lRule);
		converter.addCurrencyToMap(temmpCur);
		
		userInput.setSourceCurrency("AUD");
		userInput.setDestinationCurrency("CNY");
		userInput.setConversionAmount("100");
		objectUnderTest.determinePath(userInput);
	}
	
	@Test
	public void testDeterminePathFirstLevel() throws Exception {
		userInput.setSourceCurrency("CNY");
		userInput.setDestinationCurrency("USD");
		userInput.setConversionAmount("100");
		objectUnderTest.determinePath(userInput);
	}
	

	@Test
	public void testConvertAmount() throws Exception {
		userInput.setSourceCurrency("CNY");
		userInput.setDestinationCurrency("USD");
		userInput.setConversionAmount("120");
		objectUnderTest.validateUserInput(userInput);
		objectUnderTest.determinePath(userInput);
		objectUnderTest.convertAmount(userInput);
		Assert.assertEquals(20.0, userInput.getConvertedAmount(),0);
	}

	@Test
	public void testConvertAmountReverse() throws Exception {
		userInput.setSourceCurrency("USD");
		userInput.setDestinationCurrency("CNY");
		userInput.setConversionAmount("120");
		objectUnderTest.validateUserInput(userInput);
		objectUnderTest.determinePath(userInput);
		objectUnderTest.convertAmount(userInput);
		Assert.assertEquals(720.0, userInput.getConvertedAmount(),0);
	}
	
	
	private void buildCurrencyConverter() {
		Map<String, Currency> mapCurrecy = new HashMap<>();
		
		List<ConversionRule> lRule = new ArrayList<>();
		lRule.add(getConversionRule("CNY", "USD"));
		lRule.add(getConversionRule("EUR", "USD"));
		lRule.add(getConversionRule("USD", "NA"));
		Currency tempCurrency = new CurrencyImpl("AUD",2,lRule);
		mapCurrecy.put("AUD", tempCurrency);
		
		lRule = new ArrayList<>();
		lRule.add(getConversionRule("AUD", "USD"));
		lRule.add(getConversionRule("EUR", "USD"));
		lRule.add(getConversionRule("USD", "NA"));
		tempCurrency = new CurrencyImpl("CNY",2,lRule);
		mapCurrecy.put("CNY", tempCurrency);
		
		lRule = new ArrayList<>();
		lRule.add(getConversionRule("AUD", "USD"));
		lRule.add(getConversionRule("CNY", "USD"));
		lRule.add(getConversionRule("USD", "NA"));
		tempCurrency = new CurrencyImpl("EUR",2,lRule);
		mapCurrecy.put("EUR", tempCurrency);

		lRule = new ArrayList<>();
		lRule.add(getConversionRule("AUD", "NA"));
		lRule.add(getConversionRule("CNY", "NA"));
		lRule.add(getConversionRule("EUR", "NA"));
		tempCurrency = new CurrencyImpl("USD",2,lRule);
		mapCurrecy.put("USD", tempCurrency);
		
		converter.setMapCurrecy(mapCurrecy);
		
		List<ConversionRate> lRate = new ArrayList<>();
		lRate.add(getConversionRate("AUD", "USD", 0.8371));
		lRate.add(getConversionRate("EUR", "USD", 1.2315));
		lRate.add(getConversionRate("USD", "CNY", 6));
	
		converter.setListRates(lRate);
	}
	
	private ConversionRule getConversionRule(String str1, String str2) {
		ConversionRule ruleImpl = new ConversionRuleImpl(str1,str2);
		return ruleImpl;
	}
	
	private ConversionRate getConversionRate(String str1, String str2, double rate) {
		ConversionRate rateImpl = new ConversionRateImpl(str1,str2,rate);
		return rateImpl;
	}
	

}
