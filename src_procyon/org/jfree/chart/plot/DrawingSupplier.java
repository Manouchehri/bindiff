package org.jfree.chart.plot;

import java.awt.*;

public interface DrawingSupplier
{
    Paint getNextPaint();
    
    Paint getNextOutlinePaint();
    
    Stroke getNextStroke();
    
    Stroke getNextOutlineStroke();
    
    Shape getNextShape();
}
