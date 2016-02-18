package com.fr.solution.plugin.chart.echarts.glyph;

import com.fr.chart.chartglyph.TitleGlyph;
import com.fr.json.JSONException;
import com.fr.json.JSONObject;
import com.fr.stable.web.Repository;

/**
 * Created by richie on 16/2/2.
 */
public class EChartsTitleGlyph extends TitleGlyph {

    public EChartsTitleGlyph() {

    }

    public EChartsTitleGlyph(String title, String subTitle) {

    }

    @Override
    public JSONObject toJSONObject(Repository repo) throws JSONException {
        return createTitle(repo);
    }

    private JSONObject createTitle(Repository repo) throws JSONException {
        return JSONObject.create()
                .put("text", "iPhone销量")
                .put("subtext", "纯属虚构")
                .put("x", "center");
    }

}