package y.f.e.a;

import y.f.e.a.a;
import y.f.e.a.af;
import y.f.e.a.ax;
import y.f.e.a.c;
import y.f.e.a.k;
import y.f.e.a.l;
import y.f.e.a.m;
import y.f.e.a.w;

final class E implements ax {
   private int a = 1;
   private int b = 1;
   private double c = 1.0D;

   public void a(int var1) {
      this.a = var1;
   }

   public k a(m var1, l var2, a var3) {
      boolean var27 = af.b;
      y.c.q var4 = var1.j();
      k var5 = var1.a();
      m var6 = var1.l();
      var3.a();
      y.c.e var7 = var4.j();

      while(var7.f()) {
         y.c.d var8 = var7.a();
         y.c.q var9 = var8.a(var4);
         if(var9 != var4) {
            label84: {
               w var10 = var2.b();
               m var11 = var10.a(var9);
               double var12 = var10.a(var8).b();
               int var14 = this.a;
               m var15 = var11.l();
               m var10000 = var6;
               m var10001 = var15;

               label73:
               while(var10000 != var10001) {
                  var12 *= this.c;
                  var14 = this.b;
                  if(!var1.k() && !var11.k()) {
                     break;
                  }

                  m var16 = var11.l();

                  while(var16 != null) {
                     var10000 = var16;
                     var10001 = var1;
                     if(var27) {
                        continue label73;
                     }

                     if(var16 == var1) {
                        break label84;
                     }

                     var16 = var16.l();
                     if(var27) {
                        break;
                     }
                  }

                  var16 = var6;

                  while(true) {
                     if(var16 == null) {
                        break label73;
                     }

                     var10000 = var16;
                     var10001 = var11;
                     if(var27) {
                        break;
                     }

                     if(var16 == var11) {
                        break label84;
                     }

                     var16 = var16.l();
                     if(var27) {
                        break label73;
                     }
                  }
               }

               k var28 = var11.a();
               double var17 = var28.d() - var5.d();
               double var19 = var28.e() - var5.e();
               double var21 = var28.f() - var5.f();
               double var23 = Math.sqrt(var17 * var17 + var19 * var19 + var21 * var21);
               if(var23 >= 0.001D) {
                  if(var12 == 0.0D) {
                     var12 = 0.001D;
                  }

                  double var25;
                  switch(var14) {
                  case 1:
                     var25 = 1.0D / var12;
                     if(!var27) {
                        break;
                     }
                  case 2:
                     var25 = var23 / (var12 * var12);
                     if(!var27) {
                        break;
                     }
                  default:
                     var25 = c.a(var23 / var12, this.a) / var23;
                  }

                  var3.a(var17 * var25, var19 * var25, var21 * var25);
               }
            }
         }

         var7.g();
         if(var27) {
            break;
         }
      }

      return var3;
   }
}
