package com.fr.solution.plugin.chart.echarts.base;

import com.fr.chart.chartglyph.ChartGlyph;
import com.fr.json.JSONArray;
import com.fr.json.JSONException;
import com.fr.json.JSONObject;
import com.fr.stable.web.Repository;

/**
 * Created by richie on 16/1/29.
 */
public class NewGlyph extends ChartGlyph {

    private NewTitleGlyph titleGlyph;

    private NewLegendGlyph legendGlyph;


    public void setTitleGlyph(NewTitleGlyph titleGlyph) {
        this.titleGlyph = titleGlyph;
    }

    @Override
    public NewLegendGlyph getLegendGlyph() {
        return legendGlyph;
    }

    public void setLegendGlyph(NewLegendGlyph legendGlyph) {
        this.legendGlyph = legendGlyph;
    }

    @Override
    public JSONObject toJSONObject(Repository repo) throws JSONException {
        JSONObject jo = new JSONObject();
        jo.put("title", createTitle(repo));
//        if (titleGlyph != null) {
//            jo.put("title", titleGlyph.toJSONObject(repo));
//        }
        jo.put("tooltip", createTooltip(repo));


        jo.put("legend", createLegend(repo));

//        if (legendGlyph != null) {
//            jo.put("legend", legendGlyph.toJSONObject(repo));
//        }
        jo.put("dataRange", createDataRange(repo));
        jo.put("series", createSeries(repo));
        return jo;
    }

    private JSONObject createTitle(Repository repo) throws JSONException {
        return JSONObject.create()
                .put("text", "iPhone����")
                .put("subtext", "�����鹹")
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
                .put("text", JSONArray.create().put("��").put("��"));
    }

    private JSONArray createSeries(Repository repo) throws JSONException {
        JSONArray series = JSONArray.create();

        series.put(JSONObject.create()
                .put("name", "iPhone3")
                .put("type", "map")
                .put("mapType", "china")
                .put("itemStyle", createItemStyle(repo))
                .put("data", JSONArray.create().put(JSONObject.create().put("name", "����").put("value", 20)))
        );

        series.put(JSONObject.create()
                .put("name", "iPhone4")
                .put("type", "map")
                .put("mapType", "china")
                .put("itemStyle", createItemStyle(repo))
                .put("data", JSONArray.create().put(JSONObject.create().put("name", "����").put("value", 20)))
        );

        series.put(JSONObject.create()
                .put("name", "iPhone5")
                .put("type", "map")
                .put("mapType", "china")
                .put("itemStyle", createItemStyle(repo))
                .put("data", JSONArray.create().put(JSONObject.create().put("name", "�Ĵ�").put("value", 20)))
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
