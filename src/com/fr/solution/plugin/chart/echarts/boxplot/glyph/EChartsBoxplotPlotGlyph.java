package com.fr.solution.plugin.chart.echarts.boxplot.glyph;

import com.fr.chart.chartglyph.DataPoint;
import com.fr.chart.chartglyph.DataSeries;
import com.fr.json.JSONArray;
import com.fr.json.JSONException;
import com.fr.json.JSONObject;
import com.fr.solution.plugin.chart.echarts.common.glyph.EChartsPlotGlyph;
import com.fr.solution.plugin.chart.echarts.boxplot.plot.RoseType;
import com.fr.stable.web.Repository;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class EChartsBoxplotPlotGlyph extends EChartsPlotGlyph {

    private static final NumberFormat format = new DecimalFormat("##%");

    private RoseType roseType;

    public EChartsBoxplotPlotGlyph() {
        this(RoseType.NONE);
    }

    public EChartsBoxplotPlotGlyph(RoseType roseType) {
        this.roseType = roseType;
    }

    @Override
    public String getPlotGlyphType() {
        return "EChartsBoxplotPlotGlyph";
    }

    @Override
    public String getChartType() {
        return "EChartsBoxplot";
    }

    public JSONArray toSeriesData(Repository repo) throws JSONException {
        JSONArray result = JSONArray.create();
        int cn = getCategoryCount();
        String r = "100%";
        if (cn > 1) {
            r = format.format(1.0 / (cn + 1));
        }
        for (int c = 0; c < cn; c++) {
            JSONObject wrapper = JSONObject.create();
            result.put(wrapper);
            wrapper.put("type", "boxplot");
            if (cn > 1) {
                wrapper.put("radius", r);
                wrapper.put("center", JSONArray.create().put(format.format(1.0 * c / (cn + 1) + 0.20)).put("55%"));
            }
            wrapper.put("itemStyle",
                    JSONObject.create().put("normal",
                            JSONObject.create().put("label",
                                    JSONObject.create().put("formatter", "{c}"))));
            JSONArray data = JSONArray.create();
            wrapper.put("data", data);
            for (int i = 0, len = getSeriesSize(); i < len; i++) {
                DataSeries series = getSeries(i);
                String name = series.getSeriesName();
                JSONObject item = JSONObject.create();
                data.put(item);
                item.put("name", name);
                if (series.getDataPointCount() > 0) {
                    DataPoint dataPoint = series.getDataPoint(c);
                    item.put("value", dataPoint.getValue());
                    wrapper.put("name", dataPoint.getCategoryName());
                }
            }
        }
        return result;
    }

    public JSONObject toXAxisData(Repository repo) throws JSONException {
        JSONObject result = JSONObject.create();
            JSONArray data = JSONArray.create();
            result.put("data", data);

            for (int i = 0, len = getSeriesSize(); i < len; i++) {
                DataSeries series = getSeries(i);
                String name = series.getSeriesName();
                data.put(name);
            }
        return result;
    }


    public JSONObject toYAxisData(Repository repo) throws JSONException {
        return JSONObject.create();
    }

    public JSONObject dataZoom(Repository repo) throws JSONException {
        JSONObject dataZoom = JSONObject.create();
        dataZoom.put("type", "inside");
        return dataZoom;
    }
}
