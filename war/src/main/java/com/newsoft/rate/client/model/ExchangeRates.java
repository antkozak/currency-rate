package com.newsoft.rate.client.model;

import com.extjs.gxt.ui.client.data.BaseModel;
import java.util.Date;

public class ExchangeRates extends BaseModel {

    private static final long serialVersionUID = 2103699184769341265L;
    public static final String DATE_KEY = "date";
    public static final String RATE_KEY = "rate";

    public ExchangeRates(Date date, Double rate) {
        setDate(date);
        setRate(rate);
    }

    public Double getRate() {
        return (Double) get(RATE_KEY);
    }

    public Date getDate() {
        return (Date) get(DATE_KEY);
    }

    public void setRate(Double rate) {
        set(RATE_KEY, rate);
    }

    public void setDate(Date date) {
        set(DATE_KEY, date);
    }
}