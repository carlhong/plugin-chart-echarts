package com.fr.solution.plugin.chart.echarts.common.ui;

import com.fr.design.dialog.BasicScrollPane;
import com.fr.design.gui.ibutton.UIButtonGroup;
import com.fr.design.gui.icheckbox.UICheckBox;
import com.fr.design.gui.icombobox.UIDictionaryComboBox;
import com.fr.design.gui.ilable.UILabel;
import com.fr.design.layout.TableLayout;
import com.fr.design.layout.TableLayoutHelper;
import com.fr.design.style.color.ColorSelectBox;
import com.fr.general.Inter;
import com.fr.solution.plugin.chart.echarts.common.base.ECharts;
import com.fr.solution.plugin.chart.echarts.common.toolbox.EChartsToolbox;

import javax.swing.*;
import java.awt.*;

public class EChartsToolboxPane extends BasicScrollPane<ECharts> {

    private UIButtonGroup<Boolean> showBrush;

    private UICheckBox isRect;

    private UICheckBox isPolygon;

    private UICheckBox isKeep;

    private UICheckBox isLineX;

    private UICheckBox isLineY;

    private UICheckBox isClear;

    private JPanel brushTypePane;

    private UIButtonGroup<Boolean> showDataView;


    private ColorSelectBox bgColorSelectBox;

    private ColorSelectBox textareaColorSelectBox;

    private ColorSelectBox textareaBorderColorSelectBox;

    private ColorSelectBox textColorSelectBox;

    private ColorSelectBox buttonColorSelectBox;

    private ColorSelectBox buttonTextColorSelectBox;

    private UIButtonGroup<Boolean> showDataZoom;

    private UIButtonGroup<Boolean> showMagicType;

    private UICheckBox isLine;

    private UICheckBox isBar;

    private UICheckBox isStack;

    private UICheckBox isTiled;

    private JPanel magicTypePane;

    private UIButtonGroup<Boolean> showRestore;

    private UIButtonGroup<Boolean> showSaveAsImage;

    private static final String[] imageFormat = new String[]{"png", "jpeg"};

    private UIDictionaryComboBox<String> imageFormatComboBox;

    public EChartsToolboxPane(EChartsStylePane parent) {}

