/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs.graphnodetreeoptionsdialog.tabcomponents;

import com.google.common.base.Preconditions;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class FilterComboboxPanel
extends JPanel {
    private final JComboBox combobox;
    private final JLabel label;

    public FilterComboboxPanel(String string, List list, int n2, int n3, int n4) {
        super(new BorderLayout());
        Preconditions.checkNotNull(string);
        Preconditions.checkNotNull(list);
        this.label = new JLabel(string);
        String[] arrstring = new String[list.size()];
        list.toArray(arrstring);
        this.combobox = new JComboBox<String>(arrstring);
        this.label.setPreferredSize(new Dimension(n2, n4));
        this.combobox.setPreferredSize(new Dimension(n3, n4));
        this.init();
    }

    public String getValue() {
        return this.combobox.getSelectedItem().toString();
    }

    public void init() {
        this.setBorder(new EmptyBorder(1, 2, 2, 2));
        JPanel jPanel = new JPanel(new BorderLayout());
        jPanel.add((Component)this.label, "West");
        jPanel.add((Component)this.combobox, "Center");
        this.add((Component)jPanel, "Center");
    }

    public void setValue(String string) {
        this.combobox.setSelectedItem(string);
    }
}

