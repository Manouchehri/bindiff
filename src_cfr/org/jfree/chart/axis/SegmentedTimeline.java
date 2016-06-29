/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.axis;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.SimpleTimeZone;
import java.util.TimeZone;
import org.jfree.chart.axis.SegmentedTimeline$BaseTimelineSegmentRange;
import org.jfree.chart.axis.SegmentedTimeline$Segment;
import org.jfree.chart.axis.SegmentedTimeline$SegmentRange;
import org.jfree.chart.axis.Timeline;

public class SegmentedTimeline
implements Serializable,
Cloneable,
Timeline {
    private static final long serialVersionUID = 1093779862539903110L;
    public static final long DAY_SEGMENT_SIZE = 86400000;
    public static final long HOUR_SEGMENT_SIZE = 3600000;
    public static final long FIFTEEN_MINUTE_SEGMENT_SIZE = 900000;
    public static final long MINUTE_SEGMENT_SIZE = 60000;
    public static long FIRST_MONDAY_AFTER_1900;
    public static TimeZone NO_DST_TIME_ZONE;
    public static TimeZone DEFAULT_TIME_ZONE;
    private Calendar workingCalendarNoDST = new GregorianCalendar(NO_DST_TIME_ZONE);
    private Calendar workingCalendar = Calendar.getInstance();
    private long segmentSize;
    private int segmentsIncluded;
    private int segmentsExcluded;
    private int groupSegmentCount;
    private long startTime;
    private long segmentsIncludedSize;
    private long segmentsExcludedSize;
    private long segmentsGroupSize;
    private List exceptionSegments = new ArrayList();
    private SegmentedTimeline baseTimeline;
    private boolean adjustForDaylightSaving = false;

    public SegmentedTimeline(long l2, int n2, int n3) {
        this.segmentSize = l2;
        this.segmentsIncluded = n2;
        this.segmentsExcluded = n3;
        this.groupSegmentCount = this.segmentsIncluded + this.segmentsExcluded;
        this.segmentsIncludedSize = (long)this.segmentsIncluded * this.segmentSize;
        this.segmentsExcludedSize = (long)this.segmentsExcluded * this.segmentSize;
        this.segmentsGroupSize = this.segmentsIncludedSize + this.segmentsExcludedSize;
    }

    public static SegmentedTimeline newMondayThroughFridayTimeline() {
        SegmentedTimeline segmentedTimeline = new SegmentedTimeline(86400000, 5, 2);
        segmentedTimeline.setStartTime(FIRST_MONDAY_AFTER_1900);
        return segmentedTimeline;
    }

    public static SegmentedTimeline newFifteenMinuteTimeline() {
        SegmentedTimeline segmentedTimeline = new SegmentedTimeline(900000, 28, 68);
        segmentedTimeline.setStartTime(FIRST_MONDAY_AFTER_1900 + 36 * segmentedTimeline.getSegmentSize());
        segmentedTimeline.setBaseTimeline(SegmentedTimeline.newMondayThroughFridayTimeline());
        return segmentedTimeline;
    }

    public boolean getAdjustForDaylightSaving() {
        return this.adjustForDaylightSaving;
    }

    public void setAdjustForDaylightSaving(boolean bl2) {
        this.adjustForDaylightSaving = bl2;
    }

    public void setStartTime(long l2) {
        this.startTime = l2;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public int getSegmentsExcluded() {
        return this.segmentsExcluded;
    }

    public long getSegmentsExcludedSize() {
        return this.segmentsExcludedSize;
    }

    public int getGroupSegmentCount() {
        return this.groupSegmentCount;
    }

    public long getSegmentsGroupSize() {
        return this.segmentsGroupSize;
    }

    public int getSegmentsIncluded() {
        return this.segmentsIncluded;
    }

    public long getSegmentsIncludedSize() {
        return this.segmentsIncludedSize;
    }

    public long getSegmentSize() {
        return this.segmentSize;
    }

    public List getExceptionSegments() {
        return Collections.unmodifiableList(this.exceptionSegments);
    }

    public void setExceptionSegments(List list) {
        this.exceptionSegments = list;
    }

    public SegmentedTimeline getBaseTimeline() {
        return this.baseTimeline;
    }

    public void setBaseTimeline(SegmentedTimeline segmentedTimeline) {
        if (segmentedTimeline != null) {
            if (segmentedTimeline.getSegmentSize() < this.segmentSize) {
                throw new IllegalArgumentException("baseTimeline.getSegmentSize() is smaller than segmentSize");
            }
            if (segmentedTimeline.getStartTime() > this.startTime) {
                throw new IllegalArgumentException("baseTimeline.getStartTime() is after startTime");
            }
            if (segmentedTimeline.getSegmentSize() % this.segmentSize != 0) {
                throw new IllegalArgumentException("baseTimeline.getSegmentSize() is not multiple of segmentSize");
            }
            if ((this.startTime - segmentedTimeline.getStartTime()) % this.segmentSize != 0) {
                throw new IllegalArgumentException("baseTimeline is not aligned");
            }
        }
        this.baseTimeline = segmentedTimeline;
    }

    @Override
    public long toTimelineValue(long l2) {
        long l3 = l2 - this.startTime;
        long l4 = l3 % this.segmentsGroupSize;
        long l5 = l3 / this.segmentsGroupSize;
        if (l4 >= this.segmentsIncludedSize) {
            return this.toTimelineValue(this.startTime + this.segmentsGroupSize * (l5 + 1));
        }
        SegmentedTimeline$Segment segmentedTimeline$Segment = this.getSegment(l2);
        if (segmentedTimeline$Segment.inExceptionSegments()) {
            do {
                l2 = segmentedTimeline$Segment.getSegmentEnd() + 1;
            } while ((segmentedTimeline$Segment = this.getSegment(l2)).inExceptionSegments());
            return this.toTimelineValue(l2);
        }
        long l6 = l2 - this.startTime;
        long l7 = l6 % this.segmentsGroupSize;
        long l8 = l6 / this.segmentsGroupSize;
        long l9 = this.getExceptionSegmentCount(this.startTime, l2 - 1);
        if (l7 >= this.segmentsIncludedSize) return this.segmentsIncludedSize * (l8 + 1) - l9 * this.segmentSize;
        return this.segmentsIncludedSize * l8 + l7 - l9 * this.segmentSize;
    }

    @Override
    public long toTimelineValue(Date date) {
        return this.toTimelineValue(this.getTime(date));
    }

    @Override
    public long toMillisecond(long l2) {
        SegmentedTimeline$Segment segmentedTimeline$Segment = new SegmentedTimeline$Segment(this, this.startTime + l2 + l2 / this.segmentsIncludedSize * this.segmentsExcludedSize);
        long l3 = this.startTime;
        while (l3 <= segmentedTimeline$Segment.segmentStart) {
            long l4;
            while ((l4 = this.getExceptionSegmentCount(l3, segmentedTimeline$Segment.millisecond / this.segmentSize * this.segmentSize - 1)) > 0) {
                l3 = segmentedTimeline$Segment.segmentStart;
                int n2 = 0;
                while ((long)n2 < l4) {
                    do {
                        segmentedTimeline$Segment.inc();
                    } while (segmentedTimeline$Segment.inExcludeSegments());
                    ++n2;
                }
            }
            l3 = segmentedTimeline$Segment.segmentStart;
            while (segmentedTimeline$Segment.inExceptionSegments() || segmentedTimeline$Segment.inExcludeSegments()) {
                segmentedTimeline$Segment.inc();
                l3 += this.segmentSize;
            }
            ++l3;
        }
        return this.getTimeFromLong(segmentedTimeline$Segment.millisecond);
    }

    public long getTimeFromLong(long l2) {
        long l3 = l2;
        if (!this.adjustForDaylightSaving) return l3;
        this.workingCalendarNoDST.setTime(new Date(l2));
        this.workingCalendar.set(this.workingCalendarNoDST.get(1), this.workingCalendarNoDST.get(2), this.workingCalendarNoDST.get(5), this.workingCalendarNoDST.get(11), this.workingCalendarNoDST.get(12), this.workingCalendarNoDST.get(13));
        this.workingCalendar.set(14, this.workingCalendarNoDST.get(14));
        return this.workingCalendar.getTime().getTime();
    }

    @Override
    public boolean containsDomainValue(long l2) {
        SegmentedTimeline$Segment segmentedTimeline$Segment = this.getSegment(l2);
        return segmentedTimeline$Segment.inIncludeSegments();
    }

    @Override
    public boolean containsDomainValue(Date date) {
        return this.containsDomainValue(this.getTime(date));
    }

    @Override
    public boolean containsDomainRange(long l2, long l3) {
        if (l3 < l2) {
            throw new IllegalArgumentException(new StringBuffer().append("domainValueEnd (").append(l3).append(") < domainValueStart (").append(l2).append(")").toString());
        }
        SegmentedTimeline$Segment segmentedTimeline$Segment = this.getSegment(l2);
        boolean bl2 = true;
        do {
            bl2 = segmentedTimeline$Segment.inIncludeSegments();
            if (segmentedTimeline$Segment.contains(l3)) {
                return bl2;
            }
            segmentedTimeline$Segment.inc();
        } while (bl2);
        return bl2;
    }

    @Override
    public boolean containsDomainRange(Date date, Date date2) {
        return this.containsDomainRange(this.getTime(date), this.getTime(date2));
    }

    public void addException(long l2) {
        this.addException(new SegmentedTimeline$Segment(this, l2));
    }

    public void addException(long l2, long l3) {
        this.addException(new SegmentedTimeline$SegmentRange(this, l2, l3));
    }

    public void addException(Date date) {
        this.addException(this.getTime(date));
    }

    public void addExceptions(List list) {
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            this.addException((Date)iterator.next());
        }
    }

    private void addException(SegmentedTimeline$Segment segmentedTimeline$Segment) {
        if (!segmentedTimeline$Segment.inIncludeSegments()) return;
        int n2 = this.binarySearchExceptionSegments(segmentedTimeline$Segment);
        this.exceptionSegments.add(- n2 + 1, segmentedTimeline$Segment);
    }

    public void addBaseTimelineException(long l2) {
        SegmentedTimeline$Segment segmentedTimeline$Segment = this.baseTimeline.getSegment(l2);
        if (!segmentedTimeline$Segment.inIncludeSegments()) return;
        SegmentedTimeline$Segment segmentedTimeline$Segment2 = this.getSegment(segmentedTimeline$Segment.getSegmentStart());
        while (segmentedTimeline$Segment2.getSegmentStart() <= segmentedTimeline$Segment.getSegmentEnd()) {
            if (segmentedTimeline$Segment2.inIncludeSegments()) {
                long l3;
                long l4 = segmentedTimeline$Segment2.getSegmentStart();
                do {
                    l3 = segmentedTimeline$Segment2.getSegmentEnd();
                    segmentedTimeline$Segment2.inc();
                } while (segmentedTimeline$Segment2.inIncludeSegments());
                this.addException(l4, l3);
                continue;
            }
            segmentedTimeline$Segment2.inc();
        }
    }

    public void addBaseTimelineException(Date date) {
        this.addBaseTimelineException(this.getTime(date));
    }

    public void addBaseTimelineExclusions(long l2, long l3) {
        SegmentedTimeline$Segment segmentedTimeline$Segment = this.baseTimeline.getSegment(l2);
        while (segmentedTimeline$Segment.getSegmentStart() <= l3 && !segmentedTimeline$Segment.inExcludeSegments()) {
            segmentedTimeline$Segment.inc();
        }
        while (segmentedTimeline$Segment.getSegmentStart() <= l3) {
            long l4 = segmentedTimeline$Segment.getSegmentStart() + (long)this.baseTimeline.getSegmentsExcluded() * this.baseTimeline.getSegmentSize() - 1;
            SegmentedTimeline$Segment segmentedTimeline$Segment2 = this.getSegment(segmentedTimeline$Segment.getSegmentStart());
            while (segmentedTimeline$Segment2.getSegmentStart() <= l4) {
                if (segmentedTimeline$Segment2.inIncludeSegments()) {
                    long l5;
                    long l6 = segmentedTimeline$Segment2.getSegmentStart();
                    do {
                        l5 = segmentedTimeline$Segment2.getSegmentEnd();
                        segmentedTimeline$Segment2.inc();
                    } while (segmentedTimeline$Segment2.inIncludeSegments());
                    this.addException(new SegmentedTimeline$BaseTimelineSegmentRange(this, l6, l5));
                    continue;
                }
                segmentedTimeline$Segment2.inc();
            }
            segmentedTimeline$Segment.inc(this.baseTimeline.getGroupSegmentCount());
        }
    }

    public long getExceptionSegmentCount(long l2, long l3) {
        if (l3 < l2) {
            return 0;
        }
        int n2 = 0;
        Iterator iterator = this.exceptionSegments.iterator();
        while (iterator.hasNext()) {
            SegmentedTimeline$Segment segmentedTimeline$Segment = (SegmentedTimeline$Segment)iterator.next();
            SegmentedTimeline$Segment segmentedTimeline$Segment2 = segmentedTimeline$Segment.intersect(l2, l3);
            if (segmentedTimeline$Segment2 == null) continue;
            n2 = (int)((long)n2 + segmentedTimeline$Segment2.getSegmentCount());
        }
        return n2;
    }

    public SegmentedTimeline$Segment getSegment(long l2) {
        return new SegmentedTimeline$Segment(this, l2);
    }

    public SegmentedTimeline$Segment getSegment(Date date) {
        return this.getSegment(this.getTime(date));
    }

    private boolean equals(Object object, Object object2) {
        if (object == object2) return true;
        if (object == null) return false;
        if (!object.equals(object2)) return false;
        return true;
    }

    public boolean equals(Object object) {
        if (!(object instanceof SegmentedTimeline)) return false;
        SegmentedTimeline segmentedTimeline = (SegmentedTimeline)object;
        boolean bl2 = this.segmentSize == segmentedTimeline.getSegmentSize();
        boolean bl3 = this.segmentsIncluded == segmentedTimeline.getSegmentsIncluded();
        boolean bl4 = this.segmentsExcluded == segmentedTimeline.getSegmentsExcluded();
        boolean bl5 = this.startTime == segmentedTimeline.getStartTime();
        boolean bl6 = this.equals(this.exceptionSegments, segmentedTimeline.getExceptionSegments());
        if (!bl2) return false;
        if (!bl3) return false;
        if (!bl4) return false;
        if (!bl5) return false;
        if (!bl6) return false;
        return true;
    }

    public int hashCode() {
        int n2 = 19;
        n2 = 37 * n2 + (int)(this.segmentSize ^ this.segmentSize >>> 32);
        return 37 * n2 + (int)(this.startTime ^ this.startTime >>> 32);
    }

    private int binarySearchExceptionSegments(SegmentedTimeline$Segment segmentedTimeline$Segment) {
        int n2 = 0;
        int n3 = this.exceptionSegments.size() - 1;
        while (n2 <= n3) {
            int n4 = (n2 + n3) / 2;
            SegmentedTimeline$Segment segmentedTimeline$Segment2 = (SegmentedTimeline$Segment)this.exceptionSegments.get(n4);
            if (segmentedTimeline$Segment.contains(segmentedTimeline$Segment2)) return n4;
            if (segmentedTimeline$Segment2.contains(segmentedTimeline$Segment)) {
                return n4;
            }
            if (segmentedTimeline$Segment2.before(segmentedTimeline$Segment)) {
                n2 = n4 + 1;
                continue;
            }
            if (!segmentedTimeline$Segment2.after(segmentedTimeline$Segment)) throw new IllegalStateException("Invalid condition.");
            n3 = n4 - 1;
        }
        return - n2 + 1;
    }

    public long getTime(Date date) {
        long l2 = date.getTime();
        if (!this.adjustForDaylightSaving) return l2;
        this.workingCalendar.setTime(date);
        this.workingCalendarNoDST.set(this.workingCalendar.get(1), this.workingCalendar.get(2), this.workingCalendar.get(5), this.workingCalendar.get(11), this.workingCalendar.get(12), this.workingCalendar.get(13));
        this.workingCalendarNoDST.set(14, this.workingCalendar.get(14));
        Date date2 = this.workingCalendarNoDST.getTime();
        return date2.getTime();
    }

    public Date getDate(long l2) {
        this.workingCalendarNoDST.setTime(new Date(l2));
        return this.workingCalendarNoDST.getTime();
    }

    public Object clone() {
        return (SegmentedTimeline)super.clone();
    }

    static long access$000(SegmentedTimeline segmentedTimeline) {
        return segmentedTimeline.startTime;
    }

    static long access$100(SegmentedTimeline segmentedTimeline) {
        return segmentedTimeline.segmentSize;
    }

    static int access$200(SegmentedTimeline segmentedTimeline) {
        return segmentedTimeline.segmentsIncluded;
    }

    static int access$300(SegmentedTimeline segmentedTimeline) {
        return segmentedTimeline.groupSegmentCount;
    }

    static int access$400(SegmentedTimeline segmentedTimeline, SegmentedTimeline$Segment segmentedTimeline$Segment) {
        return segmentedTimeline.binarySearchExceptionSegments(segmentedTimeline$Segment);
    }

    static {
        DEFAULT_TIME_ZONE = TimeZone.getDefault();
        int n2 = TimeZone.getDefault().getRawOffset();
        NO_DST_TIME_ZONE = new SimpleTimeZone(n2, new StringBuffer().append("UTC-").append(n2).toString());
        GregorianCalendar gregorianCalendar = new GregorianCalendar(NO_DST_TIME_ZONE);
        gregorianCalendar.set(1900, 0, 1, 0, 0, 0);
        gregorianCalendar.set(14, 0);
        do {
            if (gregorianCalendar.get(7) == 2) {
                FIRST_MONDAY_AFTER_1900 = gregorianCalendar.getTime().getTime();
                return;
            }
            gregorianCalendar.add(5, 1);
        } while (true);
    }
}

