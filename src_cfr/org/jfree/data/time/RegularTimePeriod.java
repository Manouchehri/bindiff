/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data.time;

import java.lang.reflect.Constructor;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import org.jfree.data.time.TimePeriod;
import org.jfree.date.MonthConstants;

public abstract class RegularTimePeriod
implements Comparable,
TimePeriod,
MonthConstants {
    public static final TimeZone DEFAULT_TIME_ZONE = TimeZone.getDefault();
    public static final Calendar WORKING_CALENDAR = Calendar.getInstance(DEFAULT_TIME_ZONE);
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

    public static RegularTimePeriod createInstance(Class class_, Date date, TimeZone timeZone) {
        RegularTimePeriod regularTimePeriod = null;
        try {
            Class[] arrclass = new Class[2];
            Class class_2 = class$java$util$Date == null ? (RegularTimePeriod.class$java$util$Date = RegularTimePeriod.class$("java.util.Date")) : class$java$util$Date;
            arrclass[0] = class_2;
            Class class_3 = class$java$util$TimeZone == null ? (RegularTimePeriod.class$java$util$TimeZone = RegularTimePeriod.class$("java.util.TimeZone")) : class$java$util$TimeZone;
            arrclass[1] = class_3;
            Constructor constructor = class_.getDeclaredConstructor(arrclass);
            return (RegularTimePeriod)constructor.newInstance(date, timeZone);
        }
        catch (Exception var4_5) {
            // empty catch block
        }
        return regularTimePeriod;
    }

    public static Class downsize(Class class_) {
        Class class_2;
        Class class_3 = class$org$jfree$data$time$Year == null ? (RegularTimePeriod.class$org$jfree$data$time$Year = RegularTimePeriod.class$("org.jfree.data.time.Year")) : class$org$jfree$data$time$Year;
        if (class_.equals(class_3)) {
            Class class_4;
            if (class$org$jfree$data$time$Quarter == null) {
                class_4 = RegularTimePeriod.class$org$jfree$data$time$Quarter = RegularTimePeriod.class$("org.jfree.data.time.Quarter");
                return class_4;
            }
            class_4 = class$org$jfree$data$time$Quarter;
            return class_4;
        }
        Class class_5 = class$org$jfree$data$time$Quarter == null ? (RegularTimePeriod.class$org$jfree$data$time$Quarter = RegularTimePeriod.class$("org.jfree.data.time.Quarter")) : class$org$jfree$data$time$Quarter;
        if (class_.equals(class_5)) {
            Class class_6;
            if (class$org$jfree$data$time$Month == null) {
                class_6 = RegularTimePeriod.class$org$jfree$data$time$Month = RegularTimePeriod.class$("org.jfree.data.time.Month");
                return class_6;
            }
            class_6 = class$org$jfree$data$time$Month;
            return class_6;
        }
        Class class_7 = class$org$jfree$data$time$Month == null ? (RegularTimePeriod.class$org$jfree$data$time$Month = RegularTimePeriod.class$("org.jfree.data.time.Month")) : class$org$jfree$data$time$Month;
        if (class_.equals(class_7)) {
            Class class_8;
            if (class$org$jfree$data$time$Day == null) {
                class_8 = RegularTimePeriod.class$org$jfree$data$time$Day = RegularTimePeriod.class$("org.jfree.data.time.Day");
                return class_8;
            }
            class_8 = class$org$jfree$data$time$Day;
            return class_8;
        }
        Class class_9 = class$org$jfree$data$time$Day == null ? (RegularTimePeriod.class$org$jfree$data$time$Day = RegularTimePeriod.class$("org.jfree.data.time.Day")) : class$org$jfree$data$time$Day;
        if (class_.equals(class_9)) {
            Class class_10;
            if (class$org$jfree$data$time$Hour == null) {
                class_10 = RegularTimePeriod.class$org$jfree$data$time$Hour = RegularTimePeriod.class$("org.jfree.data.time.Hour");
                return class_10;
            }
            class_10 = class$org$jfree$data$time$Hour;
            return class_10;
        }
        Class class_11 = class$org$jfree$data$time$Hour == null ? (RegularTimePeriod.class$org$jfree$data$time$Hour = RegularTimePeriod.class$("org.jfree.data.time.Hour")) : class$org$jfree$data$time$Hour;
        if (class_.equals(class_11)) {
            Class class_12;
            if (class$org$jfree$data$time$Minute == null) {
                class_12 = RegularTimePeriod.class$org$jfree$data$time$Minute = RegularTimePeriod.class$("org.jfree.data.time.Minute");
                return class_12;
            }
            class_12 = class$org$jfree$data$time$Minute;
            return class_12;
        }
        Class class_13 = class$org$jfree$data$time$Minute == null ? (RegularTimePeriod.class$org$jfree$data$time$Minute = RegularTimePeriod.class$("org.jfree.data.time.Minute")) : class$org$jfree$data$time$Minute;
        if (class_.equals(class_13)) {
            Class class_14;
            if (class$org$jfree$data$time$Second == null) {
                class_14 = RegularTimePeriod.class$org$jfree$data$time$Second = RegularTimePeriod.class$("org.jfree.data.time.Second");
                return class_14;
            }
            class_14 = class$org$jfree$data$time$Second;
            return class_14;
        }
        Class class_15 = class$org$jfree$data$time$Second == null ? (RegularTimePeriod.class$org$jfree$data$time$Second = RegularTimePeriod.class$("org.jfree.data.time.Second")) : class$org$jfree$data$time$Second;
        if (class_.equals(class_15)) {
            Class class_16;
            if (class$org$jfree$data$time$Millisecond == null) {
                class_16 = RegularTimePeriod.class$org$jfree$data$time$Millisecond = RegularTimePeriod.class$("org.jfree.data.time.Millisecond");
                return class_16;
            }
            class_16 = class$org$jfree$data$time$Millisecond;
            return class_16;
        }
        if (class$org$jfree$data$time$Millisecond == null) {
            class_2 = RegularTimePeriod.class$org$jfree$data$time$Millisecond = RegularTimePeriod.class$("org.jfree.data.time.Millisecond");
            return class_2;
        }
        class_2 = class$org$jfree$data$time$Millisecond;
        return class_2;
    }

    public abstract RegularTimePeriod previous();

    public abstract RegularTimePeriod next();

    public abstract long getSerialIndex();

    public abstract void peg(Calendar var1);

    @Override
    public Date getStart() {
        return new Date(this.getFirstMillisecond());
    }

    @Override
    public Date getEnd() {
        return new Date(this.getLastMillisecond());
    }

    public abstract long getFirstMillisecond();

    public long getFirstMillisecond(TimeZone timeZone) {
        Calendar calendar = Calendar.getInstance(timeZone);
        return this.getFirstMillisecond(calendar);
    }

    public abstract long getFirstMillisecond(Calendar var1);

    public abstract long getLastMillisecond();

    public long getLastMillisecond(TimeZone timeZone) {
        Calendar calendar = Calendar.getInstance(timeZone);
        return this.getLastMillisecond(calendar);
    }

    public abstract long getLastMillisecond(Calendar var1);

    public long getMiddleMillisecond() {
        long l2 = this.getFirstMillisecond();
        long l3 = this.getLastMillisecond();
        return l2 + (l3 - l2) / 2;
    }

    public long getMiddleMillisecond(TimeZone timeZone) {
        Calendar calendar = Calendar.getInstance(timeZone);
        long l2 = this.getFirstMillisecond(calendar);
        long l3 = this.getLastMillisecond(calendar);
        return l2 + (l3 - l2) / 2;
    }

    public long getMiddleMillisecond(Calendar calendar) {
        long l2 = this.getFirstMillisecond(calendar);
        long l3 = this.getLastMillisecond(calendar);
        return l2 + (l3 - l2) / 2;
    }

    public String toString() {
        return String.valueOf(this.getStart());
    }

    static Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException var1_1) {
            throw new NoClassDefFoundError(var1_1.getMessage());
        }
    }
}

