/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.renderers;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers.BackgroundIcon;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.renderers.AbstractTableCellRenderer;
import com.google.security.zynamics.zylib.date.DateHelpers;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.Date;
import javax.swing.Icon;
import javax.swing.JTable;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class BackgroundCellRenderer
extends AbstractTableCellRenderer {
    final Color backgroundColor;
    final Color textColor;
    final int horizontalAlignment;
    boolean isNotAccessable = false;

    public BackgroundCellRenderer(Color color, Color color2, int n2) {
        this.backgroundColor = color;
        this.textColor = color2;
        this.horizontalAlignment = n2;
    }

    @Override
    public Component getTableCellRendererComponent(JTable jTable, Object object, boolean bl2, boolean bl3, int n2, int n3) {
        String string;
        this.buildAndSetToolTip(jTable, n2);
        this.setFont(!this.isBoldFont(jTable, n2) ? NORMAL_FONT : BOLD_FONT);
        if (object instanceof String) {
            string = (String)object;
            this.isNotAccessable = string.equals("");
        } else if (object instanceof Double) {
            string = Double.toString((Double)object);
            this.isNotAccessable = (Double)object == -1.0;
        } else if (object instanceof Integer) {
            string = Integer.toString((Integer)object);
        } else if (object instanceof IAddress) {
            string = ((IAddress)object).toHexString();
        } else {
            if (!(object instanceof Date)) {
                throw new IllegalArgumentException(String.format("Value must be a String, IAddress, Double Integer or Date. (%s)", object.getClass().toString()));
            }
            string = DateHelpers.formatDateTime((Date)object);
        }
        this.setIcon(new BackgroundIcon(this.isNotAccessable ? NOT_ACCESSABLE_TEXT : string, this.horizontalAlignment, this.textColor, this.isNotAccessable ? NOT_ACCESSABLE_COLOR : this.backgroundColor, jTable.getSelectionBackground(), bl2, -1, 0, jTable.getColumnModel().getColumn(n3).getWidth() - 1, jTable.getRowHeight() - 1));
        return this;
    }
}

