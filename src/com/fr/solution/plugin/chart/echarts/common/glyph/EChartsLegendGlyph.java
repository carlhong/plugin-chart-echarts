package com.fr.solution.plugin.chart.echarts.common.glyph;

import com.fr.chart.chartglyph.LegendGlyph;
import com.fr.chart.chartglyph.LegendItem;
import com.fr.json.JSONArray;
import com.fr.json.JSONException;
import com.fr.json.JSONObject;
import com.fr.stable.ArrayUtils;
import com.fr.stable.web.Repository;

/**
 * Created by richie on 16/2/2.
 */
public class EChartsLegendGlyph extends LegendGlyph {

    public EChartsLegendGlyph(LegendItem[] items) {
        super(items);
    }

    @Override
    public JSONObject toJSONObject(Repository repo) throws JSONException {
        JSONObject result = JSONObject.create()
                .put("orient", "horizontal")
                .put("y", "bottom");
        LegendItem[] items = getItems();

        if (ArrayUtils.isNotEmpty(items)) {
            JSONArray data = JSONArray.create();
            result.put("data", data);
            for (LegendItem item : items) {
                JSONObject jo = item.toJSONObject(repo);
                data.put(jo.optString("label"));
            }
        }
        return result;
    }

}