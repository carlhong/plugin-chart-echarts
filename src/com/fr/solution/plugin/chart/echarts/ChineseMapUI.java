package com.fr.solution.plugin.chart.echarts;

import com.fr.chart.chartattr.Plot;
import com.fr.design.chart.fun.impl.AbstractIndependentChartUI;
import com.fr.design.mainframe.chart.gui.ChartDataPane;
import com.fr.design.mainframe.chart.gui.data.report.AbstractReportDataContentPane;
import com.fr.design.mainframe.chart.gui.data.table.AbstractTableDataContentPane;
import com.fr.design.mainframe.chart.gui.type.AbstractChartTypePane;
import com.fr.solution.plugin.chart.echarts.core.map.ChineseMapReportDataContentPane;
import com.fr.solution.plugin.chart.echarts.core.map.ChineseMapTableDataContentPane;
import com.fr.solution.plugin.chart.echarts.ui.map.ChineseChartTypePane;

/**
 * Created by richie on 16/1/29.
 */
public class ChineseMapUI extends AbstractIndependentChartUI  {
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
        return "com/fr/solution/plugin/chart/echarts/images/map/chinese.png";
    }

    @Override
    public boolean isUseDefaultPane() {
        return false;
    }
}
