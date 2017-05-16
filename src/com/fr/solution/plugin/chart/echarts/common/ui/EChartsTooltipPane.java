package com.fr.solution.plugin.chart.echarts.common.ui;

import com.fr.design.dialog.BasicScrollPane;
import com.fr.design.gui.frpane.UINumberDragPane;
import com.fr.design.gui.icombobox.UIDictionaryComboBox;
import com.fr.design.gui.ilable.UILabel;
import com.fr.design.gui.itextfield.UITextField;
import com.fr.design.layout.TableLayout;
import com.fr.design.layout.TableLayoutHelper;
import com.fr.design.style.color.ColorSelectBox;
import com.fr.general.Inter;
import com.fr.solution.plugin.chart.echarts.common.base.ECharts;
import com.fr.solution.plugin.chart.echarts.common.tooltip.EChartsTooltip;
import com.fr.solution.plugin.chart.echarts.common.tooltip.TriggerType;
import com.fr.solution.plugin.chart.echarts.common.tooltip.AxisPointerType;

import javax.swing.*;
import java.awt.*;

/**
 * Created by richie on 16/2/19.
 */
public class EChartsTooltipPane extends BasicScrollPane<ECharts> {

    private static final double ALPHA_V = 100.0;
    private UIDictionaryComboBox<TriggerType> triggerComboBox;
    private UITextField formatterTextField;
    private UIDictionaryComboBox<AxisPointerType> axisPointerComboBox;
    private ColorSelectBox borderColorSelectBox;
    private UITextField borderWidthTextField;
    private ColorSelectBox bgColorSelectBox;
    private UINumberDragPane bgTransparent;

    public EChartsTooltipPane(EChartsStylePane parent) {}

    @Override
    protected JPanel createContentPane() {
        JPanel panel = new JPanel();
        double p = TableLayout.PREFERRED;
        double f = TableLayout.FILL;
        double[] rowSize = {p, p, p, p, p, p, p};

        double[] columnSize = { p, f};

        UILabel titleLabel = new UILabel(Inter.getLocText("Plugin-ECharts_Trigger"));

        triggerComboBox = new UIDictionaryComboBox<TriggerType>(
                new TriggerType[]{TriggerType.ITEM, TriggerType.AXIS},
                new String[]{
                    Inter.getLocText("Plugin-ECharts_Trigger_Item"), 
                    Inter.getLocText("Plugin-ECharts_Trigger_Axis")});

        UILabel formatterLabel = new UILabel(Inter.getLocText("Plugin-ECharts_Formatter"));

        formatterTextField = new UITextField(12);

        UILabel axisPointerLabel = new UILabel(Inter.getLocText("Plugin-ECharts_AxisPointer_Type"));

        axisPointerComboBox = new UIDictionaryComboBox<AxisPointerType>(
                new AxisPointerType[]{AxisPointerType.LINE, AxisPointerType.SHADOW, AxisPointerType.CROSS},
                new String[]{
                    Inter.getLocText("Plugin-ECharts_AxisPointer_Type_Line"), 
                    Inter.getLocText("Plugin-ECharts_AxisPointer_Type_Shadow"),
                    Inter.getLocText("Plugin-ECharts_AxisPointer_Type_Cross")});

        UILabel borderColorLabel = new UILabel(Inter.getLocText("Plugin-ECharts_Border_Color"));
        borderColorSelectBox = new ColorSelectBox(100);

        UILabel borderWidthLabel = new UILabel(Inter.getLocText("Plugin-ECharts_Border_Width"));
        borderWidthTextField = new UITextField(12);

        UILabel bgColorLabel = new UILabel(Inter.getLocText("Plugin-ECharts_Background_Color"));
        bgColorSelectBox = new ColorSelectBox(100);

        UILabel bgTransparentLabel = new UILabel(Inter.getLocText("Plugin-ECharts_Background_Transparent"));
        bgTransparent = new UINumberDragPane(0, 100);

        JPanel cen = TableLayoutHelper.createTableLayoutPane(new Component[][] {
                {titleLabel, triggerComboBox},
                {formatterLabel, formatterTextField},
                {axisPointerLabel, axisPointerComboBox},
                {borderColorLabel, borderColorSelectBox},
                {borderWidthLabel, borderWidthTextField},
                {bgColorLabel, bgColorSelectBox},
                {bgTransparentLabel, bgTransparent},
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
        axisPointerComboBox.setSelectedItem(tooltip.getAxisPointerType());
        borderWidthTextField.setText(tooltip.getBorderWidth());
        borderColorSelectBox.setSelectObject(tooltip.getBorderColor());
        bgColorSelectBox.setSelectObject(tooltip.getBgColor());
        double alpha = tooltip.getAlpha() * ALPHA_V;
        bgTransparent.populateBean(alpha);
    }

    @Override
    public void updateBean(ECharts ob) {
        if (ob == null) {
            ob = new ECharts();
        }
        EChartsTooltip tooltip = new EChartsTooltip();
        tooltip.setTriggerType(triggerComboBox.getSelectedItem());
        tooltip.setFormat(formatterTextField.getText());
        tooltip.setAxisPointerType(axisPointerComboBox.getSelectedItem());
        tooltip.setBorderWidth(borderWidthTextField.getText());
        tooltip.setBorderColor(borderColorSelectBox.getSelectObject());
        tooltip.setBgColor(bgColorSelectBox.getSelectObject());
        tooltip.setAlpha((float) (bgTransparent.updateBean() / ALPHA_V));
        ob.setTooltip(tooltip);
    }

    @Override
    protected String title4PopupWindow() {
        return Inter.getLocText("Plugin-ECharts_Tooltip");
    }
}
