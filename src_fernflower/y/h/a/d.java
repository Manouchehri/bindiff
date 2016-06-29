package y.h.a;

import y.h.aB;
import y.h.bu;
import y.h.a.K;
import y.h.a.v;

public class d implements K {
   public void a(y.c.d var1, boolean var2, y.c.q var3, y.c.q var4) {
      y.c.i var5 = var1.a();
      if(var5 != null && var5 instanceof bu) {
         v var6 = v.a(var5);
         boolean var7 = var6.e(var1);
         boolean var8 = var3 != var1.c();
         boolean var9 = var4 != var1.d();
         bu var10 = (bu)var5;
         aB var11 = var10.i(var1);
         var10.a((new y.c.f(var1)).a());
         if(!var7 && var2 && var3 != var4) {
            var11.clearPoints();
         }

         if(var8) {
            var11.setSourcePoint(y.d.t.c);
         }

         if(var9) {
            var11.setTargetPoint(y.d.t.c);
         }
      }

   }
}
