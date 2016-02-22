package com.fr.solution.plugin.chart.echarts.common.ui;

import com.fr.design.dialog.BasicScrollPane;
import com.fr.design.gui.ilable.UILabel;
import com.fr.general.Inter;
import com.fr.solution.plugin.chart.echarts.common.base.ECharts;

import javax.swing.*;
import java.awt.*;

/**
 * Created by richie on 16/2/22.
 */
public class EChartsLegendPane extends BasicScrollPane<ECharts> {

    public EChartsLegendPane(EChartsStylePane parent) {

    }
    @Override
    protected JPanel createContentPane() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new UILabel("待开发", SwingConstants.CENTER), BorderLayout.CENTER);
        return panel;
    }

    @Override
    public void populateBean(ECharts ob) {

    }

    @Override
    protected String title4PopupWindow() {
        return Inter.getLocText("Plugin-ECharts_Legend");
    }
}
