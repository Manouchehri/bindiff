package y.h;

import y.h.fj;
import y.h.hV;
import y.h.hY;

class hX implements y.f.ah {
   private final y.f.i.i a;

   hX(y.f.i.i var1) {
      this.a = var1;
   }

   public void c(y.f.X var1) {
      boolean var5 = fj.z;
      y.c.c var2 = var1.c(hV.d);
      var1.a((Object)hV.e, (y.c.c)(new hY(this, var2)));
      this.a.c(var1);
      var1.d_(hV.e);
      y.c.e var3 = var1.p();

      while(var3.f()) {
         y.c.d var4 = var3.a();
         if(var2.b(var4) == hV.a) {
            y.f.ae.a(var1, var4);
         }

         var3.g();
         if(var5) {
            break;
         }
      }

   }
}
