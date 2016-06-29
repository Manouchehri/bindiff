package y.f.d;

import y.f.Q;
import y.f.d.a;
import y.f.d.g;
import y.f.d.h;
import y.f.d.i;
import y.f.d.r;

public class f extends i {
   private y.c.A q;

   private y.c.y e(r[] var1) {
      int var14 = a.f;
      this.q = this.i.t();
      y.c.x var2 = this.i.o();

      while(var2.f()) {
         Q var3 = (Q)this.n.b(var2.e());
         this.q.a(var2.e(), this.a((Q)var3));
         var2.g();
         if(var14 != 0) {
            break;
         }
      }

      y.c.y var15 = new y.c.y();
      boolean[] var16 = new boolean[var1.length];
      g var4 = new g(this);
      var4.a(new y.c.y(this.i.o()));
      boolean[] var5 = new boolean[this.i.f()];

      label53:
      while(true) {
         boolean var10000 = var4.a();

         label50:
         while(!var10000) {
            y.c.q var6 = var4.b();
            if(var14 != 0) {
               return var15;
            }

            if(!var16[this.p.a(var6)]) {
               var15.add(var6);
               var16[this.p.a(var6)] = true;
               y.c.e var7 = var6.j();

               while(var7.f()) {
                  y.c.d var8 = var7.a();
                  y.c.q var9 = var8.a(var6);
                  var10000 = var5[var9.d()];
                  if(var14 != 0) {
                     continue label50;
                  }

                  if(!var10000 && !var16[this.p.a(var9)]) {
                     label69: {
                        double var10 = this.q.c(var9);
                        double var12 = var10 - this.g.c(var8) * this.f();
                        if(var12 < -100.0D) {
                           var4.b(var9);
                           var5[var9.d()] = true;
                           if(var14 == 0) {
                              break label69;
                           }
                        }

                        var4.a(var9, var12);
                     }
                  }

                  var7.g();
                  if(var14 != 0) {
                     break;
                  }
               }
            }

            var5[var6.d()] = true;
            if(var14 == 0) {
               continue label53;
            }
            break;
         }

         this.i.a(this.q);
         return var15;
      }
   }

   y.c.y a(r[] var1) {
      int var9 = a.f;
      if(this.c() != 4) {
         return this.e(var1);
      } else {
         this.q = this.e();
         y.c.y var2 = new y.c.y(this.i.o());
         var2.sort(new h(this, var1));
         y.c.y var3 = new y.c.y();
         boolean[] var4 = new boolean[var1.length];
         boolean[] var5 = new boolean[this.i.f()];
         y.c.x var6 = var2.a();

         while(var6.f()) {
            label33: {
               y.c.q var7 = var6.e();
               if(!var5[var7.d()] && !var4[this.p.a(var7)]) {
                  var3.add(var7);
                  var4[this.p.a(var7)] = true;
                  y.c.x var8 = var7.m();

                  while(var8.f()) {
                     var5[var8.e().d()] = true;
                     var8.g();
                     if(var9 != 0) {
                        break label33;
                     }

                     if(var9 != 0) {
                        break;
                     }
                  }
               }

               var6.g();
            }

            if(var9 != 0) {
               break;
            }
         }

         return var3;
      }
   }

   static y.c.A a(f var0) {
      return var0.q;
   }
}
