/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs.graphnodetreeoptionsdialog.tabcomponents;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.ESortOrder;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.util.List;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class SortingComboboxPanel
extends JPanel {
    private final JComboBox combobox;
    private final JLabel label;
    private final JRadioButton ascSorting;
    private final JRadioButton descSorting;
    private final int height;

    public SortingComboboxPanel(String string, List list, int n2, int n3, int n4) {
        super(new BorderLayout());
        Preconditions.checkNotNull(string);
        Preconditions.checkNotNull(list);
        this.label = new JLabel(string);
        String[] arrstring = new String[list.size()];
        list.toArray(arrstring);
        this.combobox = new JComboBox<String>(arrstring);
        this.label.setPreferredSize(new Dimension(n2, n4));
        this.combobox.setPreferredSize(new Dimension(n3, n4));
        this.ascSorting = new JRadioButton("\u25b2");
        this.descSorting = new JRadioButton("\u25bc");
        this.ascSorting.setPreferredSize(new Dimension(this.ascSorting.getPreferredSize().width, n4));
        this.descSorting.setPreferredSize(new Dimension(this.descSorting.getPreferredSize().width, n4));
        this.ascSorting.setToolTipText("Ascending");
        this.descSorting.setToolTipText("Descending");
        this.ascSorting.setSelected(true);
        this.height = n4;
        this.init();
    }

    private JPanel createSortSequencePane() {
        this.ascSorting.setForeground(Color.GRAY);
        this.descSorting.setForeground(Color.GRAY);
        this.ascSorting.setFocusable(false);
        this.descSorting.setFocusable(false);
        JPanel jPanel = new JPanel(new GridLayout(1, 2));
        jPanel.setBorder(new TitledBorder(""));
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(this.ascSorting);
        buttonGroup.add(this.descSorting);
        jPanel.add(this.ascSorting);
        jPanel.add(this.descSorting);
        JPanel jPanel2 = new JPanel(new BorderLayout());
        jPanel2.setBorder(new EmptyBorder(0, 1, 0, 0));
        jPanel2.add((Component)jPanel, "Center");
        return jPanel2;
    }

    public ESortOrder getSortOrder() {
        if (!this.ascSorting.isSelected()) return ESortOrder.DESCENDING;
        return ESortOrder.ASCENDING;
    }

    public String getValue() {
        return this.combobox.getSelectedItem().toString();
    }

    public void init() {
        this.setBorder(new EmptyBorder(2, 2, 2, 2));
        JPanel jPanel = new JPanel(new BorderLayout());
        jPanel.add((Component)this.label, "West");
        jPanel.add((Component)this.combobox, "Center");
        jPanel.add((Component)this.createSortSequencePane(), "East");
        jPanel.setPreferredSize(new Dimension(jPanel.getPreferredSize().width, this.height));
        this.add((Component)jPanel, "Center");
    }

    public void setSelectItem(String string, ESortOrder eSortOrder) {
        this.ascSorting.setSelected(eSortOrder == ESortOrder.ASCENDING);
        this.combobox.setSelectedItem(string);
    }
}

