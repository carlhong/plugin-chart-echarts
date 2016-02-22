package com.fr.solution.plugin.chart.echarts.common.tooltip;

import com.fr.general.ComparatorUtils;
import com.fr.json.JSONException;
import com.fr.json.JSONObject;
import com.fr.stable.StringUtils;
import com.fr.stable.web.Repository;
import com.fr.stable.xml.XMLPrintWriter;
import com.fr.stable.xml.XMLable;
import com.fr.stable.xml.XMLableReader;

/**
 * Created by richie on 16/2/22.
 */
public class EChartsTooltip implements XMLable {

    public static final String XML_TAG = "Tooltip";

    private TriggerType triggerType;
    private String format;

    public EChartsTooltip() {

    }

    public TriggerType getTriggerType() {
        return triggerType;
    }

    public void setTriggerType(TriggerType triggerType) {
        this.triggerType = triggerType;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public JSONObject toJSONObject(Repository repo) throws JSONException {
        JSONObject jo = JSONObject.create();
        jo.put("trigger", triggerType.getType());
        jo.put("formatter", format);
        return jo;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof EChartsTooltip
                && ComparatorUtils.equals(triggerType, ((EChartsTooltip) obj).triggerType)
                && ComparatorUtils.equals(format, ((EChartsTooltip) obj).format);
    }

    @Override
    public void readXML(XMLableReader reader) {
        if (reader.isChildNode()) {
            String tagName = reader.getTagName();
            if (tagName.equals("Attr")) {
                triggerType = TriggerType.parse(reader.getAttrAsString("trigger", ""));
                format = reader.getAttrAsString("format", "");
            }
        }
    }

    @Override
    public void writeXML(XMLPrintWriter writer) {
        writer.startTAG("Attr");
        if (triggerType != null) {
            writer.attr("trigger", triggerType.getType());
        }
        if (StringUtils.isNotEmpty(format)) {
            writer.attr("format", format);
        }
        writer.end();
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
