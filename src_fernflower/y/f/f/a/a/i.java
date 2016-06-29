package y.f.f.a.a;

import y.c.D;
import y.c.q;
import y.c.x;
import y.f.X;
import y.f.f.a.a.b;
import y.f.f.a.a.f;
import y.f.f.a.a.p;

public class i {
   public static p a(X var0) {
      boolean var11 = f.e;
      y.f.b.c var1 = new y.f.b.c(var0);
      p var2 = new p(var0);
      D var3 = new D();
      D var4 = new D();
      var2.a((b)null);
      var4.c((Object)var2.a());
      var3.c((Object)var1.b());

      y.f.b.c var12;
      label43:
      while(true) {
         boolean var10000 = var3.isEmpty();

         label40:
         while(!var10000) {
            q var5 = (q)var3.g();
            b var7 = (b)var4.g();
            x var9 = var1.b(var5).a();

            while(true) {
               if(!var9.f()) {
                  continue label43;
               }

               q var10 = var9.e();
               b var8 = var2.a(var7, (D)null, var10);
               var7.a(var8);
               var12 = var1;
               if(var11) {
                  break label43;
               }

               var10000 = var1.d(var10);
               if(var11) {
                  break;
               }

               if(var10000) {
                  var4.c((Object)var8);
                  var3.c((Object)var10);
               }

               var9.g();
               if(var11) {
                  break label40;
               }
            }
         }

         var12 = var1;
         break;
      }

      var12.c();
      if(y.c.i.g) {
         f.e = !var11;
      }

      return var2;
   }
}
