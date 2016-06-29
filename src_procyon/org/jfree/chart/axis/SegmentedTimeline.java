package org.jfree.chart.axis;

import java.io.*;
import java.util.*;

public class SegmentedTimeline implements Serializable, Cloneable, Timeline
{
    private static final long serialVersionUID = 1093779862539903110L;
    public static final long DAY_SEGMENT_SIZE = 86400000L;
    public static final long HOUR_SEGMENT_SIZE = 3600000L;
    public static final long FIFTEEN_MINUTE_SEGMENT_SIZE = 900000L;
    public static final long MINUTE_SEGMENT_SIZE = 60000L;
    public static long FIRST_MONDAY_AFTER_1900;
    public static TimeZone NO_DST_TIME_ZONE;
    public static TimeZone DEFAULT_TIME_ZONE;
    private Calendar workingCalendarNoDST;
    private Calendar workingCalendar;
    private long segmentSize;
    private int segmentsIncluded;
    private int segmentsExcluded;
    private int groupSegmentCount;
    private long startTime;
    private long segmentsIncludedSize;
    private long segmentsExcludedSize;
    private long segmentsGroupSize;
    private List exceptionSegments;
    private SegmentedTimeline baseTimeline;
    private boolean adjustForDaylightSaving;
    
    public SegmentedTimeline(final long segmentSize, final int segmentsIncluded, final int segmentsExcluded) {
        this.workingCalendarNoDST = new GregorianCalendar(SegmentedTimeline.NO_DST_TIME_ZONE);
        this.workingCalendar = Calendar.getInstance();
        this.exceptionSegments = new ArrayList();
        this.adjustForDaylightSaving = false;
        this.segmentSize = segmentSize;
        this.segmentsIncluded = segmentsIncluded;
        this.segmentsExcluded = segmentsExcluded;
        this.groupSegmentCount = this.segmentsIncluded + this.segmentsExcluded;
        this.segmentsIncludedSize = this.segmentsIncluded * this.segmentSize;
        this.segmentsExcludedSize = this.segmentsExcluded * this.segmentSize;
        this.segmentsGroupSize = this.segmentsIncludedSize + this.segmentsExcludedSize;
    }
    
    public static SegmentedTimeline newMondayThroughFridayTimeline() {
        final SegmentedTimeline segmentedTimeline = new SegmentedTimeline(86400000L, 5, 2);
        segmentedTimeline.setStartTime(SegmentedTimeline.FIRST_MONDAY_AFTER_1900);
        return segmentedTimeline;
    }
    
    public static SegmentedTimeline newFifteenMinuteTimeline() {
        final SegmentedTimeline segmentedTimeline = new SegmentedTimeline(900000L, 28, 68);
        segmentedTimeline.setStartTime(SegmentedTimeline.FIRST_MONDAY_AFTER_1900 + 36L * segmentedTimeline.getSegmentSize());
        segmentedTimeline.setBaseTimeline(newMondayThroughFridayTimeline());
        return segmentedTimeline;
    }
    
    public boolean getAdjustForDaylightSaving() {
        return this.adjustForDaylightSaving;
    }
    
    public void setAdjustForDaylightSaving(final boolean adjustForDaylightSaving) {
        this.adjustForDaylightSaving = adjustForDaylightSaving;
    }
    
    public void setStartTime(final long startTime) {
        this.startTime = startTime;
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
        return Collections.unmodifiableList((List<?>)this.exceptionSegments);
    }
    
    public void setExceptionSegments(final List exceptionSegments) {
        this.exceptionSegments = exceptionSegments;
    }
    
    public SegmentedTimeline getBaseTimeline() {
        return this.baseTimeline;
    }
    
    public void setBaseTimeline(final SegmentedTimeline baseTimeline) {
        if (baseTimeline != null) {
            if (baseTimeline.getSegmentSize() < this.segmentSize) {
                throw new IllegalArgumentException("baseTimeline.getSegmentSize() is smaller than segmentSize");
            }
            if (baseTimeline.getStartTime() > this.startTime) {
                throw new IllegalArgumentException("baseTimeline.getStartTime() is after startTime");
            }
            if (baseTimeline.getSegmentSize() % this.segmentSize != 0L) {
                throw new IllegalArgumentException("baseTimeline.getSegmentSize() is not multiple of segmentSize");
            }
            if ((this.startTime - baseTimeline.getStartTime()) % this.segmentSize != 0L) {
                throw new IllegalArgumentException("baseTimeline is not aligned");
            }
        }
        this.baseTimeline = baseTimeline;
    }
    
