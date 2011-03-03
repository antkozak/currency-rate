package com.newsoft.rate.service;

import com.newsoft.rate.model.CurrencyRateImpl;
import com.newsoft.rate.model.DailyExchangeRates;
import java.util.List;

import com.newsoft.rate.model.DailyExchangeRatesImpl;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Test for {@link RateServiceImpl}
 * <p/>
 * Date: Feb 20, 2011
 *
 * @author Anton Kozak
 */
public class RateServiceImplTest {
     @Test
    public void testGetExchangeRates(){
         RateServiceImpl service = new RateServiceImpl();
         List<DailyExchangeRatesImpl> rates = service.getExchangeRates(null, null);
         assertEquals(rates.size(), 3);
     }
}
