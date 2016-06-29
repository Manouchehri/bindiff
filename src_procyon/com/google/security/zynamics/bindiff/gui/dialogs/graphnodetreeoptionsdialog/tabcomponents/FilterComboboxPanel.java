package com.google.security.zynamics.bindiff.gui.dialogs.graphnodetreeoptionsdialog.tabcomponents;

import javax.swing.*;
import java.util.*;
import com.google.common.base.*;
import javax.swing.border.*;
import java.awt.*;

public class FilterComboboxPanel extends JPanel
{
    private final JComboBox combobox;
    private final JLabel label;
    
    public FilterComboboxPanel(final String s, final List list, final int n, final int n2, final int n3) {
        super(new BorderLayout());
        Preconditions.checkNotNull(s);
        Preconditions.checkNotNull(list);
        this.label = new JLabel(s);
        final String[] array = new String[list.size()];
        list.toArray(array);
        this.combobox = new JComboBox(array);
        this.label.setPreferredSize(new Dimension(n, n3));
        this.combobox.setPreferredSize(new Dimension(n2, n3));
        this.init();
    }
    
    public String getValue() {
        return this.combobox.getSelectedItem().toString();
    }
    
    public void init() {
        this.setBorder(new EmptyBorder(1, 2, 2, 2));
        final JPanel panel = new JPanel(new BorderLayout());
        panel.add(this.label, "West");
        panel.add(this.combobox, "Center");
        this.add(panel, "Center");
    }
    
    public void setValue(final String selectedItem) {
        this.combobox.setSelectedItem(selectedItem);
    }
}
