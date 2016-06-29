package org.jfree.chart.plot;

import java.awt.geom.*;

public interface Zoomable
{
    boolean isDomainZoomable();
    
    boolean isRangeZoomable();
    
    PlotOrientation getOrientation();
    
    void zoomDomainAxes(final double p0, final PlotRenderingInfo p1, final Point2D p2);
    
    void zoomDomainAxes(final double p0, final double p1, final PlotRenderingInfo p2, final Point2D p3);
    
    void zoomRangeAxes(final double p0, final PlotRenderingInfo p1, final Point2D p2);
    
    void zoomRangeAxes(final double p0, final double p1, final PlotRenderingInfo p2, final Point2D p3);
}
