/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.ui;

import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;
import org.jfree.ui.Size2D;

public final class RectangleAnchor
implements Serializable {
    private static final long serialVersionUID = -2457494205644416327L;
    public static final RectangleAnchor CENTER = new RectangleAnchor("RectangleAnchor.CENTER");
    public static final RectangleAnchor TOP = new RectangleAnchor("RectangleAnchor.TOP");
    public static final RectangleAnchor TOP_LEFT = new RectangleAnchor("RectangleAnchor.TOP_LEFT");
    public static final RectangleAnchor TOP_RIGHT = new RectangleAnchor("RectangleAnchor.TOP_RIGHT");
    public static final RectangleAnchor BOTTOM = new RectangleAnchor("RectangleAnchor.BOTTOM");
    public static final RectangleAnchor BOTTOM_LEFT = new RectangleAnchor("RectangleAnchor.BOTTOM_LEFT");
    public static final RectangleAnchor BOTTOM_RIGHT = new RectangleAnchor("RectangleAnchor.BOTTOM_RIGHT");
    public static final RectangleAnchor LEFT = new RectangleAnchor("RectangleAnchor.LEFT");
    public static final RectangleAnchor RIGHT = new RectangleAnchor("RectangleAnchor.RIGHT");
    private String name;

    private RectangleAnchor(String string) {
        this.name = string;
    }

    public String toString() {
        return this.name;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof RectangleAnchor)) {
            return false;
        }
        RectangleAnchor rectangleAnchor = (RectangleAnchor)object;
        if (this.name.equals(rectangleAnchor.name)) return true;
        return false;
    }

    public int hashCode() {
        return this.name.hashCode();
    }

    public static Point2D coordinates(Rectangle2D rectangle2D, RectangleAnchor rectangleAnchor) {
        Point2D.Double double_ = new Point2D.Double();
        if (rectangleAnchor == CENTER) {
            double_.setLocation(rectangle2D.getCenterX(), rectangle2D.getCenterY());
            return double_;
        }
        if (rectangleAnchor == TOP) {
            double_.setLocation(rectangle2D.getCenterX(), rectangle2D.getMinY());
            return double_;
        }
        if (rectangleAnchor == BOTTOM) {
            double_.setLocation(rectangle2D.getCenterX(), rectangle2D.getMaxY());
            return double_;
        }
        if (rectangleAnchor == LEFT) {
            double_.setLocation(rectangle2D.getMinX(), rectangle2D.getCenterY());
            return double_;
        }
        if (rectangleAnchor == RIGHT) {
            double_.setLocation(rectangle2D.getMaxX(), rectangle2D.getCenterY());
            return double_;
        }
        if (rectangleAnchor == TOP_LEFT) {
            double_.setLocation(rectangle2D.getMinX(), rectangle2D.getMinY());
            return double_;
        }
        if (rectangleAnchor == TOP_RIGHT) {
            double_.setLocation(rectangle2D.getMaxX(), rectangle2D.getMinY());
            return double_;
        }
        if (rectangleAnchor == BOTTOM_LEFT) {
            double_.setLocation(rectangle2D.getMinX(), rectangle2D.getMaxY());
            return double_;
        }
        if (rectangleAnchor != BOTTOM_RIGHT) return double_;
        double_.setLocation(rectangle2D.getMaxX(), rectangle2D.getMaxY());
        return double_;
    }

    public static Rectangle2D createRectangle(Size2D size2D, double d2, double d3, RectangleAnchor rectangleAnchor) {
        Rectangle2D.Double double_ = null;
        double d4 = size2D.getWidth();
        double d5 = size2D.getHeight();
        if (rectangleAnchor == CENTER) {
            return new Rectangle2D.Double(d2 - d4 / 2.0, d3 - d5 / 2.0, d4, d5);
        }
        if (rectangleAnchor == TOP) {
            return new Rectangle2D.Double(d2 - d4 / 2.0, d3 - d5 / 2.0, d4, d5);
        }
        if (rectangleAnchor == BOTTOM) {
            return new Rectangle2D.Double(d2 - d4 / 2.0, d3 - d5 / 2.0, d4, d5);
        }
        if (rectangleAnchor == LEFT) {
            return new Rectangle2D.Double(d2, d3 - d5 / 2.0, d4, d5);
        }
        if (rectangleAnchor == RIGHT) {
            return new Rectangle2D.Double(d2 - d4, d3 - d5 / 2.0, d4, d5);
        }
        if (rectangleAnchor == TOP_LEFT) {
            return new Rectangle2D.Double(d2 - d4 / 2.0, d3 - d5 / 2.0, d4, d5);
        }
        if (rectangleAnchor == TOP_RIGHT) {
            return new Rectangle2D.Double(d2 - d4 / 2.0, d3 - d5 / 2.0, d4, d5);
        }
        if (rectangleAnchor == BOTTOM_LEFT) {
            return new Rectangle2D.Double(d2 - d4 / 2.0, d3 - d5 / 2.0, d4, d5);
        }
        if (rectangleAnchor != BOTTOM_RIGHT) return double_;
        return new Rectangle2D.Double(d2 - d4 / 2.0, d3 - d5 / 2.0, d4, d5);
    }

    private Object readResolve() {
        RectangleAnchor rectangleAnchor = null;
        if (this.equals(CENTER)) {
            return CENTER;
        }
        if (this.equals(TOP)) {
            return TOP;
        }
        if (this.equals(BOTTOM)) {
            return BOTTOM;
        }
        if (this.equals(LEFT)) {
            return LEFT;
        }
        if (this.equals(RIGHT)) {
            return RIGHT;
        }
        if (this.equals(TOP_LEFT)) {
            return TOP_LEFT;
        }
        if (this.equals(TOP_RIGHT)) {
            return TOP_RIGHT;
        }
        if (this.equals(BOTTOM_LEFT)) {
            return BOTTOM_LEFT;
        }
        if (!this.equals(BOTTOM_RIGHT)) return rectangleAnchor;
        return BOTTOM_RIGHT;
    }
}

