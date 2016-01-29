package com.fr.solution.plugin.chart.echarts;

import com.fr.stable.fun.impl.AbstractJavaScriptFileHandler;

/**
 * Created by richie on 16/1/29.
 */
public class EChartsFileLoader extends AbstractJavaScriptFileHandler {
    @Override
    public String[] pathsForFiles() {
        return new String[]{
                "/com/fr/solution/plugin/chart/echarts/web/lib/echarts.min.js"
        };
    }
}
