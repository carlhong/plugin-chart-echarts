package com.fr.solution.plugin.chart.echarts.map.ui;

import com.fr.chart.chartattr.ChartCollection;
import com.fr.design.event.UIObserver;
import com.fr.design.event.UIObserverListener;
import com.fr.design.mainframe.chart.gui.ChartDataPane;
import com.fr.design.mainframe.chart.gui.data.report.AbstractReportDataContentPane;
import com.fr.design.mainframe.chart.gui.data.table.AbstractTableDataContentPane;

import java.util.List;

/**
 * Created by richie on 16/1/29.
 */
public class ChineseMapReportDataContentPane extends AbstractReportDataContentPane implements UIObserver {

    public ChineseMapReportDataContentPane(ChartDataPane parent) {

    }

    @Override
    protected String[] columnNames() {
        return new String[0];
    }

    @Override
    public void populateBean(ChartCollection ob) {

    }

    @Override
    public void registerChangeListener(UIObserverListener listener) {

    }

    @Override
    public boolean shouldResponseChangeListener() {
        return true;
    }
}