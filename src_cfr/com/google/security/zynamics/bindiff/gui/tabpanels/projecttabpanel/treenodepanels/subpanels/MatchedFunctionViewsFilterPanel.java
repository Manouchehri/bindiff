/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.subpanels;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.gui.components.viewsearchfield.IViewSearchFieldListener;
import com.google.security.zynamics.bindiff.gui.components.viewsearchfield.TableTextSearchComboBox;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.subpanels.IViewsFilterCheckboxListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.subpanels.MatchedFunctionViewsFilterPanel$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.subpanels.MatchedFunctionViewsFilterPanel$InternalClearButtonLister;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.subpanels.MatchedFunctionViewsFilterPanel$InternalFilterCheckboxListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.subpanels.MatchedFunctionViewsFilterPanel$InternalOptionButtonListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.subpanels.MatchedFunctionViewsFilterPanel$InternalSearchResultListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.AbstractTable;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.MatchedFunctionViewsTable;
import com.google.security.zynamics.bindiff.utils.ImageUtils;
import com.google.security.zynamics.zylib.general.ListenerProvider;
import com.google.security.zynamics.zylib.general.Pair;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class MatchedFunctionViewsFilterPanel
extends JPanel {
    private static final ImageIcon ICON_OPTIONS = ImageUtils.getImageIcon("data/buttonicons/options.png");
    private static final ImageIcon ICON_CLEAR = ImageUtils.getImageIcon("data/buttonicons/clear.png");
    private static final ImageIcon ICON_CLEAR_GRAY = ImageUtils.getImageIcon("data/buttonicons/clear-gray.png");
    private final ListenerProvider checkBoxFilterListeners = new ListenerProvider();
    private final MatchedFunctionViewsFilterPanel$InternalSearchResultListener searchResultListener;
    private final MatchedFunctionViewsFilterPanel$InternalFilterCheckboxListener filterCheckboxListener;
    private final MatchedFunctionViewsFilterPanel$InternalClearButtonLister clearButtonListener;
    private final MatchedFunctionViewsFilterPanel$InternalOptionButtonListener optionsButtonListener;
    private final JButton optionsButton;
    private final JButton clearButton;
    private final JCheckBox showStructuralChangedFunctions;
    private final JCheckBox showInstructionChangedOnlyFunctions;
    private final JCheckBox showIdenticalFunctions;
    private final TableTextSearchComboBox searchCombobox;
    private final MatchedFunctionViewsTable matchedFunctionsViewTable;

    public MatchedFunctionViewsFilterPanel(MatchedFunctionViewsTable matchedFunctionViewsTable) {
        super(new BorderLayout());
        this.clearButtonListener = new MatchedFunctionViewsFilterPanel$InternalClearButtonLister(this, null);
        this.optionsButton = new JButton(ICON_OPTIONS);
        this.clearButton = new JButton(ICON_CLEAR_GRAY);
        this.showStructuralChangedFunctions = new JCheckBox("Show structural changes", true);
        this.showInstructionChangedOnlyFunctions = new JCheckBox("Show only instructions changed", true);
        this.showIdenticalFunctions = new JCheckBox("Show identical", true);
        Preconditions.checkNotNull(matchedFunctionViewsTable);
        this.searchResultListener = new MatchedFunctionViewsFilterPanel$InternalSearchResultListener(this, null);
        this.filterCheckboxListener = new MatchedFunctionViewsFilterPanel$InternalFilterCheckboxListener(this, null);
        this.optionsButtonListener = new MatchedFunctionViewsFilterPanel$InternalOptionButtonListener(this, null);
        this.matchedFunctionsViewTable = matchedFunctionViewsTable;
        this.searchCombobox = new TableTextSearchComboBox(matchedFunctionViewsTable, MatchedFunctionViewsFilterPanel.getColumnIndices());
        this.searchCombobox.addListener(this.searchResultListener);
        this.clearButton.addActionListener(this.clearButtonListener);
        this.optionsButton.addActionListener(this.optionsButtonListener);
        this.clearButton.setToolTipText("Clear Search Results");
        this.optionsButton.setToolTipText("Search Settings");
        this.showStructuralChangedFunctions.addItemListener(this.filterCheckboxListener);
        this.showInstructionChangedOnlyFunctions.addItemListener(this.filterCheckboxListener);
        this.showIdenticalFunctions.addItemListener(this.filterCheckboxListener);
        this.searchCombobox.setSearchOptions(false, false, true, true, false);
        this.add((Component)this.createPanel(), "Center");
    }

    private static List getColumnIndices() {
        ArrayList<Pair> arrayList = new ArrayList<Pair>();
        arrayList.add(new Pair(3, (Object)ESide.PRIMARY));
        arrayList.add(new Pair(4, (Object)ESide.PRIMARY));
        arrayList.add(new Pair(5, (Object)ESide.PRIMARY));
        arrayList.add(new Pair(6, (Object)ESide.SECONDARY));
        arrayList.add(new Pair(7, (Object)ESide.SECONDARY));
        arrayList.add(new Pair(8, (Object)ESide.SECONDARY));
        return arrayList;
    }

    private JPanel createChangesFilterPanel() {
        this.showStructuralChangedFunctions.setMinimumSize(new Dimension(0, 0));
        this.showInstructionChangedOnlyFunctions.setMinimumSize(new Dimension(0, 0));
        this.showIdenticalFunctions.setMinimumSize(new Dimension(0, 0));
        JPanel jPanel = new JPanel(new BorderLayout());
        jPanel.add((Component)this.showStructuralChangedFunctions, "West");
        JPanel jPanel2 = new JPanel(new BorderLayout());
        jPanel2.add((Component)this.showInstructionChangedOnlyFunctions, "West");
        jPanel.add((Component)jPanel2, "Center");
        JPanel jPanel3 = new JPanel(new BorderLayout());
        jPanel3.add((Component)this.showIdenticalFunctions, "West");
        jPanel2.add((Component)jPanel3, "Center");
        return jPanel;
    }

    private JPanel createPanel() {
        this.searchCombobox.setBackground(Color.WHITE);
        this.searchCombobox.setMinimumSize(new Dimension(30, 0));
        Dimension dimension = new Dimension(this.searchCombobox.getPreferredSize().width, this.searchCombobox.getPreferredSize().height - 4);
        this.searchCombobox.setPreferredSize(dimension);
        this.searchCombobox.setSize(dimension);
        JPanel jPanel = new JPanel(new BorderLayout());
        jPanel.add((Component)this.searchCombobox, "Center");
        JPanel jPanel2 = new JPanel(new BorderLayout());
        jPanel2.add((Component)this.createTextFilterPanel(), "West");
        JPanel jPanel3 = new JPanel(new BorderLayout());
        jPanel3.add((Component)this.createChangesFilterPanel(), "West");
        jPanel3.setBorder(new EmptyBorder(0, 5, 0, 1));
        jPanel.add((Component)jPanel2, "East");
        jPanel2.add((Component)jPanel3, "Center");
        JPanel jPanel4 = new JPanel(new BorderLayout());
        jPanel4.setBorder(new EmptyBorder(0, 0, 5, 0));
        jPanel4.add(jPanel);
        return jPanel4;
    }

    private JPanel createTextFilterPanel() {
        JPanel jPanel = new JPanel(new BorderLayout());
        Dimension dimension = this.searchCombobox.getPreferredSize();
        this.optionsButton.setPreferredSize(new Dimension(32, dimension.height));
        this.optionsButton.setBackground(Color.WHITE);
        this.optionsButton.setFocusable(false);
        this.clearButton.setPreferredSize(new Dimension(32, dimension.height));
        this.clearButton.setBackground(Color.WHITE);
        this.clearButton.setFocusable(false);
        JPanel jPanel2 = new JPanel(new GridLayout(1, 2, 1, 1));
        jPanel2.setBorder(new EmptyBorder(0, 1, 0, 0));
        jPanel2.add(this.clearButton);
        jPanel2.add(this.optionsButton);
        jPanel.add((Component)jPanel2, "Center");
        return jPanel;
    }

    public void addListener(IViewsFilterCheckboxListener iViewsFilterCheckboxListener) {
        this.checkBoxFilterListeners.addListener(iViewsFilterCheckboxListener);
    }

    public void dispose() {
        this.searchCombobox.removeListener(this.searchResultListener);
        this.clearButton.removeActionListener(this.clearButtonListener);
        this.optionsButton.removeActionListener(this.optionsButtonListener);
        this.showStructuralChangedFunctions.removeItemListener(this.filterCheckboxListener);
        this.showInstructionChangedOnlyFunctions.removeItemListener(this.filterCheckboxListener);
        this.showIdenticalFunctions.removeItemListener(this.filterCheckboxListener);
    }

    public void removeListener(IViewsFilterCheckboxListener iViewsFilterCheckboxListener) {
        this.checkBoxFilterListeners.removeListener(iViewsFilterCheckboxListener);
    }

    static /* synthetic */ TableTextSearchComboBox access$400(MatchedFunctionViewsFilterPanel matchedFunctionViewsFilterPanel) {
        return matchedFunctionViewsFilterPanel.searchCombobox;
    }

    static /* synthetic */ ImageIcon access$500() {
        return ICON_CLEAR_GRAY;
    }

    static /* synthetic */ JButton access$600(MatchedFunctionViewsFilterPanel matchedFunctionViewsFilterPanel) {
        return matchedFunctionViewsFilterPanel.clearButton;
    }

    static /* synthetic */ JCheckBox access$700(MatchedFunctionViewsFilterPanel matchedFunctionViewsFilterPanel) {
        return matchedFunctionViewsFilterPanel.showStructuralChangedFunctions;
    }

    static /* synthetic */ JCheckBox access$800(MatchedFunctionViewsFilterPanel matchedFunctionViewsFilterPanel) {
        return matchedFunctionViewsFilterPanel.showInstructionChangedOnlyFunctions;
    }

    static /* synthetic */ JCheckBox access$900(MatchedFunctionViewsFilterPanel matchedFunctionViewsFilterPanel) {
        return matchedFunctionViewsFilterPanel.showIdenticalFunctions;
    }

    static /* synthetic */ ListenerProvider access$1000(MatchedFunctionViewsFilterPanel matchedFunctionViewsFilterPanel) {
        return matchedFunctionViewsFilterPanel.checkBoxFilterListeners;
    }

    static /* synthetic */ MatchedFunctionViewsTable access$1100(MatchedFunctionViewsFilterPanel matchedFunctionViewsFilterPanel) {
        return matchedFunctionViewsFilterPanel.matchedFunctionsViewTable;
    }

    static /* synthetic */ ImageIcon access$1200() {
        return ICON_CLEAR;
    }
}

