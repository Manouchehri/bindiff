package org.jfree.data.time;

import java.io.Serializable;
import java.util.Date;
import org.jfree.data.time.TimePeriod;

public class SimpleTimePeriod implements Serializable, Comparable, TimePeriod {
   private static final long serialVersionUID = 8684672361131829554L;
   private Date start;
   private Date end;

   public SimpleTimePeriod(long var1, long var3) {
      this(new Date(var1), new Date(var3));
   }

   public SimpleTimePeriod(Date var1, Date var2) {
      if(var1.getTime() > var2.getTime()) {
         throw new IllegalArgumentException("Requires end >= start.");
      } else {
         this.start = var1;
         this.end = var2;
      }
   }

   public Date getStart() {
      return this.start;
   }

   public Date getEnd() {
      return this.end;
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof TimePeriod)) {
         return false;
      } else {
         TimePeriod var2 = (TimePeriod)var1;
         return !this.start.equals(var2.getStart())?false:this.end.equals(var2.getEnd());
      }
   }

   public int compareTo(Object var1) {
      TimePeriod var2 = (TimePeriod)var1;
      long var3 = this.getStart().getTime();
      long var5 = this.getEnd().getTime();
      long var7 = var3 + (var5 - var3) / 2L;
      long var9 = var2.getStart().getTime();
      long var11 = var2.getEnd().getTime();
      long var13 = var9 + (var11 - var9) / 2L;
      return var7 < var13?-1:(var7 > var13?1:(var3 < var9?-1:(var3 > var9?1:(var5 < var11?-1:(var5 > var11?1:0)))));
   }

   public int hashCode() {
      byte var1 = 17;
      int var2 = 37 * var1 + this.start.hashCode();
      var2 = 37 * var2 + this.end.hashCode();
      return var2;
   }
}
