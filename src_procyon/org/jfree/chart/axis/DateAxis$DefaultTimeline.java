package org.jfree.chart.axis;

import java.io.*;
import java.util.*;

class DateAxis$DefaultTimeline implements Serializable, Timeline
{
    private DateAxis$DefaultTimeline() {
    }
    
    public long toTimelineValue(final long n) {
        return n;
    }
    
    public long toTimelineValue(final Date date) {
        return date.getTime();
    }
    
    public long toMillisecond(final long n) {
        return n;
    }
    
    public boolean containsDomainValue(final long n) {
        return true;
    }
    
    public boolean containsDomainValue(final Date date) {
        return true;
    }
    
    public boolean containsDomainRange(final long n, final long n2) {
        return true;
    }
    
    public boolean containsDomainRange(final Date date, final Date date2) {
        return true;
    }
    
    public boolean equals(final Object o) {
        return o != null && (o == this || o instanceof DateAxis$DefaultTimeline);
    }
    
    DateAxis$DefaultTimeline(final DateAxis$1 dateAxis$1) {
        this();
    }
}
