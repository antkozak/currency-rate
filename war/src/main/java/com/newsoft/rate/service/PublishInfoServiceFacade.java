package com.newsoft.rate.service;

import com.newsoft.rate.model.DailyExchangeRates;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * Bridge between service API and GWT.
 */
@RemoteServiceRelativePath("../service/publishInfoService")
public interface PublishInfoServiceFacade extends RemoteService {

    /**
     * Returns exchange rates.
     *
     * @param startDate start date.
     * @param endDate end date.
     * @param currency currency. 
     * @return rates grouped by date.
     */
    public Map<Date,Double> getExchangeRates(String currency, Date startDate, Date endDate);
}