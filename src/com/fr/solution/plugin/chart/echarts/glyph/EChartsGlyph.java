package com.fr.solution.plugin.chart.echarts.glyph;

import com.fr.chart.chartglyph.ChartGlyph;
import com.fr.json.JSONArray;
import com.fr.json.JSONException;
import com.fr.json.JSONObject;
import com.fr.stable.web.Repository;

/**
 * Created by richie on 16/1/29.
 */
public class EChartsGlyph extends ChartGlyph {

    @Override
    public JSONObject toJSONObject(Repository repo) throws JSONException {
        JSONObject jo = new JSONObject();
        EChartsTitleGlyph titleGlyph = (EChartsTitleGlyph) getTitleGlyph();
        if (titleGlyph != null) {
            jo.put("title", titleGlyph.toJSONObject(repo));
        }
        jo.put("tooltip", createTooltip(repo));

        EChartsLegendGlyph legendGlyph = (EChartsLegendGlyph) getLegendGlyph();
        if (legendGlyph != null) {
            jo.put("legend", legendGlyph.toJSONObject(repo));
        }
        jo.put("dataRange", createDataRange(repo));
        EChartsPlotGlyph plotGlyph = (EChartsPlotGlyph) getPlotGlyph();
        if (plotGlyph != null) {
            jo.put("series", plotGlyph.toSeriesData(repo));
        }
        return jo;
    }


    private JSONObject createTooltip(Repository repo) throws JSONException {
        return JSONObject.create()
                .put("trigger", "item");
    }


    private JSONObject createDataRange(Repository repo) throws JSONException {
        return JSONObject.create()
                .put("min", 0)
                .put("max", 2500)
                .put("x", "left")
                .put("y", "bottom")
                .put("text", JSONArray.create().put("高").put("低"));
    }
}