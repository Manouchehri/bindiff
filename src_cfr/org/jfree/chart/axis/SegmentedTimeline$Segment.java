/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.axis;

import java.io.Serializable;
import java.util.Date;
import org.jfree.chart.axis.SegmentedTimeline;

public class SegmentedTimeline$Segment
implements Serializable,
Cloneable,
Comparable {
    protected long segmentNumber;
    protected long segmentStart;
    protected long segmentEnd;
    protected long millisecond;
    private final SegmentedTimeline this$0;

    protected SegmentedTimeline$Segment(SegmentedTimeline segmentedTimeline) {
        this.this$0 = segmentedTimeline;
    }

    protected SegmentedTimeline$Segment(SegmentedTimeline segmentedTimeline, long l2) {
        this.this$0 = segmentedTimeline;
        this.segmentNumber = this.calculateSegmentNumber(l2);
        this.segmentStart = SegmentedTimeline.access$000(segmentedTimeline) + this.segmentNumber * SegmentedTimeline.access$100(segmentedTimeline);
        this.segmentEnd = this.segmentStart + SegmentedTimeline.access$100(segmentedTimeline) - 1;
        this.millisecond = l2;
    }

    public long calculateSegmentNumber(long l2) {
        if (l2 < SegmentedTimeline.access$000(this.this$0)) return (l2 - SegmentedTimeline.access$000(this.this$0)) / SegmentedTimeline.access$100(this.this$0) - 1;
        return (l2 - SegmentedTimeline.access$000(this.this$0)) / SegmentedTimeline.access$100(this.this$0);
    }

    public long getSegmentNumber() {
        return this.segmentNumber;
    }

    public long getSegmentCount() {
        return 1;
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

    public boolean contains(long l2) {
        if (this.segmentStart > l2) return false;
        if (l2 > this.segmentEnd) return false;
        return true;
    }

    public boolean contains(long l2, long l3) {
        if (this.segmentStart > l2) return false;
        if (l3 > this.segmentEnd) return false;
        return true;
    }

    public boolean contains(SegmentedTimeline$Segment segmentedTimeline$Segment) {
        return this.contains(segmentedTimeline$Segment.getSegmentStart(), segmentedTimeline$Segment.getSegmentEnd());
    }

    public boolean contained(long l2, long l3) {
        if (l2 > this.segmentStart) return false;
        if (this.segmentEnd > l3) return false;
        return true;
    }

    public SegmentedTimeline$Segment intersect(long l2, long l3) {
        if (l2 > this.segmentStart) return null;
        if (this.segmentEnd > l3) return null;
        return this;
    }

    public boolean before(SegmentedTimeline$Segment segmentedTimeline$Segment) {
        if (this.segmentEnd >= segmentedTimeline$Segment.getSegmentStart()) return false;
        return true;
    }

    public boolean after(SegmentedTimeline$Segment segmentedTimeline$Segment) {
        if (this.segmentStart <= segmentedTimeline$Segment.getSegmentEnd()) return false;
        return true;
    }

    public boolean equals(Object object) {
        if (!(object instanceof SegmentedTimeline$Segment)) return false;
        SegmentedTimeline$Segment segmentedTimeline$Segment = (SegmentedTimeline$Segment)object;
        if (this.segmentNumber != segmentedTimeline$Segment.getSegmentNumber()) return false;
        if (this.segmentStart != segmentedTimeline$Segment.getSegmentStart()) return false;
        if (this.segmentEnd != segmentedTimeline$Segment.getSegmentEnd()) return false;
        if (this.millisecond != segmentedTimeline$Segment.getMillisecond()) return false;
        return true;
    }

    public SegmentedTimeline$Segment copy() {
        try {
            return (SegmentedTimeline$Segment)this.clone();
        }
        catch (CloneNotSupportedException var1_1) {
            return null;
        }
    }

    public int compareTo(Object object) {
        SegmentedTimeline$Segment segmentedTimeline$Segment = (SegmentedTimeline$Segment)object;
        if (this.before(segmentedTimeline$Segment)) {
            return -1;
        }
        if (!this.after(segmentedTimeline$Segment)) return 0;
        return 1;
    }

    public boolean inIncludeSegments() {
        if (this.getSegmentNumberRelativeToGroup() >= (long)SegmentedTimeline.access$200(this.this$0)) return false;
        if (this.inExceptionSegments()) return false;
        return true;
    }

    public boolean inExcludeSegments() {
        if (this.getSegmentNumberRelativeToGroup() < (long)SegmentedTimeline.access$200(this.this$0)) return false;
        return true;
    }

    private long getSegmentNumberRelativeToGroup() {
        long l2 = this.segmentNumber % (long)SegmentedTimeline.access$300(this.this$0);
        if (l2 >= 0) return l2;
        l2 += (long)SegmentedTimeline.access$300(this.this$0);
        return l2;
    }

    public boolean inExceptionSegments() {
        if (SegmentedTimeline.access$400(this.this$0, this) < 0) return false;
        return true;
    }

    public void inc(long l2) {
        this.segmentNumber += l2;
        long l3 = l2 * SegmentedTimeline.access$100(this.this$0);
        this.segmentStart += l3;
        this.segmentEnd += l3;
        this.millisecond += l3;
    }

    public void inc() {
        this.inc(1);
    }

    public void dec(long l2) {
        this.segmentNumber -= l2;
        long l3 = l2 * SegmentedTimeline.access$100(this.this$0);
        this.segmentStart -= l3;
        this.segmentEnd -= l3;
        this.millisecond -= l3;
    }

    public void dec() {
        this.dec(1);
    }

    public void moveIndexToStart() {
        this.millisecond = this.segmentStart;
    }

    public void moveIndexToEnd() {
        this.millisecond = this.segmentEnd;
    }
}

