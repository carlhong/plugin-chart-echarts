package com.fr.solution.plugin.chart.echarts.pie.ui;

import com.fr.chart.chartattr.Chart;
import com.fr.chart.chartattr.Plot;
import com.fr.design.mainframe.chart.gui.type.ChartImagePane;
import com.fr.general.FRLogger;
import com.fr.general.Inter;
import com.fr.solution.plugin.chart.echarts.common.base.ECharts;
import com.fr.solution.plugin.chart.echarts.pie.EChartsPie;
import com.fr.solution.plugin.chart.echarts.pie.plot.EChartsPiePlot;
import com.fr.solution.plugin.chart.echarts.common.ui.AbstractEChartsTypePane;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by richie on 16/1/29.
 */
public class EChartsPieChartTypePane extends AbstractEChartsTypePane {
    /**
     * 弹出框的标题
     *
     * @return 弹出框的标题
     */
    public String title4PopupWindow() {
        return Inter.getLocText("Plugin-ECharts_Pie");
    }

    /**
     * 界面是否接受
     *
     * @param ob 对象是否为chart
     * @return 界面是否接受对象
     */
    public boolean accept(Object ob) {
        return (ob instanceof Chart) && ((Chart) ob).getPlot().accept(EChartsPiePlot.class);
    }

    @Override
    public Chart getDefaultChart() {
        return EChartsPie.charts[0];
    }

    @Override
    public void populateBean(Chart chart) {
        for(ChartImagePane imagePane : typeDemo) {
            imagePane.isPressing = false;
        }
        Plot plot = chart.getPlot();
        if(plot instanceof EChartsPiePlot) {
            lastTypeIndex = ((EChartsPiePlot)plot).getPieType().ordinal();
            typeDemo.get(lastTypeIndex).isPressing = true;
        }
        checkDemosBackground();
    }

    @Override
    public Plot getSelectedClonedPlot() {
        EChartsPiePlot newPlot = null;
        Chart[] pieChart = EChartsPie.charts;
        for(int i = 0, len = pieChart.length; i < len; i++){
            if(typeDemo.get(i).isPressing){
                newPlot = (EChartsPiePlot)pieChart[i].getPlot();
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
                "/com/fr/solution/plugin/chart/echarts/pie/images/pie_type_none.png",
                "/com/fr/solution/plugin/chart/echarts/pie/images/pie_type_area.png",
                "/com/fr/solution/plugin/chart/echarts/pie/images/pie_type_radius.png",
        };
    }

    @Override
    public String[] getNamesOfTypes() {
        return new String[]{
                "Normal",
                "Area",
                "Redius"
        };
    }
}