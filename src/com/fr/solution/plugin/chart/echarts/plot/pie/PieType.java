package com.fr.solution.plugin.chart.echarts.plot.pie;

import com.fr.general.ComparatorUtils;

/**
 * Created by richie on 16/2/18.
 */
public enum PieType {

    REGULAR("regular"), CIRCLE("circle");

    private String type;

    PieType(String type) {
        this.type = type;
    }

    public String toTypeString() {
        return type;
    }

    private static PieType[] positions;

    /**
     * 将字符串转换成枚举类型
     * @param p 待转换的整数
     * @return 枚举
     */
    public static PieType parse(String p) {
        if (positions == null) {
            positions = PieType.values();
        }
        for (PieType ip : positions) {
            if (ComparatorUtils.equals(p, ip.type)) {
                return ip;
            }
        }
        return REGULAR;
    }
}
