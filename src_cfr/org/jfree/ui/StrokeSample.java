/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.ui;

import java.awt.BasicStroke;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class StrokeSample
extends JComponent
implements ListCellRenderer {
    private Stroke stroke;
    private Dimension preferredSize;

    public StrokeSample(Stroke stroke) {
        this.stroke = stroke;
        this.preferredSize = new Dimension(80, 18);
    }

    public Stroke getStroke() {
        return this.stroke;
    }

    public void setStroke(Stroke stroke) {
        this.stroke = stroke;
        this.repaint();
    }

    @Override
    public Dimension getPreferredSize() {
        return this.preferredSize;
    }

    @Override
    public void paintComponent(Graphics graphics) {
        Graphics2D graphics2D = (Graphics2D)graphics;
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Dimension dimension = this.getSize();
        Insets insets = this.getInsets();
        double d2 = insets.left;
        double d3 = insets.top;
        double d4 = dimension.getWidth() - (double)insets.left - (double)insets.right;
        double d5 = dimension.getHeight() - (double)insets.top - (double)insets.bottom;
        Point2D.Double double_ = new Point2D.Double(d2 + 6.0, d3 + d5 / 2.0);
        Point2D.Double double_2 = new Point2D.Double(d2 + d4 - 6.0, d3 + d5 / 2.0);
        Ellipse2D.Double double_3 = new Ellipse2D.Double(double_.getX() - 5.0, double_.getY() - 5.0, 10.0, 10.0);
        Ellipse2D.Double double_4 = new Ellipse2D.Double(double_2.getX() - 6.0, double_2.getY() - 5.0, 10.0, 10.0);
        graphics2D.draw(double_3);
        graphics2D.fill(double_3);
        graphics2D.draw(double_4);
        graphics2D.fill(double_4);
        Line2D.Double double_5 = new Line2D.Double(double_, double_2);
        if (this.stroke != null) {
            graphics2D.setStroke(this.stroke);
        } else {
            graphics2D.setStroke(new BasicStroke(0.0f));
        }
        graphics2D.draw(double_5);
    }

    public Component getListCellRendererComponent(JList jList, Object object, int n2, boolean bl2, boolean bl3) {
        if (!(object instanceof StrokeSample)) return this;
        StrokeSample strokeSample = (StrokeSample)object;
        this.setStroke(strokeSample.getStroke());
        return this;
    }
}

