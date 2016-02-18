package com.fr.solution.plugin.chart.echarts.title;

import com.fr.chart.chartattr.Title;
import com.fr.solution.plugin.chart.echarts.glyph.NewTitleGlyph;

/**
 * Created by richie on 16/2/18.
 */
public class NewTitle extends Title {
    public static final String XML_TAG = "NewTitle";

    @Override
    public NewTitleGlyph createGlyph() {
        return new NewTitleGlyph();
    }
}
