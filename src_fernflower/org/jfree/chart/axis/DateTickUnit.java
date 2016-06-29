package org.jfree.chart.axis;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import org.jfree.chart.axis.TickUnit;
import org.jfree.util.ObjectUtilities;

public class DateTickUnit extends TickUnit implements Serializable {
   private static final long serialVersionUID = -7289292157229621901L;
   public static final int YEAR = 0;
   public static final int MONTH = 1;
   public static final int DAY = 2;
   public static final int HOUR = 3;
   public static final int MINUTE = 4;
   public static final int SECOND = 5;
   public static final int MILLISECOND = 6;
   private int unit;
   private int count;
   private int rollUnit;
   private int rollCount;
   private DateFormat formatter;
   private static final String[] units = new String[]{"YEAR", "MONTH", "DAY", "HOUR", "MINUTE", "SECOND", "MILLISECOND"};

   public DateTickUnit(int var1, int var2) {
      this(var1, var2, (DateFormat)null);
   }

   public DateTickUnit(int var1, int var2, DateFormat var3) {
      this(var1, var2, var1, var2, var3);
   }

   public DateTickUnit(int var1, int var2, int var3, int var4, DateFormat var5) {
      super((double)getMillisecondCount(var1, var2));
      this.unit = var1;
      this.count = var2;
      this.rollUnit = var3;
      this.rollCount = var4;
      this.formatter = var5;
      if(var5 == null) {
         this.formatter = DateFormat.getDateInstance(3);
      }

   }

   public int getUnit() {
      return this.unit;
   }

   public int getCount() {
      return this.count;
   }

   public int getRollUnit() {
      return this.rollUnit;
   }

   public int getRollCount() {
      return this.rollCount;
   }

   public String valueToString(double var1) {
      return this.formatter.format(new Date((long)var1));
   }

   public String dateToString(Date var1) {
      return this.formatter.format(var1);
   }

   public Date addToDate(Date var1) {
      Calendar var2 = Calendar.getInstance();
      var2.setTime(var1);
      var2.add(this.getCalendarField(this.unit), this.count);
      return var2.getTime();
   }

   public Date rollDate(Date var1) {
      Calendar var2 = Calendar.getInstance();
      var2.setTime(var1);
      var2.add(this.getCalendarField(this.rollUnit), this.rollCount);
      return var2.getTime();
   }

   public int getCalendarField() {
      return this.getCalendarField(this.unit);
   }

   private int getCalendarField(int var1) {
      switch(var1) {
      case 0:
         return 1;
      case 1:
         return 2;
      case 2:
         return 5;
      case 3:
         return 11;
      case 4:
         return 12;
      case 5:
         return 13;
      case 6:
         return 14;
      default:
         return 14;
      }
   }

   private static long getMillisecondCount(int var0, int var1) {
      switch(var0) {
      case 0:
         return 31536000000L * (long)var1;
      case 1:
         return 2678400000L * (long)var1;
      case 2:
         return 86400000L * (long)var1;
      case 3:
         return 3600000L * (long)var1;
      case 4:
         return 60000L * (long)var1;
      case 5:
         return 1000L * (long)var1;
      case 6:
         return (long)var1;
      default:
         throw new IllegalArgumentException("DateTickUnit.getMillisecondCount() : unit must be one of the constants YEAR, MONTH, DAY, HOUR, MINUTE, SECOND or MILLISECOND defined in the DateTickUnit class. Do *not* use the constants defined in java.util.Calendar.");
      }
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof DateTickUnit)) {
         return false;
      } else if(!super.equals(var1)) {
         return false;
      } else {
         DateTickUnit var2 = (DateTickUnit)var1;
         return this.unit != var2.unit?false:(this.count != var2.count?false:ObjectUtilities.equal(this.formatter, var2.formatter));
      }
   }

   public int hashCode() {
      byte var1 = 19;
      int var2 = 37 * var1 + this.unit;
      var2 = 37 * var2 + this.count;
      var2 = 37 * var2 + this.formatter.hashCode();
      return var2;
   }

   public String toString() {
      return "DateTickUnit[" + units[this.unit] + ", " + this.count + "]";
   }
}
