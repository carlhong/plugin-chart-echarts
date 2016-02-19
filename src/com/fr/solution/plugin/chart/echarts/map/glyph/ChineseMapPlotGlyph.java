package com.fr.solution.plugin.chart.echarts.map.glyph;

import com.fr.json.JSONArray;
import com.fr.json.JSONException;
import com.fr.json.JSONObject;
import com.fr.solution.plugin.chart.echarts.common.glyph.EChartsPlotGlyph;
import com.fr.stable.web.Repository;

/**
 * Created by richie on 16/1/29.
 */
public class ChineseMapPlotGlyph extends EChartsPlotGlyph {
    @Override
    public void layoutAxisGlyph(int resolution) {

    }

    @Override
    public void layoutDataSeriesGlyph(int resolution) {

    }

    @Override
    public String getPlotGlyphType() {
        return "ChineseMapPlotGlyph";
    }

    @Override
    public String getChartType() {
        return "ChineseMap";
    }

    public JSONArray toSeriesData(Repository repo) throws JSONException {
        JSONArray series = JSONArray.create();

        series.put(JSONObject.create()
                .put("name", "iPhone3")
                .put("type", "map")
                .put("mapType", "china")
                .put("itemStyle", createItemStyle(repo))
                .put("data", JSONArray.create().put(JSONObject.create().put("name", "北京").put("value", 20)))
        );

        series.put(JSONObject.create()
                .put("name", "iPhone4")
                .put("type", "map")
                .put("mapType", "china")
                .put("itemStyle", createItemStyle(repo))
                .put("data", JSONArray.create()
                        .put(JSONObject.create().put("name", "江苏").put("value", 20))
                        .put(JSONObject.create().put("name", "四川").put("value", 300))
                )
        );

        series.put(JSONObject.create()
                .put("name", "iPhone5")
                .put("type", "map")
                .put("mapType", "china")
                .put("itemStyle", createItemStyle(repo))
                .put("data", JSONArray.create().put(JSONObject.create().put("name", "四川").put("value", 20)))
        );

        return series;
    }

    private JSONObject createItemStyle(Repository repo) throws JSONException {
        JSONObject itemStyle = JSONObject.create();
        itemStyle.put("normal", JSONObject.create().put("label", JSONObject.create().put("show", true)));
        itemStyle.put("emphasis", JSONObject.create().put("label", JSONObject.create().put("show", true)));
        return itemStyle;
    }
}