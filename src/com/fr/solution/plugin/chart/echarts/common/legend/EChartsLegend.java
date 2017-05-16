package com.fr.solution.plugin.chart.echarts.common.legend;

import com.fr.chart.chartattr.Legend;
import com.fr.chart.chartglyph.LegendItem;
import com.fr.solution.plugin.chart.echarts.common.glyph.EChartsLegendGlyph;
import com.fr.stable.xml.XMLPrintWriter;
import com.fr.stable.xml.XMLableReader;

/**
 * Created by richie on 16/2/18.
 */
public class EChartsLegend extends Legend {

    public static final String XML_TAG = "EChartsLegend";

    public EChartsLegend() {}

    public EChartsLegendGlyph createLegendGlyph(LegendItem[] items) {
        EChartsLegendGlyph resultLegendGlyph = new EChartsLegendGlyph(items);

        resultLegendGlyph.setFont(getFRFont());
        resultLegendGlyph.setGeneralInfo(this);
        resultLegendGlyph.setPosition(getPosition());
        resultLegendGlyph.setVisible(isLegendVisible());
        return resultLegendGlyph;
    }

    @Override
    public void readXML(XMLableReader reader) {
        super.readXML(reader);

        if (reader.isChildNode()) {
            String name = reader.getTagName();
            if ("Attr4ECharts".equals(name)) {

            }
        }
    }

    @Override
    public void writeXML(XMLPrintWriter writer) {
        writer.startTAG(XML_TAG);
        super.writeXML(writer);
        writer.startTAG("Attr4ECharts").end();
        writer.end();
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
