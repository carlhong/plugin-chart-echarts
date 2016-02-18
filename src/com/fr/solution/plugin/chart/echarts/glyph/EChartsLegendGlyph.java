package com.fr.solution.plugin.chart.echarts.glyph;

import com.fr.chart.chartglyph.LegendGlyph;
import com.fr.json.JSONArray;
import com.fr.json.JSONException;
import com.fr.json.JSONObject;
import com.fr.stable.web.Repository;

/**
 * Created by richie on 16/2/2.
 */
public class EChartsLegendGlyph extends LegendGlyph {

    @Override
    public JSONObject toJSONObject(Repository repo) throws JSONException {
        return createLegend(repo);
    }

    private JSONObject createLegend(Repository repo) throws JSONException {
        return JSONObject.create()
                .put("orient", "vertical")
                .put("x", "left")
                .put("data", JSONArray.create().put("iPhone3").put("iPhone4").put("iPhone5"));
    }
}