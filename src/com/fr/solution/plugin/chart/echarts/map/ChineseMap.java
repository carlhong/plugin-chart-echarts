package com.fr.solution.plugin.chart.echarts.map;

import com.fr.chart.chartattr.Chart;
import com.fr.general.Inter;
import com.fr.solution.plugin.chart.echarts.common.base.AbstractIndependentEChartsProvider;
import com.fr.solution.plugin.chart.echarts.common.base.ECharts;
import com.fr.solution.plugin.chart.echarts.map.plot.ChineseMapPlot;

/**
 * Created by richie on 16/1/29.
 */
public class ChineseMap extends AbstractIndependentEChartsProvider {

    private static ECharts createChineseMap() {
        ChineseMapPlot plot = new ChineseMapPlot();
        return new ECharts(plot);
    }

    public static ECharts[] charts = new ECharts[] {
            createChineseMap()
    };


    @Override
    public String getChartName() {
        return "Plugin-ECharts_Chinese_Map";
    }

    @Override
    public Chart[] getChartTypes() {
        return charts;
    }

    @Override
    public String getChartImagePath() {
        return "com/fr/solution/plugin/chart/echarts/map/images/map256.png";
    }

}