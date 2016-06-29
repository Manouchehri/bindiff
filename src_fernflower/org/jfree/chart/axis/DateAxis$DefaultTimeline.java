package org.jfree.chart.axis;

import java.io.Serializable;
import java.util.Date;
import org.jfree.chart.axis.DateAxis$1;
import org.jfree.chart.axis.Timeline;

class DateAxis$DefaultTimeline implements Serializable, Timeline {
   private DateAxis$DefaultTimeline() {
   }

   public long toTimelineValue(long var1) {
      return var1;
   }

   public long toTimelineValue(Date var1) {
      return var1.getTime();
   }

   public long toMillisecond(long var1) {
      return var1;
   }

   public boolean containsDomainValue(long var1) {
      return true;
   }

   public boolean containsDomainValue(Date var1) {
      return true;
   }

   public boolean containsDomainRange(long var1, long var3) {
      return true;
   }

   public boolean containsDomainRange(Date var1, Date var2) {
      return true;
   }

   public boolean equals(Object var1) {
      return var1 == null?false:(var1 == this?true:var1 instanceof DateAxis$DefaultTimeline);
   }

   DateAxis$DefaultTimeline(DateAxis$1 var1) {
      this();
   }
}
