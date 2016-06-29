/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.subpanels;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.gui.components.viewsearchfield.IViewSearchFieldListener;
import com.google.security.zynamics.bindiff.gui.components.viewsearchfield.TableTextSearchComboBox;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.subpanels.UnmatchedFunctionViewsFilterPanel$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.subpanels.UnmatchedFunctionViewsFilterPanel$InternalClearButtonLister;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.subpanels.UnmatchedFunctionViewsFilterPanel$InternalOptionButtonListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.subpanels.UnmatchedFunctionViewsFilterPanel$InternalSearchResultListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.AbstractTable;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.UnmatchedFunctionViewsTable;
import com.google.security.zynamics.bindiff.utils.ImageUtils;
import com.google.security.zynamics.zylib.general.Pair;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class UnmatchedFunctionViewsFilterPanel
extends JPanel {
    private static final ImageIcon ICON_OPTIONS = ImageUtils.getImageIcon("data/buttonicons/options.png");
    private static final ImageIcon ICON_CLEAR = ImageUtils.getImageIcon("data/buttonicons/clear.png");
    private static final ImageIcon ICON_CLEAR_GRAY = ImageUtils.getImageIcon("data/buttonicons/clear-gray.png");
    private final UnmatchedFunctionViewsFilterPanel$InternalClearButtonLister clearButtonListener;
    private final UnmatchedFunctionViewsFilterPanel$InternalOptionButtonListener optionsButtonListener;
    private final UnmatchedFunctionViewsFilterPanel$InternalSearchResultListener searchResultListener;
    private final TableTextSearchComboBox searchCombobox;
    private final JButton optionsButton;
    private final JButton clearButton;
    private final UnmatchedFunctionViewsTable unmatchedFunctionsViewTable;
    private final ESide side;

    public UnmatchedFunctionViewsFilterPanel(UnmatchedFunctionViewsTable unmatchedFunctionViewsTable, ESide eSide) {
        super(new BorderLayout());
        this.clearButtonListener = new UnmatchedFunctionViewsFilterPanel$InternalClearButtonLister(this, null);
        this.optionsButtonListener = new UnmatchedFunctionViewsFilterPanel$InternalOptionButtonListener(this, null);
        this.searchResultListener = new UnmatchedFunctionViewsFilterPanel$InternalSearchResultListener(this, null);
        this.optionsButton = new JButton(ICON_OPTIONS);
        this.clearButton = new JButton(ICON_CLEAR_GRAY);
        this.unmatchedFunctionsViewTable = (UnmatchedFunctionViewsTable)Preconditions.checkNotNull(unmatchedFunctionViewsTable);
        this.side = (ESide)((Object)Preconditions.checkNotNull((Object)eSide));
        this.searchCombobox = new TableTextSearchComboBox(unmatchedFunctionViewsTable, UnmatchedFunctionViewsFilterPanel.getColumnIndices(eSide));
        this.searchCombobox.addListener(this.searchResultListener);
        this.clearButton.addActionListener(this.clearButtonListener);
        this.optionsButton.addActionListener(this.optionsButtonListener);
        this.clearButton.setToolTipText("Clear Search Results");
        this.optionsButton.setToolTipText("Search Settings");
        this.add((Component)this.createPanel(), "West");
    }

    private static List getColumnIndices(ESide eSide) {
        ArrayList<Pair> arrayList = new ArrayList<Pair>();
        arrayList.add(new Pair(0, (Object)eSide));
        arrayList.add(new Pair(1, (Object)eSide));
        arrayList.add(new Pair(2, (Object)eSide));
        return arrayList;
    }

    private JPanel createPanel() {
        this.searchCombobox.setBackground(Color.WHITE);
        this.searchCombobox.setMinimumSize(new Dimension(30, 0));
        this.searchCombobox.setMaximumSize(new Dimension(400, 0));
        Dimension dimension = new Dimension(400, this.searchCombobox.getPreferredSize().height - 4);
        this.searchCombobox.setPreferredSize(dimension);
        this.searchCombobox.setSize(dimension);
        this.clearButton.setBackground(Color.WHITE);
        this.clearButton.setFocusable(false);
        this.clearButton.setPreferredSize(new Dimension(32, 23));
        JPanel jPanel = new JPanel(new BorderLayout());
        jPanel.add((Component)this.searchCombobox, "Center");
        JPanel jPanel2 = new JPanel(new BorderLayout());
        jPanel2.add((Component)this.clearButton, "Center");
        this.optionsButton.setPreferredSize(new Dimension(32, 23));
        this.optionsButton.setBackground(Color.WHITE);
        this.optionsButton.setFocusable(false);
        this.clearButton.setPreferredSize(new Dimension(32, 23));
        this.clearButton.setBackground(Color.WHITE);
        this.clearButton.setFocusable(false);
        JPanel jPanel3 = new JPanel(new GridLayout(1, 2, 1, 1));
        jPanel3.setBorder(new EmptyBorder(0, 1, 0, 5));
        jPanel3.add(this.clearButton);
        jPanel3.add(this.optionsButton);
        jPanel2.add((Component)jPanel3, "Center");
        jPanel.add((Component)jPanel2, "East");
        JPanel jPanel4 = new JPanel(new BorderLayout());
        jPanel4.setMaximumSize(new Dimension(467, 23));
        jPanel4.setMinimumSize(new Dimension(467, 23));
        jPanel4.setSize(new Dimension(467, 23));
        jPanel4.add((Component)jPanel, "West");
        JPanel jPanel5 = new JPanel(new BorderLayout());
        jPanel5.setBorder(new EmptyBorder(0, 0, 5, 0));
        jPanel5.add((Component)jPanel4, "West");
        return jPanel5;
    }

    public void dispose() {
        this.searchCombobox.removeListener(this.searchResultListener);
        this.clearButton.removeActionListener(this.clearButtonListener);
    }

    public TableTextSearchComboBox getSearchCombobox() {
        return this.searchCombobox;
    }

    static /* synthetic */ TableTextSearchComboBox access$300(UnmatchedFunctionViewsFilterPanel unmatchedFunctionViewsFilterPanel) {
        return unmatchedFunctionViewsFilterPanel.searchCombobox;
    }

    static /* synthetic */ ImageIcon access$400() {
        return ICON_CLEAR_GRAY;
    }

    static /* synthetic */ JButton access$500(UnmatchedFunctionViewsFilterPanel unmatchedFunctionViewsFilterPanel) {
        return unmatchedFunctionViewsFilterPanel.clearButton;
    }

    static /* synthetic */ ESide access$600(UnmatchedFunctionViewsFilterPanel unmatchedFunctionViewsFilterPanel) {
        return unmatchedFunctionViewsFilterPanel.side;
    }

    static /* synthetic */ UnmatchedFunctionViewsTable access$700(UnmatchedFunctionViewsFilterPanel unmatchedFunctionViewsFilterPanel) {
        return unmatchedFunctionViewsFilterPanel.unmatchedFunctionsViewTable;
    }

    static /* synthetic */ ImageIcon access$800() {
        return ICON_CLEAR;
    }
}

