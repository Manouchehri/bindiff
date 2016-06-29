package org.jfree.ui;

import java.io.*;
import java.awt.geom.*;

public final class RectangleAnchor implements Serializable
{
    private static final long serialVersionUID = -2457494205644416327L;
    public static final RectangleAnchor CENTER;
    public static final RectangleAnchor TOP;
    public static final RectangleAnchor TOP_LEFT;
    public static final RectangleAnchor TOP_RIGHT;
    public static final RectangleAnchor BOTTOM;
    public static final RectangleAnchor BOTTOM_LEFT;
    public static final RectangleAnchor BOTTOM_RIGHT;
    public static final RectangleAnchor LEFT;
    public static final RectangleAnchor RIGHT;
    private String name;
    
    private RectangleAnchor(final String name) {
        this.name = name;
    }
    
    public String toString() {
        return this.name;
    }
    
    public boolean equals(final Object o) {
        return this == o || (o instanceof RectangleAnchor && this.name.equals(((RectangleAnchor)o).name));
    }
    
    public int hashCode() {
        return this.name.hashCode();
    }
    
    public static Point2D coordinates(final Rectangle2D rectangle2D, final RectangleAnchor rectangleAnchor) {
        final Point2D.Double double1 = new Point2D.Double();
        if (rectangleAnchor == RectangleAnchor.CENTER) {
            double1.setLocation(rectangle2D.getCenterX(), rectangle2D.getCenterY());
        }
        else if (rectangleAnchor == RectangleAnchor.TOP) {
            double1.setLocation(rectangle2D.getCenterX(), rectangle2D.getMinY());
        }
        else if (rectangleAnchor == RectangleAnchor.BOTTOM) {
            double1.setLocation(rectangle2D.getCenterX(), rectangle2D.getMaxY());
        }
        else if (rectangleAnchor == RectangleAnchor.LEFT) {
            double1.setLocation(rectangle2D.getMinX(), rectangle2D.getCenterY());
        }
        else if (rectangleAnchor == RectangleAnchor.RIGHT) {
            double1.setLocation(rectangle2D.getMaxX(), rectangle2D.getCenterY());
        }
        else if (rectangleAnchor == RectangleAnchor.TOP_LEFT) {
            double1.setLocation(rectangle2D.getMinX(), rectangle2D.getMinY());
        }
        else if (rectangleAnchor == RectangleAnchor.TOP_RIGHT) {
            double1.setLocation(rectangle2D.getMaxX(), rectangle2D.getMinY());
        }
        else if (rectangleAnchor == RectangleAnchor.BOTTOM_LEFT) {
            double1.setLocation(rectangle2D.getMinX(), rectangle2D.getMaxY());
        }
        else if (rectangleAnchor == RectangleAnchor.BOTTOM_RIGHT) {
            double1.setLocation(rectangle2D.getMaxX(), rectangle2D.getMaxY());
        }
        return double1;
    }
    
    public static Rectangle2D createRectangle(final Size2D size2D, final double n, final double n2, final RectangleAnchor rectangleAnchor) {
        Rectangle2D rectangle2D = null;
        final double width = size2D.getWidth();
        final double height = size2D.getHeight();
        if (rectangleAnchor == RectangleAnchor.CENTER) {
            rectangle2D = new Rectangle2D.Double(n - width / 2.0, n2 - height / 2.0, width, height);
        }
        else if (rectangleAnchor == RectangleAnchor.TOP) {
            rectangle2D = new Rectangle2D.Double(n - width / 2.0, n2 - height / 2.0, width, height);
        }
        else if (rectangleAnchor == RectangleAnchor.BOTTOM) {
            rectangle2D = new Rectangle2D.Double(n - width / 2.0, n2 - height / 2.0, width, height);
        }
        else if (rectangleAnchor == RectangleAnchor.LEFT) {
            rectangle2D = new Rectangle2D.Double(n, n2 - height / 2.0, width, height);
        }
        else if (rectangleAnchor == RectangleAnchor.RIGHT) {
            rectangle2D = new Rectangle2D.Double(n - width, n2 - height / 2.0, width, height);
        }
        else if (rectangleAnchor == RectangleAnchor.TOP_LEFT) {
            rectangle2D = new Rectangle2D.Double(n - width / 2.0, n2 - height / 2.0, width, height);
        }
        else if (rectangleAnchor == RectangleAnchor.TOP_RIGHT) {
            rectangle2D = new Rectangle2D.Double(n - width / 2.0, n2 - height / 2.0, width, height);
        }
        else if (rectangleAnchor == RectangleAnchor.BOTTOM_LEFT) {
            rectangle2D = new Rectangle2D.Double(n - width / 2.0, n2 - height / 2.0, width, height);
        }
        else if (rectangleAnchor == RectangleAnchor.BOTTOM_RIGHT) {
            rectangle2D = new Rectangle2D.Double(n - width / 2.0, n2 - height / 2.0, width, height);
        }
        return rectangle2D;
    }
    
    private Object readResolve() {
        Object o = null;
        if (this.equals(RectangleAnchor.CENTER)) {
            o = RectangleAnchor.CENTER;
        }
        else if (this.equals(RectangleAnchor.TOP)) {
            o = RectangleAnchor.TOP;
        }
        else if (this.equals(RectangleAnchor.BOTTOM)) {
            o = RectangleAnchor.BOTTOM;
        }
        else if (this.equals(RectangleAnchor.LEFT)) {
            o = RectangleAnchor.LEFT;
        }
        else if (this.equals(RectangleAnchor.RIGHT)) {
            o = RectangleAnchor.RIGHT;
        }
        else if (this.equals(RectangleAnchor.TOP_LEFT)) {
            o = RectangleAnchor.TOP_LEFT;
        }
        else if (this.equals(RectangleAnchor.TOP_RIGHT)) {
            o = RectangleAnchor.TOP_RIGHT;
        }
        else if (this.equals(RectangleAnchor.BOTTOM_LEFT)) {
            o = RectangleAnchor.BOTTOM_LEFT;
        }
        else if (this.equals(RectangleAnchor.BOTTOM_RIGHT)) {
            o = RectangleAnchor.BOTTOM_RIGHT;
        }
        return o;
    }
    
    static {
        CENTER = new RectangleAnchor("RectangleAnchor.CENTER");
        TOP = new RectangleAnchor("RectangleAnchor.TOP");
        TOP_LEFT = new RectangleAnchor("RectangleAnchor.TOP_LEFT");
        TOP_RIGHT = new RectangleAnchor("RectangleAnchor.TOP_RIGHT");
        BOTTOM = new RectangleAnchor("RectangleAnchor.BOTTOM");
        BOTTOM_LEFT = new RectangleAnchor("RectangleAnchor.BOTTOM_LEFT");
        BOTTOM_RIGHT = new RectangleAnchor("RectangleAnchor.BOTTOM_RIGHT");
        LEFT = new RectangleAnchor("RectangleAnchor.LEFT");
        RIGHT = new RectangleAnchor("RectangleAnchor.RIGHT");
    }
}
