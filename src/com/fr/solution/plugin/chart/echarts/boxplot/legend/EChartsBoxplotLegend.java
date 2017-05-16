package com.fr.solution.plugin.chart.echarts.boxplot.legend;

import com.fr.chart.chartglyph.LegendItem;
import com.fr.solution.plugin.chart.echarts.boxplot.glyph.EChartsBoxplotLegendGlyph;
import com.fr.solution.plugin.chart.echarts.common.legend.EChartsLegend;

/**
 * Created by hongtao on 2017/5/4.
 */
public class EChartsBoxplotLegend extends EChartsLegend{

    public EChartsBoxplotLegendGlyph createLegendGlyph(LegendItem[] items) {
        EChartsBoxplotLegendGlyph resultLegendGlyph = new EChartsBoxplotLegendGlyph(items);

        resultLegendGlyph.setFont(getFRFont());
        resultLegendGlyph.setGeneralInfo(this);
        resultLegendGlyph.setPosition(getPosition());
        resultLegendGlyph.setVisible(isLegendVisible());

        return resultLegendGlyph;
    }
}
