# ECharts图表插件开发文档

## 关键接口解释

`IndependentChartProvider`

介绍:该接口的作用是扩展图表类型引擎部分,一般继承`AbstractIndependentEChartsProvider`就可以了

`IndependentChartUIProvider`

介绍:该接口的作用是扩展图表类型的设计器部分,一般继承`AbstractIndependentEChartsUI`就可以了

以上两个接口,都是在plugin.xml中进行配置以扩展图表类型的,使用class属性来对应相应的扩展类,plotID属性对应图表Plot类型

## 关键类解释

每实现一种新类型的图表,都需要实现抽象类`AbstractIndependentEChartsProvider`来扩展已有的图表类型引擎以及实现抽象类`AbstractIndependentEChartsUI`类扩展已有的图表类型的设计界面.

为了方便统一处理新的图表类型,我们继承内置的`com.fr.chart.chartattr.Chart`类实现一个全新的图表类[com.fr.solution.plugin.chart.echarts.ECharts](echarts.md).

### 继承了AbstractIndependentEChartsProvider的类需要实现以下方法

// 该方法用于描述图表的名字

`public String getChartName()`

// 该方法用于描述图表的显示名字,会根据不同的语言设置显示不同的名字

`public String getChartUseName()`

// 该方法用户描述图表的子类型

`public Chart[] getChartTypes()`

// 该方法用于描述图表对应的图片,一般在设计界面和图表选择界面会看到该图片

`public String getChartImagePath()`

### 继承了AbstractIndependentEChartsUI的类需要实现以下方法

// 该方法用于描述图表类型选择界面(一种图表还会有若干种子类型,所以需要这个界面)

[`public AbstractChartTypePane getPlotTypePane()`](echarts_type_pane.md)

// 该方法用于描述此种图表类型的使用数据集数据时的数据设置界面

`public AbstractTableDataContentPane getTableDataSourcePane(Plot plot, ChartDataPane parent)`

// 该方法用于描述此种图表类型的使用单元格数据时的数据设置界面

`public AbstractReportDataContentPane getReportDataSourcePane(Plot plot, ChartDataPane parent)`

// 该方法用户描述此种类型的图表的小图标,一般在添加表单元素的选择界面可以看到

`public String getIconPath()`

### 所有新加的实现了XMLAble接口或者其子类的类,都必须要实现相等的判断方法,否者界面设计变化时无法正确检测到属性变化

`public boolean equals(Object ob)`

例如:ECharts,EChartsTooltip等
