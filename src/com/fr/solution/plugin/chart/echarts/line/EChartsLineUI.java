package com.fr.solution.plugin.chart.echarts.line;

import com.fr.chart.chartattr.Plot;
import com.fr.design.mainframe.chart.gui.ChartDataPane;
import com.fr.design.mainframe.chart.gui.data.report.AbstractReportDataContentPane;
import com.fr.design.mainframe.chart.gui.data.table.AbstractTableDataContentPane;
import com.fr.design.mainframe.chart.gui.type.AbstractChartTypePane;
import com.fr.solution.plugin.chart.echarts.common.ui.AbstractIndependentEChartsUI;
import com.fr.solution.plugin.chart.echarts.line.ui.EChartsLineChartTypePane;
import com.fr.solution.plugin.chart.echarts.line.ui.EChartsLineReportDataContentPane;
import com.fr.solution.plugin.chart.echarts.line.ui.EChartsLineTableDataContentPane;

public class EChartsLineUI extends AbstractIndependentEChartsUI {

    @Override
    public AbstractChartTypePane getPlotTypePane() {
        return new EChartsLineChartTypePane();
    }

    @Override
    public AbstractTableDataContentPane getTableDataSourcePane(Plot plot, ChartDataPane parent) {
        return new EChartsLineTableDataContentPane(parent);
    }

    @Override
    public AbstractReportDataContentPane getReportDataSourcePane(Plot plot, ChartDataPane parent) {
        return new EChartsLineReportDataContentPane(parent);
    }

    @Override
    public String getIconPath() {
        return "com/fr/solution/plugin/chart/echarts/line/images/line.png";
    }
}