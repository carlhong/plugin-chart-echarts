package com.fr.solution.plugin.chart.echarts.base;

import com.fr.chart.chartglyph.ChartGlyph;
import com.fr.json.JSONException;
import com.fr.json.JSONObject;
import com.fr.stable.web.Repository;

/**
 * Created by richie on 16/2/2.
 */
public class NewTitleGlyph extends ChartGlyph {


    public NewTitleGlyph(String title, String subTitle) {

    }

    @Override
    public JSONObject toJSONObject(Repository repo) throws JSONException {
        return createTitle(repo);
    }

    private JSONObject createTitle(Repository repo) throws JSONException {
        return JSONObject.create()
                .put("text", "iPhoneœ˙¡ø")
                .put("subtext", "¥ø Ù–Èππ")
                .put("x", "center");
    }

}
