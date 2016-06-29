package org.jfree.chart.axis;

import java.util.*;

public interface Timeline
{
    long toTimelineValue(final long p0);
    
    long toTimelineValue(final Date p0);
    
    long toMillisecond(final long p0);
    
    boolean containsDomainValue(final long p0);
    
    boolean containsDomainValue(final Date p0);
    
    boolean containsDomainRange(final long p0, final long p1);
    
    boolean containsDomainRange(final Date p0, final Date p1);
}
