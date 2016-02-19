package com.fr.solution.plugin.chart.echarts.pie.ui;

import com.fr.chart.chartattr.Chart;
import com.fr.design.mainframe.chart.gui.type.ChartImagePane;
import com.fr.general.Inter;
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

    public void updateBean(Chart chart) {
        if (chart != null) {
            chart.setPlot(new EChartsPiePlot());
        }
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
    protected List<ChartImagePane> initDemoList() {
        List <ChartImagePane> demoList = new ArrayList<ChartImagePane>();
        String[] iconPaths = getTypeIconPath();
        ChartImagePane pane = new ChartImagePane(iconPaths[0], "Regular");
        pane.isPressing = true;
        demoList.add(pane);
        demoList.add(new ChartImagePane(iconPaths[1], "Circle"));
        return demoList;
    }

    @Override
    protected String[] getTypeIconPath() {
        return new String[]{
                "/com/fr/solution/plugin/chart/echarts/pie/images/pie_type1.png",
                "/com/fr/solution/plugin/chart/echarts/pie/images/pie_type2.png"
        };
    }
}