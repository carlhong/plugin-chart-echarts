package com.fr.solution.plugin.chart.echarts.base;

import com.fr.base.chart.BaseChartGlyph;
import com.fr.base.chart.chartdata.ChartData;
import com.fr.chart.chartattr.Chart;
import com.fr.general.ComparatorUtils;

/**
 * Created by richie on 16/1/29.
 */
public class NewChart extends Chart {


    public NewChart() {
        setWrapperName("EChartsFactory");
    }

    public NewChart(NewPlot plot) {
        super(plot);
        setWrapperName("EChartsFactory");
    }

    @Override
    public BaseChartGlyph createGlyph(ChartData chartData) {
        NewGlyph glyph = new NewGlyph();
        glyph.setGeneralInfo(this);
        NewPlot newPlot = (NewPlot) getPlot();
        if (newPlot != null) {
            glyph.setLegendGlyph(newPlot.createChartLegendGlyph(chartData));
            glyph.setTitleGlyph(newPlot.createChartTitleGlyph(chartData));
        }
        glyph.setWrapperName(getWrapperName());
        glyph.setChartImagePath(getImagePath());
        glyph.setRequiredJS(getRequiredJS());
        glyph.setJSDraw(isJSDraw());

        return glyph;
    }

    /**
     * 判断图表类型是否是obClass
     * @param obClass 传入对象
     * @return 是否是obClass对象
     */
    public boolean accept(Class<? extends Chart> obClass){
        return ComparatorUtils.equals(NewChart.class, obClass);
    }
}