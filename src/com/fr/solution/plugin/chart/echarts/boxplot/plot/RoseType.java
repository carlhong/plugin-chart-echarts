package com.fr.solution.plugin.chart.echarts.boxplot.plot;

import com.fr.general.ComparatorUtils;

public enum RoseType {

    NONE("none"), AREA("area"), RADIUS("radius");

    private String type;

    RoseType(String type) {
        this.type = type;
    }

    public String toTypeString() {
        return type;
    }

    private static RoseType[] positions;

    /**
     * 将字符串转换成枚举类型
     * @param p 待转换的整数
     * @return 枚举
     */
    public static RoseType parse(String p) {
        if (positions == null) {
            positions = RoseType.values();
        }
        for (RoseType ip : positions) {
            if (ComparatorUtils.equals(p, ip.type)) {
                return ip;
            }
        }
        return NONE;
    }
}
