package com.fr.solution.plugin.chart.echarts.scatter.glyph;

import com.fr.json.JSONException;
import com.fr.json.JSONObject;
import com.fr.solution.plugin.chart.echarts.common.glyph.EChartsGlyph;
import com.fr.stable.web.Repository;

/**
 * Created by hongtao on 2017/5/3.
 */
public class EChartsScatterGlyph extends EChartsGlyph{

    @Override
    public JSONObject toJSONObject(Repository repo) throws JSONException {
        JSONObject jo = super.toJSONObject(repo);
        EChartsScatterPlotGlyph plotGlyph = (EChartsScatterPlotGlyph) getPlotGlyph();
        if (plotGlyph != null) {
            jo.put("xAxis", plotGlyph.toXAxisData(repo));
            jo.put("yAxis", plotGlyph.toYAxisData(repo));
            jo.put("dataZoom", plotGlyph.dataZoom(repo));
        }
        return jo;
    }
}
