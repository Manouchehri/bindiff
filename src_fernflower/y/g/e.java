package y.g;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import y.g.au;
import y.g.f;
import y.g.g;
import y.g.i;
import y.g.j;
import y.g.k;
import y.g.p;

public class e {
   public static Comparator a(y.c.c var0) {
      return new j(var0);
   }

   public static Comparator b(y.c.c var0) {
      return new k(var0);
   }

   public static Comparator c(y.c.c var0) {
      return new i(var0);
   }

   public static Comparator a() {
      return new f();
   }

   public static int a(int var0, int var1) {
      return var0 < var1?-1:(var0 > var1?1:0);
   }

   public static int a(long var0, long var2) {
      return var0 < var2?-1:(var0 > var2?1:0);
   }

   public static int a(float var0, float var1) {
      return var0 < var1?-1:(var0 > var1?1:0);
   }

   public static int a(double var0, double var2) {
      return var0 < var2?-1:(var0 > var2?1:0);
   }

   public static void a(List var0, Comparator var1) {
      if(var0.size() >= 2) {
         if(var1 instanceof g || var1 == null && var0.get(0) instanceof g) {
            au.a(var0, var1);
            if(!p.c) {
               return;
            }
         }

         Collections.sort(var0, var1);
      }
   }

   public static void a(Object[] var0, Comparator var1) {
      if(var0.length >= 2) {
         if(var1 instanceof g || var1 == null && var0[0] instanceof g) {
            au.a(var0, var1);
            if(!p.c) {
               return;
            }
         }

         Arrays.sort(var0, var1);
      }
   }

   public static void a(Object[] var0, int var1, int var2, Comparator var3) {
      if(var1 > var2) {
         throw new IllegalArgumentException("fromIndex(" + var1 + ") > toIndex(" + var2 + ")");
      } else if(var1 < 0) {
         throw a(var1);
      } else if(var2 > var0.length) {
         throw a(var2);
      } else if(var1 != var2) {
         if(var3 instanceof g || var3 == null && var0[var1] instanceof g) {
            au.a(var0, var1, var2, var3);
            if(!p.c) {
               return;
            }
         }

         Arrays.sort(var0, var1, var2, var3);
      }
   }

   private static ArrayIndexOutOfBoundsException a(int var0) {
      return new ArrayIndexOutOfBoundsException("Array index out of range: " + var0);
   }
}
