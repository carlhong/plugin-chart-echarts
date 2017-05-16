package com.fr.solution.plugin.chart.echarts.funnel.glyph;

import com.fr.json.JSONException;
import com.fr.json.JSONObject;
import com.fr.solution.plugin.chart.echarts.common.glyph.EChartsGlyph;
import com.fr.stable.web.Repository;

/**
 * Created by hongtao on 2017/5/3.
 */
public class EChartsFunnelGlyph extends EChartsGlyph{

    @Override
    public JSONObject toJSONObject(Repository repo) throws JSONException {
        JSONObject jo = super.toJSONObject(repo);
        EChartsFunnelPlotGlyph plotGlyph = (EChartsFunnelPlotGlyph) getPlotGlyph();
        if (plotGlyph != null) {
            jo.put("dataZoom", plotGlyph.dataZoom(repo));
        }
        return jo;
    }
}
