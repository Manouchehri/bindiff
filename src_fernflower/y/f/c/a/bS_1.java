package y.f.c.a;

import y.f.c.a.A;
import y.f.c.a.N;
import y.f.c.a.aP;
import y.f.c.a.aQ;
import y.f.c.a.aU;
import y.f.c.a.aV;

class bS {
   static void a(y.f.X var0, aU var1, aV var2, aP var3) {
      boolean var10 = N.x;
      y.c.A var4 = y.g.M.a();
      int var5 = 0;

      while(var5 < var1.b()) {
         aQ var6 = var1.a(var5);
         y.c.x var7 = var6.d().a();

         while(true) {
            if(var7.f()) {
               y.c.q var8 = var7.e();
               var4.a(var8, var5);
               var7.g();
               if(var10) {
                  break;
               }

               if(!var10) {
                  continue;
               }
            }

            ++var5;
            break;
         }

         if(var10) {
            break;
         }
      }

      y.f.aE var11 = y.f.aE.a((byte)2);
      y.f.aE var12 = y.f.aE.a((byte)1);
      y.c.e var13 = var0.p();

      while(var13.f()) {
         y.c.d var14 = var13.a();
         A var9 = var2.a(var14);
         if(!var14.e() && a(var14, var4)) {
            if(var9.c() == null || var9.c().g()) {
               var3.a(var14, true, var11);
            }

            if(var9.e() == null || var9.e().g()) {
               var3.a(var14, false, var12);
            }
         }

         var13.g();
         if(var10) {
            break;
         }
      }

   }

   private static boolean a(y.c.d var0, y.c.A var1) {
      return var1.a(var0.c()) > var1.a(var0.d());
   }
}
