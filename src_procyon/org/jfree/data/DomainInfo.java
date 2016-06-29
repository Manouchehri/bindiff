package org.jfree.data;

public interface DomainInfo
{
    double getDomainLowerBound(final boolean p0);
    
    double getDomainUpperBound(final boolean p0);
    
    Range getDomainBounds(final boolean p0);
}
