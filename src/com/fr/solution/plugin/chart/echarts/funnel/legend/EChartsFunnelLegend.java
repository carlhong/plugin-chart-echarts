package com.fr.solution.plugin.chart.echarts.funnel.legend;

import com.fr.chart.chartglyph.LegendItem;
import com.fr.solution.plugin.chart.echarts.funnel.glyph.EChartsFunnelLegendGlyph;
import com.fr.solution.plugin.chart.echarts.common.legend.EChartsLegend;

/**
 * Created by hongtao on 2017/5/4.
 */
public class EChartsFunnelLegend extends EChartsLegend{

    public EChartsFunnelLegendGlyph createLegendGlyph(LegendItem[] items) {
        EChartsFunnelLegendGlyph resultLegendGlyph = new EChartsFunnelLegendGlyph(items);

        resultLegendGlyph.setFont(getFRFont());
        resultLegendGlyph.setGeneralInfo(this);
        resultLegendGlyph.setPosition(getPosition());
        resultLegendGlyph.setVisible(isLegendVisible());

        return resultLegendGlyph;
    }
}
