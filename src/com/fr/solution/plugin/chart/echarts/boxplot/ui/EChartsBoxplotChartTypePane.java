package com.fr.solution.plugin.chart.echarts.boxplot.ui;

import com.fr.chart.chartattr.Chart;
import com.fr.chart.chartattr.Plot;
import com.fr.design.mainframe.chart.gui.type.ChartImagePane;
import com.fr.general.FRLogger;
import com.fr.general.Inter;
import com.fr.solution.plugin.chart.echarts.common.base.ECharts;
import com.fr.solution.plugin.chart.echarts.boxplot.EChartsBoxplot;
import com.fr.solution.plugin.chart.echarts.boxplot.plot.EChartsBoxplotPlot;
import com.fr.solution.plugin.chart.echarts.common.ui.AbstractEChartsTypePane;

import java.util.ArrayList;
import java.util.List;

public class EChartsBoxplotChartTypePane extends AbstractEChartsTypePane {
    /**
     * 弹出框的标题
     *
     * @return 弹出框的标题
     */
    public String title4PopupWindow() {
        return Inter.getLocText("Plugin-ECharts_Boxplot");
    }

    /**
     * 界面是否接受
     *
     * @param ob 对象是否为chart
     * @return 界面是否接受对象
     */
    public boolean accept(Object ob) {
        return (ob instanceof ECharts) && ((ECharts) ob).getPlot().accept(EChartsBoxplotPlot.class);
    }

    @Override
    public Chart getDefaultChart() {
        return EChartsBoxplot.charts[0];
    }

    @Override
    public void populateBean(Chart chart) {
        for (ChartImagePane imagePane : typeDemo) {
            imagePane.isPressing = false;
        }
        Plot plot = chart.getPlot();
        if (plot instanceof EChartsBoxplotPlot) {
            lastTypeIndex = ((EChartsBoxplotPlot)plot).getBoxplotType().ordinal();
            typeDemo.get(lastTypeIndex).isPressing = true;
        }
        checkDemosBackground();
    }

    @Override
    protected String getPlotTypeID() {
        return EChartsBoxplotPlot.PLOT_ID;
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
        EChartsBoxplotPlot newPlot = null;
        Chart[] boxplotChart = EChartsBoxplot.charts;
        for (int i = 0, len = boxplotChart.length; i < len; i++) {
            if (typeDemo.get(i).isPressing) {
                newPlot = (EChartsBoxplotPlot)boxplotChart[i].getPlot();
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
                "/com/fr/solution/plugin/chart/echarts/boxplot/images/boxplot48.png",
                //"/com/fr/solution/plugin/chart/echarts/boxplot/images/boxplot_type_area.png",
                //"/com/fr/solution/plugin/chart/echarts/boxplot/images/boxplot_type_radius.png",
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