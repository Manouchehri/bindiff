/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.ui;

import java.awt.geom.Rectangle2D;
import java.io.Serializable;

public final class RectangleEdge
implements Serializable {
    private static final long serialVersionUID = -7400988293691093548L;
    public static final RectangleEdge TOP = new RectangleEdge("RectangleEdge.TOP");
    public static final RectangleEdge BOTTOM = new RectangleEdge("RectangleEdge.BOTTOM");
    public static final RectangleEdge LEFT = new RectangleEdge("RectangleEdge.LEFT");
    public static final RectangleEdge RIGHT = new RectangleEdge("RectangleEdge.RIGHT");
    private String name;

    private RectangleEdge(String string) {
        this.name = string;
    }

    public String toString() {
        return this.name;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof RectangleEdge)) {
            return false;
        }
        RectangleEdge rectangleEdge = (RectangleEdge)object;
        if (this.name.equals(rectangleEdge.name)) return true;
        return false;
    }

    public int hashCode() {
        return this.name.hashCode();
    }

    public static boolean isTopOrBottom(RectangleEdge rectangleEdge) {
        if (rectangleEdge == TOP) return true;
        if (rectangleEdge == BOTTOM) return true;
        return false;
    }

    public static boolean isLeftOrRight(RectangleEdge rectangleEdge) {
        if (rectangleEdge == LEFT) return true;
        if (rectangleEdge == RIGHT) return true;
        return false;
    }

    public static RectangleEdge opposite(RectangleEdge rectangleEdge) {
        RectangleEdge rectangleEdge2 = null;
        if (rectangleEdge == TOP) {
            return BOTTOM;
        }
        if (rectangleEdge == BOTTOM) {
            return TOP;
        }
        if (rectangleEdge == LEFT) {
            return RIGHT;
        }
        if (rectangleEdge != RIGHT) return rectangleEdge2;
        return LEFT;
    }

    public static double coordinate(Rectangle2D rectangle2D, RectangleEdge rectangleEdge) {
        double d2 = 0.0;
        if (rectangleEdge == TOP) {
            return rectangle2D.getMinY();
        }
        if (rectangleEdge == BOTTOM) {
            return rectangle2D.getMaxY();
        }
        if (rectangleEdge == LEFT) {
            return rectangle2D.getMinX();
        }
        if (rectangleEdge != RIGHT) return d2;
        return rectangle2D.getMaxX();
    }

    private Object readResolve() {
        RectangleEdge rectangleEdge = null;
        if (this.equals(TOP)) {
            return TOP;
        }
        if (this.equals(BOTTOM)) {
            return BOTTOM;
        }
        if (this.equals(LEFT)) {
            return LEFT;
        }
        if (!this.equals(RIGHT)) return rectangleEdge;
        return RIGHT;
    }
}

