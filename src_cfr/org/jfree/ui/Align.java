/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.ui;

import java.awt.geom.Rectangle2D;

public final class Align {
    public static final int CENTER = 0;
    public static final int TOP = 1;
    public static final int BOTTOM = 2;
    public static final int LEFT = 4;
    public static final int RIGHT = 8;
    public static final int TOP_LEFT = 5;
    public static final int TOP_RIGHT = 9;
    public static final int BOTTOM_LEFT = 6;
    public static final int BOTTOM_RIGHT = 10;
    public static final int FIT_HORIZONTAL = 12;
    public static final int FIT_VERTICAL = 3;
    public static final int FIT = 15;
    public static final int NORTH = 1;
    public static final int SOUTH = 2;
    public static final int WEST = 4;
    public static final int EAST = 8;
    public static final int NORTH_WEST = 5;
    public static final int NORTH_EAST = 9;
    public static final int SOUTH_WEST = 6;
    public static final int SOUTH_EAST = 10;

    private Align() {
    }

    public static void align(Rectangle2D rectangle2D, Rectangle2D rectangle2D2, int n2) {
        double d2 = rectangle2D2.getCenterX() - rectangle2D.getWidth() / 2.0;
        double d3 = rectangle2D2.getCenterY() - rectangle2D.getHeight() / 2.0;
        double d4 = rectangle2D.getWidth();
        double d5 = rectangle2D.getHeight();
        if ((n2 & 3) == 3) {
            d5 = rectangle2D2.getHeight();
        }
        if ((n2 & 12) == 12) {
            d4 = rectangle2D2.getWidth();
        }
        if ((n2 & 1) == 1) {
            d3 = rectangle2D2.getMinY();
        }
        if ((n2 & 2) == 2) {
            d3 = rectangle2D2.getMaxY() - d5;
        }
        if ((n2 & 4) == 4) {
            d2 = rectangle2D2.getX();
        }
        if ((n2 & 8) == 8) {
            d2 = rectangle2D2.getMaxX() - d4;
        }
        rectangle2D.setRect(d2, d3, d4, d5);
    }
}

