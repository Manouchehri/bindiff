package y.f.f.a;

import y.c.q;
import y.d.u;
import y.f.X;
import y.f.f.a.f;
import y.f.f.a.k;
import y.f.f.a.l;

class m implements y.f.f.a.a.h {
   private final k a;

   private m(k var1) {
      this.a = var1;
   }

   public void a(y.f.f.a.a.e var1) {
      boolean var19 = f.a;
      if(!var1.e()) {
         if(!var1.d()) {
            y.f.f.a.a.b var2 = (y.f.f.a.a.b)var1;
            q var3 = var2.b_();
            k.a(this.a).d(var3);
            double var8 = Double.MAX_VALUE;
            double var10 = -1.7976931348623157E308D;
            double var12 = Double.MAX_VALUE;
            double var14 = -1.7976931348623157E308D;
            y.c.e var16 = k.b(this.a).g(var3).a();

            X var20;
            label58:
            while(true) {
               int var10000 = var16.f();

               label55:
               while(var10000 != 0) {
                  y.c.d var17 = var16.a();
                  var20 = k.a(this.a);
                  if(var19) {
                     break label58;
                  }

                  u var18 = var20.j(var17).b();

                  while(var18.f()) {
                     double var4 = var18.a().a();
                     double var6 = var18.a().b();
                     double var21;
                     var10000 = (var21 = var4 - var8) == 0.0D?0:(var21 < 0.0D?-1:1);
                     if(var19) {
                        continue label55;
                     }

                     if(var10000 < 0) {
                        var8 = var4;
                     }

                     if(var4 > var10) {
                        var10 = var4;
                     }

                     if(var6 < var12) {
                        var12 = var6;
                     }

                     if(var6 > var14) {
                        var14 = var6;
                     }

                     var18.g();
                     if(var19) {
                        break;
                     }
                  }

                  var16.g();
                  if(!var19) {
                     continue label58;
                  }
                  break;
               }

               k.a(this.a).b(var3, var10 - var8, var14 - var12);
               var20 = k.a(this.a);
               break;
            }

            var20.c(var3, var8, var12);
         }
      }
   }

   m(k var1, l var2) {
      this(var1);
   }
}
