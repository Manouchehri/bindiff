/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.axis;

import java.io.Serializable;
import java.util.Date;
import org.jfree.chart.axis.DateAxis$1;
import org.jfree.chart.axis.Timeline;

class DateAxis$DefaultTimeline
implements Serializable,
Timeline {
    private DateAxis$DefaultTimeline() {
    }

    @Override
    public long toTimelineValue(long l2) {
        return l2;
    }

    @Override
    public long toTimelineValue(Date date) {
        return date.getTime();
    }

    @Override
    public long toMillisecond(long l2) {
        return l2;
    }

    @Override
    public boolean containsDomainValue(long l2) {
        return true;
    }

    @Override
    public boolean containsDomainValue(Date date) {
        return true;
    }

    @Override
    public boolean containsDomainRange(long l2, long l3) {
        return true;
    }

    @Override
    public boolean containsDomainRange(Date date, Date date2) {
        return true;
    }

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (object == this) {
            return true;
        }
        if (!(object instanceof DateAxis$DefaultTimeline)) return false;
        return true;
    }

    DateAxis$DefaultTimeline(DateAxis$1 dateAxis$1) {
        this();
    }
}

