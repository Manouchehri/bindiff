package org.jfree.chart.axis;

import org.jfree.chart.axis.SegmentedTimeline;
import org.jfree.chart.axis.SegmentedTimeline$Segment;

public class SegmentedTimeline$SegmentRange extends SegmentedTimeline$Segment {
   private long segmentCount;
   private final SegmentedTimeline this$0;

   public SegmentedTimeline$SegmentRange(SegmentedTimeline var1, long var2, long var4) {
      super(var1);
      this.this$0 = var1;
      SegmentedTimeline$Segment var6 = var1.getSegment(var2);
      SegmentedTimeline$Segment var7 = var1.getSegment(var4);
      this.millisecond = var2;
      this.segmentNumber = this.calculateSegmentNumber(var2);
      this.segmentStart = var6.segmentStart;
      this.segmentEnd = var7.segmentEnd;
      this.segmentCount = var7.getSegmentNumber() - var6.getSegmentNumber() + 1L;
   }

   public long getSegmentCount() {
      return this.segmentCount;
   }

   public SegmentedTimeline$Segment intersect(long var1, long var3) {
      long var5 = Math.max(var1, this.segmentStart);
      long var7 = Math.min(var3, this.segmentEnd);
      return var5 <= var7?new SegmentedTimeline$SegmentRange(this.this$0, var5, var7):null;
   }

   public boolean inIncludeSegments() {
      SegmentedTimeline$Segment var1 = this.this$0.getSegment(this.segmentStart);

      while(var1.getSegmentStart() < this.segmentEnd) {
         if(!var1.inIncludeSegments()) {
            return false;
         }

         var1.inc();
      }

      return true;
   }

   public boolean inExcludeSegments() {
      SegmentedTimeline$Segment var1 = this.this$0.getSegment(this.segmentStart);

      while(var1.getSegmentStart() < this.segmentEnd) {
         if(!var1.inExceptionSegments()) {
            return false;
         }

         var1.inc();
      }

      return true;
   }

   public void inc(long var1) {
      throw new IllegalArgumentException("Not implemented in SegmentRange");
   }
}
