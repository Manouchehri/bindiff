package org.jfree.chart.annotations;

import java.awt.*;
import java.awt.geom.*;
import org.jfree.chart.axis.*;
import org.jfree.chart.plot.*;

public interface XYAnnotation
{
    void draw(final Graphics2D p0, final XYPlot p1, final Rectangle2D p2, final ValueAxis p3, final ValueAxis p4, final int p5, final PlotRenderingInfo p6);
}
