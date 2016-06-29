package org.jfree.chart.renderer.xy;

import org.jfree.chart.renderer.*;
import java.awt.geom.*;
import org.jfree.chart.plot.*;

public class XYItemRendererState extends RendererState
{
    public Line2D workingLine;
    
    public XYItemRendererState(final PlotRenderingInfo plotRenderingInfo) {
        super(plotRenderingInfo);
        this.workingLine = new Line2D.Double();
    }
}
