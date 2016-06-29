package y.f.c.a;

import y.f.c.a.N;
import y.f.c.a.aQ;
import y.f.c.a.aU;
import y.f.c.a.aV;
import y.f.c.a.aX;
import y.f.c.a.z;

class bN implements z {
   public double a(y.f.X var1, aQ var2, aV var3, y.c.q var4, y.c.q var5) {
      aX var8;
      y.f.am var9;
      y.d.c var10;
      if(var4 != null && var5 != null) {
         aX var26 = var3.a(var5);
         y.f.am var7 = var1.a((Object)var5);
         var8 = var3.a(var4);
         var9 = var1.a((Object)var4);
         var10 = var26.a(3);
         y.d.c var11 = var8.a(1);
         double var12 = 0.0D;
         if(var10 != null) {
            double var14 = var7.getY();
            double var16 = var7.getX();
            var12 = Math.max(var12, -var10.c());
            if(var11 == null) {
               return var12;
            }

            var10.b(var14);
            var10.a(var16);
            double var18 = var9.getX();
            double var20 = var9.getY();
            var12 = Math.max(var12, var11.d() - var9.getWidth());
            var11.b(var20);
            var11.a(var18);
            double var22 = var11.c(var10);
            if(var22 != Double.MAX_VALUE) {
               double var24 = var7.getX() - (var9.getX() + var9.getWidth());
               var12 = Math.max(var12, var24 - var22);
            }

            var11.a(-var18);
            var11.b(-var20);
            var10.a(-var16);
            var10.b(-var14);
            if(!N.x) {
               return var12;
            }
         }

         if(var11 != null) {
            var12 = Math.max(var12, var11.d() - var9.getWidth());
         }

         return var12;
      } else {
         double var6 = 0.0D;
         if(var5 != null) {
            var8 = var3.a(var5);
            var1.a((Object)var5);
            var10 = var8.a(3);
            if(var8.i() != null) {
               var6 = Math.max(var6, var8.i().d());
            }

            if(var10 != null) {
               var6 = Math.max(var6, -var10.c());
            }
         }

         if(var4 != null) {
            var8 = var3.a(var4);
            var9 = var1.a((Object)var4);
            var10 = var8.a(1);
            if(var8.i() != null) {
               var6 = Math.max(var6, var8.i().d());
            }

            if(var10 != null) {
               var6 = Math.max(var6, var10.d() - var9.getWidth());
            }
         }

         return var6;
      }
   }

   public void b(y.f.X var1, aU var2, aV var3) {
   }

   public void a(y.f.X var1, aU var2, aV var3) {
   }
}
