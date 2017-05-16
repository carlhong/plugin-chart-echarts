package com.fr.solution.plugin.chart.echarts.gauge.glyph;

import com.fr.json.JSONException;
import com.fr.json.JSONObject;
import com.fr.solution.plugin.chart.echarts.common.glyph.EChartsGlyph;
import com.fr.stable.web.Repository;

/**
 * Created by hongtao on 2017/5/3.
 */
public class EChartsGaugeGlyph extends EChartsGlyph{

    @Override
    public JSONObject toJSONObject(Repository repo) throws JSONException {
        JSONObject jo = super.toJSONObject(repo);
        EChartsGaugePlotGlyph plotGlyph = (EChartsGaugePlotGlyph) getPlotGlyph();
        if (plotGlyph != null) {
            jo.put("xAxis", plotGlyph.toXAxisData(repo));
            jo.put("yAxis", plotGlyph.toYAxisData(repo));
            jo.put("dataZoom", plotGlyph.dataZoom(repo));
        }
        return jo;
    }
}
