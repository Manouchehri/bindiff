package org.jfree.chart.plot;

import java.awt.geom.Point2D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.PlotRenderingInfo;

public interface Zoomable {
   boolean isDomainZoomable();

   boolean isRangeZoomable();

   PlotOrientation getOrientation();

   void zoomDomainAxes(double var1, PlotRenderingInfo var3, Point2D var4);

   void zoomDomainAxes(double var1, double var3, PlotRenderingInfo var5, Point2D var6);

   void zoomRangeAxes(double var1, PlotRenderingInfo var3, Point2D var4);

   void zoomRangeAxes(double var1, double var3, PlotRenderingInfo var5, Point2D var6);
}
