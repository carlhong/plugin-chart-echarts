package com.fr.solution.plugin.chart.echarts.gauge.legend;

import com.fr.chart.chartglyph.LegendItem;
import com.fr.solution.plugin.chart.echarts.gauge.glyph.EChartsGaugeLegendGlyph;
import com.fr.solution.plugin.chart.echarts.common.legend.EChartsLegend;

/**
 * Created by hongtao on 2017/5/4.
 */
public class EChartsGaugeLegend extends EChartsLegend{

    public EChartsGaugeLegendGlyph createLegendGlyph(LegendItem[] items) {
        EChartsGaugeLegendGlyph resultLegendGlyph = new EChartsGaugeLegendGlyph(items);

        resultLegendGlyph.setFont(getFRFont());
        resultLegendGlyph.setGeneralInfo(this);
        resultLegendGlyph.setPosition(getPosition());
        resultLegendGlyph.setVisible(isLegendVisible());

        return resultLegendGlyph;
    }
}
