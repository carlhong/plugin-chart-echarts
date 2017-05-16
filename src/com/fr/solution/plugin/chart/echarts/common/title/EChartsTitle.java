package com.fr.solution.plugin.chart.echarts.common.title;

import com.fr.base.Formula;
import com.fr.base.Utils;
import com.fr.chart.chartattr.Title;
import com.fr.general.GeneralUtils;
import com.fr.solution.plugin.chart.echarts.common.glyph.EChartsTitleGlyph;
import com.fr.stable.xml.XMLPrintWriter;
import com.fr.stable.xml.XMLableReader;

/**
 * Created by richie on 16/2/18.
 */
public class EChartsTitle extends Title {

    public static final String XML_TAG = "EChartsTitle";

    public EChartsTitle() {}

    @Override
    public EChartsTitleGlyph createGlyph() {
        Object text = getTextObject();
        String text4Glyph = null;
        if (text instanceof Formula) {
            Formula formula = (Formula)text;
            if (formula.getResult() != null) {
                text4Glyph = Utils.objectToString(formula.getResult());
            }
        } else {
            text4Glyph = GeneralUtils.objectToString(text);
        }
        EChartsTitleGlyph titleGlyph = new EChartsTitleGlyph(text4Glyph);
        titleGlyph.setVisible(isTitleVisible());
        return titleGlyph;
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
