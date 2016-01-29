package com.fr.solution.plugin.chart.echarts.base;

import com.fr.chart.chartglyph.ChartGlyph;
import com.fr.json.JSONException;
import com.fr.json.JSONObject;
import com.fr.stable.web.Repository;

/**
 * Created by richie on 16/1/29.
 */
public class EChartsGlyph extends ChartGlyph {

    @Override
    public JSONObject toJSONObject(Repository repo) throws JSONException {
        return new JSONObject();
    }
}
