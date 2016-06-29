package com.google.common.primitives;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Chars$CharArrayAsList;
import com.google.common.primitives.Chars$LexicographicalComparator;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.annotation.CheckReturnValue;

@CheckReturnValue
@GwtCompatible(
   emulated = true
)
public final class Chars {
   public static final int BYTES = 2;

   public static int hashCode(char var0) {
      return var0;
   }

   public static char checkedCast(long var0) {
      char var2 = (char)((int)var0);
      if((long)var2 != var0) {
         throw new IllegalArgumentException((new StringBuilder(34)).append("Out of range: ").append(var0).toString());
      } else {
         return var2;
      }
   }

   public static char saturatedCast(long var0) {
      return var0 > 65535L?'\uffff':(var0 < 0L?'\u0000':(char)((int)var0));
   }

   @Deprecated
   public static int compare(char var0, char var1) {
      return var0 - var1;
   }

   public static boolean contains(char[] var0, char var1) {
      char[] var2 = var0;
      int var3 = var0.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         char var5 = var2[var4];
         if(var5 == var1) {
            return true;
         }
      }

      return false;
   }

   public static int indexOf(char[] var0, char var1) {
      return indexOf(var0, var1, 0, var0.length);
   }

   private static int indexOf(char[] var0, char var1, int var2, int var3) {
      for(int var4 = var2; var4 < var3; ++var4) {
         if(var0[var4] == var1) {
            return var4;
         }
      }

      return -1;
   }

   public static int indexOf(char[] var0, char[] var1) {
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

   public static int lastIndexOf(char[] var0, char var1) {
      return lastIndexOf(var0, var1, 0, var0.length);
   }

   private static int lastIndexOf(char[] var0, char var1, int var2, int var3) {
      for(int var4 = var3 - 1; var4 >= var2; --var4) {
         if(var0[var4] == var1) {
            return var4;
         }
      }

      return -1;
   }

   public static char min(char... var0) {
      Preconditions.checkArgument(var0.length > 0);
      char var1 = var0[0];

      for(int var2 = 1; var2 < var0.length; ++var2) {
         if(var0[var2] < var1) {
            var1 = var0[var2];
         }
      }

      return var1;
   }

   public static char max(char... var0) {
      Preconditions.checkArgument(var0.length > 0);
      char var1 = var0[0];

      for(int var2 = 1; var2 < var0.length; ++var2) {
         if(var0[var2] > var1) {
            var1 = var0[var2];
         }
      }

      return var1;
   }

   public static char[] concat(char[]... var0) {
      int var1 = 0;
      char[][] var2 = var0;
      int var3 = var0.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         char[] var5 = var2[var4];
         var1 += var5.length;
      }

      char[] var8 = new char[var1];
      var3 = 0;
      char[][] var9 = var0;
      int var10 = var0.length;

      for(int var6 = 0; var6 < var10; ++var6) {
         char[] var7 = var9[var6];
         System.arraycopy(var7, 0, var8, var3, var7.length);
         var3 += var7.length;
      }

      return var8;
   }

   @GwtIncompatible("doesn\'t work")
   public static byte[] toByteArray(char var0) {
      return new byte[]{(byte)(var0 >> 8), (byte)var0};
   }

   @GwtIncompatible("doesn\'t work")
   public static char fromByteArray(byte[] var0) {
      Preconditions.checkArgument(var0.length >= 2, "array too small: %s < %s", new Object[]{Integer.valueOf(var0.length), Integer.valueOf(2)});
      return fromBytes(var0[0], var0[1]);
   }

   @GwtIncompatible("doesn\'t work")
   public static char fromBytes(byte var0, byte var1) {
      return (char)(var0 << 8 | var1 & 255);
   }

   public static char[] ensureCapacity(char[] var0, int var1, int var2) {
      Preconditions.checkArgument(var1 >= 0, "Invalid minLength: %s", new Object[]{Integer.valueOf(var1)});
      Preconditions.checkArgument(var2 >= 0, "Invalid padding: %s", new Object[]{Integer.valueOf(var2)});
      return var0.length < var1?copyOf(var0, var1 + var2):var0;
   }

   private static char[] copyOf(char[] var0, int var1) {
      char[] var2 = new char[var1];
      System.arraycopy(var0, 0, var2, 0, Math.min(var0.length, var1));
      return var2;
   }

   public static String join(String var0, char... var1) {
      Preconditions.checkNotNull(var0);
      int var2 = var1.length;
      if(var2 == 0) {
         return "";
      } else {
         StringBuilder var3 = new StringBuilder(var2 + var0.length() * (var2 - 1));
         var3.append(var1[0]);

         for(int var4 = 1; var4 < var2; ++var4) {
            var3.append(var0).append(var1[var4]);
         }

         return var3.toString();
      }
   }

   public static Comparator lexicographicalComparator() {
      return Chars$LexicographicalComparator.INSTANCE;
   }

   public static char[] toArray(Collection var0) {
      if(var0 instanceof Chars$CharArrayAsList) {
         return ((Chars$CharArrayAsList)var0).toCharArray();
      } else {
         Object[] var1 = var0.toArray();
         int var2 = var1.length;
         char[] var3 = new char[var2];

         for(int var4 = 0; var4 < var2; ++var4) {
            var3[var4] = ((Character)Preconditions.checkNotNull(var1[var4])).charValue();
         }

         return var3;
      }
   }

   public static List asList(char... var0) {
      return (List)(var0.length == 0?Collections.emptyList():new Chars$CharArrayAsList(var0));
   }

   // $FF: synthetic method
   static int access$000(char[] var0, char var1, int var2, int var3) {
      return indexOf(var0, var1, var2, var3);
   }

   // $FF: synthetic method
   static int access$100(char[] var0, char var1, int var2, int var3) {
      return lastIndexOf(var0, var1, var2, var3);
   }
}
