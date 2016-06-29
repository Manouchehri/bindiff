package com.google.security.zynamics.bindiff.gui.dialogs.graphnodetreeoptionsdialog.tabcomponents;

import java.util.*;
import com.google.common.base.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import com.google.security.zynamics.bindiff.enums.*;

public class SortingComboboxPanel extends JPanel
{
    private final JComboBox combobox;
    private final JLabel label;
    private final JRadioButton ascSorting;
    private final JRadioButton descSorting;
    private final int height;
    
    public SortingComboboxPanel(final String s, final List list, final int n, final int n2, final int height) {
        super(new BorderLayout());
        Preconditions.checkNotNull(s);
        Preconditions.checkNotNull(list);
        this.label = new JLabel(s);
        final String[] array = new String[list.size()];
        list.toArray(array);
        this.combobox = new JComboBox(array);
        this.label.setPreferredSize(new Dimension(n, height));
        this.combobox.setPreferredSize(new Dimension(n2, height));
        this.ascSorting = new JRadioButton("\u25b2");
        this.descSorting = new JRadioButton("\u25bc");
        this.ascSorting.setPreferredSize(new Dimension(this.ascSorting.getPreferredSize().width, height));
        this.descSorting.setPreferredSize(new Dimension(this.descSorting.getPreferredSize().width, height));
        this.ascSorting.setToolTipText("Ascending");
        this.descSorting.setToolTipText("Descending");
        this.ascSorting.setSelected(true);
        this.height = height;
        this.init();
    }
    
    private JPanel createSortSequencePane() {
        this.ascSorting.setForeground(Color.GRAY);
        this.descSorting.setForeground(Color.GRAY);
        this.ascSorting.setFocusable(false);
        this.descSorting.setFocusable(false);
        final JPanel panel = new JPanel(new GridLayout(1, 2));
        panel.setBorder(new TitledBorder(""));
        final ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(this.ascSorting);
        buttonGroup.add(this.descSorting);
        panel.add(this.ascSorting);
        panel.add(this.descSorting);
        final JPanel panel2 = new JPanel(new BorderLayout());
        panel2.setBorder(new EmptyBorder(0, 1, 0, 0));
        panel2.add(panel, "Center");
        return panel2;
    }
    
    public ESortOrder getSortOrder() {
        if (this.ascSorting.isSelected()) {
            return ESortOrder.ASCENDING;
        }
        return ESortOrder.DESCENDING;
    }
    
    public String getValue() {
        return this.combobox.getSelectedItem().toString();
    }
    
    public void init() {
        this.setBorder(new EmptyBorder(2, 2, 2, 2));
        final JPanel panel = new JPanel(new BorderLayout());
        panel.add(this.label, "West");
        panel.add(this.combobox, "Center");
        panel.add(this.createSortSequencePane(), "East");
        panel.setPreferredSize(new Dimension(panel.getPreferredSize().width, this.height));
        this.add(panel, "Center");
    }
    
    public void setSelectItem(final String selectedItem, final ESortOrder eSortOrder) {
        this.ascSorting.setSelected(eSortOrder == ESortOrder.ASCENDING);
        this.combobox.setSelectedItem(selectedItem);
    }
}
