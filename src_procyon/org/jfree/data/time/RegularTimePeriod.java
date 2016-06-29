package org.jfree.data.time;

import org.jfree.date.*;
import java.util.*;

public abstract class RegularTimePeriod implements Comparable, TimePeriod, MonthConstants
{
    public static final TimeZone DEFAULT_TIME_ZONE;
    public static final Calendar WORKING_CALENDAR;
    static Class class$java$util$Date;
    static Class class$java$util$TimeZone;
    static Class class$org$jfree$data$time$Year;
    static Class class$org$jfree$data$time$Quarter;
    static Class class$org$jfree$data$time$Month;
    static Class class$org$jfree$data$time$Day;
    static Class class$org$jfree$data$time$Hour;
    static Class class$org$jfree$data$time$Minute;
    static Class class$org$jfree$data$time$Second;
    static Class class$org$jfree$data$time$Millisecond;
    
    public static RegularTimePeriod createInstance(final Class clazz, final Date date, final TimeZone timeZone) {
        RegularTimePeriod regularTimePeriod = null;
        try {
            regularTimePeriod = clazz.getDeclaredConstructor((RegularTimePeriod.class$java$util$Date == null) ? (RegularTimePeriod.class$java$util$Date = class$("java.util.Date")) : RegularTimePeriod.class$java$util$Date, (RegularTimePeriod.class$java$util$TimeZone == null) ? (RegularTimePeriod.class$java$util$TimeZone = class$("java.util.TimeZone")) : RegularTimePeriod.class$java$util$TimeZone).newInstance(date, timeZone);
        }
        catch (Exception ex) {}
        return regularTimePeriod;
    }
    
    public static Class downsize(final Class clazz) {
        if (clazz.equals((RegularTimePeriod.class$org$jfree$data$time$Year == null) ? (RegularTimePeriod.class$org$jfree$data$time$Year = class$("org.jfree.data.time.Year")) : RegularTimePeriod.class$org$jfree$data$time$Year)) {
            return (RegularTimePeriod.class$org$jfree$data$time$Quarter == null) ? (RegularTimePeriod.class$org$jfree$data$time$Quarter = class$("org.jfree.data.time.Quarter")) : RegularTimePeriod.class$org$jfree$data$time$Quarter;
        }
        if (clazz.equals((RegularTimePeriod.class$org$jfree$data$time$Quarter == null) ? (RegularTimePeriod.class$org$jfree$data$time$Quarter = class$("org.jfree.data.time.Quarter")) : RegularTimePeriod.class$org$jfree$data$time$Quarter)) {
            return (RegularTimePeriod.class$org$jfree$data$time$Month == null) ? (RegularTimePeriod.class$org$jfree$data$time$Month = class$("org.jfree.data.time.Month")) : RegularTimePeriod.class$org$jfree$data$time$Month;
        }
        if (clazz.equals((RegularTimePeriod.class$org$jfree$data$time$Month == null) ? (RegularTimePeriod.class$org$jfree$data$time$Month = class$("org.jfree.data.time.Month")) : RegularTimePeriod.class$org$jfree$data$time$Month)) {
            return (RegularTimePeriod.class$org$jfree$data$time$Day == null) ? (RegularTimePeriod.class$org$jfree$data$time$Day = class$("org.jfree.data.time.Day")) : RegularTimePeriod.class$org$jfree$data$time$Day;
        }
        if (clazz.equals((RegularTimePeriod.class$org$jfree$data$time$Day == null) ? (RegularTimePeriod.class$org$jfree$data$time$Day = class$("org.jfree.data.time.Day")) : RegularTimePeriod.class$org$jfree$data$time$Day)) {
            return (RegularTimePeriod.class$org$jfree$data$time$Hour == null) ? (RegularTimePeriod.class$org$jfree$data$time$Hour = class$("org.jfree.data.time.Hour")) : RegularTimePeriod.class$org$jfree$data$time$Hour;
        }
        if (clazz.equals((RegularTimePeriod.class$org$jfree$data$time$Hour == null) ? (RegularTimePeriod.class$org$jfree$data$time$Hour = class$("org.jfree.data.time.Hour")) : RegularTimePeriod.class$org$jfree$data$time$Hour)) {
            return (RegularTimePeriod.class$org$jfree$data$time$Minute == null) ? (RegularTimePeriod.class$org$jfree$data$time$Minute = class$("org.jfree.data.time.Minute")) : RegularTimePeriod.class$org$jfree$data$time$Minute;
        }
        if (clazz.equals((RegularTimePeriod.class$org$jfree$data$time$Minute == null) ? (RegularTimePeriod.class$org$jfree$data$time$Minute = class$("org.jfree.data.time.Minute")) : RegularTimePeriod.class$org$jfree$data$time$Minute)) {
            return (RegularTimePeriod.class$org$jfree$data$time$Second == null) ? (RegularTimePeriod.class$org$jfree$data$time$Second = class$("org.jfree.data.time.Second")) : RegularTimePeriod.class$org$jfree$data$time$Second;
        }
        if (clazz.equals((RegularTimePeriod.class$org$jfree$data$time$Second == null) ? (RegularTimePeriod.class$org$jfree$data$time$Second = class$("org.jfree.data.time.Second")) : RegularTimePeriod.class$org$jfree$data$time$Second)) {
            return (RegularTimePeriod.class$org$jfree$data$time$Millisecond == null) ? (RegularTimePeriod.class$org$jfree$data$time$Millisecond = class$("org.jfree.data.time.Millisecond")) : RegularTimePeriod.class$org$jfree$data$time$Millisecond;
        }
        return (RegularTimePeriod.class$org$jfree$data$time$Millisecond == null) ? (RegularTimePeriod.class$org$jfree$data$time$Millisecond = class$("org.jfree.data.time.Millisecond")) : RegularTimePeriod.class$org$jfree$data$time$Millisecond;
    }
    
