package com.fr.solution.plugin.chart.echarts.core.map;

import com.fr.chart.chartglyph.PlotGlyph;

/**
 * Created by richie on 16/1/29.
 */
public class ChineseMapPlotGlyph extends PlotGlyph {
    @Override
    public void layoutAxisGlyph(int resolution) {

    }

    @Override
    public void layoutDataSeriesGlyph(int resolution) {

    }

    @Override
    public String getPlotGlyphType() {
        return "ChineseMapPlotGlyph";
    }

    @Override
    public String getChartType() {
        return "ChineseMap";
    }
}
