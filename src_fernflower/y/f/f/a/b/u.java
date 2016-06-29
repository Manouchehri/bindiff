package y.f.f.a.b;

import y.f.f.a.b.a;
import y.f.f.a.b.v;
import y.f.f.a.b.y;

public class u {
   private a a;
   private y.c.i b;
   private y.f.f.a.a.p c;
   private y.c.d d = null;

   public u(a var1) {
      this.a = var1;
      this.b = this.a.d();
      this.c = this.a.b();
   }

   public void a(y.c.f var1) {
      boolean var5 = a.c;
      this.c(var1);
      y.c.e var2 = var1.a();

      while(var2.f()) {
         this.d = var2.a();
         if(!this.a.t(this.d) && this.a.A(this.d) >= 1) {
            y.c.f var3 = this.a.d(this.d);
            if(var3 != null) {
               boolean var4 = y.b(this.a, this.d);
               if(var4) {
                  this.b(var3);
                  y.a(this.a, this.d);
               }
            }
         }

         var2.g();
         if(var5) {
            break;
         }
      }

   }

   public void b(y.c.f var1) {
      boolean var3 = a.c;
      y.c.e var2 = var1.a();

      while(var2.f()) {
         this.a(var2.a());
         var2.g();
         if(var3) {
            break;
         }
      }

   }

   public void a(y.c.d var1) {
      boolean var9 = a.c;
      y.c.d var2 = this.a.c(var1);
      this.a.g(var1);
      this.a.h(var1);
      y.c.q var5 = var1.c();
      y.c.q var6 = var1.d();
      y.f.f.a.a.b var7 = this.c.a(var5);
      y.f.f.a.a.b var8 = this.c.a(var6);
      if(var7 == var8.c()) {
         this.a.b(var5, var1);
         this.a.a(var6, var2);
         this.b.a(var1);
         this.b.a(var2);
         if(!this.a.d(var6)) {
            return;
         }

         this.a(var6);
         if(!var9) {
            return;
         }
      }

      if(var8 == var7.c()) {
         this.a.b(var6, var2);
         this.a.a(var5, var1);
         this.b.a(var1);
         this.b.a(var2);
         if(!this.a.d(var5)) {
            return;
         }

         this.a(var5);
         if(!var9) {
            return;
         }
      }

      this.a.a(var6, var2);
      this.a.a(var5, var1);
      this.b.a(var1);
      this.b.a(var2);
      if(this.a.d(var5)) {
         this.a(var5);
      }

      if(this.a.d(var6)) {
         this.a(var6);
      }

   }

   private void a(y.c.q var1) {
      boolean var15 = a.c;
      if(var1.c() == 2) {
         y.c.d var2;
         y.c.d var3;
         y.c.d var5;
         label62: {
            var3 = this.a.a(var1).b();
            if(this.a.a(var3)) {
               var2 = this.a.c(var3);
               var3 = this.a.h(var2);
               var5 = this.a.c(var3);
               if(!var15) {
                  break label62;
               }
            }

            var5 = this.a.c(var3);
            var2 = this.a.g(var3);
            this.a.c(var2);
         }

         y.c.d var6;
         y.c.d var7;
         label67: {
            y.c.d var8 = this.a.e(var2);
            y.c.f var9 = this.a.f(var2);
            this.a.z(var8);
            if(var9.size() == 2) {
               label54: {
                  var6 = var8;
                  var7 = this.a.c(var8);
                  this.b.e(var8);
                  if(var7 != null) {
                     this.b.e(var7);
                     if(!var15) {
                        break label54;
                     }
                  }

                  var7 = this.a.k(var8);
               }

               this.a.b(var8, false);
               if(!var15) {
                  break label67;
               }
            }

            y.c.d var10 = this.a.g(var2);
            y.c.d var11 = this.a.h(var3);
            var6 = this.b.a(var2.c(), var3.d());
            var7 = this.a.k(var6);
            y.c.p var12 = var9.a(var6, this.a.j(var2));
            this.a.a(var6, var12);
            var9.remove(var2);
            var9.remove(var3);
            if(var10 != null) {
               if(this.a.i(var2) == var10) {
                  this.a.c(var6, var10);
               }

               if(this.a.i(var10) == var2) {
                  this.a.c(var10, var6);
               }
            }

            if(var11 != null) {
               if(this.a.i(var3) == var11) {
                  this.a.c(var6, var11);
               }

               if(this.a.i(var11) == var3) {
                  this.a.c(var11, var6);
               }
            }

            this.a.b(var6, var8);
         }

         label68: {
            y.c.q var16 = var6.c();
            y.c.q var17 = var6.d();
            y.f.f.a.a.b var18 = this.c.a(var16);
            y.f.f.a.a.b var13 = this.c.a(var17);
            if(var13 == var18.c()) {
               this.a.c(var16, var2, var6);
               this.a.e(var17, var5, var7);
               if(!var15) {
                  break label68;
               }
            }

            if(var18 == var13.c()) {
               this.a.e(var16, var2, var6);
               this.a.c(var17, var5, var7);
               if(!var15) {
                  break label68;
               }
            }

            this.a.c(var16, var2, var6);
            this.a.c(var17, var5, var7);
         }

         this.a.z(this.d);
         y.f.f.a.a.b var14 = this.c.a(var1);
         this.c.a((y.f.f.a.a.f)var14);
         this.b.a(var1);
      }

   }

   private void c(y.c.f var1) {
      var1.sort(new v(this));
   }

   static a a(u var0) {
      return var0.a;
   }
}
