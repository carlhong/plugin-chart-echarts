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
import com.fr.solution.plugin.chart.echarts.bar.glyph.EChartsBarGlyph;
import com.fr.solution.plugin.chart.echarts.common.data.EChartsMoreNameCDDefinition;
import com.fr.solution.plugin.chart.echarts.common.data.EChartsNormalReportDataDefinition;
import com.fr.solution.plugin.chart.echarts.common.data.EChartsOneValueCDDefinition;
import com.fr.solution.plugin.chart.echarts.common.glyph.EChartsGlyph;
import com.fr.solution.plugin.chart.echarts.common.glyph.EChartsLegendGlyph;
import com.fr.solution.plugin.chart.echarts.common.glyph.EChartsTitleGlyph;
import com.fr.solution.plugin.chart.echarts.common.legend.EChartsLegend;
import com.fr.solution.plugin.chart.echarts.common.plot.EChartsPlot;
import com.fr.solution.plugin.chart.echarts.common.theme.EChartsTheme;
import com.fr.solution.plugin.chart.echarts.common.title.EChartsTitle;
import com.fr.solution.plugin.chart.echarts.common.toolbox.EChartsToolbox;
import com.fr.solution.plugin.chart.echarts.common.tooltip.EChartsTooltip;
import com.fr.solution.plugin.chart.echarts.line.glyph.EChartsLineGlyph;
import com.fr.solution.plugin.chart.echarts.scatter.glyph.EChartsScatterGlyph;
import com.fr.stable.fun.FunctionHelper;
import com.fr.stable.fun.FunctionProcessor;
import com.fr.stable.fun.impl.AbstractFunctionProcessor;
import com.fr.stable.xml.XMLPrintWriter;
import com.fr.stable.xml.XMLReadable;
import com.fr.stable.xml.XMLableReader;

/**
 * Created by richie on 16/1/29.
 */
public class ECharts extends Chart {

    private static final FunctionProcessor P = new AbstractFunctionProcessor() {
        @Override
        public int getId() {
            return FunctionHelper.generateFunctionID("com.fr.solution.plugin.chart.echarts");
        }

        @Override
        public String getLocaleKey() {
            return "ECharts";
        }
    };

    private EChartsLegend legend;
    private EChartsTheme theme;
    private EChartsTooltip tooltip;
    private EChartsToolbox toolbox;

    public ECharts() {
        this(null);
    }

    public ECharts(EChartsPlot plot) {
        super(plot);
        setWrapperName("EChartsFactory");
        setTitle(new EChartsTitle());
        setLegend(new EChartsLegend());
        setTooltip(new EChartsTooltip());
        setToolbox(new EChartsToolbox());
    }

    public EChartsLegend getLegend() {
        return legend;
    }

    public void setLegend(EChartsLegend legend) {
        this.legend = legend;
    }

    public EChartsTheme getTheme() {
        return theme;
    }

    public void setTheme(EChartsTheme theme) {
        this.theme = theme;
    }

    public EChartsTooltip getTooltip() {
        return tooltip;
    }

    public void setTooltip(EChartsTooltip tooltip) {
        this.tooltip = tooltip;
    }

    public EChartsToolbox getToolbox() {
        return toolbox;
    }

    public void setToolbox(EChartsToolbox toolbox) {
        this.toolbox = toolbox;
    }

    @Override
        public BaseChartGlyph createGlyph(ChartData chartData) {
        EChartsGlyph glyph = new EChartsGlyph();
        switch (this.getPlotType()) {
            case "EChartsBarPlot":
                glyph = new EChartsBarGlyph();
                break;
            case "EChartsLinePlot":
                glyph = new EChartsLineGlyph();
                break;
            case "EChartsScatterPlot":
                glyph = new EChartsScatterGlyph();
                break;
            default:
        }
        glyph.setGeneralInfo(this);
        EChartsPlot EChartsPlot = (EChartsPlot) getPlot();
        if (EChartsPlot != null) {
            PlotGlyph plotGlyph = EChartsPlot.createPlotGlyph(chartData);
            glyph.setPlotGlyph(plotGlyph);
            EChartsLegendGlyph legendGlyph = EChartsPlot.createLegendGlyph(plotGlyph);
            glyph.setLegendGlyph(legendGlyph);
        }
        EChartsTitle title = (EChartsTitle) getTitle();
        if (title != null) {
            EChartsTitleGlyph titleGlyph = title.createGlyph();
            glyph.setTitleGlyph(titleGlyph);
        }

        glyph.setWrapperName(getWrapperName());
        glyph.setChartImagePath(getImagePath());
        glyph.setRequiredJS(getRequiredJS());
        glyph.setJSDraw(isJSDraw());

        if (theme != null) {
            glyph.setTheme(theme);
        }
        if (tooltip != null) {
            glyph.setTooltip(tooltip);
        }
        if (toolbox != null) {
            glyph.setToolbox(toolbox);
        }

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
            } else if (ComparatorUtils.equals(tmpNodeName, "ChartDefinition")) {
                reader.readXMLObject(new XMLReadable() {
                    public void readXML(XMLableReader reader) {
                        setFilterDefinition(readDefinition(reader));
                    }
                });
            } else if (tmpNodeName.equals(EChartsTheme.XML_TAG)) {
                theme = (EChartsTheme) GeneralXMLTools.readXMLable(reader);
            } else if (tmpNodeName.equals(EChartsTooltip.XML_TAG)) {
                tooltip = (EChartsTooltip) GeneralXMLTools.readXMLable(reader);
            } else if (tmpNodeName.equals(EChartsToolbox.XML_TAG)) {
                toolbox = (EChartsToolbox) GeneralXMLTools.readXMLable(reader);
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
        if (theme != null) {
            GeneralXMLTools.writeXMLable(writer, theme, EChartsTheme.XML_TAG);
        }
        if (tooltip != null) {
            GeneralXMLTools.writeXMLable(writer, tooltip, EChartsTooltip.XML_TAG);
        }
        if (toolbox != null) {
            GeneralXMLTools.writeXMLable(writer, toolbox, EChartsToolbox.XML_TAG);
        }
    }

    @Override
    public boolean equals(Object ob) {
        return ob instanceof ECharts
                && super.equals(ob)
                && ComparatorUtils.equals(theme, ((ECharts) ob).theme)
                && ComparatorUtils.equals(tooltip, ((ECharts) ob).tooltip)
                && ComparatorUtils.equals(toolbox, ((ECharts) ob).toolbox);
    }
}