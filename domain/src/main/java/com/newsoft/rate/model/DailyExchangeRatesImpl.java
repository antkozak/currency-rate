package com.newsoft.rate.model;

import javax.jdo.annotations.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Class contains daily exchange rates.
 * <p/>
 * Date: Mar 4, 2010
 *
 * @author Anton Kozak
 */
@PersistenceCapable(identityType= IdentityType.APPLICATION)
public class DailyExchangeRatesImpl /*implements DailyExchangeRates */{

    @PrimaryKey
    @Persistent(valueStrategy= IdGeneratorStrategy.IDENTITY)
    private Long id;

    @Persistent
    private Date rateDate;

    @Persistent
    private Set<CurrencyRateImpl> rates = new HashSet<CurrencyRateImpl>();

    /**
     * Returns id.
     *
     * @return id.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id id.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Returns rate date.
     *
     * @return rate date.
     */
    public Date getRateDate() {
        return rateDate;
    }

    /**
     * Sets rate date.
     *
     * @param rateDate rate date.
     */
    public void setRateDate(Date rateDate) {
        this.rateDate = rateDate;
    }

    /**
     * Returns daily rates.
     *
     * @return daily rates.
     */
    public Set<CurrencyRateImpl> getRates() {
        return rates;
    }

    /**
     * Returns daily rates.
     *
     * @param rates daily rates.
     */
    public void setRates(Set<CurrencyRateImpl> rates) {
        this.rates = rates;
    }
}
