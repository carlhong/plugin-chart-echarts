package com.fr.solution.plugin.chart.echarts.bar.plot;

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
import com.fr.solution.plugin.chart.echarts.bar.glyph.EChartsBarPlotGlyph;
import com.fr.solution.plugin.chart.echarts.bar.legend.EChartsBarLegend;
import com.fr.solution.plugin.chart.echarts.bar.monitor.MonitorHelper;
import com.fr.stable.StringUtils;
import com.fr.stable.fun.FunctionProcessor;
import com.fr.stable.xml.XMLPrintWriter;
import com.fr.stable.xml.XMLableReader;

import java.util.ArrayList;

public class EChartsBarPlot extends EChartsPlot {

    public static final String PLOT_ID = "EChartsBarPlot";


    private RoseType barType;

    private EChartsBarLegend EChartsBarLegend;

    public EChartsBarPlot() {
        this(RoseType.NONE);
        this.EChartsBarLegend = new EChartsBarLegend();
    }

    public EChartsBarPlot(RoseType barType) {
        this.barType = barType;
        this.EChartsBarLegend = new EChartsBarLegend();
    }

    public RoseType getBarType() {
        return barType;
    }

    @Override
    public PlotGlyph createPlotGlyph(ChartData chartData) {
        PlotGlyph glyph = new EChartsBarPlotGlyph(barType );
        install4PlotGlyph(glyph, chartData);
        return glyph;
    }

    public EChartsBarLegend getBarLegend() {
        return EChartsBarLegend;
    }

    @Override
    public EChartsLegendGlyph createLegendGlyph(PlotGlyph plotGlyph) {
        EChartsBarLegend legend = getBarLegend();
        if (legend == null) {
            legend = new EChartsBarLegend();
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
        return newPlot instanceof EChartsBarPlot;
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
        return ComparatorUtils.equals(EChartsBarPlot.class, obClass);
    }

    @Override
    public String getPlotName() {
        return Inter.getLocText("Plugin-ECharts_Bar");
    }

    protected void readPlotXML(XMLableReader reader) {
        super.readPlotXML(reader);
        if (reader.isChildNode()) {
            String tagName = reader.getTagName();

            if (tagName.equals("BarAttr4ECharts")) {
                barType = RoseType.parse(reader.getAttrAsString("barType", StringUtils.EMPTY));
            }
        }
    }


    @Override
    public void writeXML(XMLPrintWriter writer) {
        super.writeXML(writer);
        writer.startTAG("BarAttr4ECharts");
        writer.attr("barType", barType.toTypeString());
        writer.end();
    }

    @Override
    public boolean equals(Object ob) {
        return ob instanceof EChartsBarPlot
                && super.equals(ob)
                && ComparatorUtils.equals(((EChartsBarPlot) ob).barType, barType);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        EChartsBarPlot cloned = (EChartsBarPlot) super.clone();
        cloned.barType = barType;
        return cloned;
    }
}
