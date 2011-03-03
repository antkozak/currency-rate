package com.newsoft.rate.service;

import com.newsoft.rate.model.DailyExchangeRates;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Service for exchange rates processing.
 * <p/>
 * Copyright (C) 2010 Edmunds.com
 * <p/>
 * Date: Feb 21, 2011
 *
 * @author Anton Kozak
 */
public interface RateService extends Serializable {
    /**
     * Returns exchange rates.
     *
     * @param startDate start date.
     * @param endDate end date.
     * @return list of {@link com.newsoft.rate.model.DailyExchangeRates}
     */
    List<DailyExchangeRates> getExchangeRates(Date startDate, Date endDate);
}
