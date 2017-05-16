package com.fr.solution.plugin.chart.echarts.bar;

import com.fr.chart.chartattr.Chart;
import com.fr.solution.plugin.chart.echarts.common.base.AbstractIndependentEChartsProvider;
import com.fr.solution.plugin.chart.echarts.common.base.ECharts;
import com.fr.solution.plugin.chart.echarts.bar.plot.EChartsBarPlot;
import com.fr.solution.plugin.chart.echarts.bar.plot.RoseType;

public class EChartsBar extends AbstractIndependentEChartsProvider {

    private static ECharts createBar(RoseType type) {
        EChartsBarPlot plot = new EChartsBarPlot(type);
        return new ECharts(plot);
    }

    public static ECharts[] charts = new ECharts[] {
            createBar(RoseType.NONE)
            //createBar(RoseType.NONE),
            //createBar(RoseType.AREA),
            //createBar(RoseType.RADIUS),
    };

    @Override
    public String getChartName() {
        return "Plugin-ECharts_Bar";
    }

    @Override
    public Chart[] getChartTypes() {
        return charts;
    }

    @Override
    public String getChartImagePath() {
        return "com/fr/solution/plugin/chart/echarts/bar/images/bar512.png";
    }
}