    public long toTimelineValue(long n) {
        final long n2 = n - this.startTime;
        final long n3 = n2 % this.segmentsGroupSize;
        final long n4 = n2 / this.segmentsGroupSize;
        long n5;
        if (n3 >= this.segmentsIncludedSize) {
            n5 = this.toTimelineValue(this.startTime + this.segmentsGroupSize * (n4 + 1L));
        }
        else {
            SegmentedTimeline$Segment segmentedTimeline$Segment = this.getSegment(n);
            if (segmentedTimeline$Segment.inExceptionSegments()) {
                do {
                    segmentedTimeline$Segment = this.getSegment(n = segmentedTimeline$Segment.getSegmentEnd() + 1L);
                } while (segmentedTimeline$Segment.inExceptionSegments());
                n5 = this.toTimelineValue(n);
            }
            else {
                final long n6 = n - this.startTime;
                final long n7 = n6 % this.segmentsGroupSize;
                final long n8 = n6 / this.segmentsGroupSize;
                final long exceptionSegmentCount = this.getExceptionSegmentCount(this.startTime, n - 1L);
                if (n7 < this.segmentsIncludedSize) {
                    n5 = this.segmentsIncludedSize * n8 + n7 - exceptionSegmentCount * this.segmentSize;
                }
                else {
                    n5 = this.segmentsIncludedSize * (n8 + 1L) - exceptionSegmentCount * this.segmentSize;
                }
            }
        }
        return n5;
    }
    
    public long toTimelineValue(final Date date) {
        return this.toTimelineValue(this.getTime(date));
    }
    
    public long toMillisecond(final long n) {
        final SegmentedTimeline$Segment segmentedTimeline$Segment = new SegmentedTimeline$Segment(this, this.startTime + n + n / this.segmentsIncludedSize * this.segmentsExcludedSize);
        long segmentStart;
        for (long n2 = this.startTime; n2 <= segmentedTimeline$Segment.segmentStart; n2 = segmentStart + 1L) {
            long exceptionSegmentCount;
            while ((exceptionSegmentCount = this.getExceptionSegmentCount(n2, segmentedTimeline$Segment.millisecond / this.segmentSize * this.segmentSize - 1L)) > 0L) {
                n2 = segmentedTimeline$Segment.segmentStart;
                for (int n3 = 0; n3 < exceptionSegmentCount; ++n3) {
                    do {
                        segmentedTimeline$Segment.inc();
                    } while (segmentedTimeline$Segment.inExcludeSegments());
                }
            }
            segmentStart = segmentedTimeline$Segment.segmentStart;
            while (segmentedTimeline$Segment.inExceptionSegments() || segmentedTimeline$Segment.inExcludeSegments()) {
                segmentedTimeline$Segment.inc();
                segmentStart += this.segmentSize;
            }
        }
        return this.getTimeFromLong(segmentedTimeline$Segment.millisecond);
    }
    
    public long getTimeFromLong(final long n) {
        long time = n;
        if (this.adjustForDaylightSaving) {
            this.workingCalendarNoDST.setTime(new Date(n));
            this.workingCalendar.set(this.workingCalendarNoDST.get(1), this.workingCalendarNoDST.get(2), this.workingCalendarNoDST.get(5), this.workingCalendarNoDST.get(11), this.workingCalendarNoDST.get(12), this.workingCalendarNoDST.get(13));
            this.workingCalendar.set(14, this.workingCalendarNoDST.get(14));
            time = this.workingCalendar.getTime().getTime();
        }
        return time;
    }
    
    public boolean containsDomainValue(final long n) {
        return this.getSegment(n).inIncludeSegments();
    }
    
    public boolean containsDomainValue(final Date date) {
        return this.containsDomainValue(this.getTime(date));
    }
    
