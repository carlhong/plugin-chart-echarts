package com.fr.solution.plugin.chart.echarts.base;

import com.fr.base.chart.BaseChartGlyph;
import com.fr.base.chart.chartdata.ChartData;
import com.fr.chart.chartattr.Chart;
import com.fr.chart.chartattr.Plot;

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
}
