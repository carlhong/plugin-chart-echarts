package com.fr.solution.plugin.chart.echarts.common.base;

import com.fr.base.chart.BaseChartGlyph;
import com.fr.base.chart.chartdata.ChartData;
import com.fr.chart.chartattr.Chart;
import com.fr.chart.chartattr.ChartXMLCompatibleUtils;
import com.fr.chart.chartattr.Plot;
import com.fr.chart.chartdata.TopDefinition;
import com.fr.chart.chartglyph.PlotGlyph;
import com.fr.general.ComparatorUtils;
import com.fr.general.xml.GeneralXMLTools;
import com.fr.solution.plugin.chart.echarts.common.data.EChartsMoreNameCDDefinition;
import com.fr.solution.plugin.chart.echarts.common.data.EChartsNormalReportDataDefinition;
import com.fr.solution.plugin.chart.echarts.common.data.EChartsOneValueCDDefinition;
import com.fr.solution.plugin.chart.echarts.common.glyph.EChartsGlyph;
import com.fr.solution.plugin.chart.echarts.common.glyph.EChartsLegendGlyph;
import com.fr.solution.plugin.chart.echarts.common.glyph.EChartsTitleGlyph;
import com.fr.solution.plugin.chart.echarts.common.plot.EChartsPlot;
import com.fr.solution.plugin.chart.echarts.common.title.EChartsTitle;
import com.fr.stable.xml.XMLPrintWriter;
import com.fr.stable.xml.XMLReadable;
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
            } else if (tmpNodeName.equals("ChartAttr")) {
                this.setJSDraw(reader.getAttrAsBoolean("isJSDraw", true));
                this.setStyleGlobal(reader.getAttrAsBoolean("isStyleGlobal",false));
            } else if(ComparatorUtils.equals(tmpNodeName, "ChartDefinition")) {
                reader.readXMLObject(new XMLReadable() {
                    public void readXML(XMLableReader reader) {
                        setFilterDefinition(readDefinition(reader));
                    }
                });
            }
        }
    }

    public static TopDefinition readDefinition(XMLableReader reader) {
        TopDefinition filterDefinition;
        String tmpNodeName = reader.getTagName();
        if (EChartsOneValueCDDefinition.XML_TAG.equals(tmpNodeName)) {
            filterDefinition = new EChartsOneValueCDDefinition();
        } else if (EChartsMoreNameCDDefinition.XML_TAG.equals(tmpNodeName)) {
            filterDefinition = new EChartsMoreNameCDDefinition();
        } else if (EChartsNormalReportDataDefinition.XML_TAG.equals(tmpNodeName)) {
            filterDefinition = new EChartsNormalReportDataDefinition();
        }else {
            return ChartXMLCompatibleUtils.readDefinition(reader);
        }

        reader.readXMLObject(filterDefinition);
        return filterDefinition;
    }



    @Override
    public void writeXML(XMLPrintWriter writer) {
        super.writeXML(writer);
    }
}