package org.jfree.ui;

import javax.swing.table.*;
import javax.swing.*;
import java.text.*;
import java.awt.*;

public class NumberCellRenderer extends DefaultTableCellRenderer
{
    public NumberCellRenderer() {
        this.setHorizontalAlignment(4);
    }
    
    public Component getTableCellRendererComponent(final JTable table, final Object o, final boolean b, final boolean b2, final int n, final int n2) {
        this.setFont(null);
        final NumberFormat numberInstance = NumberFormat.getNumberInstance();
        if (o != null) {
            this.setText(numberInstance.format(o));
        }
        else {
            this.setText("");
        }
        if (b) {
            this.setBackground(table.getSelectionBackground());
        }
        else {
            this.setBackground(null);
        }
        return this;
    }
}
