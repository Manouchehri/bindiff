package org.jfree.ui;

import javax.swing.table.*;
import java.text.*;
import javax.swing.*;
import java.awt.*;

public class DateCellRenderer extends DefaultTableCellRenderer
{
    private DateFormat formatter;
    
    public DateCellRenderer() {
        this(DateFormat.getDateTimeInstance());
    }
    
    public DateCellRenderer(final DateFormat formatter) {
        this.formatter = formatter;
        this.setHorizontalAlignment(0);
    }
    
    public Component getTableCellRendererComponent(final JTable table, final Object o, final boolean b, final boolean b2, final int n, final int n2) {
        this.setFont(null);
        if (o != null) {
            this.setText(this.formatter.format(o));
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
