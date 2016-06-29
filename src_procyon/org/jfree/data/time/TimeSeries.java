package org.jfree.data.time;

import java.io.*;
import org.jfree.data.general.*;
import java.util.*;
import java.lang.reflect.*;
import org.jfree.util.*;

public class TimeSeries extends Series implements Serializable, Cloneable
{
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
    
    public TimeSeries(final String s) {
        this(s, "Time", "Value", (TimeSeries.class$org$jfree$data$time$Day == null) ? (TimeSeries.class$org$jfree$data$time$Day = class$("org.jfree.data.time.Day")) : TimeSeries.class$org$jfree$data$time$Day);
    }
    
    public TimeSeries(final String s, final Class clazz) {
        this(s, "Time", "Value", clazz);
    }
    
    public TimeSeries(final String s, final String domain, final String range, final Class timePeriodClass) {
        super(s);
        this.domain = domain;
        this.range = range;
        this.timePeriodClass = timePeriodClass;
        this.data = new ArrayList();
        this.maximumItemCount = Integer.MAX_VALUE;
        this.maximumItemAge = Long.MAX_VALUE;
    }
    
    public String getDomainDescription() {
        return this.domain;
    }
    
    public void setDomainDescription(final String domain) {
        this.firePropertyChange("Domain", this.domain, this.domain = domain);
    }
    
    public String getRangeDescription() {
        return this.range;
    }
    
    public void setRangeDescription(final String range) {
        this.firePropertyChange("Range", this.range, this.range = range);
    }
    
    public int getItemCount() {
        return this.data.size();
    }
    
    public List getItems() {
        return Collections.unmodifiableList((List<?>)this.data);
    }
    
    public int getMaximumItemCount() {
        return this.maximumItemCount;
    }
    
    public void setMaximumItemCount(final int maximumItemCount) {
        if (maximumItemCount < 0) {
            throw new IllegalArgumentException("Negative 'maximum' argument.");
        }
        this.maximumItemCount = maximumItemCount;
        final int size = this.data.size();
        if (size > maximumItemCount) {
            this.delete(0, size - maximumItemCount - 1);
        }
    }
    
    public long getMaximumItemAge() {
        return this.maximumItemAge;
    }
    
    public void setMaximumItemAge(final long maximumItemAge) {
        if (maximumItemAge < 0L) {
            throw new IllegalArgumentException("Negative 'periods' argument.");
        }
        this.maximumItemAge = maximumItemAge;
        this.removeAgedItems(true);
    }
    
    public Class getTimePeriodClass() {
        return this.timePeriodClass;
    }
    
    public TimeSeriesDataItem getDataItem(final int n) {
        return this.data.get(n);
    }
    
    public TimeSeriesDataItem getDataItem(final RegularTimePeriod regularTimePeriod) {
        final int index = this.getIndex(regularTimePeriod);
        if (index >= 0) {
            return (TimeSeriesDataItem)this.data.get(index);
        }
        return null;
    }
    
    public RegularTimePeriod getTimePeriod(final int n) {
        return this.getDataItem(n).getPeriod();
    }
    
    public RegularTimePeriod getNextTimePeriod() {
        return this.getTimePeriod(this.getItemCount() - 1).next();
    }
    
    public Collection getTimePeriods() {
        final ArrayList<RegularTimePeriod> list = new ArrayList<RegularTimePeriod>();
        for (int i = 0; i < this.getItemCount(); ++i) {
            list.add(this.getTimePeriod(i));
        }
        return list;
    }
    
    public Collection getTimePeriodsUniqueToOtherSeries(final TimeSeries timeSeries) {
        final ArrayList<RegularTimePeriod> list = new ArrayList<RegularTimePeriod>();
        for (int i = 0; i < timeSeries.getItemCount(); ++i) {
            final RegularTimePeriod timePeriod = timeSeries.getTimePeriod(i);
            if (this.getIndex(timePeriod) < 0) {
                list.add(timePeriod);
            }
        }
        return list;
    }
    
