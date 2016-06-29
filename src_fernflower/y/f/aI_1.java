package y.f;

import y.f.I;
import y.f.X;
import y.f.a;

public class aI extends a {
   private double a = 2.0D;
   private boolean b;

   public void c(X var1) {
      boolean var14 = X.j;
      this.a(var1);
      y.c.e var2 = var1.p();

      while(var2.f()) {
         y.c.d var3 = var2.a();
         I var4 = var1.g(var3);
         if(var4.pointCount() >= 1) {
            y.c.D var5 = new y.c.D();
            var5.add(var1.p(var3));
            int var6 = 0;

            label59: {
               while(var6 < var4.pointCount()) {
                  var5.add(var4.getPoint(var6));
                  ++var6;
                  if(var14) {
                     break label59;
                  }

                  if(var14) {
                     break;
                  }
               }

               var5.add(var1.q(var3));
               var6 = var5.size();
            }

            y.c.p var7 = var5.k();
            y.d.t var8 = (y.d.t)var7.c();
            y.c.p var9 = var7.a();
            y.d.t var10 = (y.d.t)var9.c();
            y.c.p var11 = var9.a();

            int var10000;
            label48: {
               while(var11 != null) {
                  y.d.t var12 = (y.d.t)var11.c();
                  y.c.p var13 = var11.a();
                  var10000 = this.a(var8, var10, var12);
                  if(var14) {
                     break label48;
                  }

                  label73: {
                     if(var10000 != 0) {
                        var5.h(var9);
                        if(!var14) {
                           break label73;
                        }
                     }

                     if(this.a(this.a(var8), this.a(var10), this.a(var12))) {
                        var5.h(var9);
                        if(!var14) {
                           break label73;
                        }
                     }

                     var8 = var10;
                  }

                  var9 = var11;
                  var10 = var12;
                  var11 = var13;
                  if(var14) {
                     break;
                  }
               }

               var10000 = var6;
            }

            if(var10000 != var5.size()) {
               var5.g();
               var5.j();
               var1.b(var3, var5);
            }
         }

         var2.g();
         if(var14) {
            break;
         }
      }

   }

   private boolean a(y.d.t var1, y.d.t var2, y.d.t var3) {
      return y.d.e.d(var1, var2, var3) && (!this.b || this.b(var1, var2, var3));
   }

   private boolean b(y.d.t var1, y.d.t var2, y.d.t var3) {
      return var1.a > var2.a == var2.a > var3.a && var1.b > var2.b == var2.b > var3.b;
   }

   private y.d.t a(y.d.t var1) {
      double var2 = Math.pow(10.0D, this.a);
      double var4 = Math.rint(var1.a() * var2) / var2;
      double var6 = Math.rint(var1.b() * var2) / var2;
      return new y.d.t(var4, var6);
   }
}
