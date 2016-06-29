package y.f.e;

import y.f.X;
import y.f.e.i;
import y.f.e.q;
import y.f.e.s;
import y.g.I;
import y.g.M;

class y {
   private X a;
   private y.g.r b;
   private y.c.q[] c;
   private final q d;

   public y(q var1, X var2) {
      this.d = var1;
      this.b = null;
      this.c = null;
      this.a = var2;
   }

   public void a(y.c.A var1) {
      boolean var15 = i.b;
      y.c.y var2 = new y.c.y();
      y.c.y var3 = new y.c.y();
      y.c.A var4 = M.a();
      y.c.A var5 = M.a();
      y.c.A var6 = M.a();
      y.f.b.c var7 = new y.f.b.c(this.a);
      y.c.x var8 = this.a.o();

      while(var8.f()) {
         y.c.q var9 = var8.e();
         var5.a(var9, -1);
         if(var1 == null || var1.d(var9)) {
            var2.add(var9);
         }

         var4.a(var9, var7.d(var9));
         var6.a(var9, var7.a(var9));
         if(var7.d(var9) && var7.a(var9) == var7.b()) {
            var3.add(var9);
         }

         var8.g();
         if(var15) {
            y.c.i.g = !y.c.i.g;
            break;
         }
      }

      y.c.f var16 = new y.c.f();
      y.c.x var17 = var3.a();

      y.c.q var10000;
      y.f.b.c var28;
      label144:
      while(true) {
         if(var17.f()) {
            var10000 = var17.e();

            label139:
            while(true) {
               y.c.q var10 = var10000;
               var28 = var7;
               if(var15) {
                  break label144;
               }

               y.c.e var11 = var7.f(var10).a();

               while(true) {
                  if(!var11.f()) {
                     break label139;
                  }

                  y.c.d var12 = var11.a();
                  var10000 = var12.d();
                  if(var15) {
                     break;
                  }

                  if(var10000 != var10) {
                     var16.add(this.a.a((y.c.q)var12.c(), (y.c.q)var10));
                  }

                  var11.g();
                  if(var15) {
                     break label139;
                  }
               }
            }

            var17.g();
            if(!var15) {
               continue;
            }
         }

         var7.c();
         var28 = new y.f.b.c(this.a);
         break;
      }

      y.f.b.c var18 = var28;
      y.c.x var19 = var3.a();

      y.c.e var24;
      while(var19.f()) {
         var10000 = var19.e();

         label119:
         while(true) {
            y.c.q var21 = var10000;
            var24 = var18.g(var21).a();

            while(true) {
               if(!var24.f()) {
                  break label119;
               }

               y.c.d var13 = var24.a();
               var10000 = var13.c();
               if(var15) {
                  break;
               }

               if(var10000 != var21) {
                  var16.add(this.a.a((y.c.q)var21, (y.c.q)var13.d()));
               }

               var24.g();
               if(var15) {
                  break label119;
               }
            }
         }

         var19.g();
         if(var15) {
            break;
         }
      }

      I var20 = new I(this.a);
      y.c.x var22 = var3.a();

      while(true) {
         if(var22.f()) {
            var20.a(var18.c(var22.e()));
            var22.g();
            if(var15) {
               break;
            }

            if(!var15) {
               continue;
            }
         }

         var18.c();
         var20.d();
         break;
      }

      int var23 = y.a.j.a(this.a, var5, q.a(this.d), 0, Integer.MAX_VALUE, false);
      var20.f();
      var24 = var16.a();

      while(true) {
         if(var24.f()) {
            this.a.a((y.c.d)var24.a());
            var24.g();
            if(var15) {
               break;
            }

            if(!var15) {
               continue;
            }
         }

         this.c = new y.c.q[var23];
         this.b = new y.g.r(this.a);
         break;
      }

      int var25 = 0;

      while(true) {
         if(var25 < this.c.length) {
            this.c[var25] = this.a.d();
            this.a.b(this.c[var25], 1.0D, 1.0D);
            var4.a(this.c[var25], true);
            var1.a(this.c[var25], true);
            ++var25;
            if(var15) {
               break;
            }

            if(!var15) {
               continue;
            }
         }

         this.b.a(y.f.b.f.d, var4);
         break;
      }

      y.c.x var27 = var2.a();

      while(true) {
         if(var27.f()) {
            y.c.q var26 = var27.e();
            int var14 = var5.a(var26);
            if(var15) {
               break;
            }

            if(var14 >= 0) {
               var6.a(var26, this.c[var14]);
            }

            var27.g();
            if(!var15) {
               continue;
            }
         }

         this.b.a(y.f.b.f.c, var6);
         this.b.a(y.f.b.f.b, new s(this));
         this.b.a(q.n, var1);
         break;
      }

   }

   public void a() {
      boolean var2 = i.b;
      if(this.c != null) {
         int var1 = 0;

         while(var1 < this.c.length) {
            this.a.a((y.c.q)this.c[var1]);
            ++var1;
            if(var2) {
               return;
            }

            if(var2) {
               break;
            }
         }
      }

      if(this.b != null) {
         this.b.a();
      }

   }
}
