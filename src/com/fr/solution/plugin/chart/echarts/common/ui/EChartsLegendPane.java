package com.fr.solution.plugin.chart.echarts.common.ui;

import com.fr.design.dialog.BasicScrollPane;
import com.fr.design.gui.ibutton.UIButtonGroup;
import com.fr.design.gui.ilable.UILabel;
import com.fr.design.layout.TableLayout;
import com.fr.design.layout.TableLayoutHelper;
import com.fr.general.Inter;
import com.fr.solution.plugin.chart.echarts.common.base.ECharts;
import com.fr.solution.plugin.chart.echarts.common.legend.EChartsLegend;

import javax.swing.*;
import java.awt.*;

/**
 * Created by richie on 16/2/22.
 */
public class EChartsLegendPane extends BasicScrollPane<ECharts> {

    private UIButtonGroup<Boolean> showLegend;
    public EChartsLegendPane(EChartsStylePane parent) {}
    @Override
    protected JPanel createContentPane() {
        JPanel panel = new JPanel(new BorderLayout());
        double p = TableLayout.PREFERRED;
        double f = TableLayout.FILL;
        double[] rowSize = {p, p};
        double[] columnSize = { p, f};
        showLegend = new UIButtonGroup<Boolean>(
                new String[]{
                        Inter.getLocText("Plugin-ECharts_Title_Show"),
                        Inter.getLocText("Plugin-ECharts_Title_Not_Show")},
                new Boolean[]{true, false});
        showLegend.setSelectedIndex(0);
        JPanel cen = TableLayoutHelper.createTableLayoutPane(new Component[][] {
                {new UILabel(Inter.getLocText("Plugin-ECharts_Legend_Show_Label")), showLegend},
        },rowSize, columnSize);
        panel.add(cen, BorderLayout.CENTER);
        return panel;
    }

    @Override
    public void populateBean(ECharts ob) {
        if (ob == null) {
            return;
        }
        EChartsLegend legend = ob.getLegend();
        if (legend == null) {
            return;
        }

        showLegend.setSelectedItem(legend.isLegendVisible());

    }

    @Override
    public void updateBean(ECharts ob) {
        if (ob == null) {
            ob = new ECharts();
        }
        EChartsLegend legend = new EChartsLegend();
        legend.setLegendVisible(showLegend.getSelectedItem());
        ob.setLegend(legend);
    }

    @Override
    protected String title4PopupWindow() {
        return Inter.getLocText("Plugin-ECharts_Legend");
    }
}
