/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs.directorydiff;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class CheckboxCellRenderer
extends JCheckBox
implements TableCellRenderer {
    public CheckboxCellRenderer() {
        this.setHorizontalAlignment(0);
    }

    @Override
    public Component getTableCellRendererComponent(JTable jTable, Object object, boolean bl2, boolean bl3, int n2, int n3) {
        if (bl2) {
            this.setForeground(jTable.getSelectionForeground());
            this.setBackground(jTable.getSelectionBackground());
        } else {
            this.setForeground(jTable.getForeground());
            this.setBackground(jTable.getBackground());
        }
        this.setSelected(object != null && ((JCheckBox)object).isSelected());
        ((JCheckBox)object).setHorizontalAlignment(0);
        return this;
    }
}

