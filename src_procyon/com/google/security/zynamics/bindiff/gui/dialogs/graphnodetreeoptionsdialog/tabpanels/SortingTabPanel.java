package com.google.security.zynamics.bindiff.gui.dialogs.graphnodetreeoptionsdialog.tabpanels;

import javax.swing.*;
import com.google.security.zynamics.bindiff.gui.dialogs.graphnodetreeoptionsdialog.tabcomponents.*;
import com.google.security.zynamics.bindiff.enums.*;
import java.awt.*;
import javax.swing.border.*;
import com.google.common.collect.*;
import java.util.*;

public class SortingTabPanel extends JPanel
{
    private static int SORTING_LABEL_WIDTH;
    private static int SORTING_COMBOBOX_WIDTH;
    private static int ROW_HEIGHT;
    private SortingComboboxPanel firstSortCombo;
    private SortingComboboxPanel secondSortCombo;
    private SortingComboboxPanel thirdSortCombo;
    private SortingComboboxPanel fourthSortCombo;
    private SortingComboboxPanel fifthSortCombo;
    private final boolean isCallgraphView;
    private final boolean isCombinedView;
    private ESortOrder initialFirstOrder;
    private ESortOrder initialSecondOrder;
    private ESortOrder initialThirdOrder;
    private ESortOrder initialFourthOrder;
    private ESortOrder initialFifthOrder;
    private ESortByCriterium initialFirstCriterium;
    private ESortByCriterium initialSecondCriterium;
    private ESortByCriterium initialThirdCriterium;
    private ESortByCriterium initialFourthCriterium;
    private ESortByCriterium initialFifthCriterium;
    
    public SortingTabPanel(final boolean isCombinedView, final boolean isCallgraphView) {
        super(new BorderLayout());
        this.add(this.createPanel(isCombinedView, isCallgraphView), "Center");
        this.isCallgraphView = isCallgraphView;
        this.isCombinedView = isCombinedView;
        this.setDefaults();
    }
    
