package com.fr.solution.plugin.chart.echarts.funnel.plot;

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
import com.fr.solution.plugin.chart.echarts.funnel.glyph.EChartsFunnelPlotGlyph;
import com.fr.solution.plugin.chart.echarts.funnel.legend.EChartsFunnelLegend;
import com.fr.solution.plugin.chart.echarts.funnel.monitor.MonitorHelper;
import com.fr.stable.StringUtils;
import com.fr.stable.fun.FunctionProcessor;
import com.fr.stable.xml.XMLPrintWriter;
import com.fr.stable.xml.XMLableReader;

import java.util.ArrayList;

public class EChartsFunnelPlot extends EChartsPlot {

    public static final String PLOT_ID = "EChartsFunnelPlot";


    private RoseType funnelType;

    private EChartsFunnelLegend EChartsFunnelLegend;

    public EChartsFunnelPlot() {
        this(RoseType.NONE);
        this.EChartsFunnelLegend = new EChartsFunnelLegend();
    }

    public EChartsFunnelPlot(RoseType funnelType) {
        this.funnelType = funnelType;
        this.EChartsFunnelLegend = new EChartsFunnelLegend();
    }

    public RoseType getFunnelType() {
        return funnelType;
    }

    @Override
    public PlotGlyph createPlotGlyph(ChartData chartData) {
        PlotGlyph glyph = new EChartsFunnelPlotGlyph(funnelType );
        install4PlotGlyph(glyph, chartData);
        return glyph;
    }

    public EChartsFunnelLegend getFunnelLegend() {
        return EChartsFunnelLegend;
    }

    @Override
    public EChartsLegendGlyph createLegendGlyph(PlotGlyph plotGlyph) {
        EChartsFunnelLegend legend = getFunnelLegend();
        if (legend == null) {
            legend = new EChartsFunnelLegend();
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
        return newPlot instanceof EChartsFunnelPlot;
    }

    @Override
    public ChartData defaultChartData() {
        return new NormalChartData();
    }

    @Override
    public FunctionProcessor getFunctionToRecord() {
        return MonitorHelper.FUNNEL;
    }

    public boolean accept(Class<? extends Plot> obClass) {
        return ComparatorUtils.equals(EChartsFunnelPlot.class, obClass);
    }

    @Override
    public String getPlotName() {
        return Inter.getLocText("Plugin-ECharts_Funnel");
    }

    protected void readPlotXML(XMLableReader reader) {
        super.readPlotXML(reader);
        if (reader.isChildNode()) {
            String tagName = reader.getTagName();

            if (tagName.equals("FunnelAttr4ECharts")) {
                funnelType = RoseType.parse(reader.getAttrAsString("funnelType", StringUtils.EMPTY));
            }
        }
    }


    @Override
    public void writeXML(XMLPrintWriter writer) {
        super.writeXML(writer);
        writer.startTAG("FunnelAttr4ECharts");
        writer.attr("funnelType", funnelType.toTypeString());
        writer.end();
    }

    @Override
    public boolean equals(Object ob) {
        return ob instanceof EChartsFunnelPlot
                && super.equals(ob)
                && ComparatorUtils.equals(((EChartsFunnelPlot) ob).funnelType, funnelType);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        EChartsFunnelPlot cloned = (EChartsFunnelPlot) super.clone();
        cloned.funnelType = funnelType;
        return cloned;
    }
}
