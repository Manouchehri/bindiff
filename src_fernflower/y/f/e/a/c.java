package y.f.e.a;

import y.f.e.a.af;

class c {
   static double a(double var0, int var2) {
      boolean var3 = af.b;

      while(var2 >= 0) {
         switch(var2) {
         case 0:
            return 1.0D;
         case 1:
            return var0;
         case 2:
            return var0 * var0;
         case 3:
            return var0 * var0 * var0;
         case 4:
            return var0 * var0 * var0 * var0;
         case 5:
            return var0 * var0 * var0 * var0 * var0;
         }

         if(a((long)var2)) {
            var0 *= var0;
            var2 >>= 1;
            if(!var3) {
               continue;
            }
         }

         return var0 * a(var0 * var0, var2 - 1 >> 1);
      }

      throw new IllegalArgumentException("Negative exponents not allowed");
   }

   static boolean a(long var0) {
      return (var0 & 1L) == 0L;
   }

   static double a(int var0, double var1, double var3) {
      if(var0 == 0) {
         return 0.0D;
      } else if(var0 == 1) {
         return 0.0D;
      } else if(var1 == 0.0D && var3 == 0.0D) {
         return 0.0D;
      } else {
         double var5 = (double)var0 * var3 - var1 * var1;
         if(var5 < 0.0D) {
            return 0.0D;
         } else {
            double var7 = Math.sqrt(var5 / (double)(var0 * (var0 - 1)));
            if(var7 < 0.001D) {
               return 0.0D;
            } else if(Double.isNaN(var7)) {
               throw new IllegalArgumentException("deviation is NaN");
            } else {
               return var7;
            }
         }
      }
   }
}
