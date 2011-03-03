package com.newsoft.rate.repository;

import com.newsoft.rate.model.DailyExchangeRates;

import java.util.Date;
import java.util.List;

/**
 * Repository to perform CRUD operations under {@link DailyExchangeRates} entries.
 */
public interface DailyExchangeRatesRepository extends Repository<DailyExchangeRates, Long> {

    /**
     * Returns the list of the {@link DailyExchangeRates}.
     *
     * @param currency the name of the currency, i.e. "USD", "EUR"
     * @param startDate start date of the period.
     * @param endDate  end date of the period.
     * @return the list of the {@link DailyExchangeRates}.
     */
    List<DailyExchangeRates> findDailyExchangeRates(String currency, Date startDate, Date endDate);
}
