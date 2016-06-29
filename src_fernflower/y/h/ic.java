package y.h;

import y.h.aB;
import y.h.ch;
import y.h.fL;
import y.h.fj;
import y.h.x;

class ic {
   static void a(ch var0, aB var1, boolean var2) {
      a(var0, var1, var2, (byte)3);
   }

   static byte a(ch var0, aB var1, boolean var2, byte var3) {
      fL var4 = var2?var1.getSourcePort():var1.getTargetPort();
      fj var5 = var2?var1.getSourceRealizer():var1.getTargetRealizer();
      return a(var0, var1, var4.a(var5), var4.b(var5), var2, var3);
   }

   static void a(ch var0, aB var1, double var2, double var4, boolean var6) {
      a(var0, var1, var2, var4, var6, (byte)3);
   }

   static byte a(ch var0, aB var1, double var2, double var4, boolean var6, byte var7) {
      if(var1.bendCount() > 0) {
         double var11;
         x var20;
         double var21;
         label113: {
            var20 = var6?var1.firstBend():var1.lastBend();
            if(var1.bendCount() > 1) {
               x var13 = var1.getBend(var6?1:var1.bendCount() - 2);
               var21 = var13.b();
               var11 = var13.c();
               if(!fj.z) {
                  break label113;
               }
            }

            fL var22 = var6?var1.getTargetPort():var1.getSourcePort();
            fj var24 = var6?var1.getTargetRealizer():var1.getSourceRealizer();
            var21 = var22.a(var24);
            var11 = var22.b(var24);
         }

         double var23 = var20.b();
         double var15 = var20.c();
         if(1 == var7 || 2 != var7 && Math.abs(var23 - var21) > Math.abs(var15 - var11)) {
            if(0 != var7) {
               var20.a(var2, var11);
            }

            return (byte)1;
         } else {
            if(0 != var7) {
               var20.a(var21, var4);
            }

            return (byte)2;
         }
      } else {
         fL var8 = var6?var1.getTargetPort():var1.getSourcePort();
         fj var9 = var6?var1.getTargetRealizer():var1.getSourceRealizer();
         double var10 = var8.a(var9);
         double var12 = var8.b(var9);
         double var14 = var10 - var2;
         double var16 = var12 - var4;
         double var18;
         if(1 != var7 && (2 == var7 || Math.abs(var14) <= Math.abs(var16))) {
            if(0 != var7 && var2 != var10) {
               var18 = b(var0, var4 + var16 * 0.5D);
               var1.addPoint(var6?var2:var10, var18);
               var1.addPoint(var6?var10:var2, var18);
            }

            return (byte)2;
         } else {
            if(0 != var7 && var4 != var12) {
               var18 = a(var0, var2 + var14 * 0.5D);
               var1.addPoint(var18, var6?var4:var12);
               var1.addPoint(var18, var6?var12:var4);
            }

            return (byte)1;
         }
      }
   }

   protected static double a(ch var0, double var1) {
      if(var0 != null && var0.getGridMode()) {
         double var3 = var0.getGridResolution();
         return Math.floor(var1 / var3 + 0.5D) * var3;
      } else {
         return var1;
      }
   }

   protected static double b(ch var0, double var1) {
      if(var0 != null && var0.getGridMode()) {
         double var3 = var0.getGridResolution();
         return Math.floor(var1 / var3 + 0.5D) * var3;
      } else {
         return var1;
      }
   }
}
