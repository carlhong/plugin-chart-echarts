package com.fr.solution.plugin.chart.echarts.plot.pie;

import com.fr.base.chart.chartdata.ChartData;
import com.fr.chart.chartattr.Plot;
import com.fr.chart.chartdata.NormalChartData;
import com.fr.chart.chartglyph.PlotGlyph;
import com.fr.general.ComparatorUtils;
import com.fr.general.Inter;
import com.fr.solution.plugin.chart.echarts.glyph.pie.EChartsPiePlotGlyph;
import com.fr.solution.plugin.chart.echarts.monitor.MonitorPie;
import com.fr.solution.plugin.chart.echarts.plot.EChartsPlot;
import com.fr.stable.StringUtils;
import com.fr.stable.fun.FunctionProcessor;
import com.fr.stable.xml.XMLPrintWriter;
import com.fr.stable.xml.XMLableReader;

/**
 * Created by richie on 16/2/18.
 */
public class EChartsPiePlot extends EChartsPlot {


    private PieType pieType;

    public EChartsPiePlot() {
        this(PieType.REGULAR);
    }

    public EChartsPiePlot(PieType pieType) {
        this.pieType = pieType;
    }

    public void setPieType(PieType pieType) {
        this.pieType = pieType;
    }

    @Override
    public PlotGlyph createPlotGlyph(ChartData chartData) {
        PlotGlyph glyph = new EChartsPiePlotGlyph();
        install4PlotGlyph(glyph, chartData);
        return glyph;
    }

    @Override
    public String getPlotID() {
        return "EChartsPiePlot";
    }

    @Override
    public boolean matchPlotType(Plot newPlot) {
        return newPlot instanceof EChartsPiePlot;
    }

    @Override
    public ChartData defaultChartData() {
        return new NormalChartData();
    }

    @Override
    public FunctionProcessor getFunctionToRecord() {
        return MonitorPie.getInstance();
    }

    public boolean accept(Class<? extends Plot> obClass) {
        return ComparatorUtils.equals(EChartsPiePlot.class, obClass);
    }

    @Override
    public String getPlotName() {
        return Inter.getLocText("Plugin-ECharts_Pie");
    }

    protected void readPlotXML(XMLableReader reader) {
        super.readPlotXML(reader);
        if (reader.isChildNode()) {
            String tagName = reader.getTagName();

            if (tagName.equals("PieAttr4ECharts")) {
                pieType = PieType.parse(reader.getAttrAsString("pieType", StringUtils.EMPTY));
            }
        }
    }


    @Override
    public void writeXML(XMLPrintWriter writer) {
        super.writeXML(writer);
        writer.startTAG("PieAttr4ECharts");
        writer.attr("pieType", pieType.toTypeString());
        writer.end();
    }

    @Override
    public boolean equals(Object ob) {
        return ob instanceof EChartsPiePlot
                && super.equals(ob)
                && ComparatorUtils.equals(((EChartsPiePlot) ob).pieType, pieType);
    }
}
