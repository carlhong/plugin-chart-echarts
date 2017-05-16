package com.fr.solution.plugin.chart.echarts.scatter.legend;

import com.fr.chart.chartglyph.LegendItem;
import com.fr.solution.plugin.chart.echarts.scatter.glyph.EChartsScatterLegendGlyph;
import com.fr.solution.plugin.chart.echarts.common.legend.EChartsLegend;

/**
 * Created by hongtao on 2017/5/4.
 */
public class EChartsScatterLegend extends EChartsLegend{

    public EChartsScatterLegendGlyph createLegendGlyph(LegendItem[] items) {
        EChartsScatterLegendGlyph resultLegendGlyph = new EChartsScatterLegendGlyph(items);

        resultLegendGlyph.setFont(getFRFont());
        resultLegendGlyph.setGeneralInfo(this);
        resultLegendGlyph.setPosition(getPosition());
        resultLegendGlyph.setVisible(isLegendVisible());

        return resultLegendGlyph;
    }
}
