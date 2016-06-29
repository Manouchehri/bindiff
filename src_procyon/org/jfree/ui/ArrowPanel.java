package org.jfree.ui;

import javax.swing.*;
import java.awt.geom.*;
import java.awt.*;

public class ArrowPanel extends JPanel
{
    public static final int UP = 0;
    public static final int DOWN = 1;
    private int type;
    private Rectangle2D available;
    
    public ArrowPanel(final int type) {
        this.type = 0;
        this.available = new Rectangle2D.Float();
        this.type = type;
        this.setPreferredSize(new Dimension(14, 9));
    }
    
    public void paintComponent(final Graphics graphics) {
        super.paintComponent(graphics);
        final Graphics2D graphics2D = (Graphics2D)graphics;
        final Dimension size = this.getSize();
        final Insets insets = this.getInsets();
        this.available.setRect(insets.left, insets.top, size.getWidth() - insets.left - insets.right, size.getHeight() - insets.top - insets.bottom);
        graphics2D.translate(insets.left, insets.top);
        graphics2D.fill(this.getArrow(this.type));
    }
    
    private Shape getArrow(final int n) {
        switch (n) {
            case 0: {
                return this.getUpArrow();
            }
            case 1: {
                return this.getDownArrow();
            }
            default: {
                return this.getUpArrow();
            }
        }
    }
    
    private Shape getUpArrow() {
        final Polygon polygon = new Polygon();
        polygon.addPoint(7, 2);
        polygon.addPoint(2, 7);
        polygon.addPoint(12, 7);
        return polygon;
    }
    
    private Shape getDownArrow() {
        final Polygon polygon = new Polygon();
        polygon.addPoint(7, 7);
        polygon.addPoint(2, 2);
        polygon.addPoint(12, 2);
        return polygon;
    }
}
