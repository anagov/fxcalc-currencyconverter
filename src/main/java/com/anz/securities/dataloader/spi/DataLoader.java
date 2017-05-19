package com.anz.securities.dataloader.spi;

import com.anz.securities.common.exception.UnsuccessfulDataLoading;
import com.anz.securities.entities.dto.CurrencyConverter;

@FunctionalInterface
public interface DataLoader {

	public CurrencyConverter loadData( final LoaderConfig config) throws UnsuccessfulDataLoading;
}
