package com.fr.solution.plugin.chart.echarts.scatter;

import com.fr.chart.chartattr.Chart;
import com.fr.solution.plugin.chart.echarts.common.base.AbstractIndependentEChartsProvider;
import com.fr.solution.plugin.chart.echarts.common.base.ECharts;
import com.fr.solution.plugin.chart.echarts.scatter.plot.EChartsScatterPlot;
import com.fr.solution.plugin.chart.echarts.scatter.plot.RoseType;

public class EChartsScatter extends AbstractIndependentEChartsProvider {

    private static ECharts createScatter(RoseType type) {
        EChartsScatterPlot plot = new EChartsScatterPlot(type);
        return new ECharts(plot);
    }

    public static ECharts[] charts = new ECharts[] {
            createScatter(RoseType.NONE)
            //createScatter(RoseType.NONE),
            //createScatter(RoseType.AREA),
            //createScatter(RoseType.RADIUS),
    };

    @Override
    public String getChartName() {
        return "Plugin-ECharts_Scatter";
    }

    @Override
    public Chart[] getChartTypes() {
        return charts;
    }

    @Override
    public String getChartImagePath() {
        return "com/fr/solution/plugin/chart/echarts/scatter/images/scatter512.png";
    }
}
