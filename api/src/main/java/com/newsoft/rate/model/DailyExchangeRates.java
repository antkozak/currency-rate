package com.newsoft.rate.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * Daily exchange rates.
 * <p/>
 * Copyright (C) 2010 Edmunds.com
 * <p/>
 * Date: Feb 20, 2011
 *
 * @author Anton Kozak
 */
public interface DailyExchangeRates extends Serializable {
    /**
     * Returns id.
     *
     * @return id.
     */
    Long getId();

    /**
     * Sets id.
     *
     * @param id id.
     */
    void setId(Long id);

    /**
     * Returns rate date.
     *
     * @return rate date.
     */
    Date getRateDate();

    /**
     * Sets rate date.
     *
     * @param rateDate rate date.
     */
    void setRateDate(Date rateDate);

    /**
     * Returns daily rates.
     *
     * @return daily rates.
     */
    Set<CurrencyRate> getRates();

    /**
     * Returns daily rates.
     *
     * @param rates daily rates.
     */
    void setRates(Set<CurrencyRate> rates);
}
