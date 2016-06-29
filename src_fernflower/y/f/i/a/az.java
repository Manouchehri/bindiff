package y.f.i.a;

import java.util.ArrayList;
import java.util.List;
import y.f.i.a.I;
import y.f.i.a.K;
import y.f.i.a.N;
import y.f.i.a.R;
import y.f.i.a.T;
import y.f.i.a.Z;
import y.f.i.a.aA;
import y.f.i.a.aB;
import y.f.i.a.ab;

class az extends K {
   public void a(Z var1, I var2) {
      int var10 = ab.a;
      super.a(var1, var2);
      y.f.X var3 = var1.a();
      double var4 = var1.c().l();
      if(var4 > 0.0D) {
         y.c.x var6 = var3.o();

         while(var6.f()) {
            y.c.q var7 = var6.e();
            y.d.y var8 = var3.s(var7);
            y.d.y var9 = new y.d.y(var8.c() - var4, var8.d() - var4, var8.a() + 2.0D * var4, var8.b() + 2.0D * var4);
            this.b().a((y.d.y)var9, (Object)(new aB(var7, (aA)null)));
            var6.g();
            if(var10 != 0) {
               break;
            }
         }
      }

   }

   public void b(R var1) {
      int var9 = ab.a;
      List var2 = this.b().e(var1);
      List var3 = this.b().d(var1);
      ArrayList var4 = new ArrayList();
      int var5 = 0;

      while(true) {
         if(var5 < var2.size()) {
            N var6 = (N)var2.get(var5);
            Object var10000 = var6.b();
            if(var9 != 0) {
               break;
            }

            if(var10000 instanceof aB) {
               y.c.q var7 = aB.a((aB)var6.b());
               boolean var8 = !var3.contains(var7);
               if(var8) {
                  var4.add(var7);
               }
            }

            ++var5;
            if(var9 == 0) {
               continue;
            }
         }

         var1.a(T.b, var4);
         break;
      }

   }
}
