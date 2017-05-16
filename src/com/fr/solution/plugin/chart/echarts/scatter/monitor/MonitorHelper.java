package com.fr.solution.plugin.chart.echarts.scatter.monitor;

import com.fr.general.Inter;
import com.fr.stable.fun.FunctionHelper;
import com.fr.stable.fun.FunctionProcessor;
import com.fr.stable.fun.impl.AbstractFunctionProcessor;

public class MonitorHelper {

    public static FunctionProcessor SCATTER = new AbstractFunctionProcessor() {
        @Override
        public int getId() {
            return FunctionHelper.generateFunctionID("com.fr.solution.plugin.chart.echarts.scatter");
        }

        @Override
        public String getLocaleKey() {
            return "Plugin-ECharts_Scatter";
        }

        @Override
        public String toString() {
            return Inter.getLocText("Plugin-ECharts_Scatter");
        }
    };
}
