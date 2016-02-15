package com.fr.solution.plugin.chart.echarts.base;

import com.fr.base.chart.chartdata.ChartData;
import com.fr.chart.chartattr.Plot;
import com.fr.general.ComparatorUtils;

/**
 * Created by richie on 16/2/2.
 */
public abstract class NewPlot extends Plot {

    public boolean accept(Class<? extends Plot> obClass) {
        return ComparatorUtils.equals(NewPlot.class, obClass);
    }

    public NewTitleGlyph createChartTitleGlyph(ChartData chartData) {
        return null;
    }

    public NewLegendGlyph createChartLegendGlyph(ChartData chartData) {
        return new NewLegendGlyph();
    }
}
