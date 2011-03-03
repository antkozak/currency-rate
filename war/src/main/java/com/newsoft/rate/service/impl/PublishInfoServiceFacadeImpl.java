package com.newsoft.rate.service.impl;

import com.newsoft.rate.client.model.ExchangeRates;
import com.newsoft.rate.model.CurrencyRate;
import com.newsoft.rate.model.DailyExchangeRates;
import com.newsoft.rate.service.PublishInfoServiceFacade;
import com.newsoft.rate.service.RateService;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class PublishInfoServiceFacadeImpl implements PublishInfoServiceFacade {

    private RateService rateService;

    /**
     * Returns exchange rates.
     *
     * @param currency currency.
     * @param startDate start date.
     * @param endDate end date.
     * @return rates grouped by date.
     */
    public Map<Date,Double> getExchangeRates(String currency, Date startDate, Date endDate) {
        Map<Date,Double> result = new TreeMap<Date,Double>();
        List<DailyExchangeRates> rates = rateService.getExchangeRates(startDate, endDate);
        for(final DailyExchangeRates exchangeRates : rates) {
            Double rate = 0D;
            for(CurrencyRate currencyRate : exchangeRates.getRates()) {
                if(currencyRate.getCode().equals(currency)) {
                    rate = currencyRate.getRate();
                    break;
                }
            }
            result.put(exchangeRates.getRateDate(), rate);
        }
        return result;
    }

    public RateService getRateService() {
        return rateService;
    }

    public void setRateService(RateService rateService) {
        this.rateService = rateService;
    }
}