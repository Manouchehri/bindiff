package org.jfree.data.time;

import org.jfree.data.xy.*;
import org.jfree.data.*;
import java.util.*;
import org.jfree.data.general.*;

public class DynamicTimeSeriesCollection extends AbstractIntervalXYDataset implements DomainInfo, RangeInfo, IntervalXYDataset
{
    public static final int START = 0;
    public static final int MIDDLE = 1;
    public static final int END = 2;
    private int maximumItemCount;
    protected int historyCount;
    private Comparable[] seriesKeys;
    private Class timePeriodClass;
    protected RegularTimePeriod[] pointsInTime;
    private int seriesCount;
    protected DynamicTimeSeriesCollection$ValueSequence[] valueHistory;
    protected Calendar workingCalendar;
    private int position;
    private boolean domainIsPointsInTime;
    private int oldestAt;
    private int newestAt;
    private long deltaTime;
    private Long domainStart;
    private Long domainEnd;
    private Range domainRange;
    private Float minValue;
    private Float maxValue;
    private Range valueRange;
    static Class class$org$jfree$data$time$Minute;
    static Class class$org$jfree$data$time$Second;
    static Class class$org$jfree$data$time$Hour;
    
    public DynamicTimeSeriesCollection(final int n, final int n2) {
        this(n, n2, new Millisecond(), TimeZone.getDefault());
        this.newestAt = n2 - 1;
    }
    
    public DynamicTimeSeriesCollection(final int n, final int n2, final TimeZone timeZone) {
        this(n, n2, new Millisecond(), timeZone);
        this.newestAt = n2 - 1;
    }
    
    public DynamicTimeSeriesCollection(final int n, final int n2, final RegularTimePeriod regularTimePeriod) {
        this(n, n2, regularTimePeriod, TimeZone.getDefault());
    }
    
    public DynamicTimeSeriesCollection(final int n, final int n2, final RegularTimePeriod regularTimePeriod, final TimeZone timeZone) {
        this.maximumItemCount = 2000;
        this.timePeriodClass = ((DynamicTimeSeriesCollection.class$org$jfree$data$time$Minute == null) ? (DynamicTimeSeriesCollection.class$org$jfree$data$time$Minute = class$("org.jfree.data.time.Minute")) : DynamicTimeSeriesCollection.class$org$jfree$data$time$Minute);
        this.minValue = new Float(0.0f);
        this.maxValue = null;
        this.maximumItemCount = n2;
        this.historyCount = n2;
        this.seriesKeys = new Comparable[n];
        for (int i = 0; i < n; ++i) {
            this.seriesKeys[i] = "";
        }
        this.newestAt = n2 - 1;
        this.valueHistory = new DynamicTimeSeriesCollection$ValueSequence[n];
        this.timePeriodClass = regularTimePeriod.getClass();
        if (this.timePeriodClass == ((DynamicTimeSeriesCollection.class$org$jfree$data$time$Second == null) ? (DynamicTimeSeriesCollection.class$org$jfree$data$time$Second = class$("org.jfree.data.time.Second")) : DynamicTimeSeriesCollection.class$org$jfree$data$time$Second)) {
            this.pointsInTime = new Second[n2];
        }
        else if (this.timePeriodClass == ((DynamicTimeSeriesCollection.class$org$jfree$data$time$Minute == null) ? (DynamicTimeSeriesCollection.class$org$jfree$data$time$Minute = class$("org.jfree.data.time.Minute")) : DynamicTimeSeriesCollection.class$org$jfree$data$time$Minute)) {
            this.pointsInTime = new Minute[n2];
        }
        else if (this.timePeriodClass == ((DynamicTimeSeriesCollection.class$org$jfree$data$time$Hour == null) ? (DynamicTimeSeriesCollection.class$org$jfree$data$time$Hour = class$("org.jfree.data.time.Hour")) : DynamicTimeSeriesCollection.class$org$jfree$data$time$Hour)) {
            this.pointsInTime = new Hour[n2];
        }
        this.workingCalendar = Calendar.getInstance(timeZone);
        this.position = 0;
        this.domainIsPointsInTime = true;
    }
    
    public synchronized long setTimeBase(final RegularTimePeriod regularTimePeriod) {
        if (this.pointsInTime[0] == null) {
            this.pointsInTime[0] = regularTimePeriod;
            for (int i = 1; i < this.historyCount; ++i) {
                this.pointsInTime[i] = this.pointsInTime[i - 1].next();
            }
        }
        this.deltaTime = this.pointsInTime[1].getFirstMillisecond(this.workingCalendar) - this.pointsInTime[0].getFirstMillisecond(this.workingCalendar);
        this.oldestAt = 0;
        this.newestAt = this.historyCount - 1;
        this.findDomainLimits();
        return this.deltaTime;
    }
    
