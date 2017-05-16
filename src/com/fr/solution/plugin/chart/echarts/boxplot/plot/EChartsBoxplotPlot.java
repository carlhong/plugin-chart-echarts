package com.fr.solution.plugin.chart.echarts.boxplot.plot;

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
import com.fr.solution.plugin.chart.echarts.boxplot.glyph.EChartsBoxplotPlotGlyph;
import com.fr.solution.plugin.chart.echarts.boxplot.legend.EChartsBoxplotLegend;
import com.fr.solution.plugin.chart.echarts.boxplot.monitor.MonitorHelper;
import com.fr.stable.StringUtils;
import com.fr.stable.fun.FunctionProcessor;
import com.fr.stable.xml.XMLPrintWriter;
import com.fr.stable.xml.XMLableReader;

import java.util.ArrayList;

public class EChartsBoxplotPlot extends EChartsPlot {

    public static final String PLOT_ID = "EChartsBoxplotPlot";


    private RoseType boxplotType;

    private EChartsBoxplotLegend EChartsBoxplotLegend;

    public EChartsBoxplotPlot() {
        this(RoseType.NONE);
        this.EChartsBoxplotLegend = new EChartsBoxplotLegend();
    }

    public EChartsBoxplotPlot(RoseType boxplotType) {
        this.boxplotType = boxplotType;
        this.EChartsBoxplotLegend = new EChartsBoxplotLegend();
    }

    public RoseType getBoxplotType() {
        return boxplotType;
    }

    @Override
    public PlotGlyph createPlotGlyph(ChartData chartData) {
        PlotGlyph glyph = new EChartsBoxplotPlotGlyph(boxplotType );
        install4PlotGlyph(glyph, chartData);
        return glyph;
    }

    public EChartsBoxplotLegend getBoxplotLegend() {
        return EChartsBoxplotLegend;
    }

    @Override
    public EChartsLegendGlyph createLegendGlyph(PlotGlyph plotGlyph) {
        EChartsBoxplotLegend legend = getBoxplotLegend();
        if (legend == null) {
            legend = new EChartsBoxplotLegend();
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
                    if (!List.contains(dataPoint.getCategoryName())) {
                        List.add(dataPoint.getCategoryName());
                    }
                }
            }
        }
        LegendItem[] var3 = new LegendItem[List.size()];
        int var5 = 0;
        for (int var6 = 0; var5 < List.size(); ++var6) {
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
        return newPlot instanceof EChartsBoxplotPlot;
    }

    @Override
    public ChartData defaultChartData() {
        return new NormalChartData();
    }

    @Override
    public FunctionProcessor getFunctionToRecord() {
        return MonitorHelper.BOXPLOT;
    }

    public boolean accept(Class<? extends Plot> obClass) {
        return ComparatorUtils.equals(EChartsBoxplotPlot.class, obClass);
    }

    @Override
    public String getPlotName() {
        return Inter.getLocText("Plugin-ECharts_Boxplot");
    }

    protected void readPlotXML(XMLableReader reader) {
        super.readPlotXML(reader);
        if (reader.isChildNode()) {
            String tagName = reader.getTagName();

            if (tagName.equals("BoxplotAttr4ECharts")) {
                boxplotType = RoseType.parse(reader.getAttrAsString("boxplotType", StringUtils.EMPTY));
            }
        }
    }


    @Override
    public void writeXML(XMLPrintWriter writer) {
        super.writeXML(writer);
        writer.startTAG("BoxplotAttr4ECharts");
        writer.attr("boxplotType", boxplotType.toTypeString());
        writer.end();
    }

    @Override
    public boolean equals(Object ob) {
        return ob instanceof EChartsBoxplotPlot
                && super.equals(ob)
                && ComparatorUtils.equals(((EChartsBoxplotPlot) ob).boxplotType, boxplotType);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        EChartsBoxplotPlot cloned = (EChartsBoxplotPlot) super.clone();
        cloned.boxplotType = boxplotType;
        return cloned;
    }
}
