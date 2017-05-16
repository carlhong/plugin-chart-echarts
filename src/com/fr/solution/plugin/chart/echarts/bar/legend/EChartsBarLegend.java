package com.fr.solution.plugin.chart.echarts.bar.legend;

import com.fr.chart.chartglyph.LegendItem;
import com.fr.solution.plugin.chart.echarts.bar.glyph.EChartsBarLegendGlyph;
import com.fr.solution.plugin.chart.echarts.common.legend.EChartsLegend;

/**
 * Created by hongtao on 2017/5/4.
 */
public class EChartsBarLegend extends EChartsLegend{

    public EChartsBarLegendGlyph createLegendGlyph(LegendItem[] items) {
        EChartsBarLegendGlyph resultLegendGlyph = new EChartsBarLegendGlyph(items);

        resultLegendGlyph.setFont(getFRFont());
        resultLegendGlyph.setGeneralInfo(this);
        resultLegendGlyph.setPosition(getPosition());
        resultLegendGlyph.setVisible(isLegendVisible());

        return resultLegendGlyph;
    }
}
