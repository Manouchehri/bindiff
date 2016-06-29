package y.f;

import y.f.Q;
import y.f.X;

class aW {
   public static Q a(y.c.D var0, y.d.t var1) {
      boolean var12 = X.j;
      Q var2 = null;
      Q var3 = null;
      double var4 = Double.MAX_VALUE;
      double var6 = Double.MAX_VALUE;
      y.c.C var8 = var0.m();

      while(true) {
         if(var8.f()) {
            Q var9 = (Q)var8.d();
            double var10 = y.d.t.a(var1, var9.d().k());
            if(var12) {
               break;
            }

            if(var10 < var4) {
               var4 = var10;
               var2 = var9;
            }

            if(var10 < var6 && y.d.n.a(var9.d(), var1, 0.0D)) {
               var6 = var10;
               var3 = var9;
            }

            var8.g();
            if(!var12) {
               continue;
            }
         }

         if(var3 != null) {
            return var3;
         }
         break;
      }

      return var2;
   }

   public static y.d.n a(y.d.n var0) {
      y.d.t var1 = var0.k();
      y.d.n var2 = new y.d.n(0.0D, 0.0D, var0.e(), var0.f());
      var2.e(var1.a, var1.b);
      return var2;
   }
}
