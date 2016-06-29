/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data.time;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import org.jfree.data.general.Series;
import org.jfree.data.general.SeriesException;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.TimeSeriesDataItem;
import org.jfree.util.ObjectUtilities;

public class TimeSeries
extends Series
implements Serializable,
Cloneable {
    private static final long serialVersionUID = -5032960206869675528L;
    protected static final String DEFAULT_DOMAIN_DESCRIPTION = "Time";
    protected static final String DEFAULT_RANGE_DESCRIPTION = "Value";
    private String domain;
    private String range;
    protected Class timePeriodClass;
    protected List data;
    private int maximumItemCount;
    private long maximumItemAge;
    static Class class$org$jfree$data$time$Day;
    static Class class$java$lang$Class;
    static Class class$java$util$Date;
    static Class class$java$util$TimeZone;
    static Class class$org$jfree$data$time$RegularTimePeriod;

    public TimeSeries(String string) {
        Class class_ = class$org$jfree$data$time$Day == null ? (TimeSeries.class$org$jfree$data$time$Day = TimeSeries.class$("org.jfree.data.time.Day")) : class$org$jfree$data$time$Day;
        this(string, "Time", "Value", class_);
    }

    public TimeSeries(String string, Class class_) {
        this(string, "Time", "Value", class_);
    }

    public TimeSeries(String string, String string2, String string3, Class class_) {
        super((Comparable)((Object)string));
        this.domain = string2;
        this.range = string3;
        this.timePeriodClass = class_;
        this.data = new ArrayList();
        this.maximumItemCount = Integer.MAX_VALUE;
        this.maximumItemAge = Long.MAX_VALUE;
    }

    public String getDomainDescription() {
        return this.domain;
    }

    public void setDomainDescription(String string) {
        String string2 = this.domain;
        this.domain = string;
        this.firePropertyChange("Domain", string2, string);
    }

    public String getRangeDescription() {
        return this.range;
    }

    public void setRangeDescription(String string) {
        String string2 = this.range;
        this.range = string;
        this.firePropertyChange("Range", string2, string);
    }

    public int getItemCount() {
        return this.data.size();
    }

    public List getItems() {
        return Collections.unmodifiableList(this.data);
    }

    public int getMaximumItemCount() {
        return this.maximumItemCount;
    }

    public void setMaximumItemCount(int n2) {
        if (n2 < 0) {
            throw new IllegalArgumentException("Negative 'maximum' argument.");
        }
        this.maximumItemCount = n2;
        int n3 = this.data.size();
        if (n3 <= n2) return;
        this.delete(0, n3 - n2 - 1);
    }

    public long getMaximumItemAge() {
        return this.maximumItemAge;
    }

    public void setMaximumItemAge(long l2) {
        if (l2 < 0) {
            throw new IllegalArgumentException("Negative 'periods' argument.");
        }
        this.maximumItemAge = l2;
        this.removeAgedItems(true);
    }

    public Class getTimePeriodClass() {
        return this.timePeriodClass;
    }

    public TimeSeriesDataItem getDataItem(int n2) {
        return (TimeSeriesDataItem)this.data.get(n2);
    }

    public TimeSeriesDataItem getDataItem(RegularTimePeriod regularTimePeriod) {
        int n2 = this.getIndex(regularTimePeriod);
        if (n2 < 0) return null;
        return (TimeSeriesDataItem)this.data.get(n2);
    }

    public RegularTimePeriod getTimePeriod(int n2) {
        return this.getDataItem(n2).getPeriod();
    }

    public RegularTimePeriod getNextTimePeriod() {
        RegularTimePeriod regularTimePeriod = this.getTimePeriod(this.getItemCount() - 1);
        return regularTimePeriod.next();
    }

    public Collection getTimePeriods() {
        ArrayList<RegularTimePeriod> arrayList = new ArrayList<RegularTimePeriod>();
        int n2 = 0;
        while (n2 < this.getItemCount()) {
            arrayList.add(this.getTimePeriod(n2));
            ++n2;
        }
        return arrayList;
    }

    public Collection getTimePeriodsUniqueToOtherSeries(TimeSeries timeSeries) {
        ArrayList<RegularTimePeriod> arrayList = new ArrayList<RegularTimePeriod>();
        int n2 = 0;
        while (n2 < timeSeries.getItemCount()) {
            RegularTimePeriod regularTimePeriod = timeSeries.getTimePeriod(n2);
            int n3 = this.getIndex(regularTimePeriod);
            if (n3 < 0) {
                arrayList.add(regularTimePeriod);
            }
            ++n2;
        }
        return arrayList;
    }

    public int getIndex(RegularTimePeriod regularTimePeriod) {
        if (regularTimePeriod == null) {
            throw new IllegalArgumentException("Null 'period' argument.");
        }
        TimeSeriesDataItem timeSeriesDataItem = new TimeSeriesDataItem(regularTimePeriod, -2.147483648E9);
        return Collections.binarySearch(this.data, timeSeriesDataItem);
    }

    public Number getValue(int n2) {
        return this.getDataItem(n2).getValue();
    }

    public Number getValue(RegularTimePeriod regularTimePeriod) {
        int n2 = this.getIndex(regularTimePeriod);
        if (n2 < 0) return null;
        return this.getValue(n2);
    }

    public void add(TimeSeriesDataItem timeSeriesDataItem) {
        this.add(timeSeriesDataItem, true);
    }

    public void add(TimeSeriesDataItem timeSeriesDataItem, boolean bl2) {
        if (timeSeriesDataItem == null) {
            throw new IllegalArgumentException("Null 'item' argument.");
        }
        if (!timeSeriesDataItem.getPeriod().getClass().equals(this.timePeriodClass)) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("You are trying to add data where the time period class ");
            stringBuffer.append("is ");
            stringBuffer.append(timeSeriesDataItem.getPeriod().getClass().getName());
            stringBuffer.append(", but the TimeSeries is expecting an instance of ");
            stringBuffer.append(this.timePeriodClass.getName());
            stringBuffer.append(".");
            throw new SeriesException(stringBuffer.toString());
        }
        boolean bl3 = false;
        int n2 = this.getItemCount();
        if (n2 == 0) {
            this.data.add(timeSeriesDataItem);
            bl3 = true;
        } else {
            RegularTimePeriod regularTimePeriod = this.getTimePeriod(this.getItemCount() - 1);
            if (timeSeriesDataItem.getPeriod().compareTo(regularTimePeriod) > 0) {
                this.data.add(timeSeriesDataItem);
                bl3 = true;
            } else {
                int n3 = Collections.binarySearch(this.data, timeSeriesDataItem);
                if (n3 >= 0) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("You are attempting to add an observation for ");
                    stringBuffer.append("the time period ");
                    stringBuffer.append(timeSeriesDataItem.getPeriod().toString());
                    stringBuffer.append(" but the series already contains an observation");
                    stringBuffer.append(" for that time period. Duplicates are not ");
                    stringBuffer.append("permitted.  Try using the addOrUpdate() method.");
                    throw new SeriesException(stringBuffer.toString());
                }
                this.data.add(- n3 - 1, timeSeriesDataItem);
                bl3 = true;
            }
        }
        if (!bl3) return;
        if (this.getItemCount() > this.maximumItemCount) {
            this.data.remove(0);
        }
        this.removeAgedItems(false);
        if (!bl2) return;
        this.fireSeriesChanged();
    }

    public void add(RegularTimePeriod regularTimePeriod, double d2) {
        this.add(regularTimePeriod, d2, true);
    }

    public void add(RegularTimePeriod regularTimePeriod, double d2, boolean bl2) {
        TimeSeriesDataItem timeSeriesDataItem = new TimeSeriesDataItem(regularTimePeriod, d2);
        this.add(timeSeriesDataItem, bl2);
    }

    public void add(RegularTimePeriod regularTimePeriod, Number number) {
        this.add(regularTimePeriod, number, true);
    }

    public void add(RegularTimePeriod regularTimePeriod, Number number, boolean bl2) {
        TimeSeriesDataItem timeSeriesDataItem = new TimeSeriesDataItem(regularTimePeriod, number);
        this.add(timeSeriesDataItem, bl2);
    }

    public void update(RegularTimePeriod regularTimePeriod, Number number) {
        TimeSeriesDataItem timeSeriesDataItem = new TimeSeriesDataItem(regularTimePeriod, number);
        int n2 = Collections.binarySearch(this.data, timeSeriesDataItem);
        if (n2 < 0) throw new SeriesException("TimeSeries.update(TimePeriod, Number):  period does not exist.");
        TimeSeriesDataItem timeSeriesDataItem2 = (TimeSeriesDataItem)this.data.get(n2);
        timeSeriesDataItem2.setValue(number);
        this.fireSeriesChanged();
    }

    public void update(int n2, Number number) {
        TimeSeriesDataItem timeSeriesDataItem = this.getDataItem(n2);
        timeSeriesDataItem.setValue(number);
        this.fireSeriesChanged();
    }

    public TimeSeries addAndOrUpdate(TimeSeries timeSeries) {
        TimeSeries timeSeries2 = new TimeSeries(new StringBuffer().append("Overwritten values from: ").append(this.getKey()).toString(), timeSeries.getTimePeriodClass());
        int n2 = 0;
        while (n2 < timeSeries.getItemCount()) {
            TimeSeriesDataItem timeSeriesDataItem = timeSeries.getDataItem(n2);
            TimeSeriesDataItem timeSeriesDataItem2 = this.addOrUpdate(timeSeriesDataItem.getPeriod(), timeSeriesDataItem.getValue());
            if (timeSeriesDataItem2 != null) {
                timeSeries2.add(timeSeriesDataItem2);
            }
            ++n2;
        }
        return timeSeries2;
    }

    public TimeSeriesDataItem addOrUpdate(RegularTimePeriod regularTimePeriod, double d2) {
        return this.addOrUpdate(regularTimePeriod, new Double(d2));
    }

    public TimeSeriesDataItem addOrUpdate(RegularTimePeriod regularTimePeriod, Number number) {
        if (regularTimePeriod == null) {
            throw new IllegalArgumentException("Null 'period' argument.");
        }
        TimeSeriesDataItem timeSeriesDataItem = null;
        TimeSeriesDataItem timeSeriesDataItem2 = new TimeSeriesDataItem(regularTimePeriod, number);
        int n2 = Collections.binarySearch(this.data, timeSeriesDataItem2);
        if (n2 >= 0) {
            TimeSeriesDataItem timeSeriesDataItem3 = (TimeSeriesDataItem)this.data.get(n2);
            timeSeriesDataItem = (TimeSeriesDataItem)timeSeriesDataItem3.clone();
            timeSeriesDataItem3.setValue(number);
            this.removeAgedItems(false);
            this.fireSeriesChanged();
            return timeSeriesDataItem;
        }
        this.data.add(- n2 - 1, new TimeSeriesDataItem(regularTimePeriod, number));
        if (this.getItemCount() > this.maximumItemCount) {
            this.data.remove(0);
        }
        this.removeAgedItems(false);
        this.fireSeriesChanged();
        return timeSeriesDataItem;
    }

    public void removeAgedItems(boolean bl2) {
        if (this.getItemCount() <= 1) return;
        long l2 = this.getTimePeriod(this.getItemCount() - 1).getSerialIndex();
        boolean bl3 = false;
        while (l2 - this.getTimePeriod(0).getSerialIndex() > this.maximumItemAge) {
            this.data.remove(0);
            bl3 = true;
        }
    }

    public void removeAgedItems(long l2, boolean bl2) {
        long l3 = Long.MAX_VALUE;
        try {
            Class class_ = class$org$jfree$data$time$RegularTimePeriod == null ? (TimeSeries.class$org$jfree$data$time$RegularTimePeriod = TimeSeries.class$("org.jfree.data.time.RegularTimePeriod")) : class$org$jfree$data$time$RegularTimePeriod;
            Class[] arrclass = new Class[3];
            Class class_2 = class$java$lang$Class == null ? (TimeSeries.class$java$lang$Class = TimeSeries.class$("java.lang.Class")) : class$java$lang$Class;
            arrclass[0] = class_2;
            Class class_3 = class$java$util$Date == null ? (TimeSeries.class$java$util$Date = TimeSeries.class$("java.util.Date")) : class$java$util$Date;
            arrclass[1] = class_3;
            Class class_4 = class$java$util$TimeZone == null ? (TimeSeries.class$java$util$TimeZone = TimeSeries.class$("java.util.TimeZone")) : class$java$util$TimeZone;
            arrclass[2] = class_4;
            Method method = class_.getDeclaredMethod("createInstance", arrclass);
            RegularTimePeriod regularTimePeriod = (RegularTimePeriod)method.invoke(this.timePeriodClass, this.timePeriodClass, new Date(l2), TimeZone.getDefault());
            l3 = regularTimePeriod.getSerialIndex();
        }
        catch (NoSuchMethodException var6_5) {
            var6_5.printStackTrace();
        }
        catch (IllegalAccessException var6_6) {
            var6_6.printStackTrace();
        }
        catch (InvocationTargetException var6_7) {
            var6_7.printStackTrace();
        }
        boolean bl3 = false;
        while (this.getItemCount() > 0) {
            if (l3 - this.getTimePeriod(0).getSerialIndex() <= this.maximumItemAge) {
                if (!bl3) return;
                if (!bl2) return;
                this.fireSeriesChanged();
                return;
            }
            this.data.remove(0);
            bl3 = true;
        }
    }

    public void clear() {
        if (this.data.size() <= 0) return;
        this.data.clear();
        this.fireSeriesChanged();
    }

    public void delete(RegularTimePeriod regularTimePeriod) {
        int n2 = this.getIndex(regularTimePeriod);
        if (n2 < 0) return;
        this.data.remove(n2);
        this.fireSeriesChanged();
    }

    public void delete(int n2, int n3) {
        if (n3 < n2) {
            throw new IllegalArgumentException("Requires start <= end.");
        }
        int n4 = 0;
        do {
            if (n4 > n3 - n2) {
                this.fireSeriesChanged();
                return;
            }
            this.data.remove(n2);
            ++n4;
        } while (true);
    }

    @Override
    public Object clone() {
        return this.createCopy(0, this.getItemCount() - 1);
    }

    public TimeSeries createCopy(int n2, int n3) {
        if (n2 < 0) {
            throw new IllegalArgumentException("Requires start >= 0.");
        }
        if (n3 < n2) {
            throw new IllegalArgumentException("Requires start <= end.");
        }
        TimeSeries timeSeries = (TimeSeries)super.clone();
        timeSeries.data = new ArrayList();
        if (this.data.size() <= 0) return timeSeries;
        int n4 = n2;
        while (n4 <= n3) {
            TimeSeriesDataItem timeSeriesDataItem = (TimeSeriesDataItem)this.data.get(n4);
            TimeSeriesDataItem timeSeriesDataItem2 = (TimeSeriesDataItem)timeSeriesDataItem.clone();
            try {
                timeSeries.add(timeSeriesDataItem2);
            }
            catch (SeriesException var7_7) {
                var7_7.printStackTrace();
            }
            ++n4;
        }
        return timeSeries;
    }

    public TimeSeries createCopy(RegularTimePeriod regularTimePeriod, RegularTimePeriod regularTimePeriod2) {
        int n2;
        if (regularTimePeriod == null) {
            throw new IllegalArgumentException("Null 'start' argument.");
        }
        if (regularTimePeriod2 == null) {
            throw new IllegalArgumentException("Null 'end' argument.");
        }
        if (regularTimePeriod.compareTo(regularTimePeriod2) > 0) {
            throw new IllegalArgumentException("Requires start on or before end.");
        }
        boolean bl2 = false;
        int n3 = this.getIndex(regularTimePeriod);
        if (n3 < 0 && (n3 = - n3 + 1) == this.data.size()) {
            bl2 = true;
        }
        if ((n2 = this.getIndex(regularTimePeriod2)) < 0) {
            n2 = - n2 + 1;
            --n2;
        }
        if (n2 < 0) {
            bl2 = true;
        }
        if (!bl2) return this.createCopy(n3, n2);
        TimeSeries timeSeries = (TimeSeries)super.clone();
        timeSeries.data = new ArrayList();
        return timeSeries;
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof TimeSeries)) return false;
        if (!super.equals(object)) {
            return false;
        }
        TimeSeries timeSeries = (TimeSeries)object;
        if (!ObjectUtilities.equal(this.getDomainDescription(), timeSeries.getDomainDescription())) {
            return false;
        }
        if (!ObjectUtilities.equal(this.getRangeDescription(), timeSeries.getRangeDescription())) {
            return false;
        }
        if (!this.getClass().equals(timeSeries.getClass())) {
            return false;
        }
        if (this.getMaximumItemAge() != timeSeries.getMaximumItemAge()) {
            return false;
        }
        if (this.getMaximumItemCount() != timeSeries.getMaximumItemCount()) {
            return false;
        }
        int n2 = this.getItemCount();
        if (n2 != timeSeries.getItemCount()) {
            return false;
        }
        int n3 = 0;
        while (n3 < n2) {
            if (!this.getDataItem(n3).equals(timeSeries.getDataItem(n3))) {
                return false;
            }
            ++n3;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int n2 = this.domain != null ? this.domain.hashCode() : 0;
        n2 = 29 * n2 + (this.range != null ? this.range.hashCode() : 0);
        n2 = 29 * n2 + (this.timePeriodClass != null ? this.timePeriodClass.hashCode() : 0);
        n2 = 29 * n2 + this.data.hashCode();
        n2 = 29 * n2 + this.maximumItemCount;
        return 29 * n2 + (int)this.maximumItemAge;
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

