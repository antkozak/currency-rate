package com.newsoft.rate.service;

import com.newsoft.rate.model.CurrencyRate;
import com.newsoft.rate.model.CurrencyRateImpl;
import com.newsoft.rate.model.DailyExchangeRates;
import com.newsoft.rate.model.DailyExchangeRatesImpl;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Rate service.
 * <p/>
 * Date: Feb 20, 2011
 *
 * @author Anton Kozak
 */
@Service("rateService")
public class RateServiceImpl /*implements RateService */{

    private static final Logger LOG = Logger.getLogger(RateServiceImpl.class);

    /**
     * Returns exchange rates.
     *
     * @param startDate start date.
     * @param endDate   end date.
     * @return list of {@link DailyExchangeRates}
     */
    //TODO refactor
    public List<DailyExchangeRatesImpl> getExchangeRates(Date startDate, Date endDate) {
        List<DailyExchangeRatesImpl> rates = new ArrayList<DailyExchangeRatesImpl>();
        DailyExchangeRatesImpl dailyRate1 = new DailyExchangeRatesImpl();
        dailyRate1.setRateDate(new Date());
        CurrencyRateImpl rate1 = new CurrencyRateImpl();
        rate1.setCode("USD");
        rate1.setName("USD");
        rate1.setRate(3020D);
        CurrencyRateImpl rate2 = new CurrencyRateImpl();
        rate2.setCode("EUR");
        rate2.setName("EUR");
        rate2.setRate(4020D);
        Set<CurrencyRateImpl> set = new HashSet<CurrencyRateImpl>();
        set.add(rate1);
        set.add(rate2);
        dailyRate1.setRates(set);

        DailyExchangeRatesImpl dailyRate2 = new DailyExchangeRatesImpl();
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, -5);
        dailyRate2.setRateDate(calendar.getTime());
        rate1 = new CurrencyRateImpl();
        rate1.setCode("USD");
        rate1.setName("USD");
        rate1.setRate(3000D);
        rate2 = new CurrencyRateImpl();
        rate2.setCode("EUR");
        rate2.setName("EUR");
        rate2.setRate(3090D);
        set = new HashSet<CurrencyRateImpl>();
        set.add(rate1);
        set.add(rate2);
        dailyRate2.setRates(set);

        DailyExchangeRatesImpl dailyRate3 = new DailyExchangeRatesImpl();
        calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, -1);
        dailyRate3.setRateDate(calendar.getTime());
        rate1 = new CurrencyRateImpl();
        rate1.setCode("USD");
        rate1.setName("USD");
        rate1.setRate(2980D);
        rate2 = new CurrencyRateImpl();
        rate2.setCode("EUR");
        rate2.setName("EUR");
        rate2.setRate(4000D);
        set = new HashSet<CurrencyRateImpl>();
        set.add(rate1);
        set.add(rate2);
        dailyRate3.setRates(set);
        rates.add(dailyRate1);
        rates.add(dailyRate2);
        rates.add(dailyRate3);
        return rates;
    }
}
