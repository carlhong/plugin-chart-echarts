package com.fr.solution.plugin.chart.echarts.gauge;

import com.fr.chart.chartattr.Chart;
import com.fr.solution.plugin.chart.echarts.common.base.AbstractIndependentEChartsProvider;
import com.fr.solution.plugin.chart.echarts.common.base.ECharts;
import com.fr.solution.plugin.chart.echarts.gauge.plot.EChartsGaugePlot;
import com.fr.solution.plugin.chart.echarts.gauge.plot.RoseType;

public class EChartsGauge extends AbstractIndependentEChartsProvider {

    private static ECharts createGauge(RoseType type) {
        EChartsGaugePlot plot = new EChartsGaugePlot(type);
        return new ECharts(plot);
    }

    public static ECharts[] charts = new ECharts[] {
            createGauge(RoseType.NONE)
            //createGauge(RoseType.NONE),
            //createGauge(RoseType.AREA),
            //createGauge(RoseType.RADIUS),
    };

    @Override
    public String getChartName() {
        return "Plugin-ECharts_Gauge";
    }

    @Override
    public Chart[] getChartTypes() {
        return charts;
    }

    @Override
    public String getChartImagePath() {
        return "com/fr/solution/plugin/chart/echarts/gauge/images/gauge668.png";
    }
}
