package com.anz.securities.dataloader.spi;

import com.anz.securities.common.exception.UnsuccessfulDataLoading;
import com.anz.securities.entities.dto.CurrencyConverter;

/**
 * SPI (Service Provider Interface) type for data loader applications. Data can
 * be loaded from the XML, DB, JSON. Each loading mechanism to return the
 * CurrencyConverter object for the calculator to work
 * 
 * @author Anand Katti
 *
 */
@FunctionalInterface
public interface DataLoader {

	/**
	 * Provides a contract to load the data.
	 * 
	 * @param config
	 * @return currencyConverter
	 * @throws UnsuccessfulDataLoading
	 */
	public CurrencyConverter loadData(final LoaderConfig config) throws UnsuccessfulDataLoading;
}
