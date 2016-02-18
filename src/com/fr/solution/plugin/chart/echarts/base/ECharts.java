package com.fr.solution.plugin.chart.echarts.base;

import com.fr.base.chart.BaseChartGlyph;
import com.fr.base.chart.chartdata.ChartData;
import com.fr.chart.chartattr.Chart;
import com.fr.chart.chartattr.Plot;
import com.fr.chart.chartglyph.PlotGlyph;
import com.fr.general.ComparatorUtils;
import com.fr.general.xml.GeneralXMLTools;
import com.fr.solution.plugin.chart.echarts.glyph.EChartsGlyph;
import com.fr.solution.plugin.chart.echarts.glyph.EChartsLegendGlyph;
import com.fr.solution.plugin.chart.echarts.glyph.EChartsTitleGlyph;
import com.fr.solution.plugin.chart.echarts.plot.EChartsPlot;
import com.fr.solution.plugin.chart.echarts.title.EChartsTitle;
import com.fr.stable.xml.XMLableReader;

/**
 * Created by richie on 16/1/29.
 */
public class ECharts extends Chart {


    public ECharts() {
        setWrapperName("EChartsFactory");
        setTitle(new EChartsTitle());
    }

    public ECharts(EChartsPlot plot) {
        super(plot);
        setWrapperName("EChartsFactory");
        setTitle(new EChartsTitle());
    }

    @Override
    public BaseChartGlyph createGlyph(ChartData chartData) {
        EChartsGlyph glyph = new EChartsGlyph();
        glyph.setGeneralInfo(this);
        EChartsPlot EChartsPlot = (EChartsPlot) getPlot();
        if (EChartsPlot != null) {
            PlotGlyph plotGlyph = EChartsPlot.createPlotGlyph(chartData);
            glyph.setPlotGlyph(plotGlyph);
            EChartsLegendGlyph legendGlyph = EChartsPlot.createLegendGlyph(plotGlyph);
            glyph.setLegendGlyph(legendGlyph);
        }
        EChartsTitle title = (EChartsTitle)getTitle();
        if (title != null) {
            EChartsTitleGlyph titleGlyph = title.createGlyph();
            glyph.setTitleGlyph(titleGlyph);
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
        return ComparatorUtils.equals(ECharts.class, obClass);
    }


    @Override
    protected void readChartXML(XMLableReader reader) {
        if (reader.isChildNode()) {
            String tmpNodeName = reader.getTagName();

            if (tmpNodeName.equals(EChartsTitle.XML_TAG)) {
                setTitle(new EChartsTitle());
                reader.readXMLObject(getTitle());
            } else if (tmpNodeName.equals(Plot.XML_TAG)) {
                setPlot((Plot) GeneralXMLTools.readXMLable(reader));
            }
        }
    }

}