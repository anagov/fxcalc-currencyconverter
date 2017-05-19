package com.anz.securities.converter.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anz.securities.common.Constants;
import com.anz.securities.common.exception.CurrencyNotConverted;
import com.anz.securities.common.exception.InvalidData;
import com.anz.securities.common.exception.RuleNotFound;
import com.anz.securities.converter.dto.TraversalPath;
import com.anz.securities.converter.dto.UserInputDto;
import com.anz.securities.converter.util.ConverterUtil;
import com.anz.securities.entities.api.ConversionRate;
import com.anz.securities.entities.api.ConversionRule;
import com.anz.securities.entities.api.Currency;
import com.anz.securities.entities.dto.CurrencyConverter;
import com.anz.securities.entities.impl.ConversionRuleImpl;

public class ConverterImpl extends AbstractConverter {
	private static Logger logger = LoggerFactory.getLogger(ConverterImpl.class);

	public ConverterImpl(final CurrencyConverter converter) {
		super(converter);
	}

	@Override
	protected void validateUserInput(UserInputDto userInput) throws InvalidData {
		try {
			logger.info("Validating user request");
			ConverterUtil.isCurrencySupported(converter, userInput.getSourceCurrency());
			ConverterUtil.isCurrencySupported(converter, userInput.getDestinationCurrency());

			double amount = Double.parseDouble(userInput.getConversionAmount());
			userInput.setConvertedAmount(amount);
		} catch (NumberFormatException exNumberFormat) {
			throw new InvalidData("Incorrect amount format" + exNumberFormat.getMessage());
		} catch (Exception ex) {
			throw new InvalidData("Generic Error" + ex.getMessage());
		}

	}

	@Override
	protected void determinePath(UserInputDto userInput) throws RuleNotFound {
		logger.info("Determining the path");
		ConverterUtil.isSourceAndDestinationCurrencySame(userInput);

		Map<String, Currency> currencyRuleMap = converter.getMapCurrecy();
		String sourceCurrency = userInput.getSourceCurrency();
		ConversionRule myrule;
		TraversalPath path;
		do {

			if (userInput.getTraversedPath().contains(sourceCurrency)) {
				throw new RuleNotFound("Incorrect rule configuration");
			}
			List<ConversionRule> ruleList = currencyRuleMap.get(sourceCurrency).getRules();

			if (null == ruleList || ruleList.isEmpty()) {
				throw new RuleNotFound("Rule not found exception");
			}
			
			Collections.sort(ruleList);
			int index = Collections.binarySearch(ruleList,
					new ConversionRuleImpl(userInput.getDestinationCurrency(), ""));

			if (index < 0) {
				throw new RuleNotFound("Rule not found exception");
			}

			myrule = ruleList.get(index);

			if (!myrule.getPointer().equals(Constants.END_RULE)) {
				path = new TraversalPath(sourceCurrency, myrule.getPointer());
				userInput.addTraversedPath(sourceCurrency);
				sourceCurrency = myrule.getPointer();
			} else {
				path = new TraversalPath(sourceCurrency, userInput.getDestinationCurrency());
			}

			userInput.addTraversal(path);
		} while (!myrule.getPointer().equals(Constants.END_RULE));

	}

	@Override
	protected void convertAmount(UserInputDto userInput) throws CurrencyNotConverted {
		logger.info("Performing actual conversion");
		for (TraversalPath path : userInput.getTraversal()) {
			ConversionRate rate = ConverterUtil.getConversionRate(converter, path);
			applyCalculation(userInput, rate, path.getConversionType());
		}
	}

	private void applyCalculation(final UserInputDto userInput, final ConversionRate rate, final String convType)
			throws CurrencyNotConverted {

		double convertedAmt = 0;
		int expectedDecimal = ConverterUtil.getDecimalPlaceSupport(converter, rate.getDestinationCurrency());

		if (convType.equalsIgnoreCase(Constants.CONV_DIRECT)) {

			convertedAmt = userInput.getConvertedAmount() * Double.valueOf(rate.getConversionRate());

		} else if (convType.equalsIgnoreCase(Constants.CONV_INVERT)) {
			convertedAmt = userInput.getConvertedAmount() * (1 / Double.valueOf(rate.getConversionRate()));
		}

		userInput.setConvertedAmount(
				new BigDecimal(convertedAmt).setScale(expectedDecimal, RoundingMode.HALF_UP).doubleValue());

	}
}
