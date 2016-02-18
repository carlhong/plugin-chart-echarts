package com.fr.solution.plugin.chart.echarts.glyph.pie;

import com.fr.json.JSONArray;
import com.fr.json.JSONException;
import com.fr.solution.plugin.chart.echarts.glyph.EChartsPlotGlyph;
import com.fr.stable.web.Repository;

/**
 * Created by richie on 16/2/18.
 */
public class EChartsPiePlotGlyph extends EChartsPlotGlyph {
    @Override
    public String getPlotGlyphType() {
        return "EChartsPiePlotGlyph";
    }

    @Override
    public String getChartType() {
        return "EChartsPie";
    }

    public JSONArray toSeriesData(Repository repo) throws JSONException {
        JSONArray series = JSONArray.create();
        return series;
    }
}
