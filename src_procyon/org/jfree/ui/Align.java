package org.jfree.ui;

import java.awt.geom.*;

public final class Align
{
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
    
    public static void align(final Rectangle2D rectangle2D, final Rectangle2D rectangle2D2, final int n) {
        double x = rectangle2D2.getCenterX() - rectangle2D.getWidth() / 2.0;
        double minY = rectangle2D2.getCenterY() - rectangle2D.getHeight() / 2.0;
        double n2 = rectangle2D.getWidth();
        double n3 = rectangle2D.getHeight();
        if ((n & 0x3) == 0x3) {
            n3 = rectangle2D2.getHeight();
        }
        if ((n & 0xC) == 0xC) {
            n2 = rectangle2D2.getWidth();
        }
        if ((n & 0x1) == 0x1) {
            minY = rectangle2D2.getMinY();
        }
        if ((n & 0x2) == 0x2) {
            minY = rectangle2D2.getMaxY() - n3;
        }
        if ((n & 0x4) == 0x4) {
            x = rectangle2D2.getX();
        }
        if ((n & 0x8) == 0x8) {
            x = rectangle2D2.getMaxX() - n2;
        }
        rectangle2D.setRect(x, minY, n2, n3);
    }
}
