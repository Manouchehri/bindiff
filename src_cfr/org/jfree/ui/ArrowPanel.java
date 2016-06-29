/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.ui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;

public class ArrowPanel
extends JPanel {
    public static final int UP = 0;
    public static final int DOWN = 1;
    private int type = 0;
    private Rectangle2D available = new Rectangle2D.Float();

    public ArrowPanel(int n2) {
        this.type = n2;
        this.setPreferredSize(new Dimension(14, 9));
    }

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D)graphics;
        Dimension dimension = this.getSize();
        Insets insets = this.getInsets();
        this.available.setRect(insets.left, insets.top, dimension.getWidth() - (double)insets.left - (double)insets.right, dimension.getHeight() - (double)insets.top - (double)insets.bottom);
        graphics2D.translate(insets.left, insets.top);
        graphics2D.fill(this.getArrow(this.type));
    }

    private Shape getArrow(int n2) {
        switch (n2) {
            case 0: {
                return this.getUpArrow();
            }
            case 1: {
                return this.getDownArrow();
            }
        }
        return this.getUpArrow();
    }

    private Shape getUpArrow() {
        Polygon polygon = new Polygon();
        polygon.addPoint(7, 2);
        polygon.addPoint(2, 7);
        polygon.addPoint(12, 7);
        return polygon;
    }

    private Shape getDownArrow() {
        Polygon polygon = new Polygon();
        polygon.addPoint(7, 7);
        polygon.addPoint(2, 2);
        polygon.addPoint(12, 2);
        return polygon;
    }
}