    protected void findDomainLimits() {
        final long firstMillisecond = this.getOldestTime().getFirstMillisecond(this.workingCalendar);
        long n;
        if (this.domainIsPointsInTime) {
            n = this.getNewestTime().getFirstMillisecond(this.workingCalendar);
        }
        else {
            n = this.getNewestTime().getLastMillisecond(this.workingCalendar);
        }
        this.domainStart = new Long(firstMillisecond);
        this.domainEnd = new Long(n);
        this.domainRange = new Range(firstMillisecond, n);
    }
    
    public int getPosition() {
        return this.position;
    }
    
    public void setPosition(final int position) {
        this.position = position;
    }
    
    public void addSeries(final float[] array, final int n, final Comparable comparable) {
        this.invalidateRangeInfo();
        if (array == null) {
            throw new IllegalArgumentException("TimeSeriesDataset.addSeries(): cannot add null array of values.");
        }
        if (n >= this.valueHistory.length) {
            throw new IllegalArgumentException("TimeSeriesDataset.addSeries(): cannot add more series than specified in c'tor");
        }
        if (this.valueHistory[n] == null) {
            this.valueHistory[n] = new DynamicTimeSeriesCollection$ValueSequence(this, this.historyCount);
            ++this.seriesCount;
        }
        final int length = array.length;
        int historyCount = this.historyCount;
        boolean b = false;
        if (length < this.historyCount) {
            b = true;
            historyCount = length;
        }
        for (int i = 0; i < historyCount; ++i) {
            this.valueHistory[n].enterData(i, array[i]);
        }
        if (b) {
            for (int j = historyCount; j < this.historyCount; ++j) {
                this.valueHistory[n].enterData(j, 0.0f);
            }
        }
        if (comparable != null) {
            this.seriesKeys[n] = comparable;
        }
        this.fireSeriesChanged();
    }
    
    public void setSeriesKey(final int n, final Comparable comparable) {
        this.seriesKeys[n] = comparable;
    }
    
    public void addValue(final int n, final int n2, final float n3) {
        this.invalidateRangeInfo();
        if (n >= this.valueHistory.length) {
            throw new IllegalArgumentException("TimeSeriesDataset.addValue(): series #" + n + "unspecified in c'tor");
        }
        if (this.valueHistory[n] == null) {
            this.valueHistory[n] = new DynamicTimeSeriesCollection$ValueSequence(this, this.historyCount);
            ++this.seriesCount;
        }
        this.valueHistory[n].enterData(n2, n3);
        this.fireSeriesChanged();
    }
    
    public int getSeriesCount() {
        return this.seriesCount;
    }
    
    public int getItemCount(final int n) {
        return this.historyCount;
    }
    
    protected int translateGet(final int n) {
        if (this.oldestAt == 0) {
            return n;
        }
        int n2 = n + this.oldestAt;
        if (n2 >= this.historyCount) {
            n2 -= this.historyCount;
        }
        return n2;
    }
    
    public int offsetFromNewest(final int n) {
        return this.wrapOffset(this.newestAt + n);
    }
    
    public int offsetFromOldest(final int n) {
        return this.wrapOffset(this.oldestAt + n);
    }
    
    protected int wrapOffset(final int n) {
        int n2 = n;
        if (n2 >= this.historyCount) {
            n2 -= this.historyCount;
        }
        else if (n2 < 0) {
            n2 += this.historyCount;
        }
        return n2;
    }
    
    public synchronized RegularTimePeriod advanceTime() {
        final RegularTimePeriod next = this.pointsInTime[this.newestAt].next();
        this.newestAt = this.oldestAt;
        boolean b = false;
        float floatValue = 0.0f;
        if (this.maxValue != null) {
            floatValue = this.maxValue;
        }
        for (int i = 0; i < this.getSeriesCount(); ++i) {
            if (this.valueHistory[i].getData(this.oldestAt) == floatValue) {
                b = true;
            }
            if (b) {
                break;
            }
        }
        if (b) {
            this.invalidateRangeInfo();
        }
        final float n = 0.0f;
        for (int j = 0; j < this.getSeriesCount(); ++j) {
            this.valueHistory[j].enterData(this.newestAt, n);
        }
        this.pointsInTime[this.newestAt] = next;
        ++this.oldestAt;
        if (this.oldestAt >= this.historyCount) {
            this.oldestAt = 0;
        }
        final long longValue = this.domainStart;
        this.domainStart = new Long(longValue + this.deltaTime);
        final long longValue2 = this.domainEnd;
        this.domainEnd = new Long(longValue2 + this.deltaTime);
        this.domainRange = new Range(longValue, longValue2);
        this.fireSeriesChanged();
        return next;
    }
    
    public void invalidateRangeInfo() {
        this.maxValue = null;
        this.valueRange = null;
    }
    
