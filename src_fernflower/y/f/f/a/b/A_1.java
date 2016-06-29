package y.f.f.a.b;

import y.f.f.a.b.B;
import y.f.f.a.b.C;
import y.f.f.a.b.D;
import y.f.f.a.b.a;

public class A extends D {
   private y.c.q e;
   private y.c.q f;
   private y.c.f g;
   private y.c.h h;

   public A(a var1) {
      super(var1);
      this.h = this.c.u();
      this.b();
      this.e = this.c.d();
      this.f = this.c.d();
      this.g = new y.c.f();
   }

   public void a() {
      this.c();
      this.c.a(this.e);
      this.c.a(this.f);
      this.c.a(this.h);
      super.a();
   }

   public y.c.f a(y.c.q var1, y.c.q var2) {
      y.c.f var3 = null;
      this.c();
      this.b(var1, var2);
      var3 = y.a.v.a(this.c, this.e, this.f, true, y.a.v.a(this.c));
      return var3;
   }

   public double a(y.c.d var1, y.c.f var2) {
      boolean var8 = a.c;
      y.c.f var3 = this.a.d(var1);
      this.c();
      this.b(var1.c(), var1.d());
      double[] var4 = y.a.v.a(this.c);
      y.c.e var5 = var3.a();

      A var10000;
      while(true) {
         if(var5.f()) {
            y.c.d var6 = var5.a();
            var10000 = this;
            if(var8) {
               break;
            }

            y.c.d var7 = this.e(var6);
            var4[var7.b()] = 0.0D;
            var5.g();
            if(!var8) {
               continue;
            }
         }

         var10000 = this;
         break;
      }

      y.c.d[] var9 = new y.c.d[var10000.c.e()];
      double var10 = y.a.v.a(this.c, this.e, this.f, true, var4, var9);
      var2.addAll(y.a.v.a(this.e, this.f, var9));
      return var10;
   }

   private void b(y.c.q var1, y.c.q var2) {
      boolean var7 = a.c;
      y.c.e var3 = this.a.a(var1).a();

      y.c.d var4;
      y.c.q var5;
      y.c.d var6;
      while(true) {
         if(var3.f()) {
            var4 = var3.a();
            var5 = this.a(this.a.b(var4));
            var6 = this.c.a(this.e, var5);
            this.a((y.c.d)var6, 0);
            this.f(var6);
            var3.g();
            if(var7) {
               break;
            }

            if(!var7) {
               continue;
            }
         }

         var3 = this.a.a(var2).a();
         break;
      }

      A var10000;
      while(true) {
         if(var3.f()) {
            var4 = var3.a();
            var5 = this.a(this.a.b(var4));
            var6 = this.c.a(var5, this.f);
            this.a((y.c.d)var6, 1);
            var10000 = this;
            if(var7) {
               break;
            }

            this.f(var6);
            var3.g();
            if(!var7) {
               continue;
            }
         }

         var10000 = this;
         break;
      }

      y.f.f.a.a.b var8 = var10000.d.a(var1);
      Object var10 = this.d.a(var2);
      y.f.f.a.a.e var11 = y.f.f.a.a.n.c(var8, (y.f.f.a.a.e)var10);
      y.f.f.a.a.e var9 = var8.c();

      while(true) {
         if(var9 != var11) {
            this.a((y.c.q)((y.f.f.a.a.b)var9).b_(), 3);
            var9 = var9.c();
            if(var7) {
               break;
            }

            if(!var7) {
               continue;
            }
         }

         var10 = ((y.f.f.a.a.e)var10).c();
         break;
      }

      while(var10 != var11) {
         this.a((y.c.q)((y.f.f.a.a.b)var10).b_(), 4);
         var10 = ((y.f.f.a.a.e)var10).c();
         if(var7) {
            break;
         }
      }

   }

