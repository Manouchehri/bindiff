package org.jfree.util;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Paint;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import org.jfree.util.Log;

public class PaintUtilities {
   static Class class$java$awt$Color;

   public static boolean equal(Paint var0, Paint var1) {
      if(var0 == null) {
         return var1 == null;
      } else if(var1 == null) {
         return false;
      } else {
         boolean var2 = false;
         if(var0 instanceof GradientPaint && var1 instanceof GradientPaint) {
            GradientPaint var3 = (GradientPaint)var0;
            GradientPaint var4 = (GradientPaint)var1;
            var2 = var3.getColor1().equals(var4.getColor1()) && var3.getColor2().equals(var4.getColor2()) && var3.getPoint1().equals(var4.getPoint1()) && var3.getPoint2().equals(var4.getPoint2()) && var3.isCyclic() == var4.isCyclic() && var3.getTransparency() == var3.getTransparency();
         } else {
            var2 = var0.equals(var1);
         }

         return var2;
      }
   }

   public static String colorToString(Color var0) {
      try {
         Field[] var1 = (class$java$awt$Color == null?(class$java$awt$Color = class$("java.awt.Color")):class$java$awt$Color).getFields();

         for(int var2 = 0; var2 < var1.length; ++var2) {
            Field var3 = var1[var2];
            if(Modifier.isPublic(var3.getModifiers()) && Modifier.isFinal(var3.getModifiers()) && Modifier.isStatic(var3.getModifiers())) {
               String var4 = var3.getName();
               Object var5 = var3.get((Object)null);
               if(var5 instanceof Color && var0.equals(var5)) {
                  return var4;
               }
            }
         }
      } catch (Exception var6) {
         ;
      }

      String var7 = Integer.toHexString(var0.getRGB() & 16777215);
      StringBuffer var8 = new StringBuffer(7);
      var8.append("#");
      int var9 = 6 - var7.length();

      for(int var10 = 0; var10 < var9; ++var10) {
         var8.append("0");
      }

      var8.append(var7);
      return var8.toString();
   }

   public static Color stringToColor(String var0) {
      if(var0 == null) {
         return Color.black;
      } else {
         try {
            return Color.decode(var0);
         } catch (NumberFormatException var4) {
            try {
               Field var2 = (class$java$awt$Color == null?(class$java$awt$Color = class$("java.awt.Color")):class$java$awt$Color).getField(var0);
               return (Color)var2.get((Object)null);
            } catch (Exception var3) {
               Log.info("No such Color : " + var0);
               return Color.black;
            }
         }
      }
   }

   static Class class$(String var0) {
      try {
         return Class.forName(var0);
      } catch (ClassNotFoundException var2) {
         throw new NoClassDefFoundError(var2.getMessage());
      }
   }
}
