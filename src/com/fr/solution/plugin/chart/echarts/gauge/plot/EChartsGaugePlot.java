package com.fr.solution.plugin.chart.echarts.gauge.plot;

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
import com.fr.solution.plugin.chart.echarts.gauge.glyph.EChartsGaugePlotGlyph;
import com.fr.solution.plugin.chart.echarts.gauge.legend.EChartsGaugeLegend;
import com.fr.solution.plugin.chart.echarts.gauge.monitor.MonitorHelper;
import com.fr.stable.StringUtils;
import com.fr.stable.fun.FunctionProcessor;
import com.fr.stable.xml.XMLPrintWriter;
import com.fr.stable.xml.XMLableReader;

import java.util.ArrayList;

public class EChartsGaugePlot extends EChartsPlot {

    public static final String PLOT_ID = "EChartsGaugePlot";


    private RoseType gaugeType;

    private EChartsGaugeLegend EChartsGaugeLegend;

    public EChartsGaugePlot() {
        this(RoseType.NONE);
        this.EChartsGaugeLegend = new EChartsGaugeLegend();
    }

    public EChartsGaugePlot(RoseType gaugeType) {
        this.gaugeType = gaugeType;
        this.EChartsGaugeLegend = new EChartsGaugeLegend();
    }

    public RoseType getGaugeType() {
        return gaugeType;
    }

    @Override
    public PlotGlyph createPlotGlyph(ChartData chartData) {
        PlotGlyph glyph = new EChartsGaugePlotGlyph(gaugeType );
        install4PlotGlyph(glyph, chartData);
        return glyph;
    }

    public EChartsGaugeLegend getGaugeLegend() {
        return EChartsGaugeLegend;
    }

    @Override
    public EChartsLegendGlyph createLegendGlyph(PlotGlyph plotGlyph) {
        EChartsGaugeLegend legend = getGaugeLegend();
        if (legend == null) {
            legend = new EChartsGaugeLegend();
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
        return newPlot instanceof EChartsGaugePlot;
    }

    @Override
    public ChartData defaultChartData() {
        return new NormalChartData();
    }

    @Override
    public FunctionProcessor getFunctionToRecord() {
        return MonitorHelper.GAUGE;
    }

    public boolean accept(Class<? extends Plot> obClass) {
        return ComparatorUtils.equals(EChartsGaugePlot.class, obClass);
    }

    @Override
    public String getPlotName() {
        return Inter.getLocText("Plugin-ECharts_Gauge");
    }

    protected void readPlotXML(XMLableReader reader) {
        super.readPlotXML(reader);
        if (reader.isChildNode()) {
            String tagName = reader.getTagName();

            if (tagName.equals("GaugeAttr4ECharts")) {
                gaugeType = RoseType.parse(reader.getAttrAsString("gaugeType", StringUtils.EMPTY));
            }
        }
    }


    @Override
    public void writeXML(XMLPrintWriter writer) {
        super.writeXML(writer);
        writer.startTAG("GaugeAttr4ECharts");
        writer.attr("gaugeType", gaugeType.toTypeString());
        writer.end();
    }

    @Override
    public boolean equals(Object ob) {
        return ob instanceof EChartsGaugePlot
                && super.equals(ob)
                && ComparatorUtils.equals(((EChartsGaugePlot) ob).gaugeType, gaugeType);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        EChartsGaugePlot cloned = (EChartsGaugePlot) super.clone();
        cloned.gaugeType = gaugeType;
        return cloned;
    }
}
