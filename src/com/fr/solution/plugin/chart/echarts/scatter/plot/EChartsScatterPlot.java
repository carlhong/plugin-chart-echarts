package com.fr.solution.plugin.chart.echarts.scatter.plot;

import com.fr.base.chart.chartdata.ChartData;
import com.fr.chart.chartattr.Plot;
import com.fr.chart.chartdata.NormalChartData;
import com.fr.chart.chartglyph.DataPoint;
import com.fr.chart.chartglyph.DataSeries;
import com.fr.chart.chartglyph.LegendItem;
import com.fr.chart.chartglyph.PlotGlyph;
import com.fr.general.ComparatorUtils;
import com.fr.general.Inter;
import com.fr.solution.plugin.chart.echarts.common.glyph.EChartsLegendGlyph;
import com.fr.solution.plugin.chart.echarts.common.plot.EChartsPlot;
import com.fr.solution.plugin.chart.echarts.scatter.glyph.EChartsScatterPlotGlyph;
import com.fr.solution.plugin.chart.echarts.scatter.legend.EChartsScatterLegend;
import com.fr.solution.plugin.chart.echarts.scatter.monitor.MonitorHelper;
import com.fr.stable.StringUtils;
import com.fr.stable.fun.FunctionProcessor;
import com.fr.stable.xml.XMLPrintWriter;
import com.fr.stable.xml.XMLableReader;

import java.util.ArrayList;

public class EChartsScatterPlot extends EChartsPlot {

    public static final String PLOT_ID = "EChartsScatterPlot";


    private RoseType scatterType;

    private EChartsScatterLegend EChartsScatterLegend;

    public EChartsScatterPlot() {
        this(RoseType.NONE);
        this.EChartsScatterLegend = new EChartsScatterLegend();
    }

    public EChartsScatterPlot(RoseType scatterType) {
        this.scatterType = scatterType;
        this.EChartsScatterLegend = new EChartsScatterLegend();
    }

    public RoseType getScatterType() {
        return scatterType;
    }

    @Override
    public PlotGlyph createPlotGlyph(ChartData chartData) {
        PlotGlyph glyph = new EChartsScatterPlotGlyph(scatterType );
        install4PlotGlyph(glyph, chartData);
        return glyph;
    }

    public EChartsScatterLegend getScatterLegend() {
        return EChartsScatterLegend;
    }

    @Override
    public EChartsLegendGlyph createLegendGlyph(PlotGlyph plotGlyph) {
        EChartsScatterLegend legend = getScatterLegend();
        if (legend == null) {
            legend = new EChartsScatterLegend();
            setLegend(legend);
        }
        return legend.createLegendGlyph(createLegendItems(plotGlyph));
    }

    @Override
    public LegendItem[] createLegendItems(PlotGlyph var1) {
        return var1 == null?new LegendItem[0]:this.createLegendItems(var1, var1.getSeriesSize());
    }

    @Override
    public LegendItem[] createLegendItems(PlotGlyph var1, int var2) {
        ArrayList List = new ArrayList();
        int cn = var1.getCategoryCount();
        for (int c = 0; c < cn; c++) {
            for (int i = 0; i < var2; i++) {
                DataSeries series = var1.getSeries(i);
                if (series.getDataPointCount() > 0) {
                    DataPoint dataPoint = series.getDataPoint(c);
                    if(!List.contains(dataPoint.getCategoryName())) {
                        List.add(dataPoint.getCategoryName());
                    }
                }
            }
        }
        LegendItem[] var3 = new LegendItem[List.size()];
        int var5 = 0;
        for(int var6 = 0; var5 < List.size(); ++var6) {
            var3[var6] = new LegendItem(String.valueOf(List.get(var6)));
            ++var5;
        }
        return var3;
    }

    @Override
    public String getPlotID() {
        return PLOT_ID;
    }

    @Override
    public boolean matchPlotType(Plot newPlot) {
        return newPlot instanceof EChartsScatterPlot;
    }

    @Override
    public ChartData defaultChartData() {
        return new NormalChartData();
    }

    @Override
    public FunctionProcessor getFunctionToRecord() {
        return MonitorHelper.BAR;
    }

    public boolean accept(Class<? extends Plot> obClass) {
        return ComparatorUtils.equals(EChartsScatterPlot.class, obClass);
    }

    @Override
    public String getPlotName() {
        return Inter.getLocText("Plugin-ECharts_Scatter");
    }

    protected void readPlotXML(XMLableReader reader) {
        super.readPlotXML(reader);
        if (reader.isChildNode()) {
            String tagName = reader.getTagName();

            if (tagName.equals("ScatterAttr4ECharts")) {
                scatterType = RoseType.parse(reader.getAttrAsString("scatterType", StringUtils.EMPTY));
            }
        }
    }


    @Override
    public void writeXML(XMLPrintWriter writer) {
        super.writeXML(writer);
        writer.startTAG("ScatterAttr4ECharts");
        writer.attr("scatterType", scatterType.toTypeString());
        writer.end();
    }

    @Override
    public boolean equals(Object ob) {
        return ob instanceof EChartsScatterPlot
                && super.equals(ob)
                && ComparatorUtils.equals(((EChartsScatterPlot) ob).scatterType, scatterType);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        EChartsScatterPlot cloned = (EChartsScatterPlot) super.clone();
        cloned.scatterType = scatterType;
        return cloned;
    }
}