    public int getIndex(final RegularTimePeriod regularTimePeriod) {
        if (regularTimePeriod == null) {
            throw new IllegalArgumentException("Null 'period' argument.");
        }
        return Collections.binarySearch(this.data, new TimeSeriesDataItem(regularTimePeriod, -2.147483648E9));
    }
    
    public Number getValue(final int n) {
        return this.getDataItem(n).getValue();
    }
    
    public Number getValue(final RegularTimePeriod regularTimePeriod) {
        final int index = this.getIndex(regularTimePeriod);
        if (index >= 0) {
            return this.getValue(index);
        }
        return null;
    }
    
    public void add(final TimeSeriesDataItem timeSeriesDataItem) {
        this.add(timeSeriesDataItem, true);
    }
    
    public void add(final TimeSeriesDataItem timeSeriesDataItem, final boolean b) {
        if (timeSeriesDataItem == null) {
            throw new IllegalArgumentException("Null 'item' argument.");
        }
        if (!timeSeriesDataItem.getPeriod().getClass().equals(this.timePeriodClass)) {
            final StringBuffer sb = new StringBuffer();
            sb.append("You are trying to add data where the time period class ");
            sb.append("is ");
            sb.append(timeSeriesDataItem.getPeriod().getClass().getName());
            sb.append(", but the TimeSeries is expecting an instance of ");
            sb.append(this.timePeriodClass.getName());
            sb.append(".");
            throw new SeriesException(sb.toString());
        }
        boolean b2;
        if (this.getItemCount() == 0) {
            this.data.add(timeSeriesDataItem);
            b2 = true;
        }
        else if (timeSeriesDataItem.getPeriod().compareTo(this.getTimePeriod(this.getItemCount() - 1)) > 0) {
            this.data.add(timeSeriesDataItem);
            b2 = true;
        }
        else {
            final int binarySearch = Collections.binarySearch(this.data, timeSeriesDataItem);
            if (binarySearch >= 0) {
                final StringBuffer sb2 = new StringBuffer();
                sb2.append("You are attempting to add an observation for ");
                sb2.append("the time period ");
                sb2.append(timeSeriesDataItem.getPeriod().toString());
                sb2.append(" but the series already contains an observation");
                sb2.append(" for that time period. Duplicates are not ");
                sb2.append("permitted.  Try using the addOrUpdate() method.");
                throw new SeriesException(sb2.toString());
            }
            this.data.add(-binarySearch - 1, timeSeriesDataItem);
            b2 = true;
        }
        if (b2) {
            if (this.getItemCount() > this.maximumItemCount) {
                this.data.remove(0);
            }
            this.removeAgedItems(false);
            if (b) {
                this.fireSeriesChanged();
            }
        }
    }
    
    public void add(final RegularTimePeriod regularTimePeriod, final double n) {
        this.add(regularTimePeriod, n, true);
    }
    
    public void add(final RegularTimePeriod regularTimePeriod, final double n, final boolean b) {
        this.add(new TimeSeriesDataItem(regularTimePeriod, n), b);
    }
    
    public void add(final RegularTimePeriod regularTimePeriod, final Number n) {
        this.add(regularTimePeriod, n, true);
    }
    
    public void add(final RegularTimePeriod regularTimePeriod, final Number n, final boolean b) {
        this.add(new TimeSeriesDataItem(regularTimePeriod, n), b);
    }
    
    public void update(final RegularTimePeriod regularTimePeriod, final Number value) {
        final int binarySearch = Collections.binarySearch(this.data, new TimeSeriesDataItem(regularTimePeriod, value));
        if (binarySearch >= 0) {
            ((TimeSeriesDataItem)this.data.get(binarySearch)).setValue(value);
            this.fireSeriesChanged();
            return;
        }
        throw new SeriesException("TimeSeries.update(TimePeriod, Number):  period does not exist.");
    }
    