    public abstract RegularTimePeriod previous();
    
    public abstract RegularTimePeriod next();
    
    public abstract long getSerialIndex();
    
    public abstract void peg(final Calendar p0);
    
    public Date getStart() {
        return new Date(this.getFirstMillisecond());
    }
    
    public Date getEnd() {
        return new Date(this.getLastMillisecond());
    }
    
    public abstract long getFirstMillisecond();
    
    public long getFirstMillisecond(final TimeZone timeZone) {
        return this.getFirstMillisecond(Calendar.getInstance(timeZone));
    }
    
    public abstract long getFirstMillisecond(final Calendar p0);
    
    public abstract long getLastMillisecond();
    
    public long getLastMillisecond(final TimeZone timeZone) {
        return this.getLastMillisecond(Calendar.getInstance(timeZone));
    }
    
    public abstract long getLastMillisecond(final Calendar p0);
    
    public long getMiddleMillisecond() {
        final long firstMillisecond = this.getFirstMillisecond();
        return firstMillisecond + (this.getLastMillisecond() - firstMillisecond) / 2L;
    }
    
    public long getMiddleMillisecond(final TimeZone timeZone) {
        final Calendar instance = Calendar.getInstance(timeZone);
        final long firstMillisecond = this.getFirstMillisecond(instance);
        return firstMillisecond + (this.getLastMillisecond(instance) - firstMillisecond) / 2L;
    }
    
    public long getMiddleMillisecond(final Calendar calendar) {
        final long firstMillisecond = this.getFirstMillisecond(calendar);
        return firstMillisecond + (this.getLastMillisecond(calendar) - firstMillisecond) / 2L;
    }
    
    public String toString() {
        return String.valueOf(this.getStart());
    }
    
    static Class class$(final String s) {
        try {
            return Class.forName(s);
        }
        catch (ClassNotFoundException ex) {
            throw new NoClassDefFoundError(ex.getMessage());
        }
    }
    
    static {
        DEFAULT_TIME_ZONE = TimeZone.getDefault();
        WORKING_CALENDAR = Calendar.getInstance(RegularTimePeriod.DEFAULT_TIME_ZONE);
    }
}
