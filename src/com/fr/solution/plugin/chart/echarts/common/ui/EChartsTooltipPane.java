package com.fr.solution.plugin.chart.echarts.common.ui;

import com.fr.design.dialog.BasicScrollPane;
import com.fr.solution.plugin.chart.echarts.common.base.ECharts;

import javax.swing.*;

/**
 * Created by richie on 16/2/19.
 */
public class EChartsTooltipPane extends BasicScrollPane<ECharts> {

    public EChartsTooltipPane(EChartsStylePane parent) {

    }

    @Override
    protected JPanel createContentPane() {
        return new JPanel();
    }

    @Override
    public void populateBean(ECharts ob) {

    }

    @Override
    protected String title4PopupWindow() {
        return "Tooltip";
    }
}
