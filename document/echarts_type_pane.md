# AbstractEChartsTypePane子类介绍

具有子类型的图表,都需要继承该类以实现各种子类型选择以及切换.具体实现可以参考`EChartsPieChartTypePane`.

需要实现几个重要的方法

// 该选择界面能收的图表类型

`public boolean accept(Object ob)`

// 默认选中的图表

`public Chart getDefaultChart()`

// 图表选择界面读取并展现

`public void populateBean(Chart chart)`

// 获取选中的图表类型

`public Plot getSelectedClonedPlot()`

// 图表各种子类型的图标

`public String[] getIconsOfTypes()`

// 图表各种子类型的名字

`public String[] getNamesOfTypes()`