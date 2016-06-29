package org.jfree.chart.axis;

import java.io.*;
import java.util.*;

public class SegmentedTimeline$Segment implements Serializable, Cloneable, Comparable
{
    protected long segmentNumber;
    protected long segmentStart;
    protected long segmentEnd;
    protected long millisecond;
    private final SegmentedTimeline this$0;
    
    protected SegmentedTimeline$Segment(final SegmentedTimeline this$0) {
        this.this$0 = this$0;
    }
    
    protected SegmentedTimeline$Segment(final SegmentedTimeline this$0, final long millisecond) {
        this.this$0 = this$0;
        this.segmentNumber = this.calculateSegmentNumber(millisecond);
        this.segmentStart = SegmentedTimeline.access$000(this$0) + this.segmentNumber * SegmentedTimeline.access$100(this$0);
        this.segmentEnd = this.segmentStart + SegmentedTimeline.access$100(this$0) - 1L;
        this.millisecond = millisecond;
    }
    
    public long calculateSegmentNumber(final long n) {
        if (n >= SegmentedTimeline.access$000(this.this$0)) {
            return (n - SegmentedTimeline.access$000(this.this$0)) / SegmentedTimeline.access$100(this.this$0);
        }
        return (n - SegmentedTimeline.access$000(this.this$0)) / SegmentedTimeline.access$100(this.this$0) - 1L;
    }
    
    public long getSegmentNumber() {
        return this.segmentNumber;
    }
    
    public long getSegmentCount() {
        return 1L;
    }
    
    public long getSegmentStart() {
        return this.segmentStart;
    }
    
    public long getSegmentEnd() {
        return this.segmentEnd;
    }
    
    public long getMillisecond() {
        return this.millisecond;
    }
    
    public Date getDate() {
        return this.this$0.getDate(this.millisecond);
    }
    
    public boolean contains(final long n) {
        return this.segmentStart <= n && n <= this.segmentEnd;
    }
    
    public boolean contains(final long n, final long n2) {
        return this.segmentStart <= n && n2 <= this.segmentEnd;
    }
    
    public boolean contains(final SegmentedTimeline$Segment segmentedTimeline$Segment) {
        return this.contains(segmentedTimeline$Segment.getSegmentStart(), segmentedTimeline$Segment.getSegmentEnd());
    }
    
    public boolean contained(final long n, final long n2) {
        return n <= this.segmentStart && this.segmentEnd <= n2;
    }
    
    public SegmentedTimeline$Segment intersect(final long n, final long n2) {
        if (n <= this.segmentStart && this.segmentEnd <= n2) {
            return this;
        }
        return null;
    }
    
    public boolean before(final SegmentedTimeline$Segment segmentedTimeline$Segment) {
        return this.segmentEnd < segmentedTimeline$Segment.getSegmentStart();
    }
    
    public boolean after(final SegmentedTimeline$Segment segmentedTimeline$Segment) {
        return this.segmentStart > segmentedTimeline$Segment.getSegmentEnd();
    }
    
    public boolean equals(final Object o) {
        if (o instanceof SegmentedTimeline$Segment) {
            final SegmentedTimeline$Segment segmentedTimeline$Segment = (SegmentedTimeline$Segment)o;
            return this.segmentNumber == segmentedTimeline$Segment.getSegmentNumber() && this.segmentStart == segmentedTimeline$Segment.getSegmentStart() && this.segmentEnd == segmentedTimeline$Segment.getSegmentEnd() && this.millisecond == segmentedTimeline$Segment.getMillisecond();
        }
        return false;
    }
    
    public SegmentedTimeline$Segment copy() {
        try {
            return (SegmentedTimeline$Segment)this.clone();
        }
        catch (CloneNotSupportedException ex) {
            return null;
        }
    }
    
    public int compareTo(final Object o) {
        final SegmentedTimeline$Segment segmentedTimeline$Segment = (SegmentedTimeline$Segment)o;
        if (this.before(segmentedTimeline$Segment)) {
            return -1;
        }
        if (this.after(segmentedTimeline$Segment)) {
            return 1;
        }
        return 0;
    }
    
    public boolean inIncludeSegments() {
        return this.getSegmentNumberRelativeToGroup() < SegmentedTimeline.access$200(this.this$0) && !this.inExceptionSegments();
    }
    
    public boolean inExcludeSegments() {
        return this.getSegmentNumberRelativeToGroup() >= SegmentedTimeline.access$200(this.this$0);
    }
    
    private long getSegmentNumberRelativeToGroup() {
        long n = this.segmentNumber % SegmentedTimeline.access$300(this.this$0);
        if (n < 0L) {
            n += SegmentedTimeline.access$300(this.this$0);
        }
        return n;
    }
    
    public boolean inExceptionSegments() {
        return SegmentedTimeline.access$400(this.this$0, this) >= 0;
    }
    
    public void inc(final long n) {
        this.segmentNumber += n;
        final long n2 = n * SegmentedTimeline.access$100(this.this$0);
        this.segmentStart += n2;
        this.segmentEnd += n2;
        this.millisecond += n2;
    }
    
    public void inc() {
        this.inc(1L);
    }
    
    public void dec(final long n) {
        this.segmentNumber -= n;
        final long n2 = n * SegmentedTimeline.access$100(this.this$0);
        this.segmentStart -= n2;
        this.segmentEnd -= n2;
        this.millisecond -= n2;
    }
    
    public void dec() {
        this.dec(1L);
    }
    
    public void moveIndexToStart() {
        this.millisecond = this.segmentStart;
    }
    
    public void moveIndexToEnd() {
        this.millisecond = this.segmentEnd;
    }
}
