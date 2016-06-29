package com.google.common.primitives;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Converter;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Doubles;
import com.google.common.primitives.Floats$FloatArrayAsList;
import com.google.common.primitives.Floats$FloatConverter;
import com.google.common.primitives.Floats$LexicographicalComparator;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.annotation.CheckForNull;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@CheckReturnValue
@GwtCompatible(
   emulated = true
)
public final class Floats {
   public static final int BYTES = 4;

   public static int hashCode(float var0) {
      return Float.valueOf(var0).hashCode();
   }

   static int compare(float var0, float var1) {
      return Float.compare(var0, var1);
   }

   public static boolean isFinite(float var0) {
      return Float.NEGATIVE_INFINITY < var0 & var0 < Float.POSITIVE_INFINITY;
   }

   public static boolean contains(float[] var0, float var1) {
      float[] var2 = var0;
      int var3 = var0.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         float var5 = var2[var4];
         if(var5 == var1) {
            return true;
         }
      }

      return false;
   }

   public static int indexOf(float[] var0, float var1) {
      return indexOf(var0, var1, 0, var0.length);
   }

   private static int indexOf(float[] var0, float var1, int var2, int var3) {
      for(int var4 = var2; var4 < var3; ++var4) {
         if(var0[var4] == var1) {
            return var4;
         }
      }

      return -1;
   }

   public static int indexOf(float[] var0, float[] var1) {
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

   public static int lastIndexOf(float[] var0, float var1) {
      return lastIndexOf(var0, var1, 0, var0.length);
   }

   private static int lastIndexOf(float[] var0, float var1, int var2, int var3) {
      for(int var4 = var3 - 1; var4 >= var2; --var4) {
         if(var0[var4] == var1) {
            return var4;
         }
      }

      return -1;
   }

   public static float min(float... var0) {
      Preconditions.checkArgument(var0.length > 0);
      float var1 = var0[0];

      for(int var2 = 1; var2 < var0.length; ++var2) {
         var1 = Math.min(var1, var0[var2]);
      }

      return var1;
   }

   public static float max(float... var0) {
      Preconditions.checkArgument(var0.length > 0);
      float var1 = var0[0];

      for(int var2 = 1; var2 < var0.length; ++var2) {
         var1 = Math.max(var1, var0[var2]);
      }

      return var1;
   }

   public static float[] concat(float[]... var0) {
      int var1 = 0;
      float[][] var2 = var0;
      int var3 = var0.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         float[] var5 = var2[var4];
         var1 += var5.length;
      }

      float[] var8 = new float[var1];
      var3 = 0;
      float[][] var9 = var0;
      int var10 = var0.length;

      for(int var6 = 0; var6 < var10; ++var6) {
         float[] var7 = var9[var6];
         System.arraycopy(var7, 0, var8, var3, var7.length);
         var3 += var7.length;
      }

      return var8;
   }

   @Beta
   public static Converter stringConverter() {
      return Floats$FloatConverter.INSTANCE;
   }

   public static float[] ensureCapacity(float[] var0, int var1, int var2) {
      Preconditions.checkArgument(var1 >= 0, "Invalid minLength: %s", new Object[]{Integer.valueOf(var1)});
      Preconditions.checkArgument(var2 >= 0, "Invalid padding: %s", new Object[]{Integer.valueOf(var2)});
      return var0.length < var1?copyOf(var0, var1 + var2):var0;
   }

   private static float[] copyOf(float[] var0, int var1) {
      float[] var2 = new float[var1];
      System.arraycopy(var0, 0, var2, 0, Math.min(var0.length, var1));
      return var2;
   }

   public static String join(String var0, float... var1) {
      Preconditions.checkNotNull(var0);
      if(var1.length == 0) {
         return "";
      } else {
         StringBuilder var2 = new StringBuilder(var1.length * 12);
         var2.append(var1[0]);

         for(int var3 = 1; var3 < var1.length; ++var3) {
            var2.append(var0).append(var1[var3]);
         }

         return var2.toString();
      }
   }

   public static Comparator lexicographicalComparator() {
      return Floats$LexicographicalComparator.INSTANCE;
   }

   public static float[] toArray(Collection var0) {
      if(var0 instanceof Floats$FloatArrayAsList) {
         return ((Floats$FloatArrayAsList)var0).toFloatArray();
      } else {
         Object[] var1 = var0.toArray();
         int var2 = var1.length;
         float[] var3 = new float[var2];

         for(int var4 = 0; var4 < var2; ++var4) {
            var3[var4] = ((Number)Preconditions.checkNotNull(var1[var4])).floatValue();
         }

         return var3;
      }
   }

   public static List asList(float... var0) {
      return (List)(var0.length == 0?Collections.emptyList():new Floats$FloatArrayAsList(var0));
   }

   @Nullable
   @CheckForNull
   @Beta
   @GwtIncompatible("regular expressions")
   public static Float tryParse(String var0) {
      if(Doubles.FLOATING_POINT_PATTERN.matcher(var0).matches()) {
         try {
            return Float.valueOf(Float.parseFloat(var0));
         } catch (NumberFormatException var2) {
            ;
         }
      }

      return null;
   }

   // $FF: synthetic method
   static int access$000(float[] var0, float var1, int var2, int var3) {
      return indexOf(var0, var1, var2, var3);
   }

   // $FF: synthetic method
   static int access$100(float[] var0, float var1, int var2, int var3) {
      return lastIndexOf(var0, var1, var2, var3);
   }
}
