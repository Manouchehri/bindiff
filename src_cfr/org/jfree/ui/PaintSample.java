/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import javax.swing.JComponent;

public class PaintSample
extends JComponent {
    private Paint paint;
    private Dimension preferredSize;

    public PaintSample(Paint paint) {
        this.paint = paint;
        this.preferredSize = new Dimension(80, 12);
    }

    public Paint getPaint() {
        return this.paint;
    }

    public void setPaint(Paint paint) {
        this.paint = paint;
        this.repaint();
    }

    @Override
    public Dimension getPreferredSize() {
        return this.preferredSize;
    }

    @Override
    public void paintComponent(Graphics graphics) {
        Graphics2D graphics2D = (Graphics2D)graphics;
        Dimension dimension = this.getSize();
        Insets insets = this.getInsets();
        double d2 = insets.left;
        double d3 = insets.top;
        double d4 = dimension.getWidth() - (double)insets.left - (double)insets.right - 1.0;
        double d5 = dimension.getHeight() - (double)insets.top - (double)insets.bottom - 1.0;
        Rectangle2D.Double double_ = new Rectangle2D.Double(d2, d3, d4, d5);
        graphics2D.setPaint(this.paint);
        graphics2D.fill(double_);
        graphics2D.setPaint(Color.black);
        graphics2D.draw(double_);
    }
}

