/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.text.DateFormat;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class DateCellRenderer
extends DefaultTableCellRenderer {
    private DateFormat formatter;

    public DateCellRenderer() {
        this(DateFormat.getDateTimeInstance());
    }

    public DateCellRenderer(DateFormat dateFormat) {
        this.formatter = dateFormat;
        this.setHorizontalAlignment(0);
    }

    @Override
    public Component getTableCellRendererComponent(JTable jTable, Object object, boolean bl2, boolean bl3, int n2, int n3) {
        this.setFont(null);
        if (object != null) {
            this.setText(this.formatter.format(object));
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

