package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.helpers;

import y.h.*;
import java.awt.geom.*;
import java.awt.*;

public class ZoomHelpers
{
    public static final double MAX_ZOOM = 3.0;
    
    private static void decreaseToMaxZoom(final ch ch) {
        if (ch.getZoom() > 3.0) {
            ch.setZoom(3.0);
        }
    }
    
    private static void increaseToMinZoom(final ch ch) {
        final double minimumZoom = getMinimumZoom(ch);
        if (ch.getZoom() < minimumZoom) {
            ch.setZoom(minimumZoom);
        }
    }
    
    public static double getMinimumZoom(final ch ch) {
        double zoom = ch.getZoom();
        if (zoom < 0.0) {
            zoom = 1.0;
        }
        final Point2D viewPoint2D = ch.getViewPoint2D();
        final Rectangle a = ch.getGraph2D().a();
        ch.zoomToArea(a.getX(), a.getY(), a.getWidth(), a.getHeight());
        final double zoom2 = ch.getZoom();
        ch.setZoom(zoom);
        ch.setViewPoint2D(viewPoint2D.getX(), viewPoint2D.getY());
        return zoom2 - zoom2 / 2.0;
    }
    
    public static void keepZoomValid(final ch ch) {
        decreaseToMaxZoom(ch);
        increaseToMinZoom(ch);
    }
}
