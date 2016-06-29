package org.jfree.data.category;

public interface IntervalCategoryDataset extends CategoryDataset
{
    Number getStartValue(final int p0, final int p1);
    
    Number getStartValue(final Comparable p0, final Comparable p1);
    
    Number getEndValue(final int p0, final int p1);
    
    Number getEndValue(final Comparable p0, final Comparable p1);
}
