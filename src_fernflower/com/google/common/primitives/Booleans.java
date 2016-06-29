package com.google.common.primitives;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Booleans$BooleanArrayAsList;
import com.google.common.primitives.Booleans$LexicographicalComparator;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.annotation.CheckReturnValue;

@CheckReturnValue
@GwtCompatible
public final class Booleans {
   public static int hashCode(boolean var0) {
      return var0?1231:1237;
   }

   @Deprecated
   public static int compare(boolean var0, boolean var1) {
      return var0 == var1?0:(var0?1:-1);
   }

   public static boolean contains(boolean[] var0, boolean var1) {
      boolean[] var2 = var0;
      int var3 = var0.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         boolean var5 = var2[var4];
         if(var5 == var1) {
            return true;
         }
      }

      return false;
   }

   public static int indexOf(boolean[] var0, boolean var1) {
      return indexOf(var0, var1, 0, var0.length);
   }

   private static int indexOf(boolean[] var0, boolean var1, int var2, int var3) {
      for(int var4 = var2; var4 < var3; ++var4) {
         if(var0[var4] == var1) {
            return var4;
         }
      }

      return -1;
   }

   public static int indexOf(boolean[] var0, boolean[] var1) {
      Preconditions.checkNotNull(var0, "array");
      Preconditions.checkNotNull(var1, "target");
      if(var1.length == 0) {
         return 0;
      } else {
         label28:
         for(int var2 = 0; var2 < var0.length - var1.length + 1; ++var2) {
            for(int var3 = 0; var3 < var1.length; ++var3) {
               if(var0[var2 + var3] != var1[var3]) {
                  continue label28;
               }
            }

            return var2;
         }

         return -1;
      }
   }

   public static int lastIndexOf(boolean[] var0, boolean var1) {
      return lastIndexOf(var0, var1, 0, var0.length);
   }

   private static int lastIndexOf(boolean[] var0, boolean var1, int var2, int var3) {
      for(int var4 = var3 - 1; var4 >= var2; --var4) {
         if(var0[var4] == var1) {
            return var4;
         }
      }

      return -1;
   }

   public static boolean[] concat(boolean[]... var0) {
      int var1 = 0;
      boolean[][] var2 = var0;
      int var3 = var0.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         boolean[] var5 = var2[var4];
         var1 += var5.length;
      }

      boolean[] var8 = new boolean[var1];
      var3 = 0;
      boolean[][] var9 = var0;
      int var10 = var0.length;

      for(int var6 = 0; var6 < var10; ++var6) {
         boolean[] var7 = var9[var6];
         System.arraycopy(var7, 0, var8, var3, var7.length);
         var3 += var7.length;
      }

      return var8;
   }

   public static boolean[] ensureCapacity(boolean[] var0, int var1, int var2) {
      Preconditions.checkArgument(var1 >= 0, "Invalid minLength: %s", new Object[]{Integer.valueOf(var1)});
      Preconditions.checkArgument(var2 >= 0, "Invalid padding: %s", new Object[]{Integer.valueOf(var2)});
      return var0.length < var1?copyOf(var0, var1 + var2):var0;
   }

   private static boolean[] copyOf(boolean[] var0, int var1) {
      boolean[] var2 = new boolean[var1];
      System.arraycopy(var0, 0, var2, 0, Math.min(var0.length, var1));
      return var2;
   }

   public static String join(String var0, boolean... var1) {
      Preconditions.checkNotNull(var0);
      if(var1.length == 0) {
         return "";
      } else {
         StringBuilder var2 = new StringBuilder(var1.length * 7);
         var2.append(var1[0]);

         for(int var3 = 1; var3 < var1.length; ++var3) {
            var2.append(var0).append(var1[var3]);
         }

         return var2.toString();
      }
   }

   public static Comparator lexicographicalComparator() {
      return Booleans$LexicographicalComparator.INSTANCE;
   }

   public static boolean[] toArray(Collection var0) {
      if(var0 instanceof Booleans$BooleanArrayAsList) {
         return ((Booleans$BooleanArrayAsList)var0).toBooleanArray();
      } else {
         Object[] var1 = var0.toArray();
         int var2 = var1.length;
         boolean[] var3 = new boolean[var2];

         for(int var4 = 0; var4 < var2; ++var4) {
            var3[var4] = ((Boolean)Preconditions.checkNotNull(var1[var4])).booleanValue();
         }

         return var3;
      }
   }

   public static List asList(boolean... var0) {
      return (List)(var0.length == 0?Collections.emptyList():new Booleans$BooleanArrayAsList(var0));
   }

   @Beta
   public static int countTrue(boolean... var0) {
      int var1 = 0;
      boolean[] var2 = var0;
      int var3 = var0.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         boolean var5 = var2[var4];
         if(var5) {
            ++var1;
         }
      }

      return var1;
   }

   // $FF: synthetic method
   static int access$000(boolean[] var0, boolean var1, int var2, int var3) {
      return indexOf(var0, var1, var2, var3);
   }

   // $FF: synthetic method
   static int access$100(boolean[] var0, boolean var1, int var2, int var3) {
      return lastIndexOf(var0, var1, var2, var3);
   }
}
