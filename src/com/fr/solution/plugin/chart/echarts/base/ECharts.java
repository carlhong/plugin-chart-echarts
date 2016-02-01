package com.fr.solution.plugin.chart.echarts.base;

import com.fr.base.chart.BaseChartGlyph;
import com.fr.base.chart.chartdata.ChartData;
import com.fr.chart.chartattr.Chart;
import com.fr.chart.chartattr.Plot;
import com.fr.general.ComparatorUtils;

/**
 * Created by richie on 16/1/29.
 */
public class ECharts extends Chart {

    public ECharts() {
        setWrapperName("EChartsFactory");
    }

    public ECharts(Plot plot) {
        setPlot(plot);
        setWrapperName("EChartsFactory");
    }

    @Override
    public BaseChartGlyph createGlyph(ChartData chartData) {
        return super.createGlyph(chartData);
    }

    /**
     * 判断图表类型是否是obClass
     * @param obClass 传入对象
     * @return 是否是obClass对象
     */
    public boolean accept(Class<? extends Chart> obClass){
        return ComparatorUtils.equals(ECharts.class, obClass);
    }
}
