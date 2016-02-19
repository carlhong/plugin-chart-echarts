package com.fr.solution.plugin.chart.echarts.pie;

import com.fr.chart.chartattr.Plot;
import com.fr.design.mainframe.chart.gui.ChartDataPane;
import com.fr.design.mainframe.chart.gui.data.report.AbstractReportDataContentPane;
import com.fr.design.mainframe.chart.gui.data.table.AbstractTableDataContentPane;
import com.fr.design.mainframe.chart.gui.type.AbstractChartTypePane;
import com.fr.solution.plugin.chart.echarts.common.ui.AbstractIndependentEChartsUI;
import com.fr.solution.plugin.chart.echarts.pie.ui.EChartsPieChartTypePane;
import com.fr.solution.plugin.chart.echarts.pie.ui.EChartsPieReportDataContentPane;
import com.fr.solution.plugin.chart.echarts.pie.ui.EChartsPieTableDataContentPane;

/**
 * Created by richie on 16/1/29.
 */
public class EChartsPieUI extends AbstractIndependentEChartsUI {

    @Override
    public AbstractChartTypePane getPlotTypePane() {
        return new EChartsPieChartTypePane();
    }

    @Override
    public AbstractTableDataContentPane getTableDataSourcePane(Plot plot, ChartDataPane parent) {
        return new EChartsPieTableDataContentPane(parent);
    }

    @Override
    public AbstractReportDataContentPane getReportDataSourcePane(Plot plot, ChartDataPane parent) {
        return new EChartsPieReportDataContentPane();
    }

    @Override
    public String getIconPath() {
        return "com/fr/solution/plugin/chart/echarts/pie/images/pie.png";
    }
}