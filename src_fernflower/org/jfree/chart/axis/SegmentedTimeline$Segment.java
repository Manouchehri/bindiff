package org.jfree.chart.axis;

import java.io.Serializable;
import java.util.Date;
import org.jfree.chart.axis.SegmentedTimeline;

public class SegmentedTimeline$Segment implements Serializable, Cloneable, Comparable {
   protected long segmentNumber;
   protected long segmentStart;
   protected long segmentEnd;
   protected long millisecond;
   private final SegmentedTimeline this$0;

   protected SegmentedTimeline$Segment(SegmentedTimeline var1) {
      this.this$0 = var1;
   }

   protected SegmentedTimeline$Segment(SegmentedTimeline var1, long var2) {
      this.this$0 = var1;
      this.segmentNumber = this.calculateSegmentNumber(var2);
      this.segmentStart = SegmentedTimeline.access$000(var1) + this.segmentNumber * SegmentedTimeline.access$100(var1);
      this.segmentEnd = this.segmentStart + SegmentedTimeline.access$100(var1) - 1L;
      this.millisecond = var2;
   }

   public long calculateSegmentNumber(long var1) {
      return var1 >= SegmentedTimeline.access$000(this.this$0)?(var1 - SegmentedTimeline.access$000(this.this$0)) / SegmentedTimeline.access$100(this.this$0):(var1 - SegmentedTimeline.access$000(this.this$0)) / SegmentedTimeline.access$100(this.this$0) - 1L;
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

   public boolean contains(long var1) {
      return this.segmentStart <= var1 && var1 <= this.segmentEnd;
   }

   public boolean contains(long var1, long var3) {
      return this.segmentStart <= var1 && var3 <= this.segmentEnd;
   }

   public boolean contains(SegmentedTimeline$Segment var1) {
      return this.contains(var1.getSegmentStart(), var1.getSegmentEnd());
   }

   public boolean contained(long var1, long var3) {
      return var1 <= this.segmentStart && this.segmentEnd <= var3;
   }

   public SegmentedTimeline$Segment intersect(long var1, long var3) {
      return var1 <= this.segmentStart && this.segmentEnd <= var3?this:null;
   }

   public boolean before(SegmentedTimeline$Segment var1) {
      return this.segmentEnd < var1.getSegmentStart();
   }

   public boolean after(SegmentedTimeline$Segment var1) {
      return this.segmentStart > var1.getSegmentEnd();
   }

   public boolean equals(Object var1) {
      if(!(var1 instanceof SegmentedTimeline$Segment)) {
         return false;
      } else {
         SegmentedTimeline$Segment var2 = (SegmentedTimeline$Segment)var1;
         return this.segmentNumber == var2.getSegmentNumber() && this.segmentStart == var2.getSegmentStart() && this.segmentEnd == var2.getSegmentEnd() && this.millisecond == var2.getMillisecond();
      }
   }

   public SegmentedTimeline$Segment copy() {
      try {
         return (SegmentedTimeline$Segment)this.clone();
      } catch (CloneNotSupportedException var2) {
         return null;
      }
   }

   public int compareTo(Object var1) {
      SegmentedTimeline$Segment var2 = (SegmentedTimeline$Segment)var1;
      return this.before(var2)?-1:(this.after(var2)?1:0);
   }

   public boolean inIncludeSegments() {
      return this.getSegmentNumberRelativeToGroup() < (long)SegmentedTimeline.access$200(this.this$0)?!this.inExceptionSegments():false;
   }

   public boolean inExcludeSegments() {
      return this.getSegmentNumberRelativeToGroup() >= (long)SegmentedTimeline.access$200(this.this$0);
   }

   private long getSegmentNumberRelativeToGroup() {
      long var1 = this.segmentNumber % (long)SegmentedTimeline.access$300(this.this$0);
      if(var1 < 0L) {
         var1 += (long)SegmentedTimeline.access$300(this.this$0);
      }

      return var1;
   }

   public boolean inExceptionSegments() {
      return SegmentedTimeline.access$400(this.this$0, this) >= 0;
   }

   public void inc(long var1) {
      this.segmentNumber += var1;
      long var3 = var1 * SegmentedTimeline.access$100(this.this$0);
      this.segmentStart += var3;
      this.segmentEnd += var3;
      this.millisecond += var3;
   }

   public void inc() {
      this.inc(1L);
   }

   public void dec(long var1) {
      this.segmentNumber -= var1;
      long var3 = var1 * SegmentedTimeline.access$100(this.this$0);
      this.segmentStart -= var3;
      this.segmentEnd -= var3;
      this.millisecond -= var3;
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
