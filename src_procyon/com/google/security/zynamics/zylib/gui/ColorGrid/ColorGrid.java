package com.google.security.zynamics.zylib.gui.ColorGrid;

import javax.swing.*;
import java.util.*;
import com.google.common.base.*;
import java.awt.*;

public class ColorGrid extends JPanel
{
    private static final long serialVersionUID = -5981626927250840656L;
    private static final int squareSize = 40;
    private final List m_colors;
    private final int m_columns;
    
    public ColorGrid(final List list, final int columns) {
        this.m_colors = (List)Preconditions.checkNotNull(list, (Object)"Error: colors argument can not be null");
        this.m_columns = columns;
        this.setPreferredSize(new Dimension(columns * 40, (this.m_colors.size() / this.m_columns + ((this.m_colors.size() % this.m_columns != 0) ? 1 : 0)) * 40));
    }
    
    public Color getColorAt(final int n, final int n2) {
        final int n3 = n2 / 40;
        final int n4 = n / 40;
        if (n3 * this.m_columns + n4 < this.m_colors.size()) {
            return (Color)this.m_colors.get(n3 * this.m_columns + n4);
        }
        return null;
    }
    
    @Override
    public void paint(final Graphics graphics) {
        for (int n = this.m_colors.size() / this.m_columns + ((this.m_colors.size() % this.m_columns != 0) ? 1 : 0), i = 0; i < n; ++i) {
            for (int n2 = 0; n2 < this.m_columns && i * this.m_columns + n2 < this.m_colors.size(); ++n2) {
                graphics.setColor((Color)this.m_colors.get(i * this.m_columns + n2));
                graphics.fillRect(n2 * 40, i * 40, 40, 40);
                graphics.setColor(Color.BLACK);
                graphics.drawRect(n2 * 40, i * 40, 40, 40);
            }
        }
    }
}
