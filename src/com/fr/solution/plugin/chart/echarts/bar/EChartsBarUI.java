package com.fr.solution.plugin.chart.echarts.bar;

import com.fr.chart.chartattr.Plot;
import com.fr.design.mainframe.chart.gui.ChartDataPane;
import com.fr.design.mainframe.chart.gui.data.report.AbstractReportDataContentPane;
import com.fr.design.mainframe.chart.gui.data.table.AbstractTableDataContentPane;
import com.fr.design.mainframe.chart.gui.type.AbstractChartTypePane;
import com.fr.solution.plugin.chart.echarts.common.ui.AbstractIndependentEChartsUI;
import com.fr.solution.plugin.chart.echarts.bar.ui.EChartsBarChartTypePane;
import com.fr.solution.plugin.chart.echarts.bar.ui.EChartsBarReportDataContentPane;
import com.fr.solution.plugin.chart.echarts.bar.ui.EChartsBarTableDataContentPane;

public class EChartsBarUI extends AbstractIndependentEChartsUI {

    @Override
    public AbstractChartTypePane getPlotTypePane() {
        return new EChartsBarChartTypePane();
    }

    @Override
    public AbstractTableDataContentPane getTableDataSourcePane(Plot plot, ChartDataPane parent) {
        return new EChartsBarTableDataContentPane(parent);
    }

    @Override
    public AbstractReportDataContentPane getReportDataSourcePane(Plot plot, ChartDataPane parent) {
        return new EChartsBarReportDataContentPane(parent);
    }

    @Override
    public String getIconPath() {
        return "com/fr/solution/plugin/chart/echarts/bar/images/bar.png";
    }
}