    protected double findMaxValue() {
        double n = 0.0;
        for (int i = 0; i < this.getSeriesCount(); ++i) {
            for (int j = 0; j < this.historyCount; ++j) {
                final double yValue = this.getYValue(i, j);
                if (yValue > n) {
                    n = yValue;
                }
            }
        }
        return n;
    }
    
    public int getOldestIndex() {
        return this.oldestAt;
    }
    
    public int getNewestIndex() {
        return this.newestAt;
    }
    
    public void appendData(final float[] array) {
        final int length = array.length;
        if (length > this.valueHistory.length) {
            throw new IllegalArgumentException("More data than series to put them in");
        }
        for (int i = 0; i < length; ++i) {
            if (this.valueHistory[i] == null) {
                this.valueHistory[i] = new DynamicTimeSeriesCollection$ValueSequence(this, this.historyCount);
            }
            this.valueHistory[i].enterData(this.newestAt, array[i]);
        }
        this.fireSeriesChanged();
    }
    
    public void appendData(final float[] array, int n, final int n2) {
        final int length = array.length;
        if (length > this.valueHistory.length) {
            throw new IllegalArgumentException("More data than series to put them in");
        }
        for (int i = 0; i < length; ++i) {
            if (this.valueHistory[i] == null) {
                this.valueHistory[i] = new DynamicTimeSeriesCollection$ValueSequence(this, this.historyCount);
            }
            this.valueHistory[i].enterData(n, array[i]);
        }
        if (n2 > 0 && ++n % n2 == 0) {
            this.fireSeriesChanged();
        }
    }
    
    public RegularTimePeriod getNewestTime() {
        return this.pointsInTime[this.newestAt];
    }
    
    public RegularTimePeriod getOldestTime() {
        return this.pointsInTime[this.oldestAt];
    }
    
    public Number getX(final int n, final int n2) {
        return new Long(this.getX(this.pointsInTime[this.translateGet(n2)]));
    }
    
    public double getYValue(final int n, final int n2) {
        return this.valueHistory[n].getData(this.translateGet(n2));
    }
    
    public Number getY(final int n, final int n2) {
        return new Float(this.getYValue(n, n2));
    }
    
    public Number getStartX(final int n, final int n2) {
        return new Long(this.pointsInTime[this.translateGet(n2)].getFirstMillisecond(this.workingCalendar));
    }
    
    public Number getEndX(final int n, final int n2) {
        return new Long(this.pointsInTime[this.translateGet(n2)].getLastMillisecond(this.workingCalendar));
    }
    
    public Number getStartY(final int n, final int n2) {
        return this.getY(n, n2);
    }
    
    public Number getEndY(final int n, final int n2) {
        return this.getY(n, n2);
    }
    
    public Comparable getSeriesKey(final int n) {
        return this.seriesKeys[n];
    }
    
    protected void fireSeriesChanged() {
        this.seriesChanged(new SeriesChangeEvent(this));
    }
    
    public double getDomainLowerBound(final boolean b) {
        return this.domainStart;
    }
    
    public double getDomainUpperBound(final boolean b) {
        return this.domainEnd;
    }
    
    public Range getDomainBounds(final boolean b) {
        if (this.domainRange == null) {
            this.findDomainLimits();
        }
        return this.domainRange;
    }
    
    private long getX(final RegularTimePeriod regularTimePeriod) {
        switch (this.position) {
            case 0: {
                return regularTimePeriod.getFirstMillisecond(this.workingCalendar);
            }
            case 1: {
                return regularTimePeriod.getMiddleMillisecond(this.workingCalendar);
            }
            case 2: {
                return regularTimePeriod.getLastMillisecond(this.workingCalendar);
            }
            default: {
                return regularTimePeriod.getMiddleMillisecond(this.workingCalendar);
            }
        }
    }
    
    public double getRangeLowerBound(final boolean b) {
        double doubleValue = Double.NaN;
        if (this.minValue != null) {
            doubleValue = this.minValue;
        }
        return doubleValue;
    }
    
    public double getRangeUpperBound(final boolean b) {
        double doubleValue = Double.NaN;
        if (this.maxValue != null) {
            doubleValue = this.maxValue;
        }
        return doubleValue;
    }
    
    public Range getRangeBounds(final boolean b) {
        if (this.valueRange == null) {
            this.valueRange = new Range(0.0, this.getRangeUpperBound(b));
        }
        return this.valueRange;
    }
    
    static Class class$(final String s) {
        try {
            return Class.forName(s);
        }
        catch (ClassNotFoundException ex) {
            throw new NoClassDefFoundError(ex.getMessage());
        }
    }
    
    static int access$000(final DynamicTimeSeriesCollection collection) {
        return collection.maximumItemCount;
    }
}