    @Override
    protected JPanel createContentPane() {
        JPanel panel = new JPanel(new BorderLayout());
        brushTypePane = initBrushTypePane();
        magicTypePane = initMagicTypePane();
        double p = TableLayout.PREFERRED;
        double f = TableLayout.FILL;
        double[] rowSize = {p, p, p, p, p, p, p, p, p, p, p, p, p, p, p, p, p, p};
        double[] columnSize = {p, f};

        showBrush = new UIButtonGroup<Boolean>(
                new String[]{
                        Inter.getLocText("Plugin-ECharts_Title_Show"),
                        Inter.getLocText("Plugin-ECharts_Title_Not_Show")},
                new Boolean[]{true, false});
        showBrush.setSelectedIndex(1);

        showDataView = new UIButtonGroup<Boolean>(
                new String[]{
                        Inter.getLocText("Plugin-ECharts_Title_Show"),
                        Inter.getLocText("Plugin-ECharts_Title_Not_Show")},
                new Boolean[]{true, false});
        showDataView.setSelectedIndex(1);

        bgColorSelectBox = new ColorSelectBox(100);

        textareaColorSelectBox = new ColorSelectBox(100);

        textareaBorderColorSelectBox = new ColorSelectBox(100);

        textColorSelectBox = new ColorSelectBox(100);

        buttonColorSelectBox = new ColorSelectBox(100);

        buttonTextColorSelectBox = new ColorSelectBox(100);

        showDataZoom = new UIButtonGroup<Boolean>(
                new String[]{
                        Inter.getLocText("Plugin-ECharts_Title_Show"),
                        Inter.getLocText("Plugin-ECharts_Title_Not_Show")},
                new Boolean[]{true, false});
        showDataZoom.setSelectedIndex(1);

        showMagicType = new UIButtonGroup<Boolean>(
                new String[]{
                        Inter.getLocText("Plugin-ECharts_Title_Show"),
                        Inter.getLocText("Plugin-ECharts_Title_Not_Show")},
                new Boolean[]{true, false});
        showMagicType.setSelectedIndex(1);

        showRestore = new UIButtonGroup<Boolean>(
                new String[]{
                        Inter.getLocText("Plugin-ECharts_Title_Show"),
                        Inter.getLocText("Plugin-ECharts_Title_Not_Show")},
                new Boolean[]{true, false});
        showRestore.setSelectedIndex(1);

        showSaveAsImage = new UIButtonGroup<Boolean>(
                new String[]{
                        Inter.getLocText("Plugin-ECharts_Title_Show"),
                        Inter.getLocText("Plugin-ECharts_Title_Not_Show")},
                new Boolean[]{true, false});
        showSaveAsImage.setSelectedIndex(1);

        imageFormatComboBox = new UIDictionaryComboBox<String>(
                new String[]{"png", "jpeg"},
                new String[]{"png", "jpeg"});

        JPanel cen = TableLayoutHelper.createTableLayoutPane(new Component[][]{
                {new UILabel(Inter.getLocText("Plugin-ECharts_Brush")), showBrush},
                {brushTypePane, null},
                {new UILabel(Inter.getLocText("Plugin-ECharts_Data_View")), showDataView},
                {new UILabel(Inter.getLocText("Plugin-ECharts_BgColor")), bgColorSelectBox},
                {new UILabel(Inter.getLocText("Plugin-ECharts_Textarea_Color")), textareaColorSelectBox},
                {new UILabel(Inter.getLocText("Plugin-ECharts_Textarea_Border_Color")), textareaBorderColorSelectBox},
                {new UILabel(Inter.getLocText("Plugin-ECharts_Text_Color")), textColorSelectBox},
                {new UILabel(Inter.getLocText("Plugin-ECharts_Button_Color")), buttonColorSelectBox},
                {new UILabel(Inter.getLocText("Plugin-ECharts_Button_Text_Color")), buttonTextColorSelectBox},
                {new JSeparator(), null},
                {new UILabel(Inter.getLocText("Plugin-ECharts_Data_Zoom")), showDataZoom},
                {new JSeparator(), null},
                {new UILabel(Inter.getLocText("Plugin-ECharts_Magic_Type")), showMagicType},
                {magicTypePane, null},
                {new UILabel(Inter.getLocText("Plugin-ECharts_Restore")), showRestore},
                {new UILabel(Inter.getLocText("Plugin-ECharts_Save_As_Image")), showSaveAsImage},
                {new UILabel(Inter.getLocText("Plugin-ECharts_Image_Format")), imageFormatComboBox},
        }, rowSize, columnSize);

        panel.add(cen, BorderLayout.CENTER);

        return panel;
    }

    private JPanel initMagicTypePane(){
        double p = TableLayout.PREFERRED;
        double f = TableLayout.FILL;
        double[] rowSize = {p, p, p};
        double[] columnSize = {p, p, p, p};

        isLine = new UICheckBox(Inter.getLocText("Plugin-ECharts_Magic_Type_Line"));
        isBar = new UICheckBox(Inter.getLocText("Plugin-ECharts_Magic_Type_Bar"));
        isStack = new UICheckBox(Inter.getLocText("Plugin-ECharts_Magic_Type_Stack"));
        isTiled = new UICheckBox(Inter.getLocText("Plugin-ECharts_Magic_Type_Tiled"));

        Component[][] components = new Component[][]{
                new Component[]{isLine, isBar, isStack, isTiled},
                new Component[]{new JSeparator(), null, null, null},
        };

        return TableLayoutHelper.createTableLayoutPane(components,rowSize,columnSize);
    }

    private JPanel initBrushTypePane(){
        double p = TableLayout.PREFERRED;
        double f = TableLayout.FILL;
        double[] rowSize = {p, p, p, p};
        double[] columnSize = {p, p, f};

        isRect = new UICheckBox(Inter.getLocText("Plugin-ECharts_Brush_Rect"));
        isPolygon = new UICheckBox(Inter.getLocText("Plugin-ECharts_Brush_Polygon"));
        isKeep = new UICheckBox(Inter.getLocText("Plugin-ECharts_Brush_Keep"));
        isLineX = new UICheckBox(Inter.getLocText("Plugin-ECharts_Brush_LineX"));
        isLineY = new UICheckBox(Inter.getLocText("Plugin-ECharts_Brush_LineY"));
        isClear = new UICheckBox(Inter.getLocText("Plugin-ECharts_Brush_Clear"));

        Component[][] components = new Component[][]{
                new Component[]{isRect, isPolygon, isKeep},
                new Component[]{isLineX, isLineY, isClear},
                new Component[]{new JSeparator(), null, null},
        };

        return TableLayoutHelper.createTableLayoutPane(components,rowSize,columnSize);
    }

