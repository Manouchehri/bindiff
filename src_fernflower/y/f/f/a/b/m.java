package y.f.f.a.b;

import y.f.f.a.b.a;

public class m {
   private a a;
   private y.c.i b;
   private y.f.f.a.a.p c;

   public m(a var1) {
      this.a = var1;
      this.b = this.a.d();
      this.c = this.a.b();
   }

   public static y.c.f a(a var0) {
      m var1 = new m(var0);
      return var1.a();
   }

   public y.c.f a() {
      boolean var4 = a.c;
      y.c.f var1 = new y.c.f();
      this.a.g();
      y.c.d[] var2 = this.b.n();
      int var3 = 0;

      y.c.f var10000;
      while(true) {
         if(var3 < var2.length) {
            var10000 = this.a(var2[var3]);
            if(var4) {
               break;
            }

            if(var10000 != null) {
               var1.add(var2[var3]);
            }

            ++var3;
            if(!var4) {
               continue;
            }
         }

         this.a.h();
         var10000 = var1;
         break;
      }

      return var10000;
   }

   public y.c.f a(y.c.d var1) {
      boolean var13 = a.c;
      if(!this.b.f(var1)) {
         return null;
      } else {
         if(this.a.a(var1)) {
            var1 = this.a.c(var1);
         }

         y.c.d var2 = this.a.c(var1);
         y.c.f var3 = null;
         y.f.f.a.a.b var4 = this.c.a(var1.c());
         y.f.f.a.a.b var5 = this.c.a(var1.d());
         if(y.f.f.a.a.n.a(var4, var5)) {
            return null;
         } else {
            y.c.D var6 = new y.c.D();
            var3 = new y.c.f();
            this.a.a(var1, var3);

            while(var5.b() > var4.b()) {
               var6.c((Object)var5);
               var5 = (y.f.f.a.a.b)var5.c();
               if(var13) {
                  break;
               }
            }

            y.c.d var7 = null;
            Object var8 = null;
            y.c.d var9 = null;

            y.c.d var11;
            y.c.p var12;
            while(true) {
               if(!y.f.f.a.a.n.a(var4, var5)) {
                  y.f.f.a.a.b var10 = (y.f.f.a.a.b)var4.c();
                  var11 = this.b.a(var4.b_(), var10.b_());
                  this.a.k(var11);
                  y.c.p var10000 = var3.b(var11);
                  if(var13) {
                     break;
                  }

                  var12 = var10000;
                  this.a.a(var11, var12);
                  this.a.b(var11, var1);
                  if(var7 != null) {
                     this.a.c(var7, var11);
                  }

                  if(var4.b() == var5.b()) {
                     var6.c((Object)var5);
                     var5 = (y.f.f.a.a.b)var5.c();
                  }

                  var7 = var11;
                  var4 = var10;
                  if(!var13) {
                     continue;
                  }
               }

               var6.c((Object)var5);
               break;
            }

            while(true) {
               if(!var6.isEmpty()) {
                  var5 = (y.f.f.a.a.b)var6.g();
                  var11 = this.b.a(var4.b_(), var5.b_());
                  this.a.k(var11);
                  var12 = var3.b(var11);
                  this.a.a(var11, var12);
                  this.a.b(var11, var1);
                  this.a.c(var11, var9);
                  if(var13) {
                     break;
                  }

                  if(var7 != null && var9 == null) {
                     this.a.c(var7, var11);
                  }

                  var9 = var11;
                  var7 = var11;
                  var4 = var5;
                  if(!var13) {
                     continue;
                  }
               }

               this.a.c(var1.c(), var1, var3.b());
               this.a.c(var1.d(), var2, this.a.c(var3.c()));
               this.b.d(var1);
               this.b.d(var2);
               break;
            }

            return var3;
         }
      }
   }
}
