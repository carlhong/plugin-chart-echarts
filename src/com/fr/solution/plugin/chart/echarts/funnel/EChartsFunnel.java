package com.fr.solution.plugin.chart.echarts.funnel;

import com.fr.chart.chartattr.Chart;
import com.fr.solution.plugin.chart.echarts.common.base.AbstractIndependentEChartsProvider;
import com.fr.solution.plugin.chart.echarts.common.base.ECharts;
import com.fr.solution.plugin.chart.echarts.funnel.plot.EChartsFunnelPlot;
import com.fr.solution.plugin.chart.echarts.funnel.plot.RoseType;

public class EChartsFunnel extends AbstractIndependentEChartsProvider {

    private static ECharts createFunnel(RoseType type) {
        EChartsFunnelPlot plot = new EChartsFunnelPlot(type);
        return new ECharts(plot);
    }

    public static ECharts[] charts = new ECharts[] {
            createFunnel(RoseType.NONE)
            //createFunnel(RoseType.NONE),
            //createFunnel(RoseType.AREA),
            //createFunnel(RoseType.RADIUS),
    };

    @Override
    public String getChartName() {
        return "Plugin-ECharts_Funnel";
    }

    @Override
    public Chart[] getChartTypes() {
        return charts;
    }

    @Override
    public String getChartImagePath() {
        return "com/fr/solution/plugin/chart/echarts/funnel/images/funnel540.png";
    }
}
