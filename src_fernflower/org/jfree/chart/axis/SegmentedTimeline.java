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

public class SegmentedTimeline implements Serializable, Cloneable, Timeline {
   private static final long serialVersionUID = 1093779862539903110L;
   public static final long DAY_SEGMENT_SIZE = 86400000L;
   public static final long HOUR_SEGMENT_SIZE = 3600000L;
   public static final long FIFTEEN_MINUTE_SEGMENT_SIZE = 900000L;
   public static final long MINUTE_SEGMENT_SIZE = 60000L;
   public static long FIRST_MONDAY_AFTER_1900;
   public static TimeZone NO_DST_TIME_ZONE;
   public static TimeZone DEFAULT_TIME_ZONE = TimeZone.getDefault();
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

   public SegmentedTimeline(long var1, int var3, int var4) {
      this.workingCalendarNoDST = new GregorianCalendar(NO_DST_TIME_ZONE);
      this.workingCalendar = Calendar.getInstance();
      this.exceptionSegments = new ArrayList();
      this.adjustForDaylightSaving = false;
      this.segmentSize = var1;
      this.segmentsIncluded = var3;
      this.segmentsExcluded = var4;
      this.groupSegmentCount = this.segmentsIncluded + this.segmentsExcluded;
      this.segmentsIncludedSize = (long)this.segmentsIncluded * this.segmentSize;
      this.segmentsExcludedSize = (long)this.segmentsExcluded * this.segmentSize;
      this.segmentsGroupSize = this.segmentsIncludedSize + this.segmentsExcludedSize;
   }

   public static SegmentedTimeline newMondayThroughFridayTimeline() {
      SegmentedTimeline var0 = new SegmentedTimeline(86400000L, 5, 2);
      var0.setStartTime(FIRST_MONDAY_AFTER_1900);
      return var0;
   }

   public static SegmentedTimeline newFifteenMinuteTimeline() {
      SegmentedTimeline var0 = new SegmentedTimeline(900000L, 28, 68);
      var0.setStartTime(FIRST_MONDAY_AFTER_1900 + 36L * var0.getSegmentSize());
      var0.setBaseTimeline(newMondayThroughFridayTimeline());
      return var0;
   }

   public boolean getAdjustForDaylightSaving() {
      return this.adjustForDaylightSaving;
   }

   public void setAdjustForDaylightSaving(boolean var1) {
      this.adjustForDaylightSaving = var1;
   }

