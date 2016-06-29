package y.f.c.a;

import y.f.c.a.N;
import y.f.c.a.aV;
import y.f.c.a.aX;
import y.f.c.a.aY;

class de {
   public void a(y.f.X var1, aV var2, byte var3, boolean var4) {
      boolean var7 = N.x;
      y.c.x var5 = var1.o();

      while(var5.f()) {
         aY var6 = var2.a(var5.e()).i();
         if(var6 != null && var6.b() == var3 || var6 == null && var4) {
            this.a(var1, var5.e(), var2);
         }

         var5.g();
         if(var7) {
            break;
         }
      }

   }

   public void a(y.f.X var1, y.c.q var2, aV var3) {
      boolean var17 = N.x;
      aX var4 = var3.a(var2);
      if(var4.b() == 0) {
         y.f.S[] var5 = this.a(var1, var2);
         if(var5 != null && var5.length > 0) {
            y.f.am var6 = var1.a((Object)var2);
            double var7 = var6.getX();
            double var9 = var6.getY();
            var6.setLocation(0.0D, 0.0D);
            int var11 = 0;

            while(var11 < var5.length) {
               y.f.S var12 = var5[var11];
               double var13 = var6.getWidth() * 0.5D;
               double var15 = var6.getHeight() * 0.5D;
               this.a(var4, var6, var12.d() + var13, var12.e() + var15, var12.b(), var12.c(), true);
               ++var11;
               if(var17) {
                  return;
               }

               if(var17) {
                  break;
               }
            }

            var6.setLocation(var7, var9);
         }
      }

   }

   protected y.f.S[] a(y.f.X var1, y.c.q var2) {
      y.c.c var3 = var1.c(y.f.U.b);
      return var3 != null?(y.f.S[])var3.b(var2):null;
   }

   public void a(aX var1, y.f.am var2, double var3, double var5, double var7, double var9, boolean var11) {
      y.d.c var12 = var11?var1.a(0, var2):var1.a(0);
      if(var12 != null) {
         var12.a(var3, var3 + var7, var5);
      }

      y.d.c var13 = var11?var1.a(1, var2):var1.a(1);
      if(var13 != null) {
         var13.b(var5, var5 + var9, var3 + var7);
      }

      y.d.c var14 = var11?var1.a(2, var2):var1.a(2);
      if(var14 != null) {
         var14.b(var3, var3 + var7, var5 + var9);
      }

      y.d.c var15 = var11?var1.a(3, var2):var1.a(3);
      if(var15 != null) {
         var15.a(var5, var5 + var9, var3);
      }

   }
}
