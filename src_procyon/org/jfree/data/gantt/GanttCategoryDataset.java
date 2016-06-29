package org.jfree.data.gantt;

import org.jfree.data.category.*;

public interface GanttCategoryDataset extends IntervalCategoryDataset
{
    Number getPercentComplete(final int p0, final int p1);
    
    Number getPercentComplete(final Comparable p0, final Comparable p1);
    
    int getSubIntervalCount(final int p0, final int p1);
    
    int getSubIntervalCount(final Comparable p0, final Comparable p1);
    
    Number getStartValue(final int p0, final int p1, final int p2);
    
    Number getStartValue(final Comparable p0, final Comparable p1, final int p2);
    
    Number getEndValue(final int p0, final int p1, final int p2);
    
    Number getEndValue(final Comparable p0, final Comparable p1, final int p2);
    
    Number getPercentComplete(final int p0, final int p1, final int p2);
    
    Number getPercentComplete(final Comparable p0, final Comparable p1, final int p2);
}
