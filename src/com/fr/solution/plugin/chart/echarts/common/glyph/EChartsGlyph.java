package com.fr.solution.plugin.chart.echarts.common.glyph;

import com.fr.chart.chartglyph.ChartGlyph;
import com.fr.json.JSONArray;
import com.fr.json.JSONException;
import com.fr.json.JSONObject;
import com.fr.solution.plugin.chart.echarts.common.theme.EChartsTheme;
import com.fr.solution.plugin.chart.echarts.common.tooltip.EChartsTooltip;
import com.fr.stable.StringUtils;
import com.fr.stable.web.Repository;

/**
 * Created by richie on 16/1/29.
 */
public class EChartsGlyph extends ChartGlyph {

    private EChartsTheme theme;
    private EChartsTooltip tooltip;

    public void setTheme(EChartsTheme theme) {
        this.theme = theme;
    }

    public void setTooltip(EChartsTooltip tooltip) {
        this.tooltip = tooltip;
    }

    @Override
    public JSONObject toJSONObject(Repository repo) throws JSONException {
        JSONObject jo = new JSONObject();
        EChartsTitleGlyph titleGlyph = (EChartsTitleGlyph) getTitleGlyph();
        if (titleGlyph != null) {
            jo.put("title", titleGlyph.toJSONObject(repo));
        }


        EChartsLegendGlyph legendGlyph = (EChartsLegendGlyph) getLegendGlyph();
        if (legendGlyph != null) {
            jo.put("legend", legendGlyph.toJSONObject(repo));
        }
        EChartsPlotGlyph plotGlyph = (EChartsPlotGlyph) getPlotGlyph();
        if (plotGlyph != null) {
            jo.put("series", plotGlyph.toSeriesData(repo));
        }
        if (theme != null) {
            jo.put("theme", theme.getName());
        }
        if (tooltip != null) {
            jo.put("tooltip", tooltip.toJSONObject(repo));
        }
        return jo;
    }
}