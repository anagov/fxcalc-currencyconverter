package com.anz.securities.converter.util;

import java.util.Collections;
import java.util.List;

import com.anz.securities.common.Constants;
import com.anz.securities.common.exception.CurrencyNotSupported;
import com.anz.securities.common.exception.SameSourceAndDestinationCurrency;
import com.anz.securities.common.exception.UndefinedConversionRate;
import com.anz.securities.converter.dto.TraversalPath;
import com.anz.securities.converter.dto.UserInputDto;
import com.anz.securities.entities.api.ConversionRate;
import com.anz.securities.entities.api.Currency;
import com.anz.securities.entities.dto.CurrencyConverter;
import com.anz.securities.entities.impl.ConversionRateImpl;

public class ConverterUtil {

	/**
	 * 
	 * @param src
	 * @param dest
	 * @return
	 * @throws UndefinedConversionRate
	 */
	public static ConversionRate getConversionRate(final CurrencyConverter converter, final TraversalPath path)
			throws UndefinedConversionRate {
		try {
			String converstionType = Constants.CONV_DIRECT;
			List<ConversionRate> rateList = converter.getListRates();
			Collections.sort(rateList);
			int index = Collections.binarySearch(rateList,
					new ConversionRateImpl(path.getFromCurrency(), path.getToCurrency()));
			if (index < 0) {
				converstionType = Constants.CONV_INVERT;
				index = Collections.binarySearch(rateList,
						new ConversionRateImpl(path.getToCurrency(), path.getFromCurrency()));
			}

			ConversionRate rate = rateList.get(index);
			path.setConversionType(converstionType);
			return rate;
		} catch (Exception ex) {
			throw new UndefinedConversionRate("Rate not defined for" + ex.getMessage());
		}
	}

	public static int getDecimalPlaceSupport(final CurrencyConverter converter, final String currency)
			throws CurrencyNotSupported {

		if (!converter.getMapCurrecy().keySet().contains(currency)) {
			throw new CurrencyNotSupported("currency not supported");
		}
		Currency cur = converter.getMapCurrecy().get(currency);
		return cur.getDecimalSupport();
	}

	public static boolean isSourceAndDestinationCurrencySame(final UserInputDto userInput)
			throws SameSourceAndDestinationCurrency {

		if ( userInput.getSourceCurrency().equalsIgnoreCase(userInput.getDestinationCurrency())) {
			throw new SameSourceAndDestinationCurrency("Converted Amount is:" + userInput.getConversionAmount());
		}
		return true;
	}

	public static boolean isCurrencySupported(final CurrencyConverter converter, final String currency)
			throws CurrencyNotSupported {
		if (!converter.isCurrencySupported(currency)) {
			throw new CurrencyNotSupported("Currency not supported - " + currency);
		}

		return true;
	}
}