    public boolean containsDomainRange(final long n, final long n2) {
        if (n2 < n) {
            throw new IllegalArgumentException("domainValueEnd (" + n2 + ") < domainValueStart (" + n + ")");
        }
        final SegmentedTimeline$Segment segment = this.getSegment(n);
        boolean inIncludeSegments;
        do {
            inIncludeSegments = segment.inIncludeSegments();
            if (segment.contains(n2)) {
                break;
            }
            segment.inc();
        } while (inIncludeSegments);
        return inIncludeSegments;
    }
    
    public boolean containsDomainRange(final Date date, final Date date2) {
        return this.containsDomainRange(this.getTime(date), this.getTime(date2));
    }
    
    public void addException(final long n) {
        this.addException(new SegmentedTimeline$Segment(this, n));
    }
    
    public void addException(final long n, final long n2) {
        this.addException(new SegmentedTimeline$SegmentRange(this, n, n2));
    }
    
    public void addException(final Date date) {
        this.addException(this.getTime(date));
    }
    
    public void addExceptions(final List list) {
        final Iterator<Date> iterator = list.iterator();
        while (iterator.hasNext()) {
            this.addException(iterator.next());
        }
    }
    
    private void addException(final SegmentedTimeline$Segment segmentedTimeline$Segment) {
        if (segmentedTimeline$Segment.inIncludeSegments()) {
            this.exceptionSegments.add(-(this.binarySearchExceptionSegments(segmentedTimeline$Segment) + 1), segmentedTimeline$Segment);
        }
    }
    
    public void addBaseTimelineException(final long n) {
        final SegmentedTimeline$Segment segment = this.baseTimeline.getSegment(n);
        if (segment.inIncludeSegments()) {
            final SegmentedTimeline$Segment segment2 = this.getSegment(segment.getSegmentStart());
            while (segment2.getSegmentStart() <= segment.getSegmentEnd()) {
                if (segment2.inIncludeSegments()) {
                    final long segmentStart = segment2.getSegmentStart();
                    long segmentEnd;
                    do {
                        segmentEnd = segment2.getSegmentEnd();
                        segment2.inc();
                    } while (segment2.inIncludeSegments());
                    this.addException(segmentStart, segmentEnd);
                }
                else {
                    segment2.inc();
                }
            }
        }
    }
    
    public void addBaseTimelineException(final Date date) {
        this.addBaseTimelineException(this.getTime(date));
    }
    
    public void addBaseTimelineExclusions(final long n, final long n2) {
        final SegmentedTimeline$Segment segment = this.baseTimeline.getSegment(n);
        while (segment.getSegmentStart() <= n2 && !segment.inExcludeSegments()) {
            segment.inc();
        }
        while (segment.getSegmentStart() <= n2) {
            final long n3 = segment.getSegmentStart() + this.baseTimeline.getSegmentsExcluded() * this.baseTimeline.getSegmentSize() - 1L;
            final SegmentedTimeline$Segment segment2 = this.getSegment(segment.getSegmentStart());
            while (segment2.getSegmentStart() <= n3) {
                if (segment2.inIncludeSegments()) {
                    final long segmentStart = segment2.getSegmentStart();
                    long segmentEnd;
                    do {
                        segmentEnd = segment2.getSegmentEnd();
                        segment2.inc();
                    } while (segment2.inIncludeSegments());
                    this.addException(new SegmentedTimeline$BaseTimelineSegmentRange(this, segmentStart, segmentEnd));
                }
                else {
                    segment2.inc();
                }
            }
            segment.inc(this.baseTimeline.getGroupSegmentCount());
        }
    }
    
    public long getExceptionSegmentCount(final long n, final long n2) {
        if (n2 < n) {
            return 0L;
        }
        int n3 = 0;
        final Iterator<SegmentedTimeline$Segment> iterator = this.exceptionSegments.iterator();
        while (iterator.hasNext()) {
            final SegmentedTimeline$Segment intersect = iterator.next().intersect(n, n2);
            if (intersect != null) {
                n3 += (int)intersect.getSegmentCount();
            }
        }
        return n3;
    }
    
    public SegmentedTimeline$Segment getSegment(final long n) {
        return new SegmentedTimeline$Segment(this, n);
    }
    
    public SegmentedTimeline$Segment getSegment(final Date date) {
        return this.getSegment(this.getTime(date));
    }
    
    private boolean equals(final Object o, final Object o2) {
        return o == o2 || (o != null && o.equals(o2));
    }
    
