package com.fr.solution.plugin.chart.echarts.common.base;

import com.fr.chart.fun.impl.AbstractIndependentChartProviderWithAPILevel;

/**
 * Created by richie on 16/1/29.
 */
public abstract class AbstractIndependentEChartsProvider extends AbstractIndependentChartProviderWithAPILevel {

    @Override
    public String[] getRequiredJS() {
        return new String[]{
                "/com/fr/solution/plugin/chart/echarts/common/web/echarts.bridge.js"
        };
    }

    @Override
    public String getWrapperName() {
        return "EChartsFactory";
    }

    @Override
    public int currentAPILevel() {
        return CURRENT_API_LEVEL;
    }
}