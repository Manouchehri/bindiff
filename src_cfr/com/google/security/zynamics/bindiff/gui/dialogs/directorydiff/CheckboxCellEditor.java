/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs.directorydiff;

import java.awt.Component;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;

public class CheckboxCellEditor
extends DefaultCellEditor
implements ItemListener {
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
    public Component getTableCellEditorComponent(JTable jTable, Object object, boolean bl2, int n2, int n3) {
        if (object == null) {
            return null;
        }
        this.checkbox = (JCheckBox)object;
        this.checkbox.addItemListener(this);
        return (Component)object;
    }

    @Override
    public void itemStateChanged(ItemEvent itemEvent) {
        super.fireEditingStopped();
    }
}

