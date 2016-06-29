package y.f.e.a;

import y.f.e.a.a;
import y.f.e.a.af;
import y.f.e.a.ax;
import y.f.e.a.c;
import y.f.e.a.k;
import y.f.e.a.l;
import y.f.e.a.m;
import y.f.e.a.w;

class ae implements ax {
   private int a = 1;

   public void a(int var1) {
      this.a = var1;
   }

   public k a(m var1, l var2, a var3) {
      boolean var24 = af.b;
      y.c.q var4 = var1.j();
      k var5 = var1.a();
      var3.a();
      y.c.e var6 = var4.j();

      while(var6.f()) {
         y.c.d var7 = var6.a();
         y.c.q var8 = var7.a(var4);
         if(var8 != var4) {
            w var9 = var2.b();
            m var10 = var9.a(var8);
            double var11 = var9.a(var7).b();
            k var13 = var10.a();
            double var14 = var13.d() - var5.d();
            double var16 = var13.e() - var5.e();
            double var18 = var13.f() - var5.f();
            double var20 = Math.sqrt(var14 * var14 + var16 * var16 + var18 * var18);
            if(var20 >= 0.001D) {
               if(var11 == 0.0D) {
                  var11 = 0.001D;
               }

               double var22;
               switch(this.a) {
               case 1:
                  var22 = 1.0D / var11;
                  if(!var24) {
                     break;
                  }
               case 2:
                  var22 = var20 / (var11 * var11);
                  if(!var24) {
                     break;
                  }
               default:
                  var22 = c.a(var20 / var11, this.a) / var20;
               }

               var3.a(var14 * var22, var16 * var22, var18 * var22);
            }
         }

         var6.g();
         if(var24) {
            break;
         }
      }

      return var3;
   }
}