    public boolean equals(final Object o) {
        if (o instanceof SegmentedTimeline) {
            final SegmentedTimeline segmentedTimeline = (SegmentedTimeline)o;
            final boolean b = this.segmentSize == segmentedTimeline.getSegmentSize();
            final boolean b2 = this.segmentsIncluded == segmentedTimeline.getSegmentsIncluded();
            final boolean b3 = this.segmentsExcluded == segmentedTimeline.getSegmentsExcluded();
            final boolean b4 = this.startTime == segmentedTimeline.getStartTime();
            final boolean equals = this.equals(this.exceptionSegments, segmentedTimeline.getExceptionSegments());
            return b && b2 && b3 && b4 && equals;
        }
        return false;
    }
    
    public int hashCode() {
        return 37 * (37 * 19 + (int)(this.segmentSize ^ this.segmentSize >>> 32)) + (int)(this.startTime ^ this.startTime >>> 32);
    }
    
    private int binarySearchExceptionSegments(final SegmentedTimeline$Segment segmentedTimeline$Segment) {
        int i = 0;
        int n = this.exceptionSegments.size() - 1;
        while (i <= n) {
            final int n2 = (i + n) / 2;
            final SegmentedTimeline$Segment segmentedTimeline$Segment2 = this.exceptionSegments.get(n2);
            if (segmentedTimeline$Segment.contains(segmentedTimeline$Segment2) || segmentedTimeline$Segment2.contains(segmentedTimeline$Segment)) {
                return n2;
            }
            if (segmentedTimeline$Segment2.before(segmentedTimeline$Segment)) {
                i = n2 + 1;
            }
            else {
                if (!segmentedTimeline$Segment2.after(segmentedTimeline$Segment)) {
                    throw new IllegalStateException("Invalid condition.");
                }
                n = n2 - 1;
            }
        }
        return -(i + 1);
    }
    
    public long getTime(final Date time) {
        long n = time.getTime();
        if (this.adjustForDaylightSaving) {
            this.workingCalendar.setTime(time);
            this.workingCalendarNoDST.set(this.workingCalendar.get(1), this.workingCalendar.get(2), this.workingCalendar.get(5), this.workingCalendar.get(11), this.workingCalendar.get(12), this.workingCalendar.get(13));
            this.workingCalendarNoDST.set(14, this.workingCalendar.get(14));
            n = this.workingCalendarNoDST.getTime().getTime();
        }
        return n;
    }
    
    public Date getDate(final long n) {
        this.workingCalendarNoDST.setTime(new Date(n));
        return this.workingCalendarNoDST.getTime();
    }
    
    public Object clone() {
        return super.clone();
    }
    
    static long access$000(final SegmentedTimeline segmentedTimeline) {
        return segmentedTimeline.startTime;
    }
    
    static long access$100(final SegmentedTimeline segmentedTimeline) {
        return segmentedTimeline.segmentSize;
    }
    
    static int access$200(final SegmentedTimeline segmentedTimeline) {
        return segmentedTimeline.segmentsIncluded;
    }
    
    static int access$300(final SegmentedTimeline segmentedTimeline) {
        return segmentedTimeline.groupSegmentCount;
    }
    
    static int access$400(final SegmentedTimeline segmentedTimeline, final SegmentedTimeline$Segment segmentedTimeline$Segment) {
        return segmentedTimeline.binarySearchExceptionSegments(segmentedTimeline$Segment);
    }
    
    static {
        SegmentedTimeline.DEFAULT_TIME_ZONE = TimeZone.getDefault();
        final int rawOffset = TimeZone.getDefault().getRawOffset();
        SegmentedTimeline.NO_DST_TIME_ZONE = new SimpleTimeZone(rawOffset, "UTC-" + rawOffset);
        final GregorianCalendar gregorianCalendar = new GregorianCalendar(SegmentedTimeline.NO_DST_TIME_ZONE);
        gregorianCalendar.set(1900, 0, 1, 0, 0, 0);
        gregorianCalendar.set(14, 0);
        while (gregorianCalendar.get(7) != 2) {
            gregorianCalendar.add(5, 1);
        }
        SegmentedTimeline.FIRST_MONDAY_AFTER_1900 = gregorianCalendar.getTime().getTime();
    }
}
