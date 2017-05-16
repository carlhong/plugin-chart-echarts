package com.fr.solution.plugin.chart.echarts.boxplot;

import com.fr.chart.chartattr.Chart;
import com.fr.solution.plugin.chart.echarts.common.base.AbstractIndependentEChartsProvider;
import com.fr.solution.plugin.chart.echarts.common.base.ECharts;
import com.fr.solution.plugin.chart.echarts.boxplot.plot.EChartsBoxplotPlot;
import com.fr.solution.plugin.chart.echarts.boxplot.plot.RoseType;

public class EChartsBoxplot extends AbstractIndependentEChartsProvider {

    private static ECharts createBoxplot(RoseType type) {
        EChartsBoxplotPlot plot = new EChartsBoxplotPlot(type);
        return new ECharts(plot);
    }

    public static ECharts[] charts = new ECharts[] {
            createBoxplot(RoseType.NONE)
            //createBoxplot(RoseType.NONE),
            //createBoxplot(RoseType.AREA),
            //createBoxplot(RoseType.RADIUS),
    };

    @Override
    public String getChartName() {
        return "Plugin-ECharts_Boxplot";
    }

    @Override
    public Chart[] getChartTypes() {
        return charts;
    }

    @Override
    public String getChartImagePath() {
        return "com/fr/solution/plugin/chart/echarts/boxplot/images/boxplot76.png";
    }
}
