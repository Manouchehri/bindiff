package org.jfree.chart.axis;

import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;

public class CompassFormat extends NumberFormat {
   private static final String N = "N";
   private static final String E = "E";
   private static final String S = "S";
   private static final String W = "W";
   public static final String[] DIRECTIONS = new String[]{"N", "NNE", "NE", "ENE", "E", "ESE", "SE", "SSE", "S", "SSW", "SW", "WSW", "W", "WNW", "NW", "NNW", "N"};

   public String getDirectionCode(double var1) {
      var1 %= 360.0D;
      if(var1 < 0.0D) {
         var1 += 360.0D;
      }

      int var3 = ((int)Math.floor(var1 / 11.25D) + 1) / 2;
      return DIRECTIONS[var3];
   }

   public StringBuffer format(double var1, StringBuffer var3, FieldPosition var4) {
      return var3.append(this.getDirectionCode(var1));
   }

   public StringBuffer format(long var1, StringBuffer var3, FieldPosition var4) {
      return var3.append(this.getDirectionCode((double)var1));
   }

   public Number parse(String var1, ParsePosition var2) {
      return null;
   }
}
