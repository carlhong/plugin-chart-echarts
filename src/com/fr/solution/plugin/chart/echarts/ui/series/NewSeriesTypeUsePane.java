package com.fr.solution.plugin.chart.echarts.ui.series;

import com.fr.base.chart.chartdata.TopDefinitionProvider;
import com.fr.chart.chartattr.ChartCollection;
import com.fr.chart.chartattr.Plot;
import com.fr.chart.chartdata.MoreNameCDDefinition;
import com.fr.chart.chartdata.OneValueCDDefinition;
import com.fr.design.beans.FurtherBasicBeanPane;
import com.fr.design.constants.LayoutConstants;
import com.fr.design.gui.frpane.UIComboBoxPane;
import com.fr.design.gui.ilable.UILabel;
import com.fr.design.mainframe.chart.gui.ChartDataPane;
import com.fr.design.mainframe.chart.gui.data.table.SeriesNameUseFieldNamePane;
import com.fr.design.mainframe.chart.gui.data.table.SeriesNameUseFieldValuePane;
import com.fr.design.utils.gui.GUICoreUtils;
import com.fr.general.Inter;
import com.fr.solution.plugin.chart.echarts.ui.filter.NewDataFilterPane;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class NewSeriesTypeUsePane extends UIComboBoxPane<ChartCollection> {

    private SeriesNameUseFieldValuePane nameFieldValuePane;
    private SeriesNameUseFieldNamePane nameFieldNamePane;

    private NewDataFilterPane dataFilterPane;

    private ChartDataPane parent;
    private Plot initplot;

    private boolean isNeedSummary = true;

    public NewSeriesTypeUsePane(ChartDataPane parent, Plot initPlot) {
        cards = initPaneList();
        this.parent = parent;
        this.initplot = initPlot;
        this.isNeedSummary = true;
        initComponents();
    }

    protected void initLayout() {
        this.setLayout(new BorderLayout(4, LayoutConstants.VGAP_MEDIUM));
        JPanel northPane = new JPanel(new BorderLayout(4, 0));
        UILabel label1 = new UILabel(Inter.getLocText("ChartF-Series_Name_From") + ":", SwingConstants.RIGHT);
        label1.setPreferredSize(new Dimension(75, 20));
        northPane.add(GUICoreUtils.createBorderLayoutPane(
                jcb, BorderLayout.CENTER,
                label1, BorderLayout.WEST
        ));
        northPane.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 1));
        add(northPane, BorderLayout.NORTH);
        add(cardPane, BorderLayout.CENTER);

        dataFilterPane = new NewDataFilterPane(initplot, parent);
        add(dataFilterPane, BorderLayout.SOUTH);
    }

    /**
     * 检查box 是否使用, hasUse, 表示上层已经使用, 否则, 则此界面都可使用
     *
     * @param hasUse 是否使用
     */
    public void checkUseBox(boolean hasUse) {
        jcb.setEnabled(hasUse);
        nameFieldValuePane.checkUse(hasUse);
    }

    /**
     * 切换 变更数据集时, 刷新Box选中项目
     *
     * @param list 列表
     */
    public void refreshBoxListWithSelectTableData(List list) {
        nameFieldValuePane.refreshBoxListWithSelectTableData(list);
        nameFieldNamePane.refreshBoxListWithSelectTableData(list);
    }

    /**
     * 清空所有的box设置
     */
    public void clearAllBoxList() {
        nameFieldValuePane.clearAllBoxList();
        nameFieldNamePane.clearAllBoxList();
    }

    /**
     * 界面标题
     *
     * @return 界面标题
     */
    protected String title4PopupWindow() {
        return Inter.getLocText("ChartF-Series_Name_From");
    }

    @Override
    protected List<FurtherBasicBeanPane<? extends ChartCollection>> initPaneList() {
        nameFieldValuePane = new SeriesNameUseFieldValuePane();
        nameFieldNamePane = new SeriesNameUseFieldNamePane();
        List<FurtherBasicBeanPane<? extends ChartCollection>> paneList = new ArrayList<FurtherBasicBeanPane<? extends ChartCollection>>();
        paneList.add(nameFieldValuePane);
        paneList.add(nameFieldNamePane);
        return paneList;
    }

    public void populateBean(ChartCollection ob, boolean isNeedSummary) {
        this.isNeedSummary = isNeedSummary;
        TopDefinitionProvider definition = ob.getSelectedChart().getFilterDefinition();
        if (definition instanceof OneValueCDDefinition) {
            this.setSelectedIndex(0);
            nameFieldValuePane.populateBean(ob, isNeedSummary);
        } else if (definition instanceof MoreNameCDDefinition) {
            this.setSelectedIndex(1);
            nameFieldNamePane.populateBean(ob, isNeedSummary);
        }
    }

    /**
     * 重新布局整个面板
     *
     * @param isNeedSummary 是否需要汇总
     */
    public void relayoutPane(boolean isNeedSummary) {
        this.isNeedSummary = isNeedSummary;
        if (jcb.getSelectedIndex() == 0) {
            nameFieldValuePane.relayoutPane(this.isNeedSummary);
        } else {
            nameFieldNamePane.relayoutPane(this.isNeedSummary);
        }
    }


    @Override
    protected void comboBoxItemStateChanged() {
        if (jcb.getSelectedIndex() == 0) {
            nameFieldValuePane.relayoutPane(this.isNeedSummary);
        } else {
            nameFieldNamePane.relayoutPane(this.isNeedSummary);
        }
    }

    public void populateBean(ChartCollection ob) {
        this.populateBean(ob, true);
    }

    /**
     * 保存界面属性到Ob-ChartCollection
     */
    public void updateBean(ChartCollection ob) {
        if (this.getSelectedIndex() == 0) {
            nameFieldValuePane.updateBean(ob);
        } else {
            nameFieldNamePane.updateBean(ob);
        }
    }

}
