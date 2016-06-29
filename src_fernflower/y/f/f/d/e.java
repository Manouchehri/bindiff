package y.f.f.d;

import y.f.X;
import y.f.f.d.f;
import y.f.f.d.o;

public class e {
   private X a;
   private int b;
   private y.c.A c;
   private y.c.h d;
   private y.c.h e;
   private y.c.h f;
   private y.c.h g;

   public e(X var1, int var2) {
      this.a = var1;
      this.b = var2;
      this.d = var1.u();
      this.e = var1.u();
      this.f = var1.u();
      this.g = var1.u();
      this.c = var1.t();
      var1.a((Object)"MIN_DIST_DP_KEY", (y.c.c)this.c);
   }

   public f a(y.c.q var1, double var2, double var4, double var6, double var8) {
      if(this.c == null) {
         return null;
      } else {
         f var10 = new f(this, var1, var2, var4, var6, var8);
         this.c.a(var1, var10);
         this.a.a(var1, var10.e());
         return var10;
      }
   }

   private void b() {
      this.a.a((y.c.h)this.d);
      this.a.a((y.c.h)this.e);
      this.a.a((y.c.h)this.f);
      this.a.a((y.c.h)this.g);
      this.a.d_("MIN_DIST_DP_KEY");
      this.a.a((y.c.A)this.c);
   }

   private y.f.f.b.o a(y.c.d var1, boolean var2) {
      y.c.D var3 = this.a.m(var1);
      if(!var2) {
         var3.n();
      }

      y.d.t var4 = (y.d.t)var3.g();
      y.d.t var5 = (y.d.t)var3.g();
      return var4.a() == var5.a()?(var4.b() < var5.b()?y.f.f.b.o.c:y.f.f.b.o.a):(var4.a() < var5.a()?y.f.f.b.o.b:y.f.f.b.o.d);
   }

   public void a() {
      boolean var4 = o.p;
      if(this.c != null) {
         y.c.e var1 = this.a.p();

         e var10000;
         while(true) {
            if(var1.f()) {
               y.c.d var2 = var1.a();
               this.d.a(var2, this.a(var2, true));
               this.e.a(var2, this.a(var2, false));
               this.f.a(var2, this.a.p(var2));
               var10000 = this;
               if(var4) {
                  break;
               }

               this.g.a(var2, this.a.q(var2));
               var1.g();
               if(!var4) {
                  continue;
               }
            }

            var10000 = this;
            break;
         }

         y.c.x var5 = var10000.a.o();

         while(true) {
            if(var5.f()) {
               y.c.q var6 = var5.e();
               f var3 = (f)this.c.b(var6);
               if(var4) {
                  break;
               }

               if(var3 != null) {
                  var3.f();
               }

               var5.g();
               if(!var4) {
                  continue;
               }
            }

            this.b();
            break;
         }

      }
   }

   static int a(e var0) {
      return var0.b;
   }

   static X b(e var0) {
      return var0.a;
   }

   static y.c.h c(e var0) {
      return var0.f;
   }

   static y.c.h d(e var0) {
      return var0.d;
   }

   static y.c.h e(e var0) {
      return var0.g;
   }

   static y.c.h f(e var0) {
      return var0.e;
   }
}
