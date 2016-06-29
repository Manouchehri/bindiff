package y.f.e.a;

import java.util.HashSet;
import y.f.e.a.af;
import y.f.e.a.as;

class n extends y.f.a {
   public void c(y.f.X var1) {
      boolean var26 = af.b;
      if(this.a() != null) {
         this.a().c(var1);
      }

      y.c.c var2 = var1.c(y.f.b.f.e);
      y.c.c var3 = var1.c(as.a);
      boolean var4 = !y.f.b.c.c((y.c.i)var1);
      if(var4 && var3 != null) {
         y.d.r var5 = new y.d.r(5.0D, 5.0D, 5.0D, 5.0D);
         y.f.b.c var6 = new y.f.b.c(var1);
         y.c.A var7 = var1.t();
         HashSet var8 = new HashSet();
         y.c.y var9 = new y.c.y();
         y.c.x var10 = var1.o();

         y.c.q var12;
         boolean var10000;
         label101:
         do {
            var10000 = var10.f();

            label98:
            while(true) {
               if(!var10000) {
                  break label101;
               }

               y.c.q var11 = var10.e();
               if(var6.d(var11) && var3.d(var11)) {
                  if(!var8.add(var11)) {
                     break;
                  }

                  var9.add(var11);
                  if(!var26) {
                     break;
                  }
               }

               var12 = var6.a(var11);

               while(var12 != var6.b()) {
                  var10000 = var3.d(var12);
                  if(var26) {
                     continue label98;
                  }

                  if(var10000) {
                     break;
                  }

                  var12 = var6.a(var12);
                  if(var26) {
                     break;
                  }
               }

               var7.a(var11, var12);
               break;
            }

            var10.g();
         } while(!var26);

         y.g.J var27 = new y.g.J(var1, var7);
         y.c.x var28 = var9.a();

         label73:
         while(true) {
            var10000 = var28.f();

            label70:
            while(var10000) {
               var12 = var28.e();
               var27.c(var12);
               y.d.r var13 = var5;
               if(var26) {
                  return;
               }

               if(var2 != null) {
                  y.d.r var14 = y.d.r.a(var2.b(var12));
                  if(var14 != null) {
                     var13 = var14;
                  }
               }

               double var29 = var1.m(var12) + var13.b;
               double var16 = var1.n(var12) + var13.a;
               double var18 = var1.p(var12) - var13.b - var13.d;
               double var20 = var1.q(var12) - var13.a - var13.c;
               y.g.I var22 = new y.g.I(var1);
               y.c.c var23 = var1.c(y.f.e.d.n);
               if(var23 != null) {
                  y.c.x var24 = var1.o();

                  while(var24.f()) {
                     y.c.q var25 = var24.e();
                     var10000 = var23.d(var25);
                     if(var26) {
                        continue label70;
                     }

                     if(!var10000) {
                        var22.a(var25);
                     }

                     var24.g();
                     if(var26) {
                        break;
                     }
                  }
               }

               y.f.j.a.a(var1, var29, var16, var18, var20);
               if(var23 != null) {
                  var22.f();
               }

               var28.g();
               if(!var26) {
                  continue label73;
               }
               break;
            }

            var27.b();
            var1.a((y.c.A)var7);
            var6.c();
            return;
         }
      }
   }
}
