package com.newsoft.rate.client;

import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.util.Params;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.VerticalPanel;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.extjs.gxt.ui.client.widget.form.SimpleComboBox;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.RootPanel;
import com.newsoft.rate.client.model.Currency;
import com.newsoft.rate.client.model.ExchangeRates;
import com.newsoft.rate.service.PublishInfoServiceFacadeAsync;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import static com.google.gwt.core.client.GWT.log;

public class Rate implements EntryPoint {

    private static final PublishInfoServiceFacadeAsync service = PublishInfoServiceFacadeAsync.Util.getInstance();
    ListStore<ExchangeRates> store = new ListStore<ExchangeRates>();
    final DateField startDate = new DateField();
    final DateField endDate = new DateField();
    final SimpleComboBox currencyCombo = new SimpleComboBox();

    public void onModuleLoad() {
        prepareDateFields();
        prepareCurrencyBox();
        LayoutContainer layoutContainer = new LayoutContainer();
        layoutContainer.setSize(800, 200);
        ContentPanel contentPanel = new ContentPanel(new FitLayout());
        contentPanel.setHeading("Currency / start date / end date");
        VerticalPanel vp = new VerticalPanel();
        vp.add(currencyCombo);
        vp.add(startDate);
        vp.add(endDate);
        contentPanel.add(vp);
        layoutContainer.add(contentPanel);
        getExchangeRates();
        layoutContainer.add(new CurrencyRatesChart(store));
        RootPanel.get().add(layoutContainer);
        layoutContainer.layout();
    }

    private void prepareDateFields() {
//        Calendar calendar = Calendar.getInstance();
//        int year = calendar.get(Calendar.YEAR);
//        calendar.clear();
//        calendar.set(Calendar.YEAR, year);
//        startDate.setValue(calendar.getTime());
//        endDate.setValue(Calendar.getInstance().getTime());
        startDate.addListener(Events.Select, new Listener<ComponentEvent>() {
            public void handleEvent(ComponentEvent be) {
                getExchangeRates();

            }
        });
        endDate.addListener(Events.Select, new Listener<ComponentEvent>() {
            public void handleEvent(ComponentEvent be) {
                getExchangeRates();
            }
        });
    }

    private void prepareCurrencyBox() {
        //TODO select it from service
        final ListStore<Currency> currencyStore = new ListStore<Currency>();
        currencyStore.add(new Currency("USD"));
        currencyStore.add(new Currency("EUR"));
        currencyStore.add(new Currency("RUB"));

        currencyCombo.setDisplayField(Currency.CURRENCY_KEY);
        currencyCombo.setWidth(150);
        currencyCombo.setStore(currencyStore);
        currencyCombo.select(1);
        currencyCombo.setTypeAhead(true);
        currencyCombo.setTriggerAction(ComboBox.TriggerAction.ALL);
        currencyCombo.addListener(Events.Select, new Listener<ComponentEvent>() {
            public void handleEvent(ComponentEvent be) {
                getExchangeRates();
            }
        });
    }

    void getExchangeRates() {
        final AsyncCallback<Map<Date, Double>> ratesCallback = new AsyncCallback<Map<Date, Double>>() {
            public void onFailure(final Throwable caught) {
                log(caught.getMessage(), caught);
            }

            public void onSuccess(final Map<Date, Double> result) {
                store.removeAll();
                for(Date date : result.keySet()) {
                    store.add(new ExchangeRates(date, result.get(date)));
                }
            }
        };
        getService().getExchangeRates(
            currencyCombo.getValue() != null ? ((Currency) currencyCombo.getValue()).getCurrency() : "USD",
            startDate.getValue(), endDate.getValue(), ratesCallback);
    }

    protected PublishInfoServiceFacadeAsync getService() {
        return service;
    }
}