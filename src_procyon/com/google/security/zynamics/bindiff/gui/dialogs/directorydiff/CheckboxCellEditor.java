package com.google.security.zynamics.bindiff.gui.dialogs.directorydiff;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CheckboxCellEditor extends DefaultCellEditor implements ItemListener
{
    private JCheckBox checkbox;
    
    public CheckboxCellEditor() {
        super(new JCheckBox());
    }
    
    @Override
    public Object getCellEditorValue() {
        this.checkbox.removeItemListener(this);
        return this.checkbox;
    }
    
    @Override
    public Component getTableCellEditorComponent(final JTable table, final Object o, final boolean b, final int n, final int n2) {
        if (o == null) {
            return null;
        }
        (this.checkbox = (JCheckBox)o).addItemListener(this);
        return (Component)o;
    }
    
    @Override
    public void itemStateChanged(final ItemEvent itemEvent) {
        super.fireEditingStopped();
    }
}
