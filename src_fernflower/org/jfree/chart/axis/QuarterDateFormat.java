package org.jfree.chart.axis;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class QuarterDateFormat extends DateFormat implements Serializable, Cloneable {
   private static final long serialVersionUID = -6738465248529797176L;
   public static final String[] REGULAR_QUARTERS = new String[]{"1", "2", "3", "4"};
   public static final String[] ROMAN_QUARTERS = new String[]{"I", "II", "III", "IV"};
   private String[] quarters;

   public QuarterDateFormat() {
      this(TimeZone.getDefault());
   }

   public QuarterDateFormat(TimeZone var1) {
      this(var1, REGULAR_QUARTERS);
   }

   public QuarterDateFormat(TimeZone var1, String[] var2) {
      this.quarters = REGULAR_QUARTERS;
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'zone\' argument.");
      } else {
         this.calendar = new GregorianCalendar(var1);
         this.quarters = var2;
         this.numberFormat = NumberFormat.getNumberInstance();
      }
   }

   public StringBuffer format(Date var1, StringBuffer var2, FieldPosition var3) {
      this.calendar.setTime(var1);
      int var4 = this.calendar.get(1);
      int var5 = this.calendar.get(2);
      var2.append(var4);
      var2.append(" ");
      int var6 = var5 / 3;
      var2.append(this.quarters[var6]);
      return var2;
   }

   public Date parse(String var1, ParsePosition var2) {
      return null;
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof QuarterDateFormat)) {
         return false;
      } else if(!super.equals(var1)) {
         return false;
      } else {
         QuarterDateFormat var2 = (QuarterDateFormat)var1;
         return Arrays.equals(this.quarters, var2.quarters);
      }
   }
}
