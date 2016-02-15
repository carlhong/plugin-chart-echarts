package com.fr.solution.plugin.chart.echarts.base;

import com.fr.base.chart.BaseChartGlyph;
import com.fr.base.chart.chartdata.ChartData;
import com.fr.chart.chartattr.Chart;
import com.fr.general.ComparatorUtils;

/**
 * Created by richie on 16/1/29.
 */
public class NewChart extends Chart {

    private NewPlot newPlot;


    public NewChart() {
        setWrapperName("EChartsFactory");
    }

    public NewChart(NewPlot plot) {
        setWrapperName("EChartsFactory");
        this.newPlot = plot;
    }

    @Override
    public BaseChartGlyph createGlyph(ChartData chartData) {
        NewGlyph glyph = new NewGlyph();
        glyph.setGeneralInfo(this);
        glyph.setWrapperName(getWrapperName());
        glyph.setChartImagePath(getImagePath());
        glyph.setRequiredJS(getRequiredJS());
        glyph.setJSDraw(isJSDraw());

        return glyph;
    }

    /**
     * �ж�ͼ�������Ƿ���obClass
     * @param obClass �������
     * @return �Ƿ���obClass����
     */
    public boolean accept(Class<? extends Chart> obClass){
        return ComparatorUtils.equals(NewChart.class, obClass);
    }
}
