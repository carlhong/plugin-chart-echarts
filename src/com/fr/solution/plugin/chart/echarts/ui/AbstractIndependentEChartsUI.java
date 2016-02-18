package com.fr.solution.plugin.chart.echarts.ui;

import com.fr.design.chart.fun.impl.AbstractIndependentChartUI;

/**
 * Created by richie on 16/2/18.
 */
public abstract class AbstractIndependentEChartsUI extends AbstractIndependentChartUI {

    @Override
    public boolean isUseDefaultPane() {
        return false;
    }
}
