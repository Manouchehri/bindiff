package org.jfree.chart.renderer.category;

import java.awt.geom.*;
import org.jfree.chart.plot.*;

public class CategoryStepRenderer$State extends CategoryItemRendererState
{
    public Line2D line;
    
    public CategoryStepRenderer$State(final PlotRenderingInfo plotRenderingInfo) {
        super(plotRenderingInfo);
        this.line = new Line2D.Double();
    }
}
