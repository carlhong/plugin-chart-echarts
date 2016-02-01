package com.fr.solution.plugin.chart.echarts.base;

import com.fr.chart.chartglyph.ChartGlyph;
import com.fr.json.JSONArray;
import com.fr.json.JSONException;
import com.fr.json.JSONObject;
import com.fr.stable.web.Repository;

/**
 * Created by richie on 16/1/29.
 */
public class NewChartGlyph extends ChartGlyph {

    @Override
    public JSONObject toJSONObject(Repository repo) throws JSONException {
        JSONObject jo = new JSONObject();
        jo.put("title", createTitle(repo));
        jo.put("tooltip", createTooltip(repo));
        jo.put("legend", createLegend(repo));
        jo.put("dataRange", createDataRange(repo));
        jo.put("series", createSeries(repo));
        return jo;
    }

    private JSONObject createTitle(Repository repo) throws JSONException {
        return JSONObject.create()
                .put("text", "iPhone销量")
                .put("subtext", "纯属虚构")
                .put("x", "center");
    }

    private JSONObject createTooltip(Repository repo) throws JSONException {
        return JSONObject.create()
                .put("trigger", "item");
    }

    private JSONObject createLegend(Repository repo) throws JSONException {
        return JSONObject.create()
                .put("orient", "vertical")
                .put("x", "left")
                .put("data", JSONArray.create().put("iPhone3").put("iPhone4").put("iPhone5"));
    }

    private JSONObject createDataRange(Repository repo) throws JSONException {
        return JSONObject.create()
                .put("min", 0)
                .put("max", 2500)
                .put("x", "left")
                .put("y", "bottom")
                .put("text", JSONArray.create().put("高").put("低"));
    }

    private JSONArray createSeries(Repository repo) throws JSONException {
        JSONArray series = JSONArray.create();

        series.put(JSONObject.create()
                .put("name", "iPhone3")
                .put("type", "map")
                .put("mapType", "china")
                .put("data", JSONArray.create().put(JSONObject.create().put("name", "北京").put("value", 20)))
        );

        series.put(JSONObject.create()
                .put("name", "iPhone4")
                .put("type", "map")
                .put("mapType", "china")
                .put("data", JSONArray.create().put(JSONObject.create().put("name", "江苏").put("value", 20)))
        );

        series.put(JSONObject.create()
                .put("name", "iPhone5")
                .put("type", "map")
                .put("mapType", "china")
                .put("data", JSONArray.create().put(JSONObject.create().put("name", "四川").put("value", 20)))
        );

        return series;
    }

}
