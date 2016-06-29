package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.renderers;

import java.awt.*;
import com.google.security.zynamics.zylib.disassembly.*;
import java.util.*;
import com.google.security.zynamics.zylib.date.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers.*;
import javax.swing.*;

public class BackgroundCellRenderer extends AbstractTableCellRenderer
{
    final Color backgroundColor;
    final Color textColor;
    final int horizontalAlignment;
    boolean isNotAccessable;
    
    public BackgroundCellRenderer(final Color backgroundColor, final Color textColor, final int horizontalAlignment) {
        this.isNotAccessable = false;
        this.backgroundColor = backgroundColor;
        this.textColor = textColor;
        this.horizontalAlignment = horizontalAlignment;
    }
    
    @Override
    public Component getTableCellRendererComponent(final JTable table, final Object o, final boolean b, final boolean b2, final int n, final int n2) {
        this.buildAndSetToolTip(table, n);
        this.setFont(this.isBoldFont(table, n) ? BackgroundCellRenderer.BOLD_FONT : BackgroundCellRenderer.NORMAL_FONT);
        if (o instanceof String) {
            final String s = (String)o;
            this.isNotAccessable = s.equals("");
        }
        else if (o instanceof Double) {
            final String s = Double.toString((double)o);
            this.isNotAccessable = ((double)o == -1.0);
        }
        else if (o instanceof Integer) {
            final String s = Integer.toString((int)o);
        }
        else if (o instanceof IAddress) {
            final String s = ((IAddress)o).toHexString();
        }
        else {
            if (!(o instanceof Date)) {
                throw new IllegalArgumentException(String.format("Value must be a String, IAddress, Double Integer or Date. (%s)", o.getClass().toString()));
            }
            final String s = DateHelpers.formatDateTime((Date)o);
        }
        String s;
        this.setIcon(new BackgroundIcon(this.isNotAccessable ? BackgroundCellRenderer.NOT_ACCESSABLE_TEXT : s, this.horizontalAlignment, this.textColor, this.isNotAccessable ? BackgroundCellRenderer.NOT_ACCESSABLE_COLOR : this.backgroundColor, table.getSelectionBackground(), b, -1, 0, table.getColumnModel().getColumn(n2).getWidth() - 1, table.getRowHeight() - 1));
        return this;
    }
}
