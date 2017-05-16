package com.fr.solution.plugin.chart.echarts.line;

import com.fr.chart.chartattr.Chart;
import com.fr.solution.plugin.chart.echarts.common.base.AbstractIndependentEChartsProvider;
import com.fr.solution.plugin.chart.echarts.common.base.ECharts;
import com.fr.solution.plugin.chart.echarts.line.plot.EChartsLinePlot;
import com.fr.solution.plugin.chart.echarts.line.plot.RoseType;

public class EChartsLine extends AbstractIndependentEChartsProvider {

    private static ECharts createLine(RoseType type) {
        EChartsLinePlot plot = new EChartsLinePlot(type);
        return new ECharts(plot);
    }

    public static ECharts[] charts = new ECharts[] {
            createLine(RoseType.NONE)
            //createLine(RoseType.NONE),
            //createLine(RoseType.AREA),
            //createLine(RoseType.RADIUS),
    };

    @Override
    public String getChartName() {
        return "Plugin-ECharts_Line";
    }

    @Override
    public Chart[] getChartTypes() {
        return charts;
    }

    @Override
    public String getChartImagePath() {
        return "com/fr/solution/plugin/chart/echarts/line/images/line512.png";
    }
}
