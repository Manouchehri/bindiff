package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.subpanels;

import com.google.security.zynamics.bindiff.enums.*;
import javax.swing.*;
import com.google.common.base.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.*;
import com.google.security.zynamics.bindiff.gui.components.viewsearchfield.*;
import java.awt.event.*;
import java.util.*;
import com.google.security.zynamics.zylib.general.*;
import java.awt.*;
import javax.swing.border.*;
import com.google.security.zynamics.bindiff.utils.*;

public class UnmatchedFunctionViewsFilterPanel extends JPanel
{
    private static final ImageIcon ICON_OPTIONS;
    private static final ImageIcon ICON_CLEAR;
    private static final ImageIcon ICON_CLEAR_GRAY;
    private final UnmatchedFunctionViewsFilterPanel$InternalClearButtonLister clearButtonListener;
    private final UnmatchedFunctionViewsFilterPanel$InternalOptionButtonListener optionsButtonListener;
    private final UnmatchedFunctionViewsFilterPanel$InternalSearchResultListener searchResultListener;
    private final TableTextSearchComboBox searchCombobox;
    private final JButton optionsButton;
    private final JButton clearButton;
    private final UnmatchedFunctionViewsTable unmatchedFunctionsViewTable;
    private final ESide side;
    
    public UnmatchedFunctionViewsFilterPanel(final UnmatchedFunctionViewsTable unmatchedFunctionViewsTable, final ESide eSide) {
        super(new BorderLayout());
        this.clearButtonListener = new UnmatchedFunctionViewsFilterPanel$InternalClearButtonLister(this, null);
        this.optionsButtonListener = new UnmatchedFunctionViewsFilterPanel$InternalOptionButtonListener(this, null);
        this.searchResultListener = new UnmatchedFunctionViewsFilterPanel$InternalSearchResultListener(this, null);
        this.optionsButton = new JButton(UnmatchedFunctionViewsFilterPanel.ICON_OPTIONS);
        this.clearButton = new JButton(UnmatchedFunctionViewsFilterPanel.ICON_CLEAR_GRAY);
        this.unmatchedFunctionsViewTable = (UnmatchedFunctionViewsTable)Preconditions.checkNotNull(unmatchedFunctionViewsTable);
        this.side = (ESide)Preconditions.checkNotNull(eSide);
        (this.searchCombobox = new TableTextSearchComboBox(unmatchedFunctionViewsTable, getColumnIndices(eSide))).addListener(this.searchResultListener);
        this.clearButton.addActionListener(this.clearButtonListener);
        this.optionsButton.addActionListener(this.optionsButtonListener);
        this.clearButton.setToolTipText("Clear Search Results");
        this.optionsButton.setToolTipText("Search Settings");
        this.add(this.createPanel(), "West");
    }
    
    private static List getColumnIndices(final ESide eSide) {
        final ArrayList<Pair> list = new ArrayList<Pair>();
        list.add(new Pair(0, eSide));
        list.add(new Pair(1, eSide));
        list.add(new Pair(2, eSide));
        return list;
    }
    
    private JPanel createPanel() {
        this.searchCombobox.setBackground(Color.WHITE);
        this.searchCombobox.setMinimumSize(new Dimension(30, 0));
        this.searchCombobox.setMaximumSize(new Dimension(400, 0));
        final Dimension dimension = new Dimension(400, this.searchCombobox.getPreferredSize().height - 4);
        this.searchCombobox.setPreferredSize(dimension);
        this.searchCombobox.setSize(dimension);
        this.clearButton.setBackground(Color.WHITE);
        this.clearButton.setFocusable(false);
        this.clearButton.setPreferredSize(new Dimension(32, 23));
        final JPanel panel = new JPanel(new BorderLayout());
        panel.add(this.searchCombobox, "Center");
        final JPanel panel2 = new JPanel(new BorderLayout());
        panel2.add(this.clearButton, "Center");
        this.optionsButton.setPreferredSize(new Dimension(32, 23));
        this.optionsButton.setBackground(Color.WHITE);
        this.optionsButton.setFocusable(false);
        this.clearButton.setPreferredSize(new Dimension(32, 23));
        this.clearButton.setBackground(Color.WHITE);
        this.clearButton.setFocusable(false);
        final JPanel panel3 = new JPanel(new GridLayout(1, 2, 1, 1));
        panel3.setBorder(new EmptyBorder(0, 1, 0, 5));
        panel3.add(this.clearButton);
        panel3.add(this.optionsButton);
        panel2.add(panel3, "Center");
        panel.add(panel2, "East");
        final JPanel panel4 = new JPanel(new BorderLayout());
        panel4.setMaximumSize(new Dimension(467, 23));
        panel4.setMinimumSize(new Dimension(467, 23));
        panel4.setSize(new Dimension(467, 23));
        panel4.add(panel, "West");
        final JPanel panel5 = new JPanel(new BorderLayout());
        panel5.setBorder(new EmptyBorder(0, 0, 5, 0));
        panel5.add(panel4, "West");
        return panel5;
    }
    
    public void dispose() {
        this.searchCombobox.removeListener(this.searchResultListener);
        this.clearButton.removeActionListener(this.clearButtonListener);
    }
    
    public TableTextSearchComboBox getSearchCombobox() {
        return this.searchCombobox;
    }
    
    static {
        ICON_OPTIONS = ImageUtils.getImageIcon("data/buttonicons/options.png");
        ICON_CLEAR = ImageUtils.getImageIcon("data/buttonicons/clear.png");
        ICON_CLEAR_GRAY = ImageUtils.getImageIcon("data/buttonicons/clear-gray.png");
    }
}
