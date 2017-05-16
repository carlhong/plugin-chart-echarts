package com.fr.solution.plugin.chart.echarts.common.glyph;

import com.fr.chart.chartglyph.PlotGlyph;
import com.fr.json.JSONArray;
import com.fr.json.JSONException;
import com.fr.json.JSONObject;
import com.fr.stable.web.Repository;

/**
 * Created by richie on 16/2/18.
 */
public abstract class EChartsPlotGlyph extends PlotGlyph {

    @Override
    public void layoutAxisGlyph(int resolution) {}

    @Override
    public void layoutDataSeriesGlyph(int resolution) {}

    @Override
    public JSONObject toJSONObject(Repository repo) throws JSONException {
        throw new UnsupportedOperationException("Not support yet!");
    }

    public abstract JSONArray toSeriesData(Repository repo) throws JSONException;
}