    @Override
    public void populateBean(ECharts ob) {
        if (ob == null) {
            return;
        }
        EChartsToolbox toolbox = ob.getToolbox();
        if (toolbox == null) {
            return;
        }
        showBrush.setSelectedItem(toolbox.isBrushVisible());
        isRect.setSelected(toolbox.isRectSelected());
        isPolygon.setSelected(toolbox.isPolygonSelected());
        isKeep.setSelected(toolbox.isKeepSelected());
        isLineX.setSelected(toolbox.isLineXSelected());
        isLineY.setSelected(toolbox.isLineYSelected());
        isClear.setSelected(toolbox.isClearSelected());
        showDataView.setSelectedItem(toolbox.isDataViewVisible());
        bgColorSelectBox.setSelectObject(toolbox.getBgColor());
        textareaColorSelectBox.setSelectObject(toolbox.getTextareaColor());
        textareaBorderColorSelectBox.setSelectObject(toolbox.getTextareaBorderColor());
        textColorSelectBox.setSelectObject(toolbox.getTextColor());
        buttonColorSelectBox.setSelectObject(toolbox.getButtonColor());
        buttonTextColorSelectBox.setSelectObject(toolbox.getButtonTextColor());
        showDataZoom.setSelectedItem(toolbox.isDataZoomVisible());
        showMagicType.setSelectedItem(toolbox.isMagicTypeVisible());
        isBar.setSelected(toolbox.isBarSelected());
        isLine.setSelected(toolbox.isLineSelected());
        isStack.setSelected(toolbox.isStackSelected());
        isTiled.setSelected(toolbox.isTiledSelected());
        showRestore.setSelectedItem(toolbox.isRestoreVisible());
        showSaveAsImage.setSelectedItem(toolbox.isSaveAsImageVisible());
        imageFormatComboBox.setSelectedItem(toolbox.getImageFormat());
    }


    @Override
    public void updateBean(ECharts ob) {
        if (ob == null) {
            ob = new ECharts();
        }
        EChartsToolbox toolbox = new EChartsToolbox();
        toolbox.setBrushVisible(showBrush.getSelectedItem());
        toolbox.setRectSelected(isRect.isSelected());
        toolbox.setPolygonSelected(isPolygon.isSelected());
        toolbox.setKeepSelected(isKeep.isSelected());
        toolbox.setLineXSelected(isLineX.isSelected());
        toolbox.setLineYSelected(isLineY.isSelected());
        toolbox.setClearSelected(isClear.isSelected());
        toolbox.setDataViewVisible(showDataView.getSelectedItem());
        toolbox.setBgColor(bgColorSelectBox.getSelectObject());
        toolbox.setTextareaColor(textareaColorSelectBox.getSelectObject());
        toolbox.setTextareaBorderColor(textareaBorderColorSelectBox.getSelectObject());
        toolbox.setTextColor(textColorSelectBox.getSelectObject());
        toolbox.setButtonColor(buttonColorSelectBox.getSelectObject());
        toolbox.setButtonTextColor(buttonTextColorSelectBox.getSelectObject());
        toolbox.setDataZoomVisible(showDataZoom.getSelectedItem());
        toolbox.setMagicTypeVisible(showMagicType.getSelectedItem());
        toolbox.setBarSelected(isBar.isSelected());
        toolbox.setLineSelected(isLine.isSelected());
        toolbox.setStackSelected(isStack.isSelected());
        toolbox.setTiledSelected(isTiled.isSelected());
        toolbox.setRestoreVisible(showRestore.getSelectedItem());
        toolbox.setSaveAsImageVisible(showSaveAsImage.getSelectedItem());
        toolbox.setImageFormat(imageFormatComboBox.getSelectedItem());
        ob.setToolbox(toolbox);
    }

    @Override
    protected String title4PopupWindow() {
        return Inter.getLocText("Plugin-ECharts_Toolbox");
    }
}
