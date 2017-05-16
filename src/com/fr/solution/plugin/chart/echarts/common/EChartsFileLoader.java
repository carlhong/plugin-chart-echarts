package com.fr.solution.plugin.chart.echarts.common;

import com.fr.stable.EncodeConstants;
import com.fr.stable.fun.impl.AbstractJavaScriptFileHandler;

/**
 * Created by richie on 16/1/29.
 */
public class EChartsFileLoader extends AbstractJavaScriptFileHandler {
    @Override
    public String[] pathsForFiles() {
        return new String[]{
                "/com/fr/solution/plugin/chart/echarts/common/web/echarts.loader.js",
                "/com/fr/solution/plugin/chart/echarts/common/web/lib/echarts.min.js",
        };
    }

    @Override
    public String encode() {
        return EncodeConstants.ENCODING_UTF_8;
    }
}