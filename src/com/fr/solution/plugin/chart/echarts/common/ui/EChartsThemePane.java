package com.fr.solution.plugin.chart.echarts.common.ui;

import com.fr.design.dialog.BasicScrollPane;
import com.fr.design.gui.icombobox.UIDictionaryComboBox;
import com.fr.design.gui.ilable.UILabel;
import com.fr.design.layout.TableLayout;
import com.fr.design.layout.TableLayoutHelper;
import com.fr.general.Inter;
import com.fr.solution.plugin.chart.echarts.common.base.ECharts;
import com.fr.solution.plugin.chart.echarts.common.theme.EChartsTheme;

import javax.swing.*;
import java.awt.*;

/**
 * Created by richie on 16/2/22.
 */
public class EChartsThemePane extends BasicScrollPane<ECharts> {

    private static final String[] themes = new String[]{"default", "dark"};

    private UIDictionaryComboBox<String> themeComboBox;

    public EChartsThemePane(EChartsStylePane stylePane) {}

    @Override
    protected JPanel createContentPane() {
        JPanel panel = new JPanel(new BorderLayout());
        double p = TableLayout.PREFERRED;
        double f = TableLayout.FILL;
        double[] rowSize = {p};
        double[] columnSize = {p, f};

        UILabel titleLabel = new UILabel(Inter.getLocText("Plugin-ECharts_Theme_Select"));

        themeComboBox = new UIDictionaryComboBox<String>(
                new String[]{"default", "dark"},
                new String[]{"默认", "暗黑"});

        JPanel cen = TableLayoutHelper.createTableLayoutPane(new Component[][] {
                {titleLabel, themeComboBox}
        },rowSize, columnSize);
        panel.add(cen, BorderLayout.CENTER);
        return panel;
    }

    @Override
    public void populateBean(ECharts ob) {
        if (ob == null) {
            return;
        }
        EChartsTheme theme = ob.getTheme();
        if (theme != null) {
            themeComboBox.setSelectedItem(theme.getName());
        }
    }

    @Override
    public void updateBean(ECharts ob) {
        if (ob == null) {
            ob = new ECharts();
        }
        EChartsTheme theme = new EChartsTheme();
        theme.setName(themeComboBox.getSelectedItem());
        ob.setTheme(theme);
    }

    @Override
    protected String title4PopupWindow() {
        return Inter.getLocText("Plugin-ECharts_Theme");
    }
}
