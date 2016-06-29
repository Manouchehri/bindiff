package com.google.security.zynamics.bindiff.gui.dialogs.directorydiff;

import javax.swing.table.*;
import javax.swing.*;
import java.awt.*;

public class CheckboxCellRenderer extends JCheckBox implements TableCellRenderer
{
    public CheckboxCellRenderer() {
        this.setHorizontalAlignment(0);
    }
    
    @Override
    public Component getTableCellRendererComponent(final JTable table, final Object o, final boolean b, final boolean b2, final int n, final int n2) {
        if (b) {
            this.setForeground(table.getSelectionForeground());
            this.setBackground(table.getSelectionBackground());
        }
        else {
            this.setForeground(table.getForeground());
            this.setBackground(table.getBackground());
        }
        this.setSelected(o != null && ((JCheckBox)o).isSelected());
        ((JCheckBox)o).setHorizontalAlignment(0);
        return this;
    }
}
