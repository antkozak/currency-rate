package com.newsoft.rate.client.model;

import com.extjs.gxt.ui.client.data.BaseModel;
import java.util.Date;

public class Currency extends BaseModel {

    private static final long serialVersionUID = 2103699184769341265L;
    public static final String CURRENCY_KEY = "currency";

    public Currency(String currency) {
        set(CURRENCY_KEY, currency);    }

    public String getCurrency() {
        return (String) get(CURRENCY_KEY);
    }
}