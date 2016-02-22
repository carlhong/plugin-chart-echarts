package com.fr.solution.plugin.chart.echarts.common.ui;

import com.fr.chart.chartattr.ChartCollection;
import com.fr.design.beans.BasicBeanPane;
import com.fr.design.dialog.BasicPane;
import com.fr.design.dialog.MultiTabPane;
import com.fr.design.event.UIObserver;
import com.fr.design.event.UIObserverListener;
import com.fr.design.gui.frpane.AttributeChangeListener;
import com.fr.design.mainframe.chart.AbstractChartAttrPane;
import com.fr.design.mainframe.chart.PaneTitleConstants;
import com.fr.general.Inter;
import com.fr.solution.plugin.chart.echarts.common.base.ECharts;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class EChartsStylePane extends AbstractChartAttrPane implements UIObserver {


    private KindOfTabPane kindOfTabPane;

    private EChartsTitlePane titlePane;
    private BasicPane tooltipPane;
    private BasicPane themePane;
    private BasicPane legendPane;

    private AttributeChangeListener listener;
    private UIObserverListener uiObserverListener;
    private ECharts chart;

    public EChartsStylePane(AttributeChangeListener listener) {
        this.listener = listener;
        initComponents();
    }

    private void initComponents() {
        setLayout(new BorderLayout());
        titlePane = new EChartsTitlePane(this);
        tooltipPane = new BasicPane() {
            @Override
            protected String title4PopupWindow() {
                return Inter.getLocText("Plugin-ECharts_Tooltip");
            }
        };
        themePane = new BasicPane() {
            @Override
            protected String title4PopupWindow() {
                return Inter.getLocText("Plugin-ECharts_Theme");
            }
        };
        legendPane = new BasicPane() {
            @Override
            protected String title4PopupWindow() {
                return Inter.getLocText("Plugin-ECharts_Legend");
            }
        };
    }

    protected void initSelfListener(Container parentComponent) {
        for (int i = 0; i < parentComponent.getComponentCount(); i++) {
            Component tmpComp = parentComponent.getComponent(i);
            if (tmpComp instanceof Container) {
                initListener((Container) tmpComp);
            }
            if (tmpComp instanceof UIObserver) {
                ((UIObserver) tmpComp).registerChangeListener(uiObserverListener);
            }
        }
    }

    @Override
    protected JPanel createContentPane() {
        JPanel content = new JPanel(new BorderLayout());
        if (chart == null) {
            return content;
        }
        kindOfTabPane = new KindOfTabPane();
        content.add(kindOfTabPane, BorderLayout.CENTER);
        return content;
    }

    /**
     * 返回对应的图片路径.
     */
    public String getIconPath() {
        return "com/fr/solution/plugin/chart/echarts/images/toolbar_item.png";
    }


    @Override
    public void populate(ChartCollection collection) {
        this.chart = (ECharts) collection.getSelectedChart();
        this.remove(leftContentPane);
        initContentPane();
        this.removeAttributeChangeListener();
        kindOfTabPane.populateBean(chart);
        this.addAttributeChangeListener(listener);
        this.initAllListeners();
    }

    @Override
    public void update(ChartCollection collection) {
        kindOfTabPane.updateBean((ECharts) collection.getSelectedChart());
    }

    /**
     * 返回界面的标题名称
     *
     * @return 返回名称.
     */
    public String title4PopupWindow() {
        return PaneTitleConstants.CHART_STYLE_TITLE;
    }

    /**
     * 注册事件监听器
     *
     * @param listener 观察者监听事件
     */
    public void registerChangeListener(UIObserverListener listener) {
        this.uiObserverListener = listener;
    }

    /**
     * 是否相应事件
     *
     * @return 是
     */
    public boolean shouldResponseChangeListener() {
        return true;
    }

    /**
     * 二级tab组件
     */
    public class KindOfTabPane extends MultiTabPane<ECharts> {

        @Override
        protected void initLayout() {
            JPanel tabPanel = new JPanel(new BorderLayout());
            tabPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 10, getBackground()));
            tabPanel.add(tabPane, BorderLayout.CENTER);

            setLayout(new BorderLayout(0, 4));
            add(tabPanel, BorderLayout.NORTH);
            add(centerPane, BorderLayout.CENTER);
        }

        @Override
        protected void dealWithTabChanged(int index) {
            dealWithChosenPane(index);
            cardLayout.show(centerPane, NameArray[index]);
            tabChanged();
        }

        private void dealWithChosenPane(int index) {
            //第一个总是标题
            if (index == 0) {
                return;
            }

            BasicPane chosenPane = paneList.get(index);
            centerPane.remove(index);
            paneList.remove(index);

            /**
             * richie:这边的目的是把空的展位面板替换成显示真是数据的面板
             */
            if (chosenPane == tooltipPane) {
                chosenPane = new EChartsTooltipPane(EChartsStylePane.this);
            } else if (chosenPane == themePane) {
                chosenPane = new EChartsThemePane(EChartsStylePane.this);
            } else if (chosenPane == legendPane) {
                chosenPane = new EChartsLegendPane(EChartsStylePane.this);
            }

            initSelfListener(chosenPane);
            centerPane.add(chosenPane, chosenPane.getTitle(), index);
            paneList.add(index, chosenPane);
        }

        @Override
        protected void tabChanged() {
            EChartsStylePane.this.removeAttributeChangeListener();
            ((BasicBeanPane<ECharts>) paneList.get(tabPane.getSelectedIndex())).populateBean(chart);
            EChartsStylePane.this.addAttributeChangeListener(listener);
        }

        @Override
        protected List<BasicPane> initPaneList() {
            java.util.List<BasicPane> paneList = new ArrayList<BasicPane>();
            paneList.add(titlePane);
            paneList.add(tooltipPane);
            paneList.add(themePane);
            paneList.add(legendPane);
            return paneList;
        }

        @Override
        public void populateBean(ECharts ob) {
            if (chart == null || kindOfTabPane.getSelectedIndex() == -1) {
                return;
            }
            ((BasicBeanPane<ECharts>) paneList.get(kindOfTabPane.getSelectedIndex())).populateBean(chart);
        }

        @Override
        public ECharts updateBean() {
            if (chart == null) {
                return null;
            }
            ((BasicBeanPane<ECharts>) paneList.get(kindOfTabPane.getSelectedIndex())).updateBean(chart);
            return chart;
        }

        @Override
        public void updateBean(ECharts ob) {
            BasicBeanPane<ECharts> pane = ((BasicBeanPane<ECharts>) paneList.get(kindOfTabPane.getSelectedIndex()));
            pane.updateBean(ob);
        }

        @Override
        public boolean accept(Object ob) {
            return true;
        }

        @Override
        public String title4PopupWindow() {
            return "Tab";
        }

        @Override
        public void reset() {

        }
    }
}