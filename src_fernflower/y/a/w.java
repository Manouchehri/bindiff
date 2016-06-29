package y.a;

import y.a.h;
import y.a.x;

public final class w {
   public static y.c.q[] a(y.c.i var0) {
      x var1 = new x();
      return a(var0, var1);
   }

   public static y.c.q[] a(y.c.i var0, y.c.c var1) {
      boolean var7 = h.a;
      int var2 = 0;
      y.c.q[] var3 = new y.c.q[var0.e()];
      y.c.x var4 = var0.o();

      int var10000;
      int var10001;
      while(true) {
         if(var4.f()) {
            y.c.q var5 = var4.e();
            int var6 = var1.a(var5);
            var10000 = var6;
            var10001 = var2;
            if(var7) {
               break;
            }

            if(var6 > var2) {
               var2 = var6;
            }

            var4.g();
            if(!var7) {
               continue;
            }
         }

         var10000 = var2;
         var10001 = 1;
         break;
      }

      int[] var8 = new int[var10000 + var10001];
      y.c.x var9 = var0.o();

      y.c.q var11;
      while(true) {
         if(var9.f()) {
            var11 = var9.e();
            ++var8[var1.a(var11)];
            var9.g();
            if(var7) {
               break;
            }

            if(!var7) {
               continue;
            }
         }

         int var10 = 1;

         label47: {
            while(var10 < var8.length) {
               var8[var10] += var8[var10 - 1];
               ++var10;
               if(var7) {
                  break label47;
               }

               if(var7) {
                  break;
               }
            }

            var10 = var8.length - 1;
         }

         label57: {
            while(var10 > 0) {
               var8[var10] = var8[var10 - 1];
               --var10;
               if(var7) {
                  break label57;
               }

               if(var7) {
                  break;
               }
            }

            var8[0] = 0;
         }

         var9 = var0.o();
         break;
      }

      y.c.q[] var12;
      while(true) {
         if(var9.f()) {
            var11 = var9.e();
            var12 = var3;
            if(var7) {
               break;
            }

            var3[var8[var1.a(var11)]++] = var11;
            var9.g();
            if(!var7) {
               continue;
            }
         }

         var12 = var3;
         break;
      }

      return var12;
   }
}
