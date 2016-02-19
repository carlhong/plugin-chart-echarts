package com.fr.solution.plugin.chart.echarts.common.ui;

import com.fr.chart.chartattr.Chart;
import com.fr.chart.chartattr.Plot;
import com.fr.chart.chartglyph.ConditionCollection;
import com.fr.design.mainframe.chart.gui.type.AbstractChartTypePane;
import com.fr.design.mainframe.chart.gui.type.ChartImagePane;
import com.fr.solution.plugin.chart.echarts.common.base.ECharts;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractEChartsTypePane extends AbstractChartTypePane{
    private static final long serialVersionUID = 7743244512351499265L;

    //新图表暂时还没有平面3d，渐变高光等布局。
    @Override
    protected List<ChartImagePane> initStyleList() {
        return new ArrayList<ChartImagePane>();
    }

    @Override
    protected String[] getTypeLayoutPath() {
        return new String[]{
        };
    }

    /**
     * 保存界面属性
     */
    public void updateBean(Chart chart) {
        checkTypeChange();
        Plot oldPlot = chart.getPlot();
        Plot newPlot = getSelectedClonedPlot();
        boolean samePlot = accept(chart);
        if(typeChanged && samePlot){
            //同一中图表切换不同类型
            cloneOldPlot2New(oldPlot, newPlot);
            chart.setPlot(newPlot);
        } else if(!samePlot){
            //不同的图表类型切换
            chart.setPlot(newPlot);
        }
    }

    public boolean accept(Object ob) {
        return ob instanceof ECharts;
    }

    protected void checkTypeChange(){
        for(int i = 0; i < typeDemo.size(); i++){
            if(typeDemo.get(i).isPressing && i != lastTypeIndex){
                typeChanged = true;
                lastTypeIndex = i;
                break;
            }
            typeChanged = false;
        }
    }

    /**
     * 同一个图表， 类型之间切换
     */
    protected void cloneOldPlot2New(Plot oldPlot, Plot newPlot) {

    }

    protected void cloneOldConditionCollection(Plot oldPlot, Plot newPlot) throws CloneNotSupportedException{
        if (oldPlot.getConditionCollection() != null) {
            newPlot.setConditionCollection((ConditionCollection)oldPlot.getConditionCollection().clone());
        }
    }
}