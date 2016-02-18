package com.fr.solution.plugin.chart.echarts.title;

import com.fr.chart.chartattr.Title;
import com.fr.solution.plugin.chart.echarts.glyph.EChartsTitleGlyph;

/**
 * Created by richie on 16/2/18.
 */
public class EChartsTitle extends Title {
    public static final String XML_TAG = "EChartsTitle";

    @Override
    public EChartsTitleGlyph createGlyph() {
        return new EChartsTitleGlyph();
    }
}
