/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.plot;

import java.awt.geom.Point2D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.PlotRenderingInfo;

public interface Zoomable {
    public boolean isDomainZoomable();

    public boolean isRangeZoomable();

    public PlotOrientation getOrientation();

    public void zoomDomainAxes(double var1, PlotRenderingInfo var3, Point2D var4);

    public void zoomDomainAxes(double var1, double var3, PlotRenderingInfo var5, Point2D var6);

    public void zoomRangeAxes(double var1, PlotRenderingInfo var3, Point2D var4);

    public void zoomRangeAxes(double var1, double var3, PlotRenderingInfo var5, Point2D var6);
}

