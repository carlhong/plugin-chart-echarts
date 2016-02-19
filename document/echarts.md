# ECharts类介绍

ECharts是`com.fr.chart.chartattr.Chart`的子类,需要实现几个重要的方法

两个构造方法,一个为不带参数,一个为带[EChartsPlot](echarts_plot.md)参数


// 生成图表配置属性的方法,最终用于生成一个JSON格式的数据到web端

`public BaseChartGlyph createGlyph(ChartData chartData) `

// 判断能够接收的图表类型

`public boolean accept(Class<? extends Chart> obClass)`

// 读取xml中相关配置

`protected void readChartXML(XMLableReader reader)`

// 各种设置信息保存到xml文件中

`public void writeXML(XMLPrintWriter writer)`