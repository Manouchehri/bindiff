package com.google.security.zynamics.zylib.gui.tables;

import javax.swing.*;
import java.awt.*;

class CTableSorter$Arrow implements Icon
{
    private final boolean descending;
    private final int size;
    private final int priority;
    
    public CTableSorter$Arrow(final boolean descending, final int size, final int priority) {
        this.descending = descending;
        this.size = size;
        this.priority = priority;
    }
    
    @Override
    public int getIconHeight() {
        return this.size;
    }
    
    @Override
    public int getIconWidth() {
        return this.size;
    }
    
    @Override
    public void paintIcon(final Component component, final Graphics graphics, final int n, int n2) {
        final Color color = (component == null) ? Color.GRAY : component.getBackground();
        final int n3 = (int)(this.size / 2 * Math.pow(0.8, this.priority));
        final int n4 = this.descending ? n3 : (-n3);
        n2 = n2 + 5 * this.size / 6 + (this.descending ? (-n4) : false);
        final int n5 = this.descending ? 1 : -1;
        graphics.translate(n, n2);
        graphics.setColor(color.darker());
        graphics.drawLine(n3 / 2, n4, 0, 0);
        graphics.drawLine(n3 / 2, n4 + n5, 0, n5);
        graphics.setColor(color.brighter());
        graphics.drawLine(n3 / 2, n4, n3, 0);
        graphics.drawLine(n3 / 2, n4 + n5, n3, n5);
        if (this.descending) {
            graphics.setColor(color.darker().darker());
        }
        else {
            graphics.setColor(color.brighter().brighter());
        }
        graphics.drawLine(n3, 0, 0, 0);
        graphics.setColor(color);
        graphics.translate(-n, -n2);
    }
}
