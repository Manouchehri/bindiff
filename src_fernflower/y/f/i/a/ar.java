package y.f.i.a;

import java.util.Iterator;
import y.f.i.a.I;
import y.f.i.a.K;
import y.f.i.a.N;
import y.f.i.a.R;
import y.f.i.a.T;
import y.f.i.a.Z;
import y.f.i.a.ab;
import y.f.i.a.as;
import y.f.i.a.at;
import y.f.i.a.au;

class ar extends K {
   public void a(Z var1, I var2) {
      int var23 = ab.a;
      super.a(var1, var2);
      y.f.c.a.bk var3 = y.f.c.a.bk.c(var1.a());
      if(var3 != null) {
         y.c.D var4 = var3.f();
         y.c.D var5 = var3.e();
         var4.sort(new as(this));
         var5.sort(new at(this));
         y.f.c.a.l var6 = null;
         int var7 = 0;
         int var8 = 0;
         Iterator var9 = var4.iterator();

         while(var9.hasNext()) {
            Object var10000 = var9.next();

            y.f.c.a.l var10;
            double var11;
            double var13;
            label37:
            while(true) {
               var10 = (y.f.c.a.l)var10000;
               var11 = var6 != null?var6.h() + var6.e():var10.g();
               var13 = var10.f();
               y.f.c.a.bt var15 = null;
               Iterator var16 = var5.iterator();

               while(true) {
                  if(!var16.hasNext()) {
                     break label37;
                  }

                  y.f.c.a.bt var17 = (y.f.c.a.bt)var16.next();
                  var10000 = var15;
                  if(var23 != 0) {
                     break;
                  }

                  double var18 = var15 != null?var15.h() + var15.e():var17.f();
                  double var20 = var17.g();
                  y.f.c.a.bh var22 = var3.a(var17, var10);
                  this.b().a((y.d.y)(new y.d.y(var11, var18, var13, var20)), (Object)(new au(var22, var8, var7, (as)null)));
                  var17.g(var18);
                  var17.d(var20);
                  var15 = var17;
                  ++var7;
                  if(var23 != 0) {
                     break label37;
                  }
               }
            }

            var10.g(var11);
            var10.d(var13);
            var6 = var10;
            ++var8;
            var7 = 0;
            if(var23 != 0) {
               break;
            }
         }
      }

   }

   public void b(R var1) {
      int var5 = ab.a;
      Iterator var2 = this.b().e(var1).iterator();

      while(var2.hasNext()) {
         N var3 = (N)var2.next();
         if(var3.b() instanceof au) {
            au var4 = (au)var3.b();
            var1.a(T.e, au.a(var4));
            var1.a(T.f, new Integer(au.b(var4)));
            var1.a(T.g, new Integer(au.c(var4)));
            if(var5 != 0) {
               break;
            }
         }
      }

   }
}
