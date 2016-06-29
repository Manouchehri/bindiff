package org.jfree.data.xy;

public interface WindDataset extends XYDataset
{
    Number getWindDirection(final int p0, final int p1);
    
    Number getWindForce(final int p0, final int p1);
}
