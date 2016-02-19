package com.fr.solution.plugin.chart.echarts.common.ui;

import com.fr.base.Formula;
import com.fr.base.Utils;
import com.fr.design.dialog.BasicScrollPane;
import com.fr.design.formula.TinyFormulaPane;
import com.fr.design.gui.ibutton.UIButtonGroup;
import com.fr.design.gui.ilable.UILabel;
import com.fr.design.layout.TableLayout;
import com.fr.design.layout.TableLayoutHelper;
import com.fr.general.GeneralUtils;
import com.fr.solution.plugin.chart.echarts.common.base.ECharts;
import com.fr.solution.plugin.chart.echarts.common.title.EChartsTitle;
import com.fr.stable.StableUtils;

import javax.swing.*;
import java.awt.*;

/**
 * Created by richie on 16/2/19.
 */
public class EChartsTitlePane extends BasicScrollPane<ECharts> {

    private UIButtonGroup<Boolean> showTitle;

    private TinyFormulaPane tinyFormulaPane;

    private EChartsStylePane parent;

    public EChartsTitlePane(EChartsStylePane parent) {
        this.parent = parent;
    }

    @Override
    protected JPanel createContentPane() {
        JPanel panel = new JPanel(new BorderLayout());
        double p = TableLayout.PREFERRED;
        double f = TableLayout.FILL;
        double[] rowSize = {p, p};
        double[] columnSize = {p, f};
        showTitle = new UIButtonGroup<Boolean>(new String[]{"显示", "不显示"}, new Boolean[]{true, false});
        showTitle.setSelectedIndex(0);
        tinyFormulaPane = new TinyFormulaPane();
        JPanel cen = TableLayoutHelper.createTableLayoutPane(new Component[][]{
                {new UILabel("显示标题"), showTitle},
                {new UILabel("标题内容"), tinyFormulaPane}
        }, rowSize, columnSize);
        panel.add(cen, BorderLayout.CENTER);
        return panel;
    }

    @Override
    public void populateBean(ECharts ob) {
        EChartsTitle title = (EChartsTitle) ob.getTitle();
        if (title == null) {
            return;
        }
        showTitle.setSelectedItem(title.isTitleVisble());
        if (title.getTextObject() instanceof Formula) {
            tinyFormulaPane.populateBean(((Formula) title.getTextObject()).getContent());
        } else {
            tinyFormulaPane.populateBean(GeneralUtils.objectToString(title.getTextObject()));
        }
    }

    @Override
    public void updateBean(ECharts ob) {
        if (ob == null) {
            ob = new ECharts();
        }
        EChartsTitle title = (EChartsTitle) ob.getTitle();
        if (title == null) {
            title = new EChartsTitle();
        }
        title.setTitleVisble(showTitle.getSelectedItem());
        String titleString = tinyFormulaPane.updateBean();
        Object titleObj;
        if (StableUtils.maybeFormula(titleString)) {
            titleObj = new Formula(titleString);
        } else {
            titleObj = titleString;
        }
        title.setTextObject(titleObj);
    }

    @Override
    protected String title4PopupWindow() {
        return "Title";
    }
}