   public void setStartTime(long var1) {
      this.startTime = var1;
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

   public void setExceptionSegments(List var1) {
      this.exceptionSegments = var1;
   }

   public SegmentedTimeline getBaseTimeline() {
      return this.baseTimeline;
   }

   public void setBaseTimeline(SegmentedTimeline var1) {
      if(var1 != null) {
         if(var1.getSegmentSize() < this.segmentSize) {
            throw new IllegalArgumentException("baseTimeline.getSegmentSize() is smaller than segmentSize");
         }

         if(var1.getStartTime() > this.startTime) {
            throw new IllegalArgumentException("baseTimeline.getStartTime() is after startTime");
         }

         if(var1.getSegmentSize() % this.segmentSize != 0L) {
            throw new IllegalArgumentException("baseTimeline.getSegmentSize() is not multiple of segmentSize");
         }

         if((this.startTime - var1.getStartTime()) % this.segmentSize != 0L) {
            throw new IllegalArgumentException("baseTimeline is not aligned");
         }
      }

      this.baseTimeline = var1;
   }

   public long toTimelineValue(long var1) {
      long var5 = var1 - this.startTime;
      long var7 = var5 % this.segmentsGroupSize;
      long var9 = var5 / this.segmentsGroupSize;
      long var3;
      if(var7 >= this.segmentsIncludedSize) {
         var3 = this.toTimelineValue(this.startTime + this.segmentsGroupSize * (var9 + 1L));
      } else {
         SegmentedTimeline$Segment var11 = this.getSegment(var1);
         if(var11.inExceptionSegments()) {
            do {
               var11 = this.getSegment(var1 = var11.getSegmentEnd() + 1L);
            } while(var11.inExceptionSegments());

            var3 = this.toTimelineValue(var1);
         } else {
            long var12 = var1 - this.startTime;
            long var14 = var12 % this.segmentsGroupSize;
            long var16 = var12 / this.segmentsGroupSize;
            long var18 = this.getExceptionSegmentCount(this.startTime, var1 - 1L);
            if(var14 < this.segmentsIncludedSize) {
               var3 = this.segmentsIncludedSize * var16 + var14 - var18 * this.segmentSize;
            } else {
               var3 = this.segmentsIncludedSize * (var16 + 1L) - var18 * this.segmentSize;
            }
         }
      }

      return var3;
   }

   public long toTimelineValue(Date var1) {
      return this.toTimelineValue(this.getTime(var1));
   }

   public long toMillisecond(long var1) {
      SegmentedTimeline$Segment var3 = new SegmentedTimeline$Segment(this, this.startTime + var1 + var1 / this.segmentsIncludedSize * this.segmentsExcludedSize);

      for(long var4 = this.startTime; var4 <= var3.segmentStart; ++var4) {
         long var6;
         while((var6 = this.getExceptionSegmentCount(var4, var3.millisecond / this.segmentSize * this.segmentSize - 1L)) > 0L) {
            var4 = var3.segmentStart;

            for(int var8 = 0; (long)var8 < var6; ++var8) {
               do {
                  var3.inc();
               } while(var3.inExcludeSegments());
            }
         }

         for(var4 = var3.segmentStart; var3.inExceptionSegments() || var3.inExcludeSegments(); var4 += this.segmentSize) {
            var3.inc();
         }
      }

      return this.getTimeFromLong(var3.millisecond);
   }

   public long getTimeFromLong(long var1) {
      long var3 = var1;
      if(this.adjustForDaylightSaving) {
         this.workingCalendarNoDST.setTime(new Date(var1));
         this.workingCalendar.set(this.workingCalendarNoDST.get(1), this.workingCalendarNoDST.get(2), this.workingCalendarNoDST.get(5), this.workingCalendarNoDST.get(11), this.workingCalendarNoDST.get(12), this.workingCalendarNoDST.get(13));
         this.workingCalendar.set(14, this.workingCalendarNoDST.get(14));
         var3 = this.workingCalendar.getTime().getTime();
      }

      return var3;
   }

   public boolean containsDomainValue(long var1) {
      SegmentedTimeline$Segment var3 = this.getSegment(var1);
      return var3.inIncludeSegments();
   }

   public boolean containsDomainValue(Date var1) {
      return this.containsDomainValue(this.getTime(var1));
   }

   public boolean containsDomainRange(long var1, long var3) {
      if(var3 < var1) {
         throw new IllegalArgumentException("domainValueEnd (" + var3 + ") < domainValueStart (" + var1 + ")");
      } else {
         SegmentedTimeline$Segment var5 = this.getSegment(var1);
         boolean var6 = true;

         do {
            var6 = var5.inIncludeSegments();
            if(var5.contains(var3)) {
               break;
            }

            var5.inc();
         } while(var6);

         return var6;
      }
   }

   public boolean containsDomainRange(Date var1, Date var2) {
      return this.containsDomainRange(this.getTime(var1), this.getTime(var2));
   }

   public void addException(long var1) {
      this.addException(new SegmentedTimeline$Segment(this, var1));
   }

   public void addException(long var1, long var3) {
      this.addException((SegmentedTimeline$Segment)(new SegmentedTimeline$SegmentRange(this, var1, var3)));
   }

   public void addException(Date var1) {
      this.addException(this.getTime(var1));
   }

   public void addExceptions(List var1) {
      Iterator var2 = var1.iterator();

      while(var2.hasNext()) {
         this.addException((Date)var2.next());
      }

   }

   private void addException(SegmentedTimeline$Segment var1) {
      if(var1.inIncludeSegments()) {
         int var2 = this.binarySearchExceptionSegments(var1);
         this.exceptionSegments.add(-(var2 + 1), var1);
      }

   }

   public void addBaseTimelineException(long var1) {
      SegmentedTimeline$Segment var3 = this.baseTimeline.getSegment(var1);
      if(var3.inIncludeSegments()) {
         SegmentedTimeline$Segment var4 = this.getSegment(var3.getSegmentStart());

         while(true) {
            while(var4.getSegmentStart() <= var3.getSegmentEnd()) {
               if(var4.inIncludeSegments()) {
                  long var5 = var4.getSegmentStart();

                  long var7;
                  do {
                     var7 = var4.getSegmentEnd();
                     var4.inc();
                  } while(var4.inIncludeSegments());

                  this.addException(var5, var7);
               } else {
                  var4.inc();
               }
            }

            return;
         }
      }
   }

   public void addBaseTimelineException(Date var1) {
      this.addBaseTimelineException(this.getTime(var1));
   }

   public void addBaseTimelineExclusions(long var1, long var3) {
      SegmentedTimeline$Segment var5 = this.baseTimeline.getSegment(var1);

      while(var5.getSegmentStart() <= var3 && !var5.inExcludeSegments()) {
         var5.inc();
      }

      label36:
      for(; var5.getSegmentStart() <= var3; var5.inc((long)this.baseTimeline.getGroupSegmentCount())) {
         long var6 = var5.getSegmentStart() + (long)this.baseTimeline.getSegmentsExcluded() * this.baseTimeline.getSegmentSize() - 1L;
         SegmentedTimeline$Segment var8 = this.getSegment(var5.getSegmentStart());

         while(true) {
            while(true) {
               if(var8.getSegmentStart() > var6) {
                  continue label36;
               }

               if(var8.inIncludeSegments()) {
                  long var9 = var8.getSegmentStart();

                  long var11;
                  do {
                     var11 = var8.getSegmentEnd();
                     var8.inc();
                  } while(var8.inIncludeSegments());

                  this.addException((SegmentedTimeline$Segment)(new SegmentedTimeline$BaseTimelineSegmentRange(this, var9, var11)));
               } else {
                  var8.inc();
               }
            }
         }
      }

   }

   public long getExceptionSegmentCount(long var1, long var3) {
      if(var3 < var1) {
         return 0L;
      } else {
         int var5 = 0;
         Iterator var6 = this.exceptionSegments.iterator();

         while(var6.hasNext()) {
            SegmentedTimeline$Segment var7 = (SegmentedTimeline$Segment)var6.next();
            SegmentedTimeline$Segment var8 = var7.intersect(var1, var3);
            if(var8 != null) {
               var5 = (int)((long)var5 + var8.getSegmentCount());
            }
         }

         return (long)var5;
      }
   }

   public SegmentedTimeline$Segment getSegment(long var1) {
      return new SegmentedTimeline$Segment(this, var1);
   }

   public SegmentedTimeline$Segment getSegment(Date var1) {
      return this.getSegment(this.getTime(var1));
   }

   private boolean equals(Object var1, Object var2) {
      return var1 == var2 || var1 != null && var1.equals(var2);
   }

   public boolean equals(Object var1) {
      if(var1 instanceof SegmentedTimeline) {
         SegmentedTimeline var2 = (SegmentedTimeline)var1;
         boolean var3 = this.segmentSize == var2.getSegmentSize();
         boolean var4 = this.segmentsIncluded == var2.getSegmentsIncluded();
         boolean var5 = this.segmentsExcluded == var2.getSegmentsExcluded();
         boolean var6 = this.startTime == var2.getStartTime();
         boolean var7 = this.equals(this.exceptionSegments, var2.getExceptionSegments());
         return var3 && var4 && var5 && var6 && var7;
      } else {
         return false;
      }
   }

   public int hashCode() {
      byte var1 = 19;
      int var2 = 37 * var1 + (int)(this.segmentSize ^ this.segmentSize >>> 32);
      var2 = 37 * var2 + (int)(this.startTime ^ this.startTime >>> 32);
      return var2;
   }

   private int binarySearchExceptionSegments(SegmentedTimeline$Segment var1) {
      int var2 = 0;
      int var3 = this.exceptionSegments.size() - 1;

      while(var2 <= var3) {
         int var4 = (var2 + var3) / 2;
         SegmentedTimeline$Segment var5 = (SegmentedTimeline$Segment)this.exceptionSegments.get(var4);
         if(var1.contains(var5) || var5.contains(var1)) {
            return var4;
         }

         if(var5.before(var1)) {
            var2 = var4 + 1;
         } else {
            if(!var5.after(var1)) {
               throw new IllegalStateException("Invalid condition.");
            }

            var3 = var4 - 1;
         }
      }

      return -(var2 + 1);
   }

   public long getTime(Date var1) {
      long var2 = var1.getTime();
      if(this.adjustForDaylightSaving) {
         this.workingCalendar.setTime(var1);
         this.workingCalendarNoDST.set(this.workingCalendar.get(1), this.workingCalendar.get(2), this.workingCalendar.get(5), this.workingCalendar.get(11), this.workingCalendar.get(12), this.workingCalendar.get(13));
         this.workingCalendarNoDST.set(14, this.workingCalendar.get(14));
         Date var4 = this.workingCalendarNoDST.getTime();
         var2 = var4.getTime();
      }

      return var2;
   }

   public Date getDate(long var1) {
      this.workingCalendarNoDST.setTime(new Date(var1));
      return this.workingCalendarNoDST.getTime();
   }

   public Object clone() {
      SegmentedTimeline var1 = (SegmentedTimeline)super.clone();
      return var1;
   }

   static long access$000(SegmentedTimeline var0) {
      return var0.startTime;
   }

   static long access$100(SegmentedTimeline var0) {
      return var0.segmentSize;
   }

   static int access$200(SegmentedTimeline var0) {
      return var0.segmentsIncluded;
   }

   static int access$300(SegmentedTimeline var0) {
      return var0.groupSegmentCount;
   }

   static int access$400(SegmentedTimeline var0, SegmentedTimeline$Segment var1) {
      return var0.binarySearchExceptionSegments(var1);
   }

   static {
      int var0 = TimeZone.getDefault().getRawOffset();
      NO_DST_TIME_ZONE = new SimpleTimeZone(var0, "UTC-" + var0);
      GregorianCalendar var1 = new GregorianCalendar(NO_DST_TIME_ZONE);
      var1.set(1900, 0, 1, 0, 0, 0);
      var1.set(14, 0);

      while(var1.get(7) != 2) {
         var1.add(5, 1);
      }

      FIRST_MONDAY_AFTER_1900 = var1.getTime().getTime();
   }
}
