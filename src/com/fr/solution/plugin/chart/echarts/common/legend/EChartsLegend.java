package com.fr.solution.plugin.chart.echarts.common.legend;

import com.fr.chart.chartattr.Legend;
import com.fr.chart.chartglyph.LegendItem;
import com.fr.solution.plugin.chart.echarts.common.glyph.EChartsLegendGlyph;

/**
 * Created by richie on 16/2/18.
 */
public class EChartsLegend extends Legend {

    public static final String XML_TAG = "EChartsLegend";

    public EChartsLegendGlyph createLegendGlyph(LegendItem[] items) {
        EChartsLegendGlyph resultLegendGlyph = new EChartsLegendGlyph(items);

        resultLegendGlyph.setFont(getFRFont());
        resultLegendGlyph.setGeneralInfo(this);
        resultLegendGlyph.setPosition(getPosition());
        resultLegendGlyph.setVisible(isLegendVisible());

        return resultLegendGlyph;
    }
}
