package com.fr.solution.plugin.chart.echarts;

import com.fr.chart.chartattr.Chart;
import com.fr.general.Inter;
import com.fr.solution.plugin.chart.echarts.base.AbstractIndependentEChartsProvider;
import com.fr.solution.plugin.chart.echarts.base.NewChart;
import com.fr.solution.plugin.chart.echarts.core.map.ChineseMapPlot;

/**
 * Created by richie on 16/1/29.
 */
public class ChineseMap extends AbstractIndependentEChartsProvider {

    private static NewChart createChineseMap() {
        ChineseMapPlot plot = new ChineseMapPlot();
        return new NewChart(plot);
    }

    public static NewChart[] charts = new NewChart[] {
            createChineseMap()
    };


    @Override
    public String getChartName() {
        return "Plugin-ECharts_Chinese_Map";
    }

    @Override
    public String getChartUseName() {
        return Inter.getLocText("Plugin-ECharts_Chinese_Map");
    }

    @Override
    public Chart[] getChartTypes() {
        return charts;
    }

    @Override
    public String getChartImagePath() {
        return "com/fr/solution/plugin/chart/echarts/images/map/map256.png";
    }

    @Override
    public String getWrapperName() {
        return "EChartsFactory";
    }

}
