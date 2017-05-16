package com.fr.solution.plugin.chart.echarts.common.toolbox;

import com.fr.general.ComparatorUtils;
import com.fr.json.JSONArray;
import com.fr.json.JSONException;
import com.fr.json.JSONObject;
import com.fr.stable.web.Repository;
import com.fr.stable.xml.XMLPrintWriter;
import com.fr.stable.xml.XMLable;
import com.fr.stable.xml.XMLableReader;

import java.awt.*;

public class EChartsToolbox implements XMLable {

    public static final String XML_TAG = "Toolbox";

    private Boolean brushVisible = false;

    private Boolean isRectSelected = false;

    private Boolean isPolygonSelected = false;

    private Boolean isKeepSelected = false;

    private Boolean isLineXSelected = false;

    private Boolean isLineYSelected = false;

    private Boolean isClearSelected = false;

    private Boolean dataViewVisible = false;

    private Color bgColor;

    private Color textareaColor;

    private Color textareaBorderColor;

    private Color textColor;

    private Color buttonColor;

    private Color buttonTextColor;

    private Boolean dataZoomVisible = false;

    private Boolean magicTypeVisible = false;

    private Boolean isBarSelected = false;

    private Boolean isLineSelected = false;

    private Boolean isStackSelected = false;

    private Boolean isTiledSelected = false;

    private Boolean restoreVisible = false;

    private Boolean saveAsImageVisible = false;

    private String imageFormat;

    public EChartsToolbox() {}

    public boolean isBrushVisible() {
        return brushVisible;
    }

    public void setBrushVisible(boolean brushVisible) {
        this.brushVisible = brushVisible;
    }

    public boolean isRectSelected() {
        return isRectSelected;
    }

    public void setRectSelected(boolean isRectSelected) {
        this.isRectSelected = isRectSelected;
    }

    public boolean isPolygonSelected() {
        return isPolygonSelected;
    }

    public void setPolygonSelected(boolean isPolygonSelected) {
        this.isPolygonSelected = isPolygonSelected;
    }

    public boolean isKeepSelected() {
        return isKeepSelected;
    }

    public void setKeepSelected(boolean isKeepSelected) {
        this.isKeepSelected = isKeepSelected;
    }

    public boolean isLineXSelected() {
        return isLineXSelected;
    }

    public void setLineXSelected(boolean isLineXSelected) {
        this.isLineXSelected = isLineXSelected;
    }

    public boolean isLineYSelected() {
        return isLineYSelected;
    }

    public void setLineYSelected(boolean isLineYSelected) {
        this.isLineYSelected = isLineYSelected;
    }

    public boolean isClearSelected() {
        return isClearSelected;
    }

    public void setClearSelected(boolean isClearSelected) {
        this.isClearSelected = isClearSelected;
    }

    public boolean isDataViewVisible() {
        return dataViewVisible;
    }

    public void setDataViewVisible(boolean dataViewVisible) {
        this.dataViewVisible = dataViewVisible;
    }

    public boolean isDataZoomVisible() {
        return dataZoomVisible;
    }

    public String color2String(Color borderColor) {
        return String.format("#%02x%02x%02x",
                borderColor.getRed(),
                borderColor.getGreen(),
                borderColor.getBlue());
    }

    public Color getBgColor() {
        return bgColor;
    }

    public void setBgColor(Color bgColor) {
        this.bgColor = bgColor;
    }

    public Color getTextareaColor() {
        return textareaColor;
    }

    public void setTextareaColor(Color textareaColor) {
        this.textareaColor = textareaColor;
    }

    public Color getTextareaBorderColor() {
        return textareaBorderColor;
    }

    public void setTextareaBorderColor(Color textareaBorderColor) {
        this.textareaBorderColor = textareaBorderColor;
    }

    public Color getTextColor() {
        return textColor;
    }

    public void setTextColor(Color textColor) {
        this.textColor = textColor;
    }

    public Color getButtonColor() {
        return buttonColor;
    }

    public void setButtonColor(Color buttonColor) {
        this.buttonColor = buttonColor;
    }

    public Color getButtonTextColor() {
        return buttonTextColor;
    }

    public void setButtonTextColor(Color buttonTextColor) {
        this.buttonTextColor = buttonTextColor;
    }

    public void setDataZoomVisible(boolean dataZoomVisible) {
        this.dataZoomVisible = dataZoomVisible;
    }

    public boolean isMagicTypeVisible() {
        return magicTypeVisible;
    }

    public void setMagicTypeVisible(boolean magicTypeVisible) {
        this.magicTypeVisible = magicTypeVisible;
    }

    public boolean isBarSelected() {
        return isBarSelected;
    }

    public void setBarSelected(boolean isBarSelected) {
        this.isBarSelected = isBarSelected;
    }

    public boolean isLineSelected() {
        return isLineSelected;
    }

    public void setLineSelected(boolean isLineSelected) {
        this.isLineSelected = isLineSelected;
    }

    public boolean isStackSelected() {
        return isStackSelected;
    }

