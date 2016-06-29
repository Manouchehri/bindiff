package org.jfree.ui;

import java.io.*;
import java.awt.geom.*;

public final class RectangleEdge implements Serializable
{
    private static final long serialVersionUID = -7400988293691093548L;
    public static final RectangleEdge TOP;
    public static final RectangleEdge BOTTOM;
    public static final RectangleEdge LEFT;
    public static final RectangleEdge RIGHT;
    private String name;
    
    private RectangleEdge(final String name) {
        this.name = name;
    }
    
    public String toString() {
        return this.name;
    }
    
    public boolean equals(final Object o) {
        return this == o || (o instanceof RectangleEdge && this.name.equals(((RectangleEdge)o).name));
    }
    
    public int hashCode() {
        return this.name.hashCode();
    }
    
    public static boolean isTopOrBottom(final RectangleEdge rectangleEdge) {
        return rectangleEdge == RectangleEdge.TOP || rectangleEdge == RectangleEdge.BOTTOM;
    }
    
    public static boolean isLeftOrRight(final RectangleEdge rectangleEdge) {
        return rectangleEdge == RectangleEdge.LEFT || rectangleEdge == RectangleEdge.RIGHT;
    }
    
    public static RectangleEdge opposite(final RectangleEdge rectangleEdge) {
        RectangleEdge rectangleEdge2 = null;
        if (rectangleEdge == RectangleEdge.TOP) {
            rectangleEdge2 = RectangleEdge.BOTTOM;
        }
        else if (rectangleEdge == RectangleEdge.BOTTOM) {
            rectangleEdge2 = RectangleEdge.TOP;
        }
        else if (rectangleEdge == RectangleEdge.LEFT) {
            rectangleEdge2 = RectangleEdge.RIGHT;
        }
        else if (rectangleEdge == RectangleEdge.RIGHT) {
            rectangleEdge2 = RectangleEdge.LEFT;
        }
        return rectangleEdge2;
    }
    
    public static double coordinate(final Rectangle2D rectangle2D, final RectangleEdge rectangleEdge) {
        double n = 0.0;
        if (rectangleEdge == RectangleEdge.TOP) {
            n = rectangle2D.getMinY();
        }
        else if (rectangleEdge == RectangleEdge.BOTTOM) {
            n = rectangle2D.getMaxY();
        }
        else if (rectangleEdge == RectangleEdge.LEFT) {
            n = rectangle2D.getMinX();
        }
        else if (rectangleEdge == RectangleEdge.RIGHT) {
            n = rectangle2D.getMaxX();
        }
        return n;
    }
    
    private Object readResolve() {
        Object o = null;
        if (this.equals(RectangleEdge.TOP)) {
            o = RectangleEdge.TOP;
        }
        else if (this.equals(RectangleEdge.BOTTOM)) {
            o = RectangleEdge.BOTTOM;
        }
        else if (this.equals(RectangleEdge.LEFT)) {
            o = RectangleEdge.LEFT;
        }
        else if (this.equals(RectangleEdge.RIGHT)) {
            o = RectangleEdge.RIGHT;
        }
        return o;
    }
    
    static {
        TOP = new RectangleEdge("RectangleEdge.TOP");
        BOTTOM = new RectangleEdge("RectangleEdge.BOTTOM");
        LEFT = new RectangleEdge("RectangleEdge.LEFT");
        RIGHT = new RectangleEdge("RectangleEdge.RIGHT");
    }
}
