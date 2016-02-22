package com.fr.solution.plugin.chart.echarts.common.theme;

import com.fr.general.ComparatorUtils;
import com.fr.stable.xml.XMLPrintWriter;
import com.fr.stable.xml.XMLable;
import com.fr.stable.xml.XMLableReader;

/**
 * Created by richie on 16/2/22.
 */
public class EChartsTheme implements XMLable {

    public static final String XML_TAG = "Theme";

    private String name;

    public EChartsTheme() {
        this("default");
    }

    public EChartsTheme(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof EChartsTheme
                && ComparatorUtils.equals(name, ((EChartsTheme) obj).name);
    }

    @Override
    public void readXML(XMLableReader reader) {
        if (reader.isChildNode()) {
            String tagName = reader.getTagName();
            if (tagName.equals("ThemeAttr")) {
                name = reader.getAttrAsString("name", "default");
            }
        }
    }

    @Override
    public void writeXML(XMLPrintWriter writer) {
        writer.startTAG("ThemeAttr");
        writer.attr("name", name);
        writer.end();
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
