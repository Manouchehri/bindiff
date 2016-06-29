package org.jfree.data.time;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import org.jfree.data.time.RegularTimePeriod;

public class FixedMillisecond extends RegularTimePeriod implements Serializable {
   private static final long serialVersionUID = 7867521484545646931L;
   private Date time;

   public FixedMillisecond() {
      this(new Date());
   }

   public FixedMillisecond(long var1) {
      this(new Date(var1));
   }

   public FixedMillisecond(Date var1) {
      this.time = var1;
   }

   public Date getTime() {
      return this.time;
   }

   public void peg(Calendar var1) {
   }

   public RegularTimePeriod previous() {
      FixedMillisecond var1 = null;
      long var2 = this.time.getTime();
      if(var2 != Long.MIN_VALUE) {
         var1 = new FixedMillisecond(var2 - 1L);
      }

      return var1;
   }

   public RegularTimePeriod next() {
      FixedMillisecond var1 = null;
      long var2 = this.time.getTime();
      if(var2 != Long.MAX_VALUE) {
         var1 = new FixedMillisecond(var2 + 1L);
      }

      return var1;
   }

   public boolean equals(Object var1) {
      if(var1 instanceof FixedMillisecond) {
         FixedMillisecond var2 = (FixedMillisecond)var1;
         return this.time.equals(var2.getTime());
      } else {
         return false;
      }
   }

   public int hashCode() {
      return this.time.hashCode();
   }

   public int compareTo(Object var1) {
      byte var2;
      if(var1 instanceof FixedMillisecond) {
         FixedMillisecond var5 = (FixedMillisecond)var1;
         long var3 = this.time.getTime() - var5.time.getTime();
         if(var3 > 0L) {
            var2 = 1;
         } else if(var3 < 0L) {
            var2 = -1;
         } else {
            var2 = 0;
         }
      } else if(var1 instanceof RegularTimePeriod) {
         var2 = 0;
      } else {
         var2 = 1;
      }

      return var2;
   }

   public long getFirstMillisecond() {
      return this.time.getTime();
   }

   public long getFirstMillisecond(Calendar var1) {
      return this.time.getTime();
   }

   public long getLastMillisecond() {
      return this.time.getTime();
   }

   public long getLastMillisecond(Calendar var1) {
      return this.time.getTime();
   }

   public long getMiddleMillisecond() {
      return this.time.getTime();
   }

   public long getMiddleMillisecond(Calendar var1) {
      return this.time.getTime();
   }

   public long getSerialIndex() {
      return this.time.getTime();
   }
}
