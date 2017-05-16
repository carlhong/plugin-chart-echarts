package com.fr.solution.plugin.chart.echarts.gauge.monitor;

import com.fr.general.Inter;
import com.fr.stable.fun.FunctionHelper;
import com.fr.stable.fun.FunctionProcessor;
import com.fr.stable.fun.impl.AbstractFunctionProcessor;

public class MonitorHelper {

    public static FunctionProcessor BAR = new AbstractFunctionProcessor() {
        @Override
        public int getId() {
            return FunctionHelper.generateFunctionID("com.fr.solution.plugin.chart.echarts.gauge");
        }

        @Override
        public String getLocaleKey() {
            return "Plugin-ECharts_Gauge";
        }

        @Override
        public String toString() {
            return Inter.getLocText("Plugin-ECharts_Gauge");
        }
    };
}
