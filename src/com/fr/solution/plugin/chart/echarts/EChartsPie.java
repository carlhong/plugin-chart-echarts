package com.fr.solution.plugin.chart.echarts;

import com.fr.chart.chartattr.Chart;
import com.fr.general.Inter;
import com.fr.solution.plugin.chart.echarts.base.AbstractIndependentEChartsProvider;
import com.fr.solution.plugin.chart.echarts.base.ECharts;
import com.fr.solution.plugin.chart.echarts.plot.pie.EChartsPiePlot;
import com.fr.solution.plugin.chart.echarts.plot.pie.PieType;

/**
 * Created by richie on 16/2/18.
 */
public class EChartsPie extends AbstractIndependentEChartsProvider {

    private static ECharts createPie(PieType type) {
        EChartsPiePlot plot = new EChartsPiePlot(type);
        return new ECharts(plot);
    }

    public static ECharts[] charts = new ECharts[] {
            createPie(PieType.REGULAR),
            createPie(PieType.CIRCLE)
    };


    @Override
    public String getChartName() {
        return "Plugin-ECharts_Pie";
    }

    @Override
    public String getChartUseName() {
        return Inter.getLocText("Plugin-ECharts_Pie");
    }

    @Override
    public Chart[] getChartTypes() {
        return charts;
    }

    @Override
    public String getChartImagePath() {
        return "com/fr/solution/plugin/chart/echarts/images/pie/pie256.png";
    }
}
