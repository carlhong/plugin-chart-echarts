package com.fr.solution.plugin.chart.echarts.common.tooltip;

import com.fr.general.ComparatorUtils;

public enum AxisPointerType {

    LINE("line"), SHADOW("shadow"),CROSS("cross");

    private String type;

    AxisPointerType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public static AxisPointerType parse(String type) {
        for (AxisPointerType tt : values()) {
            if (ComparatorUtils.equals(type, tt.type)) {
                return tt;
            }
        }
        return LINE;
    }
}
