package com.fr.solution.plugin.chart.echarts.common.ui.data;

import com.fr.chart.base.ChartConstants;
import com.fr.chart.chartattr.Bar2DPlot;
import com.fr.chart.chartattr.ChartCollection;
import com.fr.chart.chartdata.NormalTableDataDefinition;
import com.fr.chart.chartdata.TopDefinition;
import com.fr.design.gui.icombobox.UIComboBox;
import com.fr.design.gui.ilable.BoldFontTextLabel;
import com.fr.design.gui.ilable.UILabel;
import com.fr.design.mainframe.chart.gui.ChartDataPane;
import com.fr.design.mainframe.chart.gui.data.table.AbstractTableDataContentPane;
import com.fr.design.utils.gui.GUICoreUtils;
import com.fr.general.ComparatorUtils;
import com.fr.general.Inter;
import com.fr.solution.plugin.chart.echarts.common.ui.series.NewSeriesTypeUsePane;
import com.fr.stable.ArrayUtils;
import com.fr.stable.StringUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * Created by richie on 16/1/29.
 */
public class AbstractEChartsTableDataContentPane extends AbstractTableDataContentPane {

    protected UIComboBox categoryComboBox;
    protected NewSeriesTypeUsePane seriesTypeUsePane;


    public AbstractEChartsTableDataContentPane(ChartDataPane parent) {

        categoryComboBox = new UIComboBox();
        JPanel categoryPane = new JPanel(new BorderLayout(4, 0));
        categoryPane.setBorder(BorderFactory.createMatteBorder(0, 0, 6, 1, getBackground()));
        UILabel label1 = new BoldFontTextLabel(Inter.getLocText("FR-Chart-Category_Name") + ":", SwingConstants.RIGHT);
        label1.setPreferredSize(new Dimension(75, 20));
        categoryComboBox.setPreferredSize(new Dimension(100, 20));

        categoryComboBox.addItem(Inter.getLocText("Chart-Use_None"));
        categoryPane.add(GUICoreUtils.createBorderLayoutPane(new Component[]{categoryComboBox, null, null, label1, null}));

        this.setLayout(new BorderLayout());

        this.add(categoryPane, BorderLayout.NORTH);

        seriesTypeUsePane = new NewSeriesTypeUsePane(parent, new Bar2DPlot());
        this.add(seriesTypeUsePane, BorderLayout.SOUTH);

        categoryComboBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                checkSeriseUse(categoryComboBox.getSelectedItem() != null);
                makeToolTipUse(categoryComboBox);
            }
        });
    }

    protected void makeToolTipUse(UIComboBox comBox) {
        if (comBox.getSelectedItem() != null) {
            comBox.setToolTipText(comBox.getSelectedItem().toString());
        } else {
            comBox.setToolTipText(null);
        }
    }

    /**
     * 检查 某些Box是否可用
     *
     * @param hasUse 是否使用.
     */
    public void checkBoxUse(boolean hasUse) {
        categoryComboBox.setEnabled(hasUse);
        checkSeriseUse(hasUse);
    }

    protected void checkSeriseUse(boolean hasUse) {
        if (seriesTypeUsePane != null) {
            seriesTypeUsePane.checkUseBox(hasUse && categoryComboBox.getSelectedItem() != null);
        }
    }

    protected void refreshBoxListWithSelectTableData(java.util.List list) {
        refreshBoxItems(categoryComboBox, list);
        categoryComboBox.addItem(Inter.getLocText("Chart-Use_None"));

        seriesTypeUsePane.refreshBoxListWithSelectTableData(list);
    }

    /**
     * 清空所有的box设置
     */
    public void clearAllBoxList() {
        clearBoxItems(categoryComboBox);
        categoryComboBox.addItem(Inter.getLocText("Chart-Use_None"));
        seriesTypeUsePane.clearAllBoxList();
    }

    /**
     * 保存界面内容到ChartCollection
     */
    public void updateBean(ChartCollection collection) {
        seriesTypeUsePane.updateBean(collection);
        NormalTableDataDefinition dataDefinition = (NormalTableDataDefinition) collection.getSelectedChart().getFilterDefinition();
        if (dataDefinition == null) {
            return;
        }
        Object categoryName = categoryComboBox.getSelectedItem();

        if (ArrayUtils.contains(ChartConstants.NONE_KEYS, categoryName)) {
            dataDefinition.setCategoryName(StringUtils.EMPTY);
        } else {
            dataDefinition.setCategoryName(categoryName == null ? null : categoryName.toString());
        }

    }

    /**
     * 根据ChartCollection 更新界面
     */
    public void populateBean(ChartCollection collection) {
        super.populateBean(collection);
        TopDefinition top = (TopDefinition) collection.getSelectedChart().getFilterDefinition();

        if (!(top instanceof NormalTableDataDefinition)) {
            return;
        }
        NormalTableDataDefinition data = (NormalTableDataDefinition) top;

        if (data == null || ComparatorUtils.equals(data.getCategoryName(), StringUtils.EMPTY)) {
            categoryComboBox.setSelectedItem(Inter.getLocText("Chart-Use_None"));
        } else if (data != null && !this.boxItemsContainsObject(categoryComboBox, data.getCategoryName())) {
            categoryComboBox.setSelectedItem(null);
        } else {
            combineCustomEditValue(categoryComboBox, data == null ? null : data.getCategoryName());
        }

        seriesTypeUsePane.populateBean(collection, this.isNeedSummaryCaculateMethod());
    }

    private boolean boxItemsContainsObject(UIComboBox box, Object item) {
        if (box == null) {
            return false;
        }

        ComboBoxModel dataModel = box.getModel();
        for (int i = 0; i < dataModel.getSize(); i++) {
            if (ComparatorUtils.equals(dataModel.getElementAt(i), item)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 重新布局整个面板
     */
    public void redoLayoutPane() {
        seriesTypeUsePane.relayoutPane(this.isNeedSummaryCaculateMethod());
    }

}