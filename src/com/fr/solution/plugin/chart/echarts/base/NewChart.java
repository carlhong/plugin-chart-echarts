package com.fr.solution.plugin.chart.echarts.base;

import com.fr.base.chart.BaseChartGlyph;
import com.fr.base.chart.chartdata.ChartData;
import com.fr.chart.chartattr.Chart;
import com.fr.chart.chartattr.Plot;
import com.fr.chart.chartglyph.PlotGlyph;
import com.fr.general.ComparatorUtils;
import com.fr.general.xml.GeneralXMLTools;
import com.fr.solution.plugin.chart.echarts.glyph.NewGlyph;
import com.fr.solution.plugin.chart.echarts.glyph.NewLegendGlyph;
import com.fr.solution.plugin.chart.echarts.glyph.NewTitleGlyph;
import com.fr.solution.plugin.chart.echarts.plot.NewPlot;
import com.fr.solution.plugin.chart.echarts.title.NewTitle;
import com.fr.stable.xml.XMLReadable;
import com.fr.stable.xml.XMLableReader;

/**
 * Created by richie on 16/1/29.
 */
public class NewChart extends Chart {


    public NewChart() {
        setWrapperName("EChartsFactory");
        setTitle(new NewTitle());
    }

    public NewChart(NewPlot plot) {
        super(plot);
        setWrapperName("EChartsFactory");
        setTitle(new NewTitle());
    }

    @Override
    public BaseChartGlyph createGlyph(ChartData chartData) {
        NewGlyph glyph = new NewGlyph();
        glyph.setGeneralInfo(this);
        NewPlot newPlot = (NewPlot) getPlot();
        if (newPlot != null) {
            PlotGlyph plotGlyph = newPlot.createPlotGlyph(chartData);
            NewLegendGlyph legendGlyph = newPlot.createLegendGlyph(plotGlyph);
            glyph.setLegendGlyph(legendGlyph);
        }
        NewTitle title = (NewTitle)getTitle();
        if (title != null) {
            NewTitleGlyph titleGlyph = title.createGlyph();
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
        return ComparatorUtils.equals(NewChart.class, obClass);
    }


    @Override
    protected void readChartXML(XMLableReader reader) {
        if (reader.isChildNode()) {
            String tmpNodeName = reader.getTagName();

            if (tmpNodeName.equals(NewTitle.XML_TAG)) {
                setTitle(new NewTitle());
                reader.readXMLObject(getTitle());
            } else if (tmpNodeName.equals(Plot.XML_TAG)) {
                setPlot((Plot) GeneralXMLTools.readXMLable(reader));
            }
        }
    }

}