    private JPanel createPanel(final boolean b, final boolean b2) {
        final JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new LineBorder(Color.GRAY));
        final JPanel panel2 = new JPanel(new GridLayout(b ? 6 : 5, 1, 2, 2));
        panel2.setBorder(new TitledBorder("Sort Options"));
        final ArrayList arrayList = Lists.newArrayList(ESortByCriterium.NONE.toString(), ESortByCriterium.ADDRESS.toString(), ESortByCriterium.MATCHSTATE.toString(), ESortByCriterium.SELECTION.toString(), ESortByCriterium.VISIBILITY.toString());
        if (b) {
            arrayList.add(ESortByCriterium.SIDE.toString());
        }
        if (b2) {
            arrayList.add(2, ESortByCriterium.FUNCTIONTYPE.toString());
            if (!b) {
                arrayList.add(3, ESortByCriterium.FUNCTIONNAME.toString());
            }
        }
        this.firstSortCombo = new SortingComboboxPanel("First", arrayList, SortingTabPanel.SORTING_LABEL_WIDTH, SortingTabPanel.SORTING_COMBOBOX_WIDTH, SortingTabPanel.ROW_HEIGHT);
        this.secondSortCombo = new SortingComboboxPanel("Second", arrayList, SortingTabPanel.SORTING_LABEL_WIDTH, SortingTabPanel.SORTING_COMBOBOX_WIDTH, SortingTabPanel.ROW_HEIGHT);
        this.thirdSortCombo = new SortingComboboxPanel("Third", arrayList, SortingTabPanel.SORTING_LABEL_WIDTH, SortingTabPanel.SORTING_COMBOBOX_WIDTH, SortingTabPanel.ROW_HEIGHT);
        this.fourthSortCombo = new SortingComboboxPanel("Fourth", arrayList, SortingTabPanel.SORTING_LABEL_WIDTH, SortingTabPanel.SORTING_COMBOBOX_WIDTH, SortingTabPanel.ROW_HEIGHT);
        this.fifthSortCombo = new SortingComboboxPanel("Fifth", arrayList, SortingTabPanel.SORTING_LABEL_WIDTH, SortingTabPanel.SORTING_COMBOBOX_WIDTH, SortingTabPanel.ROW_HEIGHT);
        panel2.add(this.firstSortCombo);
        panel2.add(this.secondSortCombo);
        panel2.add(this.thirdSortCombo);
        panel2.add(this.fourthSortCombo);
        panel2.add(this.fifthSortCombo);
        panel.add(panel2, "North");
        return panel;
    }
    
    public ESortByCriterium getSortByCriterium(final int n) {
        switch (n) {
            case 0: {
                return ESortByCriterium.toSortCriterium(this.firstSortCombo.getValue());
            }
            case 1: {
                return ESortByCriterium.toSortCriterium(this.secondSortCombo.getValue());
            }
            case 2: {
                return ESortByCriterium.toSortCriterium(this.thirdSortCombo.getValue());
            }
            case 3: {
                return ESortByCriterium.toSortCriterium(this.fourthSortCombo.getValue());
            }
            case 4: {
                return ESortByCriterium.toSortCriterium(this.fifthSortCombo.getValue());
            }
            default: {
                return ESortByCriterium.NONE;
            }
        }
    }
    
    public ESortOrder getSortOrder(final int n) {
        switch (n) {
            case 0: {
                return this.firstSortCombo.getSortOrder();
            }
            case 1: {
                return this.secondSortCombo.getSortOrder();
            }
            case 2: {
                return this.thirdSortCombo.getSortOrder();
            }
            case 3: {
                return this.fourthSortCombo.getSortOrder();
            }
            case 4: {
                return this.fifthSortCombo.getSortOrder();
            }
            default: {
                return ESortOrder.ASCENDING;
            }
        }
    }
    
    public void restoreInitialSettings() {
        this.firstSortCombo.setSelectItem(this.initialFirstCriterium.toString(), this.initialFirstOrder);
        this.secondSortCombo.setSelectItem(this.initialSecondCriterium.toString(), this.initialSecondOrder);
        this.thirdSortCombo.setSelectItem(this.initialThirdCriterium.toString(), this.initialThirdOrder);
        this.fourthSortCombo.setSelectItem(this.initialFourthCriterium.toString(), this.initialFourthOrder);
        this.fifthSortCombo.setSelectItem(this.initialFifthCriterium.toString(), this.initialFifthOrder);
    }
    
    public void setDefaults() {
        if (!this.isCallgraphView) {
            this.secondSortCombo.setSelectItem(ESortByCriterium.MATCHSTATE.toString(), ESortOrder.ASCENDING);
            if (!this.isCombinedView) {
                this.fourthSortCombo.setSelectItem(ESortByCriterium.ADDRESS.toString(), ESortOrder.ASCENDING);
                this.fifthSortCombo.setSelectItem(ESortByCriterium.NONE.toString(), ESortOrder.ASCENDING);
            }
            else {
                this.fourthSortCombo.setSelectItem(ESortByCriterium.SIDE.toString(), ESortOrder.ASCENDING);
                this.fifthSortCombo.setSelectItem(ESortByCriterium.ADDRESS.toString(), ESortOrder.ASCENDING);
            }
        }
        else {
            this.secondSortCombo.setSelectItem(ESortByCriterium.FUNCTIONTYPE.toString(), ESortOrder.ASCENDING);
            this.thirdSortCombo.setSelectItem(ESortByCriterium.MATCHSTATE.toString(), ESortOrder.ASCENDING);
            this.fifthSortCombo.setSelectItem(ESortByCriterium.ADDRESS.toString(), ESortOrder.ASCENDING);
        }
    }
    
    public void storeInitialSettings() {
        this.initialFirstOrder = this.firstSortCombo.getSortOrder();
        this.initialSecondOrder = this.secondSortCombo.getSortOrder();
        this.initialThirdOrder = this.thirdSortCombo.getSortOrder();
        this.initialFourthOrder = this.fourthSortCombo.getSortOrder();
        this.initialFifthOrder = this.fifthSortCombo.getSortOrder();
        this.initialFirstCriterium = this.getSortByCriterium(0);
        this.initialSecondCriterium = this.getSortByCriterium(1);
        this.initialThirdCriterium = this.getSortByCriterium(2);
        this.initialFourthCriterium = this.getSortByCriterium(3);
        this.initialFifthCriterium = this.getSortByCriterium(4);
    }
    
    static {
        SortingTabPanel.SORTING_LABEL_WIDTH = 100;
        SortingTabPanel.SORTING_COMBOBOX_WIDTH = 150;
        SortingTabPanel.ROW_HEIGHT = 25;
    }
}
