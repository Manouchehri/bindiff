/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.axis;

import org.jfree.chart.axis.SegmentedTimeline;
import org.jfree.chart.axis.SegmentedTimeline$Segment;

public class SegmentedTimeline$SegmentRange
extends SegmentedTimeline$Segment {
    private long segmentCount;
    private final SegmentedTimeline this$0;

    public SegmentedTimeline$SegmentRange(SegmentedTimeline segmentedTimeline, long l2, long l3) {
        super(segmentedTimeline);
        this.this$0 = segmentedTimeline;
        SegmentedTimeline$Segment segmentedTimeline$Segment = segmentedTimeline.getSegment(l2);
        SegmentedTimeline$Segment segmentedTimeline$Segment2 = segmentedTimeline.getSegment(l3);
        this.millisecond = l2;
        this.segmentNumber = this.calculateSegmentNumber(l2);
        this.segmentStart = segmentedTimeline$Segment.segmentStart;
        this.segmentEnd = segmentedTimeline$Segment2.segmentEnd;
        this.segmentCount = segmentedTimeline$Segment2.getSegmentNumber() - segmentedTimeline$Segment.getSegmentNumber() + 1;
    }

    @Override
    public long getSegmentCount() {
        return this.segmentCount;
    }

    @Override
    public SegmentedTimeline$Segment intersect(long l2, long l3) {
        long l4;
        long l5 = Math.max(l2, this.segmentStart);
        if (l5 > (l4 = Math.min(l3, this.segmentEnd))) return null;
        return new SegmentedTimeline$SegmentRange(this.this$0, l5, l4);
    }

    @Override
    public boolean inIncludeSegments() {
        SegmentedTimeline$Segment segmentedTimeline$Segment = this.this$0.getSegment(this.segmentStart);
        while (segmentedTimeline$Segment.getSegmentStart() < this.segmentEnd) {
            if (!segmentedTimeline$Segment.inIncludeSegments()) {
                return false;
            }
            segmentedTimeline$Segment.inc();
        }
        return true;
    }

    @Override
    public boolean inExcludeSegments() {
        SegmentedTimeline$Segment segmentedTimeline$Segment = this.this$0.getSegment(this.segmentStart);
        while (segmentedTimeline$Segment.getSegmentStart() < this.segmentEnd) {
            if (!segmentedTimeline$Segment.inExceptionSegments()) {
                return false;
            }
            segmentedTimeline$Segment.inc();
        }
        return true;
    }

    @Override
    public void inc(long l2) {
        throw new IllegalArgumentException("Not implemented in SegmentRange");
    }
}

