/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.tables;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import javax.swing.Icon;

class CTableSorter$Arrow
implements Icon {
    private final boolean descending;
    private final int size;
    private final int priority;

    public CTableSorter$Arrow(boolean bl2, int n2, int n3) {
        this.descending = bl2;
        this.size = n2;
        this.priority = n3;
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
    public void paintIcon(Component component, Graphics graphics, int n2, int n3) {
        Color color = component == null ? Color.GRAY : component.getBackground();
        int n4 = (int)((double)(this.size / 2) * Math.pow(0.8, this.priority));
        int n5 = this.descending ? n4 : - n4;
        n3 = n3 + 5 * this.size / 6 + (this.descending ? - n5 : 0);
        int n6 = this.descending ? 1 : -1;
        graphics.translate(n2, n3);
        graphics.setColor(color.darker());
        graphics.drawLine(n4 / 2, n5, 0, 0);
        graphics.drawLine(n4 / 2, n5 + n6, 0, n6);
        graphics.setColor(color.brighter());
        graphics.drawLine(n4 / 2, n5, n4, 0);
        graphics.drawLine(n4 / 2, n5 + n6, n4, n6);
        if (this.descending) {
            graphics.setColor(color.darker().darker());
        } else {
            graphics.setColor(color.brighter().brighter());
        }
        graphics.drawLine(n4, 0, 0, 0);
        graphics.setColor(color);
        graphics.translate(- n2, - n3);
    }
}