    public void setStackSelected(boolean isStackSelected) {
        this.isStackSelected = isStackSelected;
    }

    public boolean isTiledSelected() {
        return isTiledSelected;
    }

    public void setTiledSelected(boolean isTiledSelected) {
        this.isTiledSelected = isTiledSelected;
    }

    public boolean isRestoreVisible() {
        return restoreVisible;
    }

    public void setRestoreVisible(boolean restoreVisible) {
        this.restoreVisible = restoreVisible;
    }

    public boolean isSaveAsImageVisible() {
        return saveAsImageVisible;
    }

    public void setSaveAsImageVisible(boolean saveAsImageVisible) {
        this.saveAsImageVisible = saveAsImageVisible;
    }

    public String getImageFormat() {
        return imageFormat;
    }

    public void setImageFormat(String imageFormat) {
        this.imageFormat = imageFormat;
    }


    public JSONObject toJSONObject(Repository repo) throws JSONException {
        JSONObject jo = JSONObject.create();
        JSONObject wrapper = JSONObject.create();
        jo.put("feature", wrapper);
        if (brushVisible) {
            JSONObject brushTypeWrapper = JSONObject.create();
            wrapper.put("brush", brushTypeWrapper);
            JSONArray brushType = JSONArray.create();
            brushTypeWrapper.put("type", brushType);
            if (isRectSelected) {
                brushType.put("rect");
            }
            if (isPolygonSelected) {
                brushType.put("polygon");
            }
            if (isKeepSelected) {
                brushType.put("keep");
            }
            if (isLineXSelected) {
                brushType.put("lineX");
            }
            if (isLineYSelected) {
                brushType.put("lineY");
            }
            if (isClearSelected) {
                brushType.put("clear");
            }
        }
        if (dataViewVisible) {
            JSONObject dataViewWrapper = JSONObject.create();
            wrapper.put("dataView", dataViewWrapper);
            dataViewWrapper.put("backgroundColor", color2String(getBgColor()));
            dataViewWrapper.put("textareaColor", color2String(getTextareaColor()));
            dataViewWrapper.put("textareaBorderColor", color2String(getTextareaBorderColor()));
            dataViewWrapper.put("textColor", color2String(getTextColor()));
            dataViewWrapper.put("buttonColor", color2String(getButtonColor()));
            dataViewWrapper.put("buttonTextColor", color2String(getButtonTextColor()));

        }
        if (dataZoomVisible) {
            wrapper.put("dataZoom", JSONObject.create());
        }
        if (magicTypeVisible) {
            JSONObject magicTypeWrapper = JSONObject.create();
            wrapper.put("magicType", magicTypeWrapper);
            JSONArray magicType = JSONArray.create();
            magicTypeWrapper.put("type", magicType);
            if (isBarSelected) {
                magicType.put("bar");
            }
            if (isLineSelected) {
                magicType.put("line");
            }
            if (isStackSelected) {
                magicType.put("stack");
            }
            if (isTiledSelected) {
                magicType.put("tiled");
            }
        }
        if (restoreVisible) {
            wrapper.put("restore", JSONObject.create());
        }
        if (saveAsImageVisible) {
            JSONObject imageFormatWrapper = JSONObject.create();
            wrapper.put("saveAsImage", imageFormatWrapper);
            imageFormatWrapper.put("type", imageFormat);
        }
        return jo;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof EChartsToolbox
                && ComparatorUtils.equals(brushVisible, ((EChartsToolbox) obj).brushVisible)
                && ComparatorUtils.equals(isRectSelected, ((EChartsToolbox) obj).isRectSelected)
                && ComparatorUtils.equals(isPolygonSelected, ((EChartsToolbox) obj).isPolygonSelected)
                && ComparatorUtils.equals(isKeepSelected, ((EChartsToolbox) obj).isKeepSelected)
                && ComparatorUtils.equals(isLineXSelected, ((EChartsToolbox) obj).isLineXSelected)
                && ComparatorUtils.equals(isLineYSelected, ((EChartsToolbox) obj).isLineYSelected)
                && ComparatorUtils.equals(isClearSelected, ((EChartsToolbox) obj).isClearSelected)
                && ComparatorUtils.equals(dataViewVisible, ((EChartsToolbox) obj).dataViewVisible)
                && ComparatorUtils.equals(bgColor, ((EChartsToolbox) obj).bgColor)
                && ComparatorUtils.equals(textareaColor, ((EChartsToolbox) obj).textareaColor)
                && ComparatorUtils.equals(textareaBorderColor, ((EChartsToolbox) obj).textareaBorderColor)
                && ComparatorUtils.equals(textColor, ((EChartsToolbox) obj).textColor)
                && ComparatorUtils.equals(buttonColor, ((EChartsToolbox) obj).buttonColor)
                && ComparatorUtils.equals(buttonTextColor, ((EChartsToolbox) obj).buttonTextColor)
                && ComparatorUtils.equals(dataZoomVisible, ((EChartsToolbox) obj).dataZoomVisible)
                && ComparatorUtils.equals(magicTypeVisible, ((EChartsToolbox) obj).magicTypeVisible)
                && ComparatorUtils.equals(isBarSelected, ((EChartsToolbox) obj).isBarSelected)
                && ComparatorUtils.equals(isLineSelected, ((EChartsToolbox) obj).isLineSelected)
                && ComparatorUtils.equals(isStackSelected, ((EChartsToolbox) obj).isStackSelected)
                && ComparatorUtils.equals(isTiledSelected, ((EChartsToolbox) obj).isTiledSelected)
                && ComparatorUtils.equals(restoreVisible, ((EChartsToolbox) obj).restoreVisible)
                && ComparatorUtils.equals(saveAsImageVisible, ((EChartsToolbox) obj).saveAsImageVisible)
                && ComparatorUtils.equals(imageFormat, ((EChartsToolbox) obj).imageFormat);
    }

