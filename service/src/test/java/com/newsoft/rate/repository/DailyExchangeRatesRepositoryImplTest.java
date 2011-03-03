package com.newsoft.rate.repository;

import com.newsoft.rate.BaseGoogleAppEngineTest;
import com.newsoft.rate.model.CurrencyRate;
import com.newsoft.rate.model.CurrencyRateImpl;
import com.newsoft.rate.model.DailyExchangeRates;
import com.newsoft.rate.model.DailyExchangeRatesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Test for {@link DailyExchangeRatesRepositoryImpl}
 */
@ContextConfiguration(locations = {"classpath:rate-service.xml"})
public class DailyExchangeRatesRepositoryImplTest extends BaseGoogleAppEngineTest {
    private static final Long ID = 100L;
    private static final Date DATE = new Date();

    @Autowired
    private DailyExchangeRatesRepositoryImpl ratesRepository;

    @Test
    public void testSave() {
        DailyExchangeRatesImpl dailyRate = new DailyExchangeRatesImpl();
        dailyRate.setId(ID);
        dailyRate.setRateDate(new Date());
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
        dailyRate.setRates(set);
        ratesRepository.save(dailyRate);
        DailyExchangeRatesImpl result = ratesRepository.findById(ID);
        Assert.assertNotNull(result);
        Assert.assertEquals(result.getId(), ID);
        //TODO verify it
//        Assert.assertEquals(result.getRateDate().getTime(), DATE.getTime());
        Assert.assertEquals(result.getRates().size(), 2);
    }

}
