package com.fr.solution.plugin.chart.echarts.pie.glyph;

import com.fr.chart.chartglyph.DataPoint;
import com.fr.chart.chartglyph.DataSeries;
import com.fr.json.JSONArray;
import com.fr.json.JSONException;
import com.fr.json.JSONFunction;
import com.fr.json.JSONObject;
import com.fr.solution.plugin.chart.echarts.common.glyph.EChartsPlotGlyph;
import com.fr.solution.plugin.chart.echarts.pie.plot.RoseType;
import com.fr.stable.web.Repository;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Created by richie on 16/2/18.
 */
public class EChartsPiePlotGlyph extends EChartsPlotGlyph {

    private static final NumberFormat format = new DecimalFormat("##%");

    private RoseType roseType;

    public EChartsPiePlotGlyph() {
        this(RoseType.NONE);
    }

    public EChartsPiePlotGlyph(RoseType roseType) {
        this.roseType = roseType;
    }

    @Override
    public String getPlotGlyphType() {
        return "EChartsPiePlotGlyph";
    }

    @Override
    public String getChartType() {
        return "EChartsPie";
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
            wrapper.put("type", "pie");
            if (cn > 1) {
                wrapper.put("radius", r);
                wrapper.put("center", JSONArray.create().put(format.format(1.0 * c / (cn + 1) + 0.20)).put("55%"));
            }
            wrapper.put("roseType", roseType.toTypeString());
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
}
