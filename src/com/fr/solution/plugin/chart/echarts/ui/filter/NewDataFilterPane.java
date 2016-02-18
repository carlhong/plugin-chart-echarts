package com.fr.solution.plugin.chart.echarts.ui.filter;

import com.fr.chart.chartattr.ChartCollection;
import com.fr.chart.chartattr.Plot;
import com.fr.design.gui.frpane.AbstractAttrNoScrollPane;
import com.fr.design.mainframe.chart.gui.ChartDataPane;
import com.fr.design.mainframe.chart.gui.style.ThirdTabPane;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by richie on 16/2/18.
 */
public class NewDataFilterPane extends ThirdTabPane<ChartCollection> {

    public NewDataFilterPane(Plot plot, ChartDataPane parent) {
        super(plot, parent);
    }

    @Override
    protected List<NamePane> initPaneList(Plot plot, AbstractAttrNoScrollPane parent) {
        List<NamePane> paneList = new ArrayList<NamePane>();
        return paneList;
    }

    @Override
    public void populateBean(ChartCollection ob) {

    }

    @Override
    protected String title4PopupWindow() {
        return null;
    }
}
