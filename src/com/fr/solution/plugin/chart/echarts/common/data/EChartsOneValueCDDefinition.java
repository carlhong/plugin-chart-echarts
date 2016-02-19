package com.fr.solution.plugin.chart.echarts.common.data;

import com.fr.chart.chartdata.NormalChartData;
import com.fr.chart.chartdata.OneValueCDDefinition;

/**
 * Created by Mitisky on 16/1/19.
 */
public class EChartsOneValueCDDefinition extends OneValueCDDefinition {

    private static final long serialVersionUID = -7069079313068958054L;

    protected NormalChartData getNormalChartData(Object[] series_name_array, Object[][] series_v_2D) {
        NormalChartData normal = new EChartsNormalChartData(categoryLabels, series_name_array, series_v_2D);
        normal.setSecondCates(secondLabels);
        normal.setThirdCates(thirdLabels);
        return normal;
    }
}