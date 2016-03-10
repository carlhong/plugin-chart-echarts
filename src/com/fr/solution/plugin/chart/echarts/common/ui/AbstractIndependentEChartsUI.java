package com.fr.solution.plugin.chart.echarts.common.ui;

import com.fr.design.chart.fun.impl.AbstractIndependentChartUIWithAPILevel;
import com.fr.design.gui.frpane.AttributeChangeListener;
import com.fr.design.mainframe.chart.AbstractChartAttrPane;

/**
 * Created by richie on 16/2/18.
 */
public abstract class AbstractIndependentEChartsUI extends AbstractIndependentChartUIWithAPILevel {

    private EChartsStylePane stylePane;

    @Override
    public boolean isUseDefaultPane() {
        return false;
    }

    public AbstractChartAttrPane[] getAttrPaneArray(AttributeChangeListener listener){
        if (stylePane == null) {
            stylePane = new EChartsStylePane(listener);
        }
        return new AbstractChartAttrPane[]{stylePane};
    }
}
