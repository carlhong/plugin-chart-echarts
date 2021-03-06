package com.fr.solution.plugin.chart.echarts.common.plot;

import com.fr.chart.chartattr.Legend;
import com.fr.chart.chartattr.Plot;
import com.fr.chart.chartglyph.PlotGlyph;
import com.fr.general.ComparatorUtils;
import com.fr.solution.plugin.chart.echarts.common.glyph.EChartsLegendGlyph;
import com.fr.solution.plugin.chart.echarts.common.legend.EChartsLegend;
import com.fr.stable.xml.XMLableReader;

/**
 * Created by richie on 16/2/2.
 */
public abstract class EChartsPlot extends Plot {

    public EChartsPlot() {
        setLegend(new EChartsLegend());
    }

    public boolean accept(Class<? extends Plot> obClass) {
        return ComparatorUtils.equals(EChartsPlot.class, obClass);
    }

    @Override
    public EChartsLegendGlyph createLegendGlyph(PlotGlyph plotGlyph) {
        EChartsLegend legend = (EChartsLegend) getLegend();
        if (legend == null) {
            legend = new EChartsLegend();
            setLegend(legend);
        }
        return legend.createLegendGlyph(createLegendItems(plotGlyph));
    }

    protected void readPlotXML(XMLableReader reader){
        if (reader.isChildNode()) {
            String tagName = reader.getTagName();

            if (EChartsLegend.XML_TAG.equals(tagName)) {
                setLegend((Legend)reader.readXMLObject(new EChartsLegend()));
            }
        }
    }
}