   public void a(y.c.q var1, int var2) {
      boolean var12 = a.c;
      y.c.f var3 = this.a.b(var1);
      y.c.e var11 = var3.a();

      while(var11.f()) {
         y.c.d var4 = var11.a();
         y.f.h.p var8 = this.a.b(var4);
         y.c.q var6 = this.a(var8);
         y.c.d var5 = this.a.i(var4);
         if(var5.c() == var1) {
            var5 = this.a.c(var5);
         }

         label21: {
            y.f.h.p var9 = this.a.b(var5);
            y.c.q var7 = this.a(var9);
            y.c.d var10;
            if(var2 == 3) {
               var10 = this.c.a(var6, var7);
               this.a(var10, var1);
               this.a((y.c.d)var10, 3);
               this.f(var10);
               if(!var12) {
                  break label21;
               }
            }

            var10 = this.c.a(var7, var6);
            this.a(var10, var1);
            this.a((y.c.d)var10, 4);
            this.f(var10);
         }

         var11.g();
         if(var12) {
            break;
         }
      }

   }

   private void c() {
      boolean var2 = a.c;
      y.c.e var1 = this.g.a();

      A var10000;
      while(true) {
         if(var1.f()) {
            var10000 = this;
            if(var2) {
               break;
            }

            if(this.c.f(var1.a())) {
               this.c.a(var1.a());
            }

            var1.g();
            if(!var2) {
               continue;
            }
         }

         var10000 = this;
         break;
      }

      var10000.g.clear();
   }

   private void f(y.c.d var1) {
      this.g.add(var1);
   }

   public void a(y.f.h.p var1, y.f.h.p[] var2) {
      boolean var15 = a.c;
      y.c.q var3 = this.a(var1);
      y.c.e var4 = var1.a();

      byte var10000;
      while(true) {
         if(var4.f()) {
            y.c.d var5 = var4.a();
            y.c.d var6 = this.a.c(var5);
            y.c.d var7 = this.e(var5);
            y.c.d var8 = this.e(var6);
            var10000 = this.c.f(var7);
            if(var15) {
               break;
            }

            if(var10000 != 0) {
               this.c.a(var7);
            }

            if(this.c.f(var8)) {
               this.c.a(var8);
            }

            var4.g();
            if(!var15) {
               continue;
            }
         }

         this.c.a(var3);
         var10000 = 0;
         break;
      }

      int var16 = var10000;

      A var24;
      while(true) {
         if(var16 < var2.length) {
            y.f.h.p var18 = var2[var16];
            y.c.q var20 = this.c.d();
            var24 = this;
            if(var15) {
               break;
            }

            this.a((y.f.h.p)var18, (y.c.q)var20);
            ++var16;
            if(!var15) {
               continue;
            }
         }

         var24 = this;
         break;
      }

      boolean[] var17 = new boolean[var24.b.g()];
      int var19 = 0;

      do {
         int var25 = var19;

         label44:
         while(true) {
            if(var25 >= var2.length) {
               return;
            }

            y.f.h.p var21 = var2[var19];
            y.c.q var22 = this.a(var21);
            y.c.e var23 = var21.a();

            while(true) {
               if(!var23.f()) {
                  break label44;
               }

               y.c.d var9 = var23.a();
               y.c.d var10 = this.a.c(var9);
               y.f.h.p var11 = this.a.b(var10);
               y.c.q var12 = this.a(var11);
               var25 = var17[var9.b()];
               if(var15) {
                  break;
               }

               if(var25 == 0) {
                  y.c.d var13 = this.c.a(var22, var12);
                  this.a((y.c.d)var9, (y.c.d)var13);
                  var17[var9.b()] = true;
                  y.c.d var14 = this.c.a(var12, var22);
                  this.a((y.c.d)var10, (y.c.d)var14);
                  var17[var10.b()] = true;
               }

               var23.g();
               if(var15) {
                  break label44;
               }
            }
         }

         ++var19;
      } while(!var15);

   }

   public void a(y.c.d var1, int var2) {
      this.g(var1).a = var2;
   }

   public int a(y.c.d var1) {
      return this.d(var1) != null?2:this.g(var1).a;
   }

   public void a(y.c.d var1, y.c.q var2) {
      this.g(var1).b = var2;
   }

   public y.c.q b(y.c.d var1) {
      return this.g(var1).b;
   }

   public y.c.d c(y.c.d var1) {
      return this.d(var1);
   }

   private C g(y.c.d var1) {
      C var2 = (C)this.h.b(var1);
      if(var2 == null) {
         var2 = this.d();
         this.h.a(var1, var2);
      }

      return var2;
   }

   private C d() {
      return new C((B)null);
   }
}
