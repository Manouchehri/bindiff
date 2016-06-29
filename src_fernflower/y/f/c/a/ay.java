package y.f.c.a;

import y.f.c.a.C;
import y.f.c.a.N;
import y.f.c.a.aV;
import y.f.c.a.ai;

final class ay implements C {
   public void a(y.f.X var1, aV var2) {
      boolean var7 = N.x;
      y.c.e var3 = var1.p();

      while(var3.f()) {
         y.c.d var4 = var3.a();
         int var5 = var2.a(var4.c()).j();
         int var6 = var2.a(var4.d()).j();
         if(var5 > var6) {
            this.a(var1, var2, var4);
         }

         var3.g();
         if(var7) {
            break;
         }
      }

   }

   public void a(y.f.X var1, aV var2, y.c.d var3) {
      label26: {
         boolean var11 = N.x;
         y.f.I var4 = var1.b(var3);
         y.d.t var5 = var4.getSourcePoint();
         y.d.t var6 = var4.getTargetPoint();
         var4.setSourcePoint(var6);
         var4.setTargetPoint(var5);
         if(var4.pointCount() > 0) {
            int var7 = 0;
            int var8 = var4.pointCount() - 1;

            while(var7 < var8) {
               y.d.t var9 = var4.getPoint(var7);
               y.d.t var10 = var4.getPoint(var8);
               var4.setPoint(var7, var10.a, var10.b);
               var4.setPoint(var8, var9.a, var9.b);
               ++var7;
               --var8;
               if(var11) {
                  break label26;
               }

               if(var11) {
                  break;
               }
            }
         }

         var1.c(var3);
      }

      ai var12 = (ai)var2.a(var3);
      var12.b(!var12.i());
   }

   public void b(y.f.X var1, aV var2) {
      boolean var5 = N.x;
      y.c.e var3 = var1.p();

      while(var3.f()) {
         y.c.d var4 = var3.a();
         if(var2.a(var4).i()) {
            this.a(var1, var2, var4);
         }

         var3.g();
         if(var5) {
            break;
         }
      }

   }
}
