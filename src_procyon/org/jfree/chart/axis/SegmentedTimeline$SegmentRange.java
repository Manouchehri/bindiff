package org.jfree.chart.axis;

public class SegmentedTimeline$SegmentRange extends SegmentedTimeline$Segment
{
    private long segmentCount;
    private final SegmentedTimeline this$0;
    
    public SegmentedTimeline$SegmentRange(final SegmentedTimeline this$0, final long millisecond, final long n) {
        super(this$0);
        this.this$0 = this$0;
        final SegmentedTimeline$Segment segment = this$0.getSegment(millisecond);
        final SegmentedTimeline$Segment segment2 = this$0.getSegment(n);
        this.millisecond = millisecond;
        this.segmentNumber = this.calculateSegmentNumber(millisecond);
        this.segmentStart = segment.segmentStart;
        this.segmentEnd = segment2.segmentEnd;
        this.segmentCount = segment2.getSegmentNumber() - segment.getSegmentNumber() + 1L;
    }
    
    public long getSegmentCount() {
        return this.segmentCount;
    }
    
    public SegmentedTimeline$Segment intersect(final long n, final long n2) {
        final long max = Math.max(n, this.segmentStart);
        final long min = Math.min(n2, this.segmentEnd);
        if (max <= min) {
            return new SegmentedTimeline$SegmentRange(this.this$0, max, min);
        }
        return null;
    }
    
    public boolean inIncludeSegments() {
        final SegmentedTimeline$Segment segment = this.this$0.getSegment(this.segmentStart);
        while (segment.getSegmentStart() < this.segmentEnd) {
            if (!segment.inIncludeSegments()) {
                return false;
            }
            segment.inc();
        }
        return true;
    }
    
    public boolean inExcludeSegments() {
        final SegmentedTimeline$Segment segment = this.this$0.getSegment(this.segmentStart);
        while (segment.getSegmentStart() < this.segmentEnd) {
            if (!segment.inExceptionSegments()) {
                return false;
            }
            segment.inc();
        }
        return true;
    }
    
    public void inc(final long n) {
        throw new IllegalArgumentException("Not implemented in SegmentRange");
    }
}
