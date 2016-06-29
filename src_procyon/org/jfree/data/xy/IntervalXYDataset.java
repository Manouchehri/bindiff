package org.jfree.data.xy;

public interface IntervalXYDataset extends XYDataset
{
    Number getStartX(final int p0, final int p1);
    
    double getStartXValue(final int p0, final int p1);
    
    Number getEndX(final int p0, final int p1);
    
    double getEndXValue(final int p0, final int p1);
    
    Number getStartY(final int p0, final int p1);
    
    double getStartYValue(final int p0, final int p1);
    
    Number getEndY(final int p0, final int p1);
    
    double getEndYValue(final int p0, final int p1);
}
