package com.newsoft.rate.client;

import com.extjs.gxt.charts.client.model.LineDataProvider;
import com.extjs.gxt.charts.client.model.charts.LineChart;
import com.newsoft.rate.client.model.ExchangeRates;

import com.extjs.gxt.charts.client.Chart;
import com.extjs.gxt.charts.client.event.ChartListener;
import com.extjs.gxt.charts.client.model.BarDataProvider;
import com.extjs.gxt.charts.client.model.ChartModel;
import com.extjs.gxt.charts.client.model.Legend;
import com.extjs.gxt.charts.client.model.ScaleProvider;
import com.extjs.gxt.charts.client.model.Legend.Position;
import com.extjs.gxt.charts.client.model.charts.BarChart;
import com.extjs.gxt.charts.client.model.charts.BarChart.BarStyle;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.RowData;
import com.extjs.gxt.ui.client.widget.layout.RowLayout;
import com.google.gwt.user.client.Element;

public class CurrencyRatesChart extends LayoutContainer {
    private ListStore<ExchangeRates> store;

    public CurrencyRatesChart(ListStore<ExchangeRates> store){
        this.store = store;
    }
  @Override
  protected void onRender(Element parent, int index) {
    super.onRender(parent, index);


    // chart
    String url = "resources/chart/open-flash-chart.swf";
    final Chart chart = new Chart(url);

    ChartListener listener = new ChartListener() {
//      public void chartClick(ChartEvent ce) {
//        int row = ce.getChartConfig().getValues().indexOf(ce.getDataType());
//        int col = ce.getChartModel().getChartConfigs().indexOf(ce.getChartConfig()) + 1;
//        CellSelectionModel<TeamSales> csm = (CellSelectionModel<TeamSales>) teamSalesGrid.getSelectionModel();
//        if (selRadio.getValue()) {
//          csm.selectCell(row, col);
//        } else {
//          teamSalesGrid.startEditing(row, col);
//        }
//      }
    };

    ChartModel model = new ChartModel("Exchange rates by date",
        "font-size: 14px; font-family: Verdana; text-align: center;");
    model.setBackgroundColour("#fefefe");
    model.setLegend(new Legend(Position.TOP, true));
    model.setScaleProvider(ScaleProvider.ROUNDED_NEAREST_SCALE_PROVIDER);

    BarChart bar = new BarChart(BarStyle.GLASS);
    bar.setColour("#00aa00");
    BarDataProvider barProvider = new BarDataProvider(ExchangeRates.RATE_KEY, ExchangeRates.DATE_KEY);
    barProvider.bind(store);
    bar.setDataProvider(barProvider);
    bar.addChartListener(listener);
    model.addChartConfig(bar);

//    bar = new BarChart(BarStyle.GLASS);
//    bar.setColour("#0000cc");
//    barProvider = new BarDataProvider(ExchangeRates.EURO_RATE_KEY);
//    barProvider.bind(store);
//
//    bar.setDataProvider(barProvider);
//    bar.addChartListener(listener);
//    model.addChartConfig(bar);
//
//    bar = new BarChart(BarStyle.GLASS);
//    bar.setColour("#ff6600");
//    barProvider = new BarDataProvider(ExchangeRates.RUB_RATE_KEY);
//    barProvider.bind(store);
//    bar.setDataProvider(barProvider);
//    bar.addChartListener(listener);
//    model.addChartConfig(bar);

    LineChart line = new LineChart();
    line.setAnimateOnShow(true);
    line.setText("Average");
    line.setColour("#FF0000");
    LineDataProvider lineProvider = new LineDataProvider(ExchangeRates.RATE_KEY);
    lineProvider.bind(store);
    line.setDataProvider(lineProvider);
    model.addChartConfig(line);

    chart.setChartModel(model);

    LayoutContainer lc = new LayoutContainer();
    RowLayout rl = new RowLayout();
    lc.setLayout(rl);
    lc.setSize(800, 600);

    RowData data;
    data = new RowData(1, 300, new Margins(10));
    ContentPanel cp = new ContentPanel(new FitLayout());
    cp.setHeading("Chart");
    cp.add(chart);
    lc.add(cp, data);

    add(lc);

  }
}
