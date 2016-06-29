package org.jfree.data.xy;

public interface XYZDataset extends XYDataset
{
    Number getZ(final int p0, final int p1);
    
    double getZValue(final int p0, final int p1);
}
