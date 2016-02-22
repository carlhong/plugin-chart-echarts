package com.fr.solution.plugin.chart.echarts.common.ui;

import com.fr.design.dialog.BasicScrollPane;
import com.fr.design.gui.icombobox.UIDictionaryComboBox;
import com.fr.design.gui.ilable.UILabel;
import com.fr.design.gui.itextfield.UITextField;
import com.fr.design.layout.TableLayout;
import com.fr.design.layout.TableLayoutHelper;
import com.fr.general.Inter;
import com.fr.solution.plugin.chart.echarts.common.base.ECharts;
import com.fr.solution.plugin.chart.echarts.common.tooltip.EChartsTooltip;
import com.fr.solution.plugin.chart.echarts.common.tooltip.TriggerType;

import javax.swing.*;
import java.awt.*;

/**
 * Created by richie on 16/2/19.
 */
public class EChartsTooltipPane extends BasicScrollPane<ECharts> {

    private UIDictionaryComboBox<TriggerType> triggerComboBox;
    private UITextField formatterTextField;

    public EChartsTooltipPane(EChartsStylePane parent) {

    }

    @Override
    protected JPanel createContentPane() {
        JPanel panel = new JPanel();
        double p = TableLayout.PREFERRED;
        double f = TableLayout.FILL;
        double[] rowSize = {p, p};
        double[] columnSize = {p, f};

        UILabel titleLabel = new UILabel("触发点");

        triggerComboBox = new UIDictionaryComboBox<TriggerType>(
                new TriggerType[]{TriggerType.ITEM, TriggerType.AXIS},
                new String[]{"图例", "坐标轴"});

        UILabel formatterLabel = new UILabel("显示格式");

        formatterTextField = new UITextField(12);

        JPanel cen = TableLayoutHelper.createTableLayoutPane(new Component[][] {
                {titleLabel, triggerComboBox},
                {formatterLabel, formatterTextField}
        },rowSize, columnSize);
        panel.add(cen, BorderLayout.CENTER);

        return panel;
    }

    @Override
    public void populateBean(ECharts ob) {
        if (ob == null) {
            return;
        }
        EChartsTooltip tooltip = ob.getTooltip();
        if (tooltip == null) {
            return;
        }
        triggerComboBox.setSelectedItem(tooltip.getTriggerType());
        formatterTextField.setText(tooltip.getFormat());
    }

    @Override
    public void updateBean(ECharts ob) {
        if (ob == null) {
            ob = new ECharts();
        }
        EChartsTooltip tooltip = new EChartsTooltip();
        tooltip.setTriggerType(triggerComboBox.getSelectedItem());
        tooltip.setFormat(formatterTextField.getText());
        ob.setTooltip(tooltip);
    }

    @Override
    protected String title4PopupWindow() {
        return Inter.getLocText("Plugin-ECharts_Tooltip");
    }
}
