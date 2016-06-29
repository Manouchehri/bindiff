package org.jfree.chart.renderer;

import java.awt.*;
import java.awt.geom.*;
import org.jfree.chart.plot.*;
import org.jfree.data.xy.*;
import java.util.*;
import org.jfree.chart.axis.*;
import org.jfree.chart.*;
import org.jfree.chart.event.*;

public interface PolarItemRenderer
{
    void drawSeries(final Graphics2D p0, final Rectangle2D p1, final PlotRenderingInfo p2, final PolarPlot p3, final XYDataset p4, final int p5);
    
    void drawAngularGridLines(final Graphics2D p0, final PolarPlot p1, final List p2, final Rectangle2D p3);
    
    void drawRadialGridLines(final Graphics2D p0, final PolarPlot p1, final ValueAxis p2, final List p3, final Rectangle2D p4);
    
    LegendItem getLegendItem(final int p0);
    
    PolarPlot getPlot();
    
    void setPlot(final PolarPlot p0);
    
    void addChangeListener(final RendererChangeListener p0);
    
    void removeChangeListener(final RendererChangeListener p0);
}
