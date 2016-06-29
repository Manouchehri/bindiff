/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.axis;

import java.util.Date;

public interface Timeline {
    public long toTimelineValue(long var1);

    public long toTimelineValue(Date var1);

    public long toMillisecond(long var1);

    public boolean containsDomainValue(long var1);

    public boolean containsDomainValue(Date var1);

    public boolean containsDomainRange(long var1, long var3);

    public boolean containsDomainRange(Date var1, Date var2);
}

