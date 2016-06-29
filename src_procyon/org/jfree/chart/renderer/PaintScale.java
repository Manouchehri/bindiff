package org.jfree.chart.renderer;

import java.awt.*;

public interface PaintScale
{
    double getLowerBound();
    
    double getUpperBound();
    
    Paint getPaint(final double p0);
}
