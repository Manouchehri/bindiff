package y.f.i.a;

import y.f.i.a.I;
import y.f.i.a.K;
import y.f.i.a.R;
import y.f.i.a.T;
import y.f.i.a.Z;
import y.f.i.a.ab;

class aC extends K {
   public void a(Z var1, I var2) {
      int var12 = ab.a;
      super.a(var1, var2);
      y.f.X var3 = var1.a();
      y.c.x var4 = var3.o();

      while(var4.f()) {
         y.c.q var5 = var4.e();
         y.d.q var6 = this.a(var3, var5);
         y.d.t var7 = var3.l(var5);
         double var8 = var7.a() - var6.a * 0.5D;
         double var10 = var7.b() - var6.b * 0.5D;
         this.b().a((y.d.y)(new y.d.y(var8, var10, var6.a, var6.b)), (Object)var5);
         var4.g();
         if(var12 != 0) {
            break;
         }
      }

   }

   public void b(R var1) {
      var1.a(T.a, this.b().d(var1));
   }

   protected y.d.q a(y.f.X var1, y.c.q var2) {
      return var1.r(var2);
   }
}
