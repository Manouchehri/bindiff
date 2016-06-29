package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.subpanels;

import javax.swing.*;
import com.google.common.base.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.*;
import com.google.security.zynamics.bindiff.gui.components.viewsearchfield.*;
import java.awt.event.*;
import java.util.*;
import com.google.security.zynamics.zylib.general.*;
import com.google.security.zynamics.bindiff.enums.*;
import javax.swing.border.*;
import java.awt.*;
import com.google.security.zynamics.bindiff.utils.*;

public class MatchedFunctionViewsFilterPanel extends JPanel
{
    private static final ImageIcon ICON_OPTIONS;
    private static final ImageIcon ICON_CLEAR;
    private static final ImageIcon ICON_CLEAR_GRAY;
    private final ListenerProvider checkBoxFilterListeners;
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
    
    public MatchedFunctionViewsFilterPanel(final MatchedFunctionViewsTable matchedFunctionsViewTable) {
        super(new BorderLayout());
        this.checkBoxFilterListeners = new ListenerProvider();
        this.clearButtonListener = new MatchedFunctionViewsFilterPanel$InternalClearButtonLister(this, null);
        this.optionsButton = new JButton(MatchedFunctionViewsFilterPanel.ICON_OPTIONS);
        this.clearButton = new JButton(MatchedFunctionViewsFilterPanel.ICON_CLEAR_GRAY);
        this.showStructuralChangedFunctions = new JCheckBox("Show structural changes", true);
        this.showInstructionChangedOnlyFunctions = new JCheckBox("Show only instructions changed", true);
        this.showIdenticalFunctions = new JCheckBox("Show identical", true);
        Preconditions.checkNotNull(matchedFunctionsViewTable);
        this.searchResultListener = new MatchedFunctionViewsFilterPanel$InternalSearchResultListener(this, null);
        this.filterCheckboxListener = new MatchedFunctionViewsFilterPanel$InternalFilterCheckboxListener(this, null);
        this.optionsButtonListener = new MatchedFunctionViewsFilterPanel$InternalOptionButtonListener(this, null);
        this.matchedFunctionsViewTable = matchedFunctionsViewTable;
        (this.searchCombobox = new TableTextSearchComboBox(matchedFunctionsViewTable, getColumnIndices())).addListener(this.searchResultListener);
        this.clearButton.addActionListener(this.clearButtonListener);
        this.optionsButton.addActionListener(this.optionsButtonListener);
        this.clearButton.setToolTipText("Clear Search Results");
        this.optionsButton.setToolTipText("Search Settings");
        this.showStructuralChangedFunctions.addItemListener(this.filterCheckboxListener);
        this.showInstructionChangedOnlyFunctions.addItemListener(this.filterCheckboxListener);
        this.showIdenticalFunctions.addItemListener(this.filterCheckboxListener);
        this.searchCombobox.setSearchOptions(false, false, true, true, false);
        this.add(this.createPanel(), "Center");
    }
    
    private static List getColumnIndices() {
        final ArrayList<Pair> list = new ArrayList<Pair>();
        list.add(new Pair(3, ESide.PRIMARY));
        list.add(new Pair(4, ESide.PRIMARY));
        list.add(new Pair(5, ESide.PRIMARY));
        list.add(new Pair(6, ESide.SECONDARY));
        list.add(new Pair(7, ESide.SECONDARY));
        list.add(new Pair(8, ESide.SECONDARY));
        return list;
    }
    
    private JPanel createChangesFilterPanel() {
        this.showStructuralChangedFunctions.setMinimumSize(new Dimension(0, 0));
        this.showInstructionChangedOnlyFunctions.setMinimumSize(new Dimension(0, 0));
        this.showIdenticalFunctions.setMinimumSize(new Dimension(0, 0));
        final JPanel panel = new JPanel(new BorderLayout());
        panel.add(this.showStructuralChangedFunctions, "West");
        final JPanel panel2 = new JPanel(new BorderLayout());
        panel2.add(this.showInstructionChangedOnlyFunctions, "West");
        panel.add(panel2, "Center");
        final JPanel panel3 = new JPanel(new BorderLayout());
        panel3.add(this.showIdenticalFunctions, "West");
        panel2.add(panel3, "Center");
        return panel;
    }
    
    private JPanel createPanel() {
        this.searchCombobox.setBackground(Color.WHITE);
        this.searchCombobox.setMinimumSize(new Dimension(30, 0));
        final Dimension dimension = new Dimension(this.searchCombobox.getPreferredSize().width, this.searchCombobox.getPreferredSize().height - 4);
        this.searchCombobox.setPreferredSize(dimension);
        this.searchCombobox.setSize(dimension);
        final JPanel panel = new JPanel(new BorderLayout());
        panel.add(this.searchCombobox, "Center");
        final JPanel panel2 = new JPanel(new BorderLayout());
        panel2.add(this.createTextFilterPanel(), "West");
        final JPanel panel3 = new JPanel(new BorderLayout());
        panel3.add(this.createChangesFilterPanel(), "West");
        panel3.setBorder(new EmptyBorder(0, 5, 0, 1));
        panel.add(panel2, "East");
        panel2.add(panel3, "Center");
        final JPanel panel4 = new JPanel(new BorderLayout());
        panel4.setBorder(new EmptyBorder(0, 0, 5, 0));
        panel4.add(panel);
        return panel4;
    }
    
    private JPanel createTextFilterPanel() {
        final JPanel panel = new JPanel(new BorderLayout());
        final Dimension preferredSize = this.searchCombobox.getPreferredSize();
        this.optionsButton.setPreferredSize(new Dimension(32, preferredSize.height));
        this.optionsButton.setBackground(Color.WHITE);
        this.optionsButton.setFocusable(false);
        this.clearButton.setPreferredSize(new Dimension(32, preferredSize.height));
        this.clearButton.setBackground(Color.WHITE);
        this.clearButton.setFocusable(false);
        final JPanel panel2 = new JPanel(new GridLayout(1, 2, 1, 1));
        panel2.setBorder(new EmptyBorder(0, 1, 0, 0));
        panel2.add(this.clearButton);
        panel2.add(this.optionsButton);
        panel.add(panel2, "Center");
        return panel;
    }
    
    public void addListener(final IViewsFilterCheckboxListener viewsFilterCheckboxListener) {
        this.checkBoxFilterListeners.addListener(viewsFilterCheckboxListener);
    }
    
    public void dispose() {
        this.searchCombobox.removeListener(this.searchResultListener);
        this.clearButton.removeActionListener(this.clearButtonListener);
        this.optionsButton.removeActionListener(this.optionsButtonListener);
        this.showStructuralChangedFunctions.removeItemListener(this.filterCheckboxListener);
        this.showInstructionChangedOnlyFunctions.removeItemListener(this.filterCheckboxListener);
        this.showIdenticalFunctions.removeItemListener(this.filterCheckboxListener);
    }
    
    public void removeListener(final IViewsFilterCheckboxListener viewsFilterCheckboxListener) {
        this.checkBoxFilterListeners.removeListener(viewsFilterCheckboxListener);
    }
    
    static {
        ICON_OPTIONS = ImageUtils.getImageIcon("data/buttonicons/options.png");
        ICON_CLEAR = ImageUtils.getImageIcon("data/buttonicons/clear.png");
        ICON_CLEAR_GRAY = ImageUtils.getImageIcon("data/buttonicons/clear-gray.png");
    }
}
