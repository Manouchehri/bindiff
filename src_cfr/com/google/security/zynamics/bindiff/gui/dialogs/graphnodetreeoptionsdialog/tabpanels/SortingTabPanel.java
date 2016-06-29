/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs.graphnodetreeoptionsdialog.tabpanels;

import com.google.common.collect.Lists;
import com.google.security.zynamics.bindiff.enums.ESortByCriterium;
import com.google.security.zynamics.bindiff.enums.ESortOrder;
import com.google.security.zynamics.bindiff.gui.dialogs.graphnodetreeoptionsdialog.tabcomponents.SortingComboboxPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class SortingTabPanel
extends JPanel {
    private static int SORTING_LABEL_WIDTH = 100;
    private static int SORTING_COMBOBOX_WIDTH = 150;
    private static int ROW_HEIGHT = 25;
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

    public SortingTabPanel(boolean bl2, boolean bl3) {
        super(new BorderLayout());
        this.add((Component)this.createPanel(bl2, bl3), "Center");
        this.isCallgraphView = bl3;
        this.isCombinedView = bl2;
        this.setDefaults();
    }

    private JPanel createPanel(boolean bl2, boolean bl3) {
        JPanel jPanel = new JPanel(new BorderLayout());
        jPanel.setBorder(new LineBorder(Color.GRAY));
        JPanel jPanel2 = new JPanel(new GridLayout(bl2 ? 6 : 5, 1, 2, 2));
        jPanel2.setBorder(new TitledBorder("Sort Options"));
        ArrayList arrayList = Lists.newArrayList(ESortByCriterium.NONE.toString(), ESortByCriterium.ADDRESS.toString(), ESortByCriterium.MATCHSTATE.toString(), ESortByCriterium.SELECTION.toString(), ESortByCriterium.VISIBILITY.toString());
        if (bl2) {
            arrayList.add(ESortByCriterium.SIDE.toString());
        }
        if (bl3) {
            arrayList.add(2, ESortByCriterium.FUNCTIONTYPE.toString());
            if (!bl2) {
                arrayList.add(3, ESortByCriterium.FUNCTIONNAME.toString());
            }
        }
        this.firstSortCombo = new SortingComboboxPanel("First", arrayList, SORTING_LABEL_WIDTH, SORTING_COMBOBOX_WIDTH, ROW_HEIGHT);
        this.secondSortCombo = new SortingComboboxPanel("Second", arrayList, SORTING_LABEL_WIDTH, SORTING_COMBOBOX_WIDTH, ROW_HEIGHT);
        this.thirdSortCombo = new SortingComboboxPanel("Third", arrayList, SORTING_LABEL_WIDTH, SORTING_COMBOBOX_WIDTH, ROW_HEIGHT);
        this.fourthSortCombo = new SortingComboboxPanel("Fourth", arrayList, SORTING_LABEL_WIDTH, SORTING_COMBOBOX_WIDTH, ROW_HEIGHT);
        this.fifthSortCombo = new SortingComboboxPanel("Fifth", arrayList, SORTING_LABEL_WIDTH, SORTING_COMBOBOX_WIDTH, ROW_HEIGHT);
        jPanel2.add(this.firstSortCombo);
        jPanel2.add(this.secondSortCombo);
        jPanel2.add(this.thirdSortCombo);
        jPanel2.add(this.fourthSortCombo);
        jPanel2.add(this.fifthSortCombo);
        jPanel.add((Component)jPanel2, "North");
        return jPanel;
    }

    public ESortByCriterium getSortByCriterium(int n2) {
        switch (n2) {
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
        }
        return ESortByCriterium.NONE;
    }

    public ESortOrder getSortOrder(int n2) {
        switch (n2) {
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
        }
        return ESortOrder.ASCENDING;
    }

    public void restoreInitialSettings() {
        this.firstSortCombo.setSelectItem(this.initialFirstCriterium.toString(), this.initialFirstOrder);
        this.secondSortCombo.setSelectItem(this.initialSecondCriterium.toString(), this.initialSecondOrder);
        this.thirdSortCombo.setSelectItem(this.initialThirdCriterium.toString(), this.initialThirdOrder);
        this.fourthSortCombo.setSelectItem(this.initialFourthCriterium.toString(), this.initialFourthOrder);
        this.fifthSortCombo.setSelectItem(this.initialFifthCriterium.toString(), this.initialFifthOrder);
    }

    public void setDefaults() {
        if (this.isCallgraphView) {
            this.secondSortCombo.setSelectItem(ESortByCriterium.FUNCTIONTYPE.toString(), ESortOrder.ASCENDING);
            this.thirdSortCombo.setSelectItem(ESortByCriterium.MATCHSTATE.toString(), ESortOrder.ASCENDING);
            this.fifthSortCombo.setSelectItem(ESortByCriterium.ADDRESS.toString(), ESortOrder.ASCENDING);
            return;
        }
        this.secondSortCombo.setSelectItem(ESortByCriterium.MATCHSTATE.toString(), ESortOrder.ASCENDING);
        if (!this.isCombinedView) {
            this.fourthSortCombo.setSelectItem(ESortByCriterium.ADDRESS.toString(), ESortOrder.ASCENDING);
            this.fifthSortCombo.setSelectItem(ESortByCriterium.NONE.toString(), ESortOrder.ASCENDING);
            return;
        }
        this.fourthSortCombo.setSelectItem(ESortByCriterium.SIDE.toString(), ESortOrder.ASCENDING);
        this.fifthSortCombo.setSelectItem(ESortByCriterium.ADDRESS.toString(), ESortOrder.ASCENDING);
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
}

