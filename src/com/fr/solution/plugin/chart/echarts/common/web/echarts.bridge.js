/**
 * Created by richie on 16/1/29.
 */
EChartsFactory = function(options, $dom) {
    this.options = options;
    this.$dom = $dom;
    this.chartID = options.chartID;
    this.autoRefreshTime = options.autoRefreshTime || 0;

    this.width = options.width || $dom.width();// 补充从dom获取.
    this.height = options.height || $dom.height();
    this.sheetIndex = options.sheetIndex || 0;
    this.ecName = options.ecName || '';

    FR.Chart.WebUtils._installChart(this, this.chartID);
};

EChartsFactory.prototype = {

    constructor : EChartsFactory,

    inits : function() {
        debugger;
        var ct = this.options.chartAttr;
        if (ct.theme != 'default') {
            FR.$defaultImport('/com/fr/solution/plugin/chart/echarts/common/web/theme/' + ct.theme + '.js');
        }
        this.newCharts = echarts.init(this.$dom[0], EChartsTheme[ct.theme]);
        this.newCharts.setOption(ct);
    },

    resize : function() {
        this.newCharts.resize();
    },
    refresh:function() {

    },

    refreshData:function(options){

    },

    //数据监控的刷新方式
    setData:function(options, aimation){

    }
};