package com.fr.plugin.chart.echarts;

import com.fr.chart.chartattr.Chart;
import com.fr.chart.fun.impl.AbstractIndependentChartProvider;
import com.fr.general.Inter;
import com.fr.plugin.chart.echarts.web.EChartsBarPlot;


public class EChartsBar extends AbstractIndependentChartProvider {

    @Override
    public String getChartName() {
        return "Plugin-ECharts_Bar";
    }

    @Override
    public String getChartUseName() {
        return Inter.getLocText("Plugin-ECharts_Bar");
    }

    @Override
    public Chart[] getChartTypes() {
        Chart[] charts = new Chart[1];
        EChartsBarPlot plot = new EChartsBarPlot();
        Chart barChart = new Chart(plot);
        barChart.setWrapperName(getWrapperName());
        charts[0] = barChart;
        barChart.setRequiredJs(getRequiredJS());
        barChart.setChartImagePath(this.getChartImagePath());
        return charts;
    }

    @Override
    public String getChartImagePath() {
        return "com/fr/plugin/chart/echarts/images/bar256.png";
    }

    @Override
    public String[] getRequiredJS() {
        return new String[]{
                "/com/fr/plugin/chart/echarts/web/echarts-all.js?encode=utf8",
                "/com/fr/plugin/chart/echarts/web/wrapper.js"
        };
    }

    @Override
    public String getWrapperName() {
        return "EChartsBarFactory";
    }
}
