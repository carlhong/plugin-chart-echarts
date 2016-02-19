package com.fr.solution.plugin.chart.echarts.pie.glyph;

import com.fr.chart.chartglyph.DataPoint;
import com.fr.chart.chartglyph.DataSeries;
import com.fr.json.JSONArray;
import com.fr.json.JSONException;
import com.fr.json.JSONFunction;
import com.fr.json.JSONObject;
import com.fr.solution.plugin.chart.echarts.common.glyph.EChartsPlotGlyph;
import com.fr.stable.web.Repository;

/**
 * Created by richie on 16/2/18.
 */
public class EChartsPiePlotGlyph extends EChartsPlotGlyph {
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
        JSONObject wrapper = JSONObject.create();
        result.put(wrapper);
        wrapper.put("type", "pie");
        wrapper.put("itemStyle",
                JSONObject.create().put("normal",
                        JSONObject.create().put("label",
                                JSONObject.create().put("formatter", "{c}"))));
        JSONArray data = JSONArray.create();
        wrapper.put("data", data);
        for (int i = 0, len = getSeriesSize(); i < len; i ++) {
            DataSeries series = getSeries(i);
            String name = series.getSeriesName();
            JSONObject item = JSONObject.create();
            data.put(item);

            item.put("name", name);
            if (series.getDataPointCount() > 0) {
                DataPoint dataPoint = series.getDataPoint(0);
                item.put("value", dataPoint.getValue());
            }
        }
        return result;
    }
}
