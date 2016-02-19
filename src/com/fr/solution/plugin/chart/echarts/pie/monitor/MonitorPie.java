package com.fr.solution.plugin.chart.echarts.pie.monitor;

import com.fr.general.Inter;
import com.fr.stable.fun.FunctionHelper;
import com.fr.stable.fun.impl.AbstractFunctionProcessor;

/**
 * Created by richie on 16/2/18.
 */
public class MonitorPie extends AbstractFunctionProcessor {

    private static MonitorPie instance = new MonitorPie();

    public static MonitorPie getInstance() {
        return instance;
    }

    @Override
    public int getId() {
        return FunctionHelper.generateFunctionID("com.fr.solution.plugin.chart.echarts");
    }

    @Override
    public String toString() {
        return Inter.getLocText("Plugin-ECharts_Pie");
    }
}
