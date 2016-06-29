package y.d;

import y.c.C;
import y.c.D;
import y.d.g;
import y.d.h;
import y.d.i;
import y.d.k;
import y.d.l;
import y.d.o;
import y.d.t;
import y.d.y;
import y.g.al;

public class f {
   public static void a(D var0, g var1) {
      boolean var13 = t.d;
      k[] var2 = a(var0);
      new al();
      double var5 = Double.MAX_VALUE;
      double var7 = -1.7976931348623157E308D;
      y.c.p var9 = var0.k();

      while(var9 != null) {
         y var10 = ((o)var9.c()).h();
         double var11 = var10.b;
         if(var11 >= 0.0D) {
            var5 = Math.min(var5, var10.d);
            var7 = Math.max(var7, var10.d + var11);
         }

         var9 = var9.a();
         if(var13) {
            break;
         }
      }

      l var15 = new l(var5, var7, 15);
      new al();
      int var14 = 0;

      while(var14 < var2.length) {
         k var3 = var2[var14];
         switch(var3.b) {
         case 0:
            var15.a(var3.c, var1);
            var15.a(var3.c);
            if(!var13) {
               break;
            }
         case 1:
            var15.b(var3.c);
         }

         ++var14;
         if(var13) {
            break;
         }
      }

   }

   static k[] a(D var0) {
      boolean var12 = t.d;
      D var1 = new D();
      C var2 = var0.m();

      int var10000;
      while(true) {
         if(var2.f()) {
            o var3 = (o)var2.d();
            y var4 = var3.h();
            double var5 = var4.b;
            double var7 = var4.a;
            double var14;
            var10000 = (var14 = var5 - 0.0D) == 0.0D?0:(var14 < 0.0D?-1:1);
            if(var12) {
               break;
            }

            if(var10000 >= 0 && var7 >= 0.0D) {
               h var9 = new h(var4.d, var4.d + var5, var3);
               k var10 = new k(var4.c, 0, var9);
               k var11 = new k(var4.c + var7, 1, var9);
               var1.add(var10);
               var1.add(var11);
            }

            var2.g();
            if(!var12) {
               continue;
            }
         }

         var10000 = var1.size();
         break;
      }

      k[] var13 = new k[var10000];
      var1.toArray(var13);
      y.g.e.a((Object[])var13, new i());
      return var13;
   }
}
