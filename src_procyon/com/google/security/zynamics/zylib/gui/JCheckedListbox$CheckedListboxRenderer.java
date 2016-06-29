package com.google.security.zynamics.zylib.gui;

import javax.swing.border.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

class JCheckedListbox$CheckedListboxRenderer extends JPanel implements ListCellRenderer
{
    private static final long serialVersionUID = 7446207257969469739L;
    private final JCheckBox checkBox;
    private final LineBorder SELECTED_BORDER;
    private final LineBorder UNSELECTED_BORDER;
    private final Color SELECTED_COLOR;
    private final Color UNSELECTED_COLOR;
    final /* synthetic */ JCheckedListbox this$0;
    
    public JCheckedListbox$CheckedListboxRenderer(final JCheckedListbox this$0) {
        this.this$0 = this$0;
        super(new BorderLayout());
        this.checkBox = new JCheckBox();
        this.SELECTED_BORDER = new LineBorder(Color.DARK_GRAY);
        this.UNSELECTED_BORDER = new LineBorder(Color.WHITE);
        this.SELECTED_COLOR = new Color(12439527);
        this.UNSELECTED_COLOR = Color.WHITE;
        this.setBorder(this.UNSELECTED_BORDER);
        this.setBackground(this.UNSELECTED_COLOR);
        this.checkBox.setBackground(this.UNSELECTED_COLOR);
    }
    
    @Override
    public Component getListCellRendererComponent(final JList list, final Object o, final int n, final boolean b, final boolean b2) {
        this.checkBox.setEnabled(this.this$0.isEnabled());
        if (this.this$0.m_selectCompleteLine) {
            this.setBorder(b ? this.SELECTED_BORDER : this.UNSELECTED_BORDER);
            this.setBackground(b ? this.SELECTED_COLOR : this.UNSELECTED_COLOR);
            this.checkBox.setBackground(b ? this.SELECTED_COLOR : this.UNSELECTED_COLOR);
        }
        this.checkBox.setText(o.toString());
        this.checkBox.setSelected(this.this$0.m_selected[n]);
        this.checkBox.updateUI();
        this.add(this.checkBox, "West");
        return this;
    }
}
