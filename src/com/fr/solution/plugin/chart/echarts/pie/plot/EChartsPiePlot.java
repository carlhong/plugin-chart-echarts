package com.fr.solution.plugin.chart.echarts.pie.plot;

import com.fr.base.chart.chartdata.ChartData;
import com.fr.chart.chartattr.Plot;
import com.fr.chart.chartdata.NormalChartData;
import com.fr.chart.chartglyph.PlotGlyph;
import com.fr.general.ComparatorUtils;
import com.fr.general.Inter;
import com.fr.solution.plugin.chart.echarts.pie.glyph.EChartsPiePlotGlyph;
import com.fr.solution.plugin.chart.echarts.pie.monitor.MonitorPie;
import com.fr.solution.plugin.chart.echarts.common.plot.EChartsPlot;
import com.fr.stable.StringUtils;
import com.fr.stable.fun.FunctionProcessor;
import com.fr.stable.xml.XMLPrintWriter;
import com.fr.stable.xml.XMLableReader;

/**
 * Created by richie on 16/2/18.
 */
public class EChartsPiePlot extends EChartsPlot {


    private RoseType pieType;

    public EChartsPiePlot() {
        this(RoseType.NONE);
    }

    public EChartsPiePlot(RoseType pieType) {
        this.pieType = pieType;
    }

    public RoseType getPieType() {
        return pieType;
    }

    @Override
    public PlotGlyph createPlotGlyph(ChartData chartData) {
        PlotGlyph glyph = new EChartsPiePlotGlyph(pieType );
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
                pieType = RoseType.parse(reader.getAttrAsString("pieType", StringUtils.EMPTY));
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

    @Override
    public Object clone() throws CloneNotSupportedException {
        EChartsPiePlot cloned = (EChartsPiePlot) super.clone();
        cloned.pieType = pieType;
        return cloned;
    }
}