    public void update(final int n, final Number value) {
        this.getDataItem(n).setValue(value);
        this.fireSeriesChanged();
    }
    
    public TimeSeries addAndOrUpdate(final TimeSeries timeSeries) {
        final TimeSeries timeSeries2 = new TimeSeries("Overwritten values from: " + this.getKey(), timeSeries.getTimePeriodClass());
        for (int i = 0; i < timeSeries.getItemCount(); ++i) {
            final TimeSeriesDataItem dataItem = timeSeries.getDataItem(i);
            final TimeSeriesDataItem addOrUpdate = this.addOrUpdate(dataItem.getPeriod(), dataItem.getValue());
            if (addOrUpdate != null) {
                timeSeries2.add(addOrUpdate);
            }
        }
        return timeSeries2;
    }
    
    public TimeSeriesDataItem addOrUpdate(final RegularTimePeriod regularTimePeriod, final double n) {
        return this.addOrUpdate(regularTimePeriod, new Double(n));
    }
    
    public TimeSeriesDataItem addOrUpdate(final RegularTimePeriod regularTimePeriod, final Number value) {
        if (regularTimePeriod == null) {
            throw new IllegalArgumentException("Null 'period' argument.");
        }
        TimeSeriesDataItem timeSeriesDataItem = null;
        final int binarySearch = Collections.binarySearch(this.data, new TimeSeriesDataItem(regularTimePeriod, value));
        if (binarySearch >= 0) {
            final TimeSeriesDataItem timeSeriesDataItem2 = this.data.get(binarySearch);
            timeSeriesDataItem = (TimeSeriesDataItem)timeSeriesDataItem2.clone();
            timeSeriesDataItem2.setValue(value);
            this.removeAgedItems(false);
            this.fireSeriesChanged();
        }
        else {
            this.data.add(-binarySearch - 1, new TimeSeriesDataItem(regularTimePeriod, value));
            if (this.getItemCount() > this.maximumItemCount) {
                this.data.remove(0);
            }
            this.removeAgedItems(false);
            this.fireSeriesChanged();
        }
        return timeSeriesDataItem;
    }
    
    public void removeAgedItems(final boolean b) {
        if (this.getItemCount() > 1) {
            final long serialIndex = this.getTimePeriod(this.getItemCount() - 1).getSerialIndex();
            boolean b2 = false;
            while (serialIndex - this.getTimePeriod(0).getSerialIndex() > this.maximumItemAge) {
                this.data.remove(0);
                b2 = true;
            }
            if (b2 && b) {
                this.fireSeriesChanged();
            }
        }
    }
    
    public void removeAgedItems(final long n, final boolean b) {
        long serialIndex = Long.MAX_VALUE;
        try {
            serialIndex = ((RegularTimePeriod)((TimeSeries.class$org$jfree$data$time$RegularTimePeriod == null) ? (TimeSeries.class$org$jfree$data$time$RegularTimePeriod = class$("org.jfree.data.time.RegularTimePeriod")) : TimeSeries.class$org$jfree$data$time$RegularTimePeriod).getDeclaredMethod("createInstance", (TimeSeries.class$java$lang$Class == null) ? (TimeSeries.class$java$lang$Class = class$("java.lang.Class")) : TimeSeries.class$java$lang$Class, (TimeSeries.class$java$util$Date == null) ? (TimeSeries.class$java$util$Date = class$("java.util.Date")) : TimeSeries.class$java$util$Date, (TimeSeries.class$java$util$TimeZone == null) ? (TimeSeries.class$java$util$TimeZone = class$("java.util.TimeZone")) : TimeSeries.class$java$util$TimeZone).invoke(this.timePeriodClass, this.timePeriodClass, new Date(n), TimeZone.getDefault())).getSerialIndex();
        }
        catch (NoSuchMethodException ex) {
            ex.printStackTrace();
        }
        catch (IllegalAccessException ex2) {
            ex2.printStackTrace();
        }
        catch (InvocationTargetException ex3) {
            ex3.printStackTrace();
        }
        boolean b2 = false;
        while (this.getItemCount() > 0 && serialIndex - this.getTimePeriod(0).getSerialIndex() > this.maximumItemAge) {
            this.data.remove(0);
            b2 = true;
        }
        if (b2 && b) {
            this.fireSeriesChanged();
        }
    }
    
