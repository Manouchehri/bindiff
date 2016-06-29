package org.jfree.chart.renderer.xy;

import java.awt.*;
import java.awt.geom.*;
import org.jfree.chart.plot.*;

class XYAreaRenderer$XYAreaRendererState extends XYItemRendererState
{
    public Polygon area;
    public Line2D line;
    
    public XYAreaRenderer$XYAreaRendererState(final PlotRenderingInfo plotRenderingInfo) {
        super(plotRenderingInfo);
        this.area = new Polygon();
        this.line = new Line2D.Double();
    }
}
