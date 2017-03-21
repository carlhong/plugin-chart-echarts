package com.fr.solution.plugin.chart.echarts.pie.monitor;

import com.fr.general.Inter;
import com.fr.stable.fun.FunctionHelper;
import com.fr.stable.fun.FunctionProcessor;
import com.fr.stable.fun.impl.AbstractFunctionProcessor;

/**
 * Created by richie on 2017/3/21.
 */
public class MonitorHelper {

    public static FunctionProcessor PIE = new AbstractFunctionProcessor() {
        @Override
        public int getId() {
            return FunctionHelper.generateFunctionID("com.fr.solution.plugin.chart.echarts.pie");
        }

        @Override
        public String getLocaleKey() {
            return "Plugin-ECharts_Pie";
        }

        @Override
        public String toString() {
            return Inter.getLocText("Plugin-ECharts_Pie");
        }
    };
}