    @Override
    public void readXML(XMLableReader reader) {
        if (reader.isChildNode()) {
            String tagName = reader.getTagName();
            if (tagName.equals("ToolboxAttr")) {
                brushVisible = reader.getAttrAsBoolean("brushVisible", false);
                isRectSelected = reader.getAttrAsBoolean("isRectSelected", false);
                isPolygonSelected = reader.getAttrAsBoolean("isPolygonSelected", false);
                isKeepSelected = reader.getAttrAsBoolean("isKeepSelected", false);
                isLineXSelected = reader.getAttrAsBoolean("isLineXSelected", false);
                isLineYSelected = reader.getAttrAsBoolean("isLineYSelected", false);
                isClearSelected = reader.getAttrAsBoolean("isClearSelected", false);
                dataViewVisible = reader.getAttrAsBoolean("dataViewVisible", false);
                bgColor = reader.getAttrAsColor("bgColor", Color.white);
                textareaColor = reader.getAttrAsColor("textareaColor", Color.white);
                textareaBorderColor = reader.getAttrAsColor("textareaBorderColor", Color.black);
                textColor = reader.getAttrAsColor("textColor", Color.black);
                buttonColor = reader.getAttrAsColor("buttonColor", Color.red);
                buttonTextColor = reader.getAttrAsColor("buttonTextColor", Color.white);
                dataZoomVisible = reader.getAttrAsBoolean("dataZoomVisible", false);
                magicTypeVisible = reader.getAttrAsBoolean("magicTypeVisible", false);
                isBarSelected = reader.getAttrAsBoolean("isBarSelected", false);
                isLineSelected = reader.getAttrAsBoolean("isLineSelected", false);
                isStackSelected = reader.getAttrAsBoolean("isStackSelected", false);
                isTiledSelected = reader.getAttrAsBoolean("isTiledSelected", false);
                restoreVisible = reader.getAttrAsBoolean("restoreVisible", false);
                saveAsImageVisible = reader.getAttrAsBoolean("saveAsImageVisible", false);
                imageFormat = reader.getAttrAsString("imageFormat", "png");
            }
        }
    }

    @Override
    public void writeXML(XMLPrintWriter writer) {
        writer.startTAG("ToolboxAttr");
        writer.attr("brushVisible", String.valueOf(brushVisible));
        writer.attr("isRectSelected", String.valueOf(isRectSelected));
        writer.attr("isPolygonSelected", String.valueOf(isPolygonSelected));
        writer.attr("isKeepSelected", String.valueOf(isKeepSelected));
        writer.attr("isLineXSelected", String.valueOf(isLineXSelected));
        writer.attr("isLineYSelected", String.valueOf(isLineYSelected));
        writer.attr("isClearSelected", String.valueOf(isClearSelected));
        writer.attr("dataViewVisible", String.valueOf(dataViewVisible));
        if (bgColor != null) {
            writer.attr("bgColor", bgColor.getRGB());
        }
        if (bgColor != null) {
            writer.attr("textareaColor", textareaColor.getRGB());
        }
        if (bgColor != null) {
            writer.attr("textareaBorderColor", textareaBorderColor.getRGB());
        }
        if (bgColor != null) {
            writer.attr("textColor", textColor.getRGB());
        }
        if (bgColor != null) {
            writer.attr("buttonColor", buttonColor.getRGB());
        }
        if (bgColor != null) {
            writer.attr("buttonTextColor", buttonTextColor.getRGB());
        }
        writer.attr("dataZoomVisible", String.valueOf(dataZoomVisible));
        writer.attr("magicTypeVisible", String.valueOf(magicTypeVisible));
        writer.attr("isBarSelected", String.valueOf(isBarSelected));
        writer.attr("isLineSelected", String.valueOf(isLineSelected));
        writer.attr("isStackSelected", String.valueOf(isStackSelected));
        writer.attr("isTiledSelected", String.valueOf(isTiledSelected));
        writer.attr("restoreVisible", String.valueOf(restoreVisible));
        writer.attr("saveAsImageVisible", String.valueOf(saveAsImageVisible));
        writer.attr("imageFormat", imageFormat);
        writer.end();
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
