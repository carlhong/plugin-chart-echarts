package com.fr.solution.plugin.chart.echarts.funnel;

import com.fr.chart.chartattr.Plot;
import com.fr.design.mainframe.chart.gui.ChartDataPane;
import com.fr.design.mainframe.chart.gui.data.report.AbstractReportDataContentPane;
import com.fr.design.mainframe.chart.gui.data.table.AbstractTableDataContentPane;
import com.fr.design.mainframe.chart.gui.type.AbstractChartTypePane;
import com.fr.solution.plugin.chart.echarts.common.ui.AbstractIndependentEChartsUI;
import com.fr.solution.plugin.chart.echarts.funnel.ui.EChartsFunnelChartTypePane;
import com.fr.solution.plugin.chart.echarts.funnel.ui.EChartsFunnelReportDataContentPane;
import com.fr.solution.plugin.chart.echarts.funnel.ui.EChartsFunnelTableDataContentPane;

public class EChartsFunnelUI extends AbstractIndependentEChartsUI {

    @Override
    public AbstractChartTypePane getPlotTypePane() {
        return new EChartsFunnelChartTypePane();
    }

    @Override
    public AbstractTableDataContentPane getTableDataSourcePane(Plot plot, ChartDataPane parent) {
        return new EChartsFunnelTableDataContentPane(parent);
    }

    @Override
    public AbstractReportDataContentPane getReportDataSourcePane(Plot plot, ChartDataPane parent) {
        return new EChartsFunnelReportDataContentPane(parent);
    }

    @Override
    public String getIconPath() {
        return "com/fr/solution/plugin/chart/echarts/funnel/images/funnel.png";
    }
}