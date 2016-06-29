package y.f.f.a;

import y.c.q;
import y.c.x;
import y.c.y;
import y.d.r;
import y.f.f.a.f;
import y.f.f.a.g;

class j implements y.f.f.a.a.h {
   private final f a;

   private j(f var1) {
      this.a = var1;
   }

   public void a(y.f.f.a.a.e var1) {
      boolean var20 = f.a;
      if(!var1.e()) {
         if(!var1.d()) {
            y.f.f.a.a.b var2 = (y.f.f.a.a.b)var1;
            q var3 = var2.b_();
            y.c.f var4 = f.a(this.a).b(var3);
            if(var4.size() != 0) {
               new y.c.f();
               y var10 = new y();
               y.c.e var11 = var4.a();
               var11.j();

               y.c.f var13;
               while(var11.f()) {
                  y.c.d var5;
                  y.c.d var6;
                  y.c.d var7;
                  y.c.d var8;
                  label51: {
                     var6 = var11.a();
                     var5 = f.a(this.a).c(var6);
                     var7 = f.a(this.a).i(var6);
                     if(var7.d() == var3) {
                        var8 = var7;
                        var7 = f.a(this.a).c(var7);
                        if(!var20) {
                           break label51;
                        }
                     }

                     var8 = f.a(this.a).c(var7);
                  }

                  q var12 = f.b(this.a).d();
                  f.a(this.a).e(var12);
                  f.b(this.a).a(var6, var12, var6.d());
                  f.b(this.a).a(var7, var12, var7.d());
                  f.b(this.a).a(var5, var5.c(), var12);
                  f.b(this.a).a(var8, var8.c(), var12);
                  var13 = f.a(this.a).a(var12);
                  var13.b(var6);
                  var13.b(var7);
                  var10.b(var12);
                  var11.h();
                  if(var20) {
                     break;
                  }
               }

               r var21 = null;
               if(f.c(this.a) != null) {
                  var21 = r.a(f.c(this.a).b(var3));
               }

               var13 = new y.c.f();
               q var14 = var10.c();
               x var15 = var10.a();

               f var10000;
               while(true) {
                  if(var15.f()) {
                     q var16 = var15.e();
                     y.c.d var17 = f.b(this.a).a(var14, var16);
                     var10000 = this.a;
                     if(var20) {
                        break;
                     }

                     if(f.c(var10000) != null) {
                        f.d(this.a).a(var17, var21);
                     }

                     f.a(this.a).u(var17);
                     f.e(this.a).a(var17, var3);
                     y.c.d var18 = f.a(this.a).k(var17);
                     f.a(this.a).u(var18);
                     f.e(this.a).a(var18, var3);
                     f.a(this.a).c().m(var18);
                     var13.b(var17);
                     y.c.f var19 = f.a(this.a).a(var14);
                     f.a(this.a).a(var14, var19.c(), var17);
                     var19 = f.a(this.a).a(var16);
                     f.a(this.a).a(var16, var19.b(), var18);
                     var14 = var16;
                     var15.g();
                     if(!var20) {
                        continue;
                     }
                  }

                  f.a(this.a).c(var3, var13);
                  var10000 = this.a;
                  break;
               }

               f.b(var10000).c(var3);
            }
         }
      }
   }

   j(f var1, g var2) {
      this(var1);
   }
}
