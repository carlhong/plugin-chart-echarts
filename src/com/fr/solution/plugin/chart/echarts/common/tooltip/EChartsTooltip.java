package com.fr.solution.plugin.chart.echarts.common.tooltip;

import com.fr.general.ComparatorUtils;
import com.fr.json.JSONException;
import com.fr.json.JSONObject;
import com.fr.stable.StringUtils;
import com.fr.stable.web.Repository;
import com.fr.stable.xml.XMLPrintWriter;
import com.fr.stable.xml.XMLable;
import com.fr.stable.xml.XMLableReader;

import java.awt.*;

/**
 * Created by richie on 16/2/22.
 */
public class EChartsTooltip implements XMLable {

    public static final String XML_TAG = "Tooltip";

    private TriggerType triggerType;
    private String format;
    private AxisPointerType axisPointerType;
    private String borderWidth;
    private Color borderColor;
    private Color bgColor;
    private float alpha;

    public EChartsTooltip() {}

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

    public AxisPointerType getAxisPointerType() {
        return axisPointerType;
    }

    public void setAxisPointerType(AxisPointerType axisPointerType) {
        this.axisPointerType = axisPointerType;
    }


    public String getBorderWidth() {
        return borderWidth;
    }

    public void setBorderWidth(String borderWidth) {
        this.borderWidth = borderWidth;
    }

    public String color2String(Color borderColor) {
        return String.format("#%02x%02x%02x",
                borderColor.getRed(),
                borderColor.getGreen(),
                borderColor.getBlue());
    }

    public String getEChartsBorderColor() {
        return color2String(borderColor);
    }

    public Color getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
    }

    public Color getBgColor() {
        return bgColor;
    }

    public void setBgColor(Color bgColor) {
        this.bgColor = bgColor;
    }

    public Float getAlpha() {
        return alpha;
    }

    public void setAlpha(Float alpha) {
        this.alpha = alpha;
    }

    public String getEChartsBgColor() {
        return String.format("rgba(%d, %d, %d, %f)",
                bgColor.getRed(),
                bgColor.getGreen(),
                bgColor.getBlue(),
                getAlpha());
    }

    public JSONObject toJSONObject(Repository repo) throws JSONException {
        JSONObject jo = JSONObject.create();
        jo.put("trigger", triggerType.getType());
        jo.put("formatter", format);
        jo.put("axisPointer",
            JSONObject.create().put("type",
                axisPointerType.getType()));
        jo.put("borderWidth", getBorderWidth());
        jo.put("borderColor", getEChartsBorderColor());
        jo.put("backgroundColor", getEChartsBgColor());
        return jo;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof EChartsTooltip
                && ComparatorUtils.equals(triggerType, ((EChartsTooltip) obj).triggerType)
                && ComparatorUtils.equals(format, ((EChartsTooltip) obj).format)
                && ComparatorUtils.equals(axisPointerType, ((EChartsTooltip) obj).axisPointerType)
                && ComparatorUtils.equals(borderWidth, ((EChartsTooltip) obj).borderWidth)
                && ComparatorUtils.equals(borderColor, ((EChartsTooltip) obj).borderColor)
                && ComparatorUtils.equals(bgColor, ((EChartsTooltip) obj).bgColor);
    }

    @Override
    public void readXML(XMLableReader reader) {
        if (reader.isChildNode()) {
            String tagName = reader.getTagName();
            if (tagName.equals("Attr")) {
                triggerType = TriggerType.parse(reader.getAttrAsString("trigger", ""));
                format = reader.getAttrAsString("format", "");
                axisPointerType = AxisPointerType.parse(reader.getAttrAsString("axisPointer", ""));
                borderWidth = reader.getAttrAsString("borderWidth", "");
                borderColor = reader.getAttrAsColor("borderColor", Color.gray);
                bgColor = reader.getAttrAsColor("bgColor", Color.gray);
                alpha = reader.getAttrAsFloat("bgTransparent", 1);
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
        if (axisPointerType != null) {
            writer.attr("axisPointer", axisPointerType.getType());
        }
        if (StringUtils.isNotEmpty(borderWidth)) {
            writer.attr("borderWidth", borderWidth);
        }
        if (borderColor != null) {
            writer.attr("borderColor", borderColor.getRGB());
        }
        if (bgColor != null) {
            writer.attr("bgColor", bgColor.getRGB());
        }
        writer.attr("bgTransparent", alpha);
        writer.end();
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
