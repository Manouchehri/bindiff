/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.ColorGrid;

import com.google.common.base.Preconditions;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.List;
import javax.swing.JPanel;

public class ColorGrid
extends JPanel {
    private static final long serialVersionUID = -5981626927250840656L;
    private static final int squareSize = 40;
    private final List m_colors;
    private final int m_columns;

    public ColorGrid(List list, int n2) {
        this.m_colors = (List)Preconditions.checkNotNull(list, "Error: colors argument can not be null");
        this.m_columns = n2;
        int n3 = this.m_colors.size() / this.m_columns + (this.m_colors.size() % this.m_columns == 0 ? 0 : 1);
        this.setPreferredSize(new Dimension(n2 * 40, n3 * 40));
    }

    public Color getColorAt(int n2, int n3) {
        int n4 = n3 / 40;
        int n5 = n2 / 40;
        if (n4 * this.m_columns + n5 >= this.m_colors.size()) return null;
        return (Color)this.m_colors.get(n4 * this.m_columns + n5);
    }

    @Override
    public void paint(Graphics graphics) {
        int n2 = this.m_colors.size() / this.m_columns + (this.m_colors.size() % this.m_columns == 0 ? 0 : 1);
        int n3 = 0;
        while (n3 < n2) {
            for (int i2 = 0; i2 < this.m_columns && n3 * this.m_columns + i2 < this.m_colors.size(); ++i2) {
                graphics.setColor((Color)this.m_colors.get(n3 * this.m_columns + i2));
                graphics.fillRect(i2 * 40, n3 * 40, 40, 40);
                graphics.setColor(Color.BLACK);
                graphics.drawRect(i2 * 40, n3 * 40, 40, 40);
            }
            ++n3;
        }
    }
}

