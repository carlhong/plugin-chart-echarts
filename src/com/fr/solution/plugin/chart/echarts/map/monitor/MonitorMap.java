package com.fr.solution.plugin.chart.echarts.map.monitor;

import com.fr.general.Inter;
import com.fr.stable.fun.FunctionHelper;
import com.fr.stable.fun.impl.AbstractFunctionProcessor;

/**
 * Created by richie on 16/2/18.
 */
public class MonitorMap extends AbstractFunctionProcessor {

    private static MonitorMap instance = new MonitorMap();

    public static MonitorMap getInstance() {
        return instance;
    }

    private MonitorMap() {
        super();
    }


    @Override
    public int getId() {
        return FunctionHelper.generateFunctionID("com.fr.solution.plugin.chart.echarts");
    }

    @Override
    public String getLocaleKey() {
        return "Plugin-ECharts_Chinese_Map";
    }

    @Override
    public String toString() {
        return Inter.getLocText("Plugin-ECharts_Chinese_Map");
    }
}
