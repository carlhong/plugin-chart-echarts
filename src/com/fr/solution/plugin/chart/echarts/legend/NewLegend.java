package com.fr.solution.plugin.chart.echarts.legend;

import com.fr.chart.chartattr.Legend;
import com.fr.solution.plugin.chart.echarts.glyph.NewLegendGlyph;

/**
 * Created by richie on 16/2/18.
 */
public class NewLegend extends Legend {

    public static final String XML_TAG = "NewLegend";

    public NewLegendGlyph createLegendGlyph() {
        NewLegendGlyph resultLegendGlyph = new NewLegendGlyph();

        resultLegendGlyph.setFont(getFRFont());
        resultLegendGlyph.setGeneralInfo(this);
        resultLegendGlyph.setPosition(getPosition());
        resultLegendGlyph.setVisible(isLegendVisible());

        return resultLegendGlyph;
    }

}
