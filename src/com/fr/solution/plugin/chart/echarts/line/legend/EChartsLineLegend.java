package com.fr.solution.plugin.chart.echarts.line.legend;

import com.fr.chart.chartglyph.LegendItem;
import com.fr.solution.plugin.chart.echarts.line.glyph.EChartsLineLegendGlyph;
import com.fr.solution.plugin.chart.echarts.common.legend.EChartsLegend;

/**
 * Created by hongtao on 2017/5/4.
 */
public class EChartsLineLegend extends EChartsLegend{

    public EChartsLineLegendGlyph createLegendGlyph(LegendItem[] items) {
        EChartsLineLegendGlyph resultLegendGlyph = new EChartsLineLegendGlyph(items);

        resultLegendGlyph.setFont(getFRFont());
        resultLegendGlyph.setGeneralInfo(this);
        resultLegendGlyph.setPosition(getPosition());
        resultLegendGlyph.setVisible(isLegendVisible());

        return resultLegendGlyph;
    }
}
