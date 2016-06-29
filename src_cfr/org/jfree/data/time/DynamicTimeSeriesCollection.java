/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data.time;

import java.util.Calendar;
import java.util.TimeZone;
import org.jfree.data.DomainInfo;
import org.jfree.data.Range;
import org.jfree.data.RangeInfo;
import org.jfree.data.general.SeriesChangeEvent;
import org.jfree.data.time.DynamicTimeSeriesCollection$ValueSequence;
import org.jfree.data.time.Hour;
import org.jfree.data.time.Millisecond;
import org.jfree.data.time.Minute;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.Second;
import org.jfree.data.xy.AbstractIntervalXYDataset;
import org.jfree.data.xy.IntervalXYDataset;

public class DynamicTimeSeriesCollection
extends AbstractIntervalXYDataset
implements DomainInfo,
RangeInfo,
IntervalXYDataset {
    public static final int START = 0;
    public static final int MIDDLE = 1;
    public static final int END = 2;
    private int maximumItemCount = 2000;
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

    public DynamicTimeSeriesCollection(int n2, int n3) {
        this(n2, n3, new Millisecond(), TimeZone.getDefault());
        this.newestAt = n3 - 1;
    }

    public DynamicTimeSeriesCollection(int n2, int n3, TimeZone timeZone) {
        this(n2, n3, new Millisecond(), timeZone);
        this.newestAt = n3 - 1;
    }

    public DynamicTimeSeriesCollection(int n2, int n3, RegularTimePeriod regularTimePeriod) {
        this(n2, n3, regularTimePeriod, TimeZone.getDefault());
    }

    public DynamicTimeSeriesCollection(int n2, int n3, RegularTimePeriod regularTimePeriod, TimeZone timeZone) {
        Class class_ = class$org$jfree$data$time$Minute == null ? (DynamicTimeSeriesCollection.class$org$jfree$data$time$Minute = DynamicTimeSeriesCollection.class$("org.jfree.data.time.Minute")) : class$org$jfree$data$time$Minute;
        this.timePeriodClass = class_;
        this.minValue = new Float(0.0f);
        this.maxValue = null;
        this.maximumItemCount = n3;
        this.historyCount = n3;
        this.seriesKeys = new Comparable[n2];
        for (int i2 = 0; i2 < n2; ++i2) {
            this.seriesKeys[i2] = "";
        }
        this.newestAt = n3 - 1;
        this.valueHistory = new DynamicTimeSeriesCollection$ValueSequence[n2];
        this.timePeriodClass = regularTimePeriod.getClass();
        Class class_2 = class$org$jfree$data$time$Second == null ? (DynamicTimeSeriesCollection.class$org$jfree$data$time$Second = DynamicTimeSeriesCollection.class$("org.jfree.data.time.Second")) : class$org$jfree$data$time$Second;
        if (this.timePeriodClass == class_2) {
            this.pointsInTime = new Second[n3];
        } else if (this.timePeriodClass == (class$org$jfree$data$time$Minute == null ? (DynamicTimeSeriesCollection.class$org$jfree$data$time$Minute = DynamicTimeSeriesCollection.class$("org.jfree.data.time.Minute")) : class$org$jfree$data$time$Minute)) {
            this.pointsInTime = new Minute[n3];
        } else {
            Class class_3 = class$org$jfree$data$time$Hour == null ? (DynamicTimeSeriesCollection.class$org$jfree$data$time$Hour = DynamicTimeSeriesCollection.class$("org.jfree.data.time.Hour")) : class$org$jfree$data$time$Hour;
            if (this.timePeriodClass == class_3) {
                this.pointsInTime = new Hour[n3];
            }
        }
        this.workingCalendar = Calendar.getInstance(timeZone);
        this.position = 0;
        this.domainIsPointsInTime = true;
    }

    public synchronized long setTimeBase(RegularTimePeriod regularTimePeriod) {
        if (this.pointsInTime[0] == null) {
            this.pointsInTime[0] = regularTimePeriod;
            for (int i2 = 1; i2 < this.historyCount; ++i2) {
                this.pointsInTime[i2] = this.pointsInTime[i2 - 1].next();
            }
        }
        long l2 = this.pointsInTime[0].getFirstMillisecond(this.workingCalendar);
        long l3 = this.pointsInTime[1].getFirstMillisecond(this.workingCalendar);
        this.deltaTime = l3 - l2;
        this.oldestAt = 0;
        this.newestAt = this.historyCount - 1;
        this.findDomainLimits();
        return this.deltaTime;
    }

    protected void findDomainLimits() {
        long l2 = this.getOldestTime().getFirstMillisecond(this.workingCalendar);
        long l3 = this.domainIsPointsInTime ? this.getNewestTime().getFirstMillisecond(this.workingCalendar) : this.getNewestTime().getLastMillisecond(this.workingCalendar);
        this.domainStart = new Long(l2);
        this.domainEnd = new Long(l3);
        this.domainRange = new Range(l2, l3);
    }

    public int getPosition() {
        return this.position;
    }

    public void setPosition(int n2) {
        this.position = n2;
    }

    public void addSeries(float[] arrf, int n2, Comparable comparable) {
        int n3;
        this.invalidateRangeInfo();
        if (arrf == null) {
            throw new IllegalArgumentException("TimeSeriesDataset.addSeries(): cannot add null array of values.");
        }
        if (n2 >= this.valueHistory.length) {
            throw new IllegalArgumentException("TimeSeriesDataset.addSeries(): cannot add more series than specified in c'tor");
        }
        if (this.valueHistory[n2] == null) {
            this.valueHistory[n2] = new DynamicTimeSeriesCollection$ValueSequence(this, this.historyCount);
            ++this.seriesCount;
        }
        int n4 = arrf.length;
        int n5 = this.historyCount;
        boolean bl2 = false;
        if (n4 < this.historyCount) {
            bl2 = true;
            n5 = n4;
        }
        for (n3 = 0; n3 < n5; ++n3) {
            this.valueHistory[n2].enterData(n3, arrf[n3]);
        }
        if (bl2) {
            for (n3 = n5; n3 < this.historyCount; ++n3) {
                this.valueHistory[n2].enterData(n3, 0.0f);
            }
        }
        if (comparable != null) {
            this.seriesKeys[n2] = comparable;
        }
        this.fireSeriesChanged();
    }

    public void setSeriesKey(int n2, Comparable comparable) {
        this.seriesKeys[n2] = comparable;
    }

    public void addValue(int n2, int n3, float f2) {
        this.invalidateRangeInfo();
        if (n2 >= this.valueHistory.length) {
            throw new IllegalArgumentException(new StringBuffer().append("TimeSeriesDataset.addValue(): series #").append(n2).append("unspecified in c'tor").toString());
        }
        if (this.valueHistory[n2] == null) {
            this.valueHistory[n2] = new DynamicTimeSeriesCollection$ValueSequence(this, this.historyCount);
            ++this.seriesCount;
        }
        this.valueHistory[n2].enterData(n3, f2);
        this.fireSeriesChanged();
    }

    @Override
    public int getSeriesCount() {
        return this.seriesCount;
    }

    @Override
    public int getItemCount(int n2) {
        return this.historyCount;
    }

    protected int translateGet(int n2) {
        if (this.oldestAt == 0) {
            return n2;
        }
        int n3 = n2 + this.oldestAt;
        if (n3 < this.historyCount) return n3;
        n3 -= this.historyCount;
        return n3;
    }

    public int offsetFromNewest(int n2) {
        return this.wrapOffset(this.newestAt + n2);
    }

    public int offsetFromOldest(int n2) {
        return this.wrapOffset(this.oldestAt + n2);
    }

    protected int wrapOffset(int n2) {
        int n3 = n2;
        if (n3 >= this.historyCount) {
            return n3 -= this.historyCount;
        }
        if (n3 >= 0) return n3;
        n3 += this.historyCount;
        return n3;
    }

    public synchronized RegularTimePeriod advanceTime() {
        RegularTimePeriod regularTimePeriod = this.pointsInTime[this.newestAt].next();
        this.newestAt = this.oldestAt;
        boolean bl2 = false;
        float f2 = 0.0f;
        if (this.maxValue != null) {
            f2 = this.maxValue.floatValue();
        }
        for (int i2 = 0; i2 < this.getSeriesCount(); ++i2) {
            if (this.valueHistory[i2].getData(this.oldestAt) == f2) {
                bl2 = true;
            }
            if (bl2) break;
        }
        if (bl2) {
            this.invalidateRangeInfo();
        }
        float f3 = 0.0f;
        for (int i3 = 0; i3 < this.getSeriesCount(); ++i3) {
            this.valueHistory[i3].enterData(this.newestAt, f3);
        }
        this.pointsInTime[this.newestAt] = regularTimePeriod;
        ++this.oldestAt;
        if (this.oldestAt >= this.historyCount) {
            this.oldestAt = 0;
        }
        long l2 = this.domainStart;
        this.domainStart = new Long(l2 + this.deltaTime);
        long l3 = this.domainEnd;
        this.domainEnd = new Long(l3 + this.deltaTime);
        this.domainRange = new Range(l2, l3);
        this.fireSeriesChanged();
        return regularTimePeriod;
    }

    public void invalidateRangeInfo() {
        this.maxValue = null;
        this.valueRange = null;
    }

    protected double findMaxValue() {
        double d2 = 0.0;
        int n2 = 0;
        while (n2 < this.getSeriesCount()) {
            for (int i2 = 0; i2 < this.historyCount; ++i2) {
                double d3 = this.getYValue(n2, i2);
                if (d3 <= d2) continue;
                d2 = d3;
            }
            ++n2;
        }
        return d2;
    }

    public int getOldestIndex() {
        return this.oldestAt;
    }

    public int getNewestIndex() {
        return this.newestAt;
    }

    public void appendData(float[] arrf) {
        int n2 = arrf.length;
        if (n2 > this.valueHistory.length) {
            throw new IllegalArgumentException("More data than series to put them in");
        }
        int n3 = 0;
        do {
            if (n3 >= n2) {
                this.fireSeriesChanged();
                return;
            }
            if (this.valueHistory[n3] == null) {
                this.valueHistory[n3] = new DynamicTimeSeriesCollection$ValueSequence(this, this.historyCount);
            }
            this.valueHistory[n3].enterData(this.newestAt, arrf[n3]);
            ++n3;
        } while (true);
    }

    public void appendData(float[] arrf, int n2, int n3) {
        int n4 = arrf.length;
        if (n4 > this.valueHistory.length) {
            throw new IllegalArgumentException("More data than series to put them in");
        }
        int n5 = 0;
        do {
            if (n5 >= n4) {
                if (n3 <= 0) return;
                if (++n2 % n3 != 0) return;
                this.fireSeriesChanged();
                return;
            }
            if (this.valueHistory[n5] == null) {
                this.valueHistory[n5] = new DynamicTimeSeriesCollection$ValueSequence(this, this.historyCount);
            }
            this.valueHistory[n5].enterData(n2, arrf[n5]);
            ++n5;
        } while (true);
    }

    public RegularTimePeriod getNewestTime() {
        return this.pointsInTime[this.newestAt];
    }

    public RegularTimePeriod getOldestTime() {
        return this.pointsInTime[this.oldestAt];
    }

    @Override
    public Number getX(int n2, int n3) {
        RegularTimePeriod regularTimePeriod = this.pointsInTime[this.translateGet(n3)];
        return new Long(this.getX(regularTimePeriod));
    }

    @Override
    public double getYValue(int n2, int n3) {
        DynamicTimeSeriesCollection$ValueSequence dynamicTimeSeriesCollection$ValueSequence = this.valueHistory[n2];
        return dynamicTimeSeriesCollection$ValueSequence.getData(this.translateGet(n3));
    }

    @Override
    public Number getY(int n2, int n3) {
        return new Float(this.getYValue(n2, n3));
    }

    @Override
    public Number getStartX(int n2, int n3) {
        RegularTimePeriod regularTimePeriod = this.pointsInTime[this.translateGet(n3)];
        return new Long(regularTimePeriod.getFirstMillisecond(this.workingCalendar));
    }

    @Override
    public Number getEndX(int n2, int n3) {
        RegularTimePeriod regularTimePeriod = this.pointsInTime[this.translateGet(n3)];
        return new Long(regularTimePeriod.getLastMillisecond(this.workingCalendar));
    }

    @Override
    public Number getStartY(int n2, int n3) {
        return this.getY(n2, n3);
    }

    @Override
    public Number getEndY(int n2, int n3) {
        return this.getY(n2, n3);
    }

    @Override
    public Comparable getSeriesKey(int n2) {
        return this.seriesKeys[n2];
    }

    protected void fireSeriesChanged() {
        this.seriesChanged(new SeriesChangeEvent(this));
    }

    @Override
    public double getDomainLowerBound(boolean bl2) {
        return this.domainStart.doubleValue();
    }

    @Override
    public double getDomainUpperBound(boolean bl2) {
        return this.domainEnd.doubleValue();
    }

    @Override
    public Range getDomainBounds(boolean bl2) {
        if (this.domainRange != null) return this.domainRange;
        this.findDomainLimits();
        return this.domainRange;
    }

    private long getX(RegularTimePeriod regularTimePeriod) {
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
        }
        return regularTimePeriod.getMiddleMillisecond(this.workingCalendar);
    }

    @Override
    public double getRangeLowerBound(boolean bl2) {
        double d2 = Double.NaN;
        if (this.minValue == null) return d2;
        return this.minValue.doubleValue();
    }

    @Override
    public double getRangeUpperBound(boolean bl2) {
        double d2 = Double.NaN;
        if (this.maxValue == null) return d2;
        return this.maxValue.doubleValue();
    }

    @Override
    public Range getRangeBounds(boolean bl2) {
        if (this.valueRange != null) return this.valueRange;
        double d2 = this.getRangeUpperBound(bl2);
        this.valueRange = new Range(0.0, d2);
        return this.valueRange;
    }

    static Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException var1_1) {
            throw new NoClassDefFoundError(var1_1.getMessage());
        }
    }

    static int access$000(DynamicTimeSeriesCollection dynamicTimeSeriesCollection) {
        return dynamicTimeSeriesCollection.maximumItemCount;
    }
}

