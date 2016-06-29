package org.jfree.data.xy;

public interface IntervalXYZDataset extends XYZDataset
{
    Number getStartXValue(final int p0, final int p1);
    
    Number getEndXValue(final int p0, final int p1);
    
    Number getStartYValue(final int p0, final int p1);
    
    Number getEndYValue(final int p0, final int p1);
    
    Number getStartZValue(final int p0, final int p1);
    
    Number getEndZValue(final int p0, final int p1);
}
