package org.jfree.date;

import java.io.Serializable;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import org.jfree.date.MonthConstants;
import org.jfree.date.SpreadsheetDate;

public abstract class SerialDate implements Serializable, Comparable, MonthConstants {
   private static final long serialVersionUID = -293716040467423637L;
   public static final DateFormatSymbols DATE_FORMAT_SYMBOLS = (new SimpleDateFormat()).getDateFormatSymbols();
   public static final int SERIAL_LOWER_BOUND = 2;
   public static final int SERIAL_UPPER_BOUND = 2958465;
   public static final int MINIMUM_YEAR_SUPPORTED = 1900;
   public static final int MAXIMUM_YEAR_SUPPORTED = 9999;
   public static final int MONDAY = 2;
   public static final int TUESDAY = 3;
   public static final int WEDNESDAY = 4;
   public static final int THURSDAY = 5;
   public static final int FRIDAY = 6;
   public static final int SATURDAY = 7;
   public static final int SUNDAY = 1;
   static final int[] LAST_DAY_OF_MONTH = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
   static final int[] AGGREGATE_DAYS_TO_END_OF_MONTH = new int[]{0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334, 365};
   static final int[] AGGREGATE_DAYS_TO_END_OF_PRECEDING_MONTH = new int[]{0, 0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334, 365};
   static final int[] LEAP_YEAR_AGGREGATE_DAYS_TO_END_OF_MONTH = new int[]{0, 31, 60, 91, 121, 152, 182, 213, 244, 274, 305, 335, 366};
   static final int[] LEAP_YEAR_AGGREGATE_DAYS_TO_END_OF_PRECEDING_MONTH = new int[]{0, 0, 31, 60, 91, 121, 152, 182, 213, 244, 274, 305, 335, 366};
   public static final int FIRST_WEEK_IN_MONTH = 1;
   public static final int SECOND_WEEK_IN_MONTH = 2;
   public static final int THIRD_WEEK_IN_MONTH = 3;
   public static final int FOURTH_WEEK_IN_MONTH = 4;
   public static final int LAST_WEEK_IN_MONTH = 0;
   public static final int INCLUDE_NONE = 0;
   public static final int INCLUDE_FIRST = 1;
   public static final int INCLUDE_SECOND = 2;
   public static final int INCLUDE_BOTH = 3;
   public static final int PRECEDING = -1;
   public static final int NEAREST = 0;
   public static final int FOLLOWING = 1;
   private String description;

   public static boolean isValidWeekdayCode(int var0) {
      switch(var0) {
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
      case 7:
         return true;
      default:
         return false;
      }
   }

   public static int stringToWeekdayCode(String var0) {
      String[] var1 = DATE_FORMAT_SYMBOLS.getShortWeekdays();
      String[] var2 = DATE_FORMAT_SYMBOLS.getWeekdays();
      int var3 = -1;
      var0 = var0.trim();

      for(int var4 = 0; var4 < var2.length; ++var4) {
         if(var0.equals(var1[var4])) {
            var3 = var4;
            break;
         }

         if(var0.equals(var2[var4])) {
            var3 = var4;
            break;
         }
      }

      return var3;
   }

   public static String weekdayCodeToString(int var0) {
      String[] var1 = DATE_FORMAT_SYMBOLS.getWeekdays();
      return var1[var0];
   }

   public static String[] getMonths() {
      return getMonths(false);
   }

   public static String[] getMonths(boolean var0) {
      return var0?DATE_FORMAT_SYMBOLS.getShortMonths():DATE_FORMAT_SYMBOLS.getMonths();
   }

   public static boolean isValidMonthCode(int var0) {
      switch(var0) {
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
      case 7:
      case 8:
      case 9:
      case 10:
      case 11:
      case 12:
         return true;
      default:
         return false;
      }
   }

   public static int monthCodeToQuarter(int var0) {
      switch(var0) {
      case 1:
      case 2:
      case 3:
         return 1;
      case 4:
      case 5:
      case 6:
         return 2;
      case 7:
      case 8:
      case 9:
         return 3;
      case 10:
      case 11:
      case 12:
         return 4;
      default:
         throw new IllegalArgumentException("SerialDate.monthCodeToQuarter: invalid month code.");
      }
   }

   public static String monthCodeToString(int var0) {
      return monthCodeToString(var0, false);
   }

   public static String monthCodeToString(int var0, boolean var1) {
      if(!isValidMonthCode(var0)) {
         throw new IllegalArgumentException("SerialDate.monthCodeToString: month outside valid range.");
      } else {
         String[] var2;
         if(var1) {
            var2 = DATE_FORMAT_SYMBOLS.getShortMonths();
         } else {
            var2 = DATE_FORMAT_SYMBOLS.getMonths();
         }

         return var2[var0 - 1];
      }
   }

   public static int stringToMonthCode(String var0) {
      String[] var1 = DATE_FORMAT_SYMBOLS.getShortMonths();
      String[] var2 = DATE_FORMAT_SYMBOLS.getMonths();
      int var3 = -1;
      var0 = var0.trim();

      try {
         var3 = Integer.parseInt(var0);
      } catch (NumberFormatException var5) {
         ;
      }

      if(var3 < 1 || var3 > 12) {
         for(int var4 = 0; var4 < var2.length; ++var4) {
            if(var0.equals(var1[var4])) {
               var3 = var4 + 1;
               break;
            }

            if(var0.equals(var2[var4])) {
               var3 = var4 + 1;
               break;
            }
         }
      }

      return var3;
   }

   public static boolean isValidWeekInMonthCode(int var0) {
      switch(var0) {
      case 0:
      case 1:
      case 2:
      case 3:
      case 4:
         return true;
      default:
         return false;
      }
   }

