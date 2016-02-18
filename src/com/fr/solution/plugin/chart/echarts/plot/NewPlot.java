package com.fr.solution.plugin.chart.echarts.plot;

import com.fr.chart.chartattr.Legend;
import com.fr.chart.chartattr.Plot;
import com.fr.chart.chartglyph.PlotGlyph;
import com.fr.general.ComparatorUtils;
import com.fr.solution.plugin.chart.echarts.glyph.NewLegendGlyph;
import com.fr.solution.plugin.chart.echarts.legend.NewLegend;
import com.fr.stable.xml.XMLableReader;

/**
 * Created by richie on 16/2/2.
 */
public abstract class NewPlot extends Plot {

    public NewPlot() {
        setLegend(new NewLegend());
    }

    public boolean accept(Class<? extends Plot> obClass) {
        return ComparatorUtils.equals(NewPlot.class, obClass);
    }

    @Override
    public NewLegendGlyph createLegendGlyph(PlotGlyph plotGlyph) {
        NewLegend legend = (NewLegend) getLegend();
        return legend.createLegendGlyph();
    }

    protected void readPlotXML(XMLableReader reader){
        if (reader.isChildNode()) {
            String tagName = reader.getTagName();

            if (NewLegend.XML_TAG.equals(tagName)) {
                setLegend((Legend)reader.readXMLObject(new NewLegend()));
            }
        }
    }
}