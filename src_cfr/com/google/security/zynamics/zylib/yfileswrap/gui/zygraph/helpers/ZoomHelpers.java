/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.helpers;

import java.awt.Rectangle;
import java.awt.geom.Point2D;
import y.h.bu;
import y.h.ch;

public class ZoomHelpers {
    public static final double MAX_ZOOM = 3.0;

    private static void decreaseToMaxZoom(ch ch2) {
        if (ch2.getZoom() <= 3.0) return;
        ch2.setZoom(3.0);
    }

    private static void increaseToMinZoom(ch ch2) {
        double d2 = ZoomHelpers.getMinimumZoom(ch2);
        if (ch2.getZoom() >= d2) return;
        ch2.setZoom(d2);
    }

    public static double getMinimumZoom(ch ch2) {
        double d2 = ch2.getZoom();
        if (d2 < 0.0) {
            d2 = 1.0;
        }
        Point2D point2D = ch2.getViewPoint2D();
        Rectangle rectangle = ch2.getGraph2D().a();
        ch2.zoomToArea(rectangle.getX(), rectangle.getY(), rectangle.getWidth(), rectangle.getHeight());
        double d3 = ch2.getZoom();
        ch2.setZoom(d2);
        ch2.setViewPoint2D(point2D.getX(), point2D.getY());
        return d3 - d3 / 2.0;
    }

    public static void keepZoomValid(ch ch2) {
        ZoomHelpers.decreaseToMaxZoom(ch2);
        ZoomHelpers.increaseToMinZoom(ch2);
    }
}

