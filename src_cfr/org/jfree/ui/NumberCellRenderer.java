/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.text.NumberFormat;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class NumberCellRenderer
extends DefaultTableCellRenderer {
    public NumberCellRenderer() {
        this.setHorizontalAlignment(4);
    }

    @Override
    public Component getTableCellRendererComponent(JTable jTable, Object object, boolean bl2, boolean bl3, int n2, int n3) {
        this.setFont(null);
        NumberFormat numberFormat = NumberFormat.getNumberInstance();
        if (object != null) {
            this.setText(numberFormat.format(object));
        } else {
            this.setText("");
        }
        if (bl2) {
            this.setBackground(jTable.getSelectionBackground());
            return this;
        }
        this.setBackground(null);
        return this;
    }
}

