package com.fr.solution.plugin.chart.echarts.core.map;

import com.fr.base.chart.chartdata.ChartData;
import com.fr.chart.chartattr.Plot;
import com.fr.chart.chartdata.NormalChartData;
import com.fr.chart.chartglyph.LegendGlyph;
import com.fr.chart.chartglyph.PlotGlyph;
import com.fr.general.ComparatorUtils;
import com.fr.general.Inter;
import com.fr.solution.plugin.chart.echarts.base.NewPlot;
import com.fr.stable.fun.FunctionProcessor;

/**
 * Created by richie on 16/1/29.
 */
public class ChineseMapPlot extends NewPlot {

    @Override
    public PlotGlyph createPlotGlyph(ChartData chartData) {
        PlotGlyph glyph = new ChineseMapPlotGlyph();
        install4PlotGlyph(glyph, chartData);
        return glyph;
    }

    @Override
    public String getPlotID() {
        return "EChartsChinaMapPlot";
    }

    @Override
    public boolean matchPlotType(Plot newPlot) {
        return newPlot instanceof ChineseMapPlot;
    }

    @Override
    public ChartData defaultChartData() {
        return new NormalChartData();
    }

    @Override
    public FunctionProcessor getFunctionToRecord() {
        return ChineseMapFunctionProcessor.MAP;
    }

    public boolean accept(Class<? extends Plot> obClass) {
        return ComparatorUtils.equals(ChineseMapPlot.class, obClass);
    }

    @Override
    public String getPlotName() {
        return Inter.getLocText("Plugin-ECharts_Chinese_Map");
    }

}