    public void clear() {
        if (this.data.size() > 0) {
            this.data.clear();
            this.fireSeriesChanged();
        }
    }
    
    public void delete(final RegularTimePeriod regularTimePeriod) {
        final int index = this.getIndex(regularTimePeriod);
        if (index >= 0) {
            this.data.remove(index);
            this.fireSeriesChanged();
        }
    }
    
    public void delete(final int n, final int n2) {
        if (n2 < n) {
            throw new IllegalArgumentException("Requires start <= end.");
        }
        for (int i = 0; i <= n2 - n; ++i) {
            this.data.remove(n);
        }
        this.fireSeriesChanged();
    }
    
    public Object clone() {
        return this.createCopy(0, this.getItemCount() - 1);
    }
    
    public TimeSeries createCopy(final int n, final int n2) {
        if (n < 0) {
            throw new IllegalArgumentException("Requires start >= 0.");
        }
        if (n2 < n) {
            throw new IllegalArgumentException("Requires start <= end.");
        }
        final TimeSeries timeSeries = (TimeSeries)super.clone();
        timeSeries.data = new ArrayList();
        if (this.data.size() > 0) {
            for (int i = n; i <= n2; ++i) {
                final TimeSeriesDataItem timeSeriesDataItem = (TimeSeriesDataItem)this.data.get(i).clone();
                try {
                    timeSeries.add(timeSeriesDataItem);
                }
                catch (SeriesException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return timeSeries;
    }
    
    public TimeSeries createCopy(final RegularTimePeriod regularTimePeriod, final RegularTimePeriod regularTimePeriod2) {
        if (regularTimePeriod == null) {
            throw new IllegalArgumentException("Null 'start' argument.");
        }
        if (regularTimePeriod2 == null) {
            throw new IllegalArgumentException("Null 'end' argument.");
        }
        if (regularTimePeriod.compareTo(regularTimePeriod2) > 0) {
            throw new IllegalArgumentException("Requires start on or before end.");
        }
        boolean b = false;
        int index = this.getIndex(regularTimePeriod);
        if (index < 0) {
            index = -(index + 1);
            if (index == this.data.size()) {
                b = true;
            }
        }
        int index2 = this.getIndex(regularTimePeriod2);
        if (index2 < 0) {
            index2 = -(index2 + 1) - 1;
        }
        if (index2 < 0) {
            b = true;
        }
        if (b) {
            final TimeSeries timeSeries = (TimeSeries)super.clone();
            timeSeries.data = new ArrayList();
            return timeSeries;
        }
        return this.createCopy(index, index2);
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof TimeSeries) || !super.equals(o)) {
            return false;
        }
        final TimeSeries timeSeries = (TimeSeries)o;
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
        final int itemCount = this.getItemCount();
        if (itemCount != timeSeries.getItemCount()) {
            return false;
        }
        for (int i = 0; i < itemCount; ++i) {
            if (!this.getDataItem(i).equals(timeSeries.getDataItem(i))) {
                return false;
            }
        }
        return true;
    }
    
    public int hashCode() {
        return 29 * (29 * (29 * (29 * (29 * ((this.domain != null) ? this.domain.hashCode() : 0) + ((this.range != null) ? this.range.hashCode() : 0)) + ((this.timePeriodClass != null) ? this.timePeriodClass.hashCode() : 0)) + this.data.hashCode()) + this.maximumItemCount) + (int)this.maximumItemAge;
    }
    
    static Class class$(final String s) {
        try {
            return Class.forName(s);
        }
        catch (ClassNotFoundException ex) {
            throw new NoClassDefFoundError(ex.getMessage());
        }
    }
}
