package com.fr.solution.plugin.chart.echarts.base;

import com.fr.base.chart.BaseChartGlyph;
import com.fr.base.chart.chartdata.ChartData;
import com.fr.chart.chartattr.Chart;
import com.fr.chart.chartattr.Plot;
import com.fr.general.ComparatorUtils;

/**
 * Created by richie on 16/1/29.
 */
public class NewChart extends Chart {

    public NewChart() {
        setWrapperName("EChartsFactory");
    }

    public NewChart(Plot plot) {
        setPlot(plot);
        setWrapperName("EChartsFactory");
    }

    @Override
    public BaseChartGlyph createGlyph(ChartData chartData) {
        NewChartGlyph glyph = new NewChartGlyph();
        glyph.setGeneralInfo(this);
        glyph.setWrapperName(wrapperName);
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