   public static boolean isLeapYear(int var0) {
      return var0 % 4 != 0?false:(var0 % 400 == 0?true:var0 % 100 != 0);
   }

   public static int leapYearCount(int var0) {
      int var1 = (var0 - 1896) / 4;
      int var2 = (var0 - 1800) / 100;
      int var3 = (var0 - 1600) / 400;
      return var1 - var2 + var3;
   }

   public static int lastDayOfMonth(int var0, int var1) {
      int var2 = LAST_DAY_OF_MONTH[var0];
      return var0 != 2?var2:(isLeapYear(var1)?var2 + 1:var2);
   }

   public static SerialDate addDays(int var0, SerialDate var1) {
      int var2 = var1.toSerial() + var0;
      return createInstance(var2);
   }

   public static SerialDate addMonths(int var0, SerialDate var1) {
      int var2 = (12 * var1.getYYYY() + var1.getMonth() + var0 - 1) / 12;
      int var3 = (12 * var1.getYYYY() + var1.getMonth() + var0 - 1) % 12 + 1;
      int var4 = Math.min(var1.getDayOfMonth(), lastDayOfMonth(var3, var2));
      return createInstance(var4, var3, var2);
   }

   public static SerialDate addYears(int var0, SerialDate var1) {
      int var2 = var1.getYYYY();
      int var3 = var1.getMonth();
      int var4 = var1.getDayOfMonth();
      int var5 = var2 + var0;
      int var6 = Math.min(var4, lastDayOfMonth(var3, var5));
      return createInstance(var6, var3, var5);
   }

   public static SerialDate getPreviousDayOfWeek(int var0, SerialDate var1) {
      if(!isValidWeekdayCode(var0)) {
         throw new IllegalArgumentException("Invalid day-of-the-week code.");
      } else {
         int var3 = var1.getDayOfWeek();
         int var2;
         if(var3 > var0) {
            var2 = Math.min(0, var0 - var3);
         } else {
            var2 = -7 + Math.max(0, var0 - var3);
         }

         return addDays(var2, var1);
      }
   }

   public static SerialDate getFollowingDayOfWeek(int var0, SerialDate var1) {
      if(!isValidWeekdayCode(var0)) {
         throw new IllegalArgumentException("Invalid day-of-the-week code.");
      } else {
         int var3 = var1.getDayOfWeek();
         int var2;
         if(var3 > var0) {
            var2 = 7 + Math.min(0, var0 - var3);
         } else {
            var2 = Math.max(0, var0 - var3);
         }

         return addDays(var2, var1);
      }
   }

   public static SerialDate getNearestDayOfWeek(int var0, SerialDate var1) {
      if(!isValidWeekdayCode(var0)) {
         throw new IllegalArgumentException("Invalid day-of-the-week code.");
      } else {
         int var2 = var1.getDayOfWeek();
         int var3 = -Math.abs(var0 - var2);
         if(var3 >= 4) {
            var3 = 7 - var3;
         }

         if(var3 <= -4) {
            var3 += 7;
         }

         return addDays(var3, var1);
      }
   }

   public SerialDate getEndOfCurrentMonth(SerialDate var1) {
      int var2 = lastDayOfMonth(var1.getMonth(), var1.getYYYY());
      return createInstance(var2, var1.getMonth(), var1.getYYYY());
   }

   public static String weekInMonthToString(int var0) {
      switch(var0) {
      case 0:
         return "Last";
      case 1:
         return "First";
      case 2:
         return "Second";
      case 3:
         return "Third";
      case 4:
         return "Fourth";
      default:
         return "SerialDate.weekInMonthToString(): invalid code.";
      }
   }

   public static String relativeToString(int var0) {
      switch(var0) {
      case -1:
         return "Preceding";
      case 0:
         return "Nearest";
      case 1:
         return "Following";
      default:
         return "ERROR : Relative To String";
      }
   }

   public static SerialDate createInstance(int var0, int var1, int var2) {
      return new SpreadsheetDate(var0, var1, var2);
   }

   public static SerialDate createInstance(int var0) {
      return new SpreadsheetDate(var0);
   }

   public static SerialDate createInstance(Date var0) {
      GregorianCalendar var1 = new GregorianCalendar();
      var1.setTime(var0);
      return new SpreadsheetDate(var1.get(5), var1.get(2) + 1, var1.get(1));
   }

   public abstract int toSerial();

   public abstract Date toDate();

   public String getDescription() {
      return this.description;
   }

   public void setDescription(String var1) {
      this.description = var1;
   }

   public String toString() {
      return this.getDayOfMonth() + "-" + monthCodeToString(this.getMonth()) + "-" + this.getYYYY();
   }

   public abstract int getYYYY();

   public abstract int getMonth();

   public abstract int getDayOfMonth();

   public abstract int getDayOfWeek();

   public abstract int compare(SerialDate var1);

   public abstract boolean isOn(SerialDate var1);

   public abstract boolean isBefore(SerialDate var1);

   public abstract boolean isOnOrBefore(SerialDate var1);

   public abstract boolean isAfter(SerialDate var1);

   public abstract boolean isOnOrAfter(SerialDate var1);

   public abstract boolean isInRange(SerialDate var1, SerialDate var2);

   public abstract boolean isInRange(SerialDate var1, SerialDate var2, int var3);

   public SerialDate getPreviousDayOfWeek(int var1) {
      return getPreviousDayOfWeek(var1, this);
   }

   public SerialDate getFollowingDayOfWeek(int var1) {
      return getFollowingDayOfWeek(var1, this);
   }

   public SerialDate getNearestDayOfWeek(int var1) {
      return getNearestDayOfWeek(var1, this);
   }
}
