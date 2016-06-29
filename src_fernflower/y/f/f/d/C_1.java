package y.f.f.d;

import y.f.S;
import y.f.U;
import y.f.X;
import y.f.f.d.e;
import y.f.f.d.f;
import y.f.f.d.o;

public class C {
   private e a = null;
   private y.c.A b = null;

   public void a(X var1, int var2) {
      boolean var18 = o.p;
      this.a = new e(var1, var2);
      y.c.c var3 = var1.c(U.b);
      this.b = y.g.M.a();
      if(var3 != null) {
         y.c.x var4 = var1.o();

         do {
            y.c.q var5;
            y.d.y var6;
            label35:
            while(true) {
               if(!var4.f()) {
                  return;
               }

               var5 = var4.e();
               var6 = var1.s(var5);
               S[] var7 = (S[])var3.b(var4.e());
               if(var7 == null || var7.length <= 0) {
                  break;
               }

               int var8 = 0;

               while(true) {
                  if(var8 >= var7.length) {
                     break label35;
                  }

                  S var9 = var7[var8];
                  y.d.y var10 = this.a(var9.a().h(), var1.l(var5));
                  var6 = this.a(var6, var10);
                  ++var8;
                  if(var18) {
                     break;
                  }

                  if(var18) {
                     break label35;
                  }
               }
            }

            y.d.y var19 = var1.s(var5);
            if(!var19.equals(var6)) {
               double var20 = var19.d() - var6.d();
               double var11 = var6.d() + var6.b() - var19.d() - var19.b();
               double var13 = var19.c() - var6.c();
               double var15 = var6.c() + var6.a() - var19.c() - var19.a();
               f var17 = this.a.a(var5, var20, var11, var13, var15);
               this.b.a(var5, var17);
            }

            var4.g();
         } while(!var18);
      }

   }

   public y.c.D a(X var1, y.c.q var2) {
      y.c.D var3;
      y.c.D var10000;
      label42: {
         boolean var20 = o.p;
         var3 = new y.c.D();
         y.c.c var4 = var1.c(U.b);
         y.d.y var5 = var1.s(var2);
         f var6 = this.b != null?(f)this.b.b(var2):null;
         if(var4 == null || var6 == null) {
            var3.add(var5);
            if(!var20) {
               break label42;
            }
         }

         double var7 = (double)var6.a();
         double var9 = (double)var6.b();
         double var11 = (double)var6.c();
         double var13 = (double)var6.d();
         y.d.y var15 = new y.d.y(var5.c() + var11, var5.d() + var7, var5.a() - var11 - var13, var5.b() - var7 - var9);
         var3.add(var15);
         S[] var16 = (S[])var4.b(var2);
         if(var16 != null && var16.length > 0) {
            int var17 = 0;

            while(var17 < var16.length) {
               S var18 = var16[var17];
               y.d.y var19 = this.a(var18.a().h(), this.a(var15));
               var10000 = var3;
               if(var20) {
                  return var10000;
               }

               var3.add(var19);
               ++var17;
               if(var20) {
                  break;
               }
            }
         }
      }

      var10000 = var3;
      return var10000;
   }

   private y.d.t a(y.d.y var1) {
      return new y.d.t(var1.c() + var1.a() * 0.5D, var1.d() + var1.b() * 0.5D);
   }

   private y.d.y a(y.d.y var1, y.d.t var2) {
      return new y.d.y(var2.a + var1.c, var2.b + var1.d, var1.a(), var1.b());
   }

   public void a() {
      if(this.a != null) {
         this.a.a();
      }

      this.a = null;
   }

   private y.d.y a(y.d.y var1, y.d.y var2) {
      double var3 = Math.min(var1.c(), var2.c());
      double var5 = Math.max(var1.c() + var1.a(), var2.c() + var2.a());
      double var7 = Math.min(var1.d(), var2.d());
      double var9 = Math.max(var1.d() + var1.b(), var2.d() + var2.b());
      return new y.d.y(var3, var7, var5 - var3, var9 - var7);
   }
}
