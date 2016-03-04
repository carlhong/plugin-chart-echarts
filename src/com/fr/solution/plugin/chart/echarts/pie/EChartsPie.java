package com.fr.solution.plugin.chart.echarts.pie;

import com.fr.chart.chartattr.Chart;
import com.fr.general.Inter;
import com.fr.solution.plugin.chart.echarts.common.base.AbstractIndependentEChartsProvider;
import com.fr.solution.plugin.chart.echarts.common.base.ECharts;
import com.fr.solution.plugin.chart.echarts.pie.plot.EChartsPiePlot;
import com.fr.solution.plugin.chart.echarts.pie.plot.RoseType;

/**
 * Created by richie on 16/2/18.
 */
public class EChartsPie extends AbstractIndependentEChartsProvider {

    private static ECharts createPie(RoseType type) {
        EChartsPiePlot plot = new EChartsPiePlot(type);
        return new ECharts(plot);
    }

    public static ECharts[] charts = new ECharts[] {
            createPie(RoseType.NONE),
            createPie(RoseType.AREA),
            createPie(RoseType.RADIUS),
    };


    @Override
    public String getChartName() {
        return "Plugin-ECharts_Pie";
    }

    @Override
    public Chart[] getChartTypes() {
        return charts;
    }

    @Override
    public String getChartImagePath() {
        return "com/fr/solution/plugin/chart/echarts/pie/images/pie256.png";
    }
}
