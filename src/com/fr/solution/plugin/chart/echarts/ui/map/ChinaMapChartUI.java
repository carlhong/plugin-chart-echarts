package com.fr.solution.plugin.chart.echarts.ui.map;

import com.fr.chart.chartattr.Plot;
import com.fr.design.chart.fun.impl.AbstractIndependentChartUI;
import com.fr.design.mainframe.chart.gui.ChartDataPane;
import com.fr.design.mainframe.chart.gui.data.report.AbstractReportDataContentPane;
import com.fr.design.mainframe.chart.gui.data.table.AbstractTableDataContentPane;
import com.fr.design.mainframe.chart.gui.type.AbstractChartTypePane;

/**
 * Created by richie on 16/1/29.
 */
public class ChinaMapChartUI extends AbstractIndependentChartUI  {
    @Override
    public AbstractChartTypePane getPlotTypePane() {
        return null;
    }

    @Override
    public AbstractTableDataContentPane getTableDataSourcePane(Plot plot, ChartDataPane parent) {
        return null;
    }

    @Override
    public AbstractReportDataContentPane getReportDataSourcePane(Plot plot, ChartDataPane parent) {
        return null;
    }

    @Override
    public String getIconPath() {
        return null;
    }
}
