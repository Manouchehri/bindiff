package com.google.common.primitives;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Converter;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Longs$LexicographicalComparator;
import com.google.common.primitives.Longs$LongArrayAsList;
import com.google.common.primitives.Longs$LongConverter;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.annotation.CheckForNull;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@CheckReturnValue
@GwtCompatible
public final class Longs {
   public static final int BYTES = 8;
   public static final long MAX_POWER_OF_TWO = 4611686018427387904L;

   public static int hashCode(long var0) {
      return (int)(var0 ^ var0 >>> 32);
   }

   @Deprecated
   public static int compare(long var0, long var2) {
      return var0 < var2?-1:(var0 > var2?1:0);
   }

   public static boolean contains(long[] var0, long var1) {
      long[] var3 = var0;
      int var4 = var0.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         long var6 = var3[var5];
         if(var6 == var1) {
            return true;
         }
      }

      return false;
   }

   public static int indexOf(long[] var0, long var1) {
      return indexOf(var0, var1, 0, var0.length);
   }

   private static int indexOf(long[] var0, long var1, int var3, int var4) {
      for(int var5 = var3; var5 < var4; ++var5) {
         if(var0[var5] == var1) {
            return var5;
         }
      }

      return -1;
   }

   public static int indexOf(long[] var0, long[] var1) {
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

   public static int lastIndexOf(long[] var0, long var1) {
      return lastIndexOf(var0, var1, 0, var0.length);
   }

   private static int lastIndexOf(long[] var0, long var1, int var3, int var4) {
      for(int var5 = var4 - 1; var5 >= var3; --var5) {
         if(var0[var5] == var1) {
            return var5;
         }
      }

      return -1;
   }

   public static long min(long... var0) {
      Preconditions.checkArgument(var0.length > 0);
      long var1 = var0[0];

      for(int var3 = 1; var3 < var0.length; ++var3) {
         if(var0[var3] < var1) {
            var1 = var0[var3];
         }
      }

      return var1;
   }

   public static long max(long... var0) {
      Preconditions.checkArgument(var0.length > 0);
      long var1 = var0[0];

      for(int var3 = 1; var3 < var0.length; ++var3) {
         if(var0[var3] > var1) {
            var1 = var0[var3];
         }
      }

      return var1;
   }

   public static long[] concat(long[]... var0) {
      int var1 = 0;
      long[][] var2 = var0;
      int var3 = var0.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         long[] var5 = var2[var4];
         var1 += var5.length;
      }

      long[] var8 = new long[var1];
      var3 = 0;
      long[][] var9 = var0;
      int var10 = var0.length;

      for(int var6 = 0; var6 < var10; ++var6) {
         long[] var7 = var9[var6];
         System.arraycopy(var7, 0, var8, var3, var7.length);
         var3 += var7.length;
      }

      return var8;
   }

   public static byte[] toByteArray(long var0) {
      byte[] var2 = new byte[8];

      for(int var3 = 7; var3 >= 0; --var3) {
         var2[var3] = (byte)((int)(var0 & 255L));
         var0 >>= 8;
      }

      return var2;
   }

   public static long fromByteArray(byte[] var0) {
      Preconditions.checkArgument(var0.length >= 8, "array too small: %s < %s", new Object[]{Integer.valueOf(var0.length), Integer.valueOf(8)});
      return fromBytes(var0[0], var0[1], var0[2], var0[3], var0[4], var0[5], var0[6], var0[7]);
   }

   public static long fromBytes(byte var0, byte var1, byte var2, byte var3, byte var4, byte var5, byte var6, byte var7) {
      return ((long)var0 & 255L) << 56 | ((long)var1 & 255L) << 48 | ((long)var2 & 255L) << 40 | ((long)var3 & 255L) << 32 | ((long)var4 & 255L) << 24 | ((long)var5 & 255L) << 16 | ((long)var6 & 255L) << 8 | (long)var7 & 255L;
   }

   @Nullable
   @CheckForNull
   @Beta
   public static Long tryParse(String var0) {
      if(((String)Preconditions.checkNotNull(var0)).isEmpty()) {
         return null;
      } else {
         boolean var1 = var0.charAt(0) == 45;
         int var2 = var1?1:0;
         if(var2 == var0.length()) {
            return null;
         } else {
            int var3 = var0.charAt(var2++) - 48;
            if(var3 >= 0 && var3 <= 9) {
               long var4;
               for(var4 = (long)(-var3); var2 < var0.length(); var4 -= (long)var3) {
                  var3 = var0.charAt(var2++) - 48;
                  if(var3 < 0 || var3 > 9 || var4 < -922337203685477580L) {
                     return null;
                  }

                  var4 *= 10L;
                  if(var4 < Long.MIN_VALUE + (long)var3) {
                     return null;
                  }
               }

               if(var1) {
                  return Long.valueOf(var4);
               } else if(var4 == Long.MIN_VALUE) {
                  return null;
               } else {
                  return Long.valueOf(-var4);
               }
            } else {
               return null;
            }
         }
      }
   }

   @Beta
   public static Converter stringConverter() {
      return Longs$LongConverter.INSTANCE;
   }

   public static long[] ensureCapacity(long[] var0, int var1, int var2) {
      Preconditions.checkArgument(var1 >= 0, "Invalid minLength: %s", new Object[]{Integer.valueOf(var1)});
      Preconditions.checkArgument(var2 >= 0, "Invalid padding: %s", new Object[]{Integer.valueOf(var2)});
      return var0.length < var1?copyOf(var0, var1 + var2):var0;
   }

   private static long[] copyOf(long[] var0, int var1) {
      long[] var2 = new long[var1];
      System.arraycopy(var0, 0, var2, 0, Math.min(var0.length, var1));
      return var2;
   }

   public static String join(String var0, long... var1) {
      Preconditions.checkNotNull(var0);
      if(var1.length == 0) {
         return "";
      } else {
         StringBuilder var2 = new StringBuilder(var1.length * 10);
         var2.append(var1[0]);

         for(int var3 = 1; var3 < var1.length; ++var3) {
            var2.append(var0).append(var1[var3]);
         }

         return var2.toString();
      }
   }

   public static Comparator lexicographicalComparator() {
      return Longs$LexicographicalComparator.INSTANCE;
   }

   public static long[] toArray(Collection var0) {
      if(var0 instanceof Longs$LongArrayAsList) {
         return ((Longs$LongArrayAsList)var0).toLongArray();
      } else {
         Object[] var1 = var0.toArray();
         int var2 = var1.length;
         long[] var3 = new long[var2];

         for(int var4 = 0; var4 < var2; ++var4) {
            var3[var4] = ((Number)Preconditions.checkNotNull(var1[var4])).longValue();
         }

         return var3;
      }
   }

   public static List asList(long... var0) {
      return (List)(var0.length == 0?Collections.emptyList():new Longs$LongArrayAsList(var0));
   }

   // $FF: synthetic method
   static int access$000(long[] var0, long var1, int var3, int var4) {
      return indexOf(var0, var1, var3, var4);
   }

   // $FF: synthetic method
   static int access$100(long[] var0, long var1, int var3, int var4) {
      return lastIndexOf(var0, var1, var3, var4);
   }
}
