package org.jfree.chart.annotations;

import java.awt.*;
import org.jfree.chart.plot.*;
import java.awt.geom.*;
import org.jfree.chart.axis.*;

public interface CategoryAnnotation
{
    void draw(final Graphics2D p0, final CategoryPlot p1, final Rectangle2D p2, final CategoryAxis p3, final ValueAxis p4);
}
