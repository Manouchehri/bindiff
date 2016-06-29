package org.jfree.util;

import java.util.Arrays;

public class ArrayUtilities {
   public static float[][] clone(float[][] var0) {
      if(var0 == null) {
         return (float[][])null;
      } else {
         float[][] var1 = new float[var0.length][];
         System.arraycopy(var0, 0, var1, 0, var0.length);

         for(int var2 = 0; var2 < var0.length; ++var2) {
            float[] var3 = var0[var2];
            float[] var4 = new float[var3.length];
            System.arraycopy(var3, 0, var4, 0, var3.length);
            var1[var2] = var4;
         }

         return var1;
      }
   }

   public static boolean equalReferencesInArrays(Object[] var0, Object[] var1) {
      if(var0 == null) {
         return var1 == null;
      } else if(var1 == null) {
         return false;
      } else if(var0.length != var1.length) {
         return false;
      } else {
         for(int var2 = 0; var2 < var0.length; ++var2) {
            if(var0[var2] == null && var1[var2] != null) {
               return false;
            }

            if(var1[var2] == null && var0[var2] != null) {
               return false;
            }

            if(var0[var2] != var1[var2]) {
               return false;
            }
         }

         return true;
      }
   }

   public static boolean equal(float[][] var0, float[][] var1) {
      if(var0 == null) {
         return var1 == null;
      } else if(var1 == null) {
         return false;
      } else if(var0.length != var1.length) {
         return false;
      } else {
         for(int var2 = 0; var2 < var0.length; ++var2) {
            if(!Arrays.equals(var0[var2], var1[var2])) {
               return false;
            }
         }

         return true;
      }
   }

   public static boolean hasDuplicateItems(Object[] var0) {
      for(int var1 = 0; var1 < var0.length; ++var1) {
         for(int var2 = 0; var2 < var1; ++var2) {
            Object var3 = var0[var1];
            Object var4 = var0[var2];
            if(var3 != null && var4 != null && var3.equals(var4)) {
               return true;
            }
         }
      }

      return false;
   }

   public static int compareVersionArrays(Comparable[] var0, Comparable[] var1) {
      int var2 = Math.min(var0.length, var1.length);

      for(int var3 = 0; var3 < var2; ++var3) {
         Comparable var4 = var0[var3];
         Comparable var5 = var1[var3];
         if(var4 != null || var5 != null) {
            if(var4 == null) {
               return 1;
            }

            if(var5 == null) {
               return -1;
            }

            int var6 = var4.compareTo(var5);
            if(var6 != 0) {
               return var6;
            }
         }
      }

      return 0;
   }
}
