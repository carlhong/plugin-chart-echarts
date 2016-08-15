package com.fr.solution.plugin.chart.echarts.map;

import com.fr.chart.chartattr.Plot;
import com.fr.design.mainframe.chart.gui.ChartDataPane;
import com.fr.design.mainframe.chart.gui.data.report.AbstractReportDataContentPane;
import com.fr.design.mainframe.chart.gui.data.table.AbstractTableDataContentPane;
import com.fr.design.mainframe.chart.gui.type.AbstractChartTypePane;
import com.fr.solution.plugin.chart.echarts.common.ui.AbstractIndependentEChartsUI;
import com.fr.solution.plugin.chart.echarts.map.ui.ChineseMapReportDataContentPane;
import com.fr.solution.plugin.chart.echarts.map.ui.ChineseMapTableDataContentPane;
import com.fr.solution.plugin.chart.echarts.map.ui.ChineseChartTypePane;

/**
 * Created by richie on 16/1/29.
 */
public class EChartsChineseMapUI extends AbstractIndependentEChartsUI {
    @Override
    public AbstractChartTypePane getPlotTypePane() {
        return new ChineseChartTypePane();
    }

    @Override
    public AbstractTableDataContentPane getTableDataSourcePane(Plot plot, ChartDataPane parent) {
        return new ChineseMapTableDataContentPane(parent);
    }

    @Override
    public AbstractReportDataContentPane getReportDataSourcePane(Plot plot, ChartDataPane parent) {
        return new ChineseMapReportDataContentPane(parent);
    }

    @Override
    public String getIconPath() {
        return "com/fr/solution/plugin/chart/echarts/map/images/chinese.png";
    }
}