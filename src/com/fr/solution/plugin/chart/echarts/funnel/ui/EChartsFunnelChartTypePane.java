package com.fr.solution.plugin.chart.echarts.funnel.ui;

import com.fr.chart.chartattr.Chart;
import com.fr.chart.chartattr.Plot;
import com.fr.design.mainframe.chart.gui.type.ChartImagePane;
import com.fr.general.FRLogger;
import com.fr.general.Inter;
import com.fr.solution.plugin.chart.echarts.common.base.ECharts;
import com.fr.solution.plugin.chart.echarts.funnel.EChartsFunnel;
import com.fr.solution.plugin.chart.echarts.funnel.plot.EChartsFunnelPlot;
import com.fr.solution.plugin.chart.echarts.common.ui.AbstractEChartsTypePane;

import java.util.ArrayList;
import java.util.List;

public class EChartsFunnelChartTypePane extends AbstractEChartsTypePane {
    /**
     * 弹出框的标题
     *
     * @return 弹出框的标题
     */
    public String title4PopupWindow() {
        return Inter.getLocText("Plugin-ECharts_Funnel");
    }

    /**
     * 界面是否接受
     *
     * @param ob 对象是否为chart
     * @return 界面是否接受对象
     */
    public boolean accept(Object ob) {
        return (ob instanceof ECharts) && ((ECharts) ob).getPlot().accept(EChartsFunnelPlot.class);
    }

    @Override
    public Chart getDefaultChart() {
        return EChartsFunnel.charts[0];
    }

    @Override
    public void populateBean(Chart chart) {
        for (ChartImagePane imagePane : typeDemo) {
            imagePane.isPressing = false;
        }
        Plot plot = chart.getPlot();
        if (plot instanceof EChartsFunnelPlot) {
            lastTypeIndex = ((EChartsFunnelPlot)plot).getFunnelType().ordinal();
            typeDemo.get(lastTypeIndex).isPressing = true;
        }
        checkDemosBackground();
    }

    @Override
    protected String getPlotTypeID() {
        return EChartsFunnelPlot.PLOT_ID;
    }

    @Override
    protected String[] getTypeTipName() {
        return getNamesOfTypes();
    }

    @Override
    protected String[] getTypeLayoutTipName() {
        return getNamesOfTypes();
    }

    @Override
    public Plot getSelectedClonedPlot() {
        EChartsFunnelPlot newPlot = null;
        Chart[] funnelChart = EChartsFunnel.charts;
        for (int i = 0, len = funnelChart.length; i < len; i++) {
            if(typeDemo.get(i).isPressing){
                newPlot = (EChartsFunnelPlot)funnelChart[i].getPlot();
            }
        }

        Plot cloned = null;
        try {
            cloned = (Plot)newPlot.clone();
        } catch (CloneNotSupportedException e) {
            FRLogger.getLogger().error("Error In ColumnChart");
        }
        return cloned;
    }

    @Override
    public String[] getIconsOfTypes() {
        return new String[]{
                "/com/fr/solution/plugin/chart/echarts/funnel/images/funnel42.png",
                //"/com/fr/solution/plugin/chart/echarts/funnel/images/funnel_type_area.png",
                //"/com/fr/solution/plugin/chart/echarts/funnel/images/funnel_type_radius.png",
        };
    }

    @Override
    public String[] getNamesOfTypes() {
        return new String[]{
                "Normal",
                //"Area",
                //"Redius"
        };
    }
}