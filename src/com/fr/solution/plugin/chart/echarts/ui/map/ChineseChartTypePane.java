package com.fr.solution.plugin.chart.echarts.ui.map;

import com.fr.chart.chartattr.Chart;
import com.fr.design.mainframe.chart.gui.type.UserDefinedChartTypePane;
import com.fr.general.Inter;
import com.fr.solution.plugin.chart.echarts.ChineseMap;
import com.fr.solution.plugin.chart.echarts.plot.map.ChineseMapPlot;

/**
 * Created by richie on 16/1/29.
 */
public class ChineseChartTypePane extends UserDefinedChartTypePane {
    /**
     * 弹出框的标题
     *
     * @return 弹出框的标题
     */
    public String title4PopupWindow() {
        return Inter.getLocText("Plugin-ECharts_Chinese_Map");
    }

    public void updateBean(Chart chart) {
        if (chart != null) {
            chart.setPlot(new ChineseMapPlot());
        }
    }

    /**
     * 界面是否接受
     * @param ob 对象是否为chart
     * @return 界面是否接受对象
     */
    public boolean accept(Object ob) {
        return (ob instanceof Chart)&&((Chart) ob).getPlot().accept(ChineseMapPlot.class);
    }

    @Override
    public Chart getDefaultChart() {
        return ChineseMap.charts[0];
    }

    @Override
    protected String[] getTypeIconPath() {
        return new String[]{
                "/com/fr/solution/plugin/chart/echarts/images/map/map_type1.png"
        };
    }
}