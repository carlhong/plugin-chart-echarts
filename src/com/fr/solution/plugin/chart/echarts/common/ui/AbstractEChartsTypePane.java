package com.fr.solution.plugin.chart.echarts.common.ui;

import com.fr.chart.chartattr.Chart;
import com.fr.chart.chartattr.Legend;
import com.fr.chart.chartattr.Plot;
import com.fr.chart.chartglyph.ConditionCollection;
import com.fr.design.mainframe.chart.gui.type.AbstractChartTypePane;
import com.fr.design.mainframe.chart.gui.type.ChartImagePane;
import com.fr.general.FRLogger;
import com.fr.solution.plugin.chart.echarts.common.base.ECharts;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractEChartsTypePane extends AbstractChartTypePane{
    private static final long serialVersionUID = 7743244512351499265L;

    @Override
    protected List<ChartImagePane> initStyleList() {
        return new ArrayList<ChartImagePane>();
    }

    @Override
    protected String[] getTypeLayoutPath() {
        return new String[]{
        };
    }

    @Override
    protected String[] getTypeIconPath() {
        return getIconsOfTypes();
    }

    public abstract String[] getIconsOfTypes();

    /**
     * 不同字类型图表的名字
     * @return 名字
     */
    public abstract String[] getNamesOfTypes();


    public abstract Plot getSelectedClonedPlot();

    @Override
    protected List<ChartImagePane> initDemoList() {
        List <ChartImagePane> demoList = new ArrayList<ChartImagePane>();
        String[] iconPaths = getTypeIconPath();
        String[] names = getNamesOfTypes();
        ChartImagePane pane = new ChartImagePane(iconPaths[0], names[0]);
        pane.isPressing = true;
        demoList.add(pane);
        demoList.add(new ChartImagePane(iconPaths[1], names[1]));
        demoList.add(new ChartImagePane(iconPaths[2], names[2]));
        return demoList;
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
        try {
            if (oldPlot.getLegend() != null) {
                newPlot.setLegend((Legend) oldPlot.getLegend().clone());
            }
        } catch (CloneNotSupportedException e) {
            FRLogger.getLogger().error(e.getMessage(), e);
        }
    }

    protected void cloneOldConditionCollection(Plot oldPlot, Plot newPlot) throws CloneNotSupportedException{
        if (oldPlot.getConditionCollection() != null) {
            newPlot.setConditionCollection((ConditionCollection)oldPlot.getConditionCollection().clone());
        }
    }
}