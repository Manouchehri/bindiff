package y.g.a;

import y.c.x;
import y.g.a.d;
import y.g.a.e;
import y.g.a.n;
import y.g.a.o;

public class c implements e {
   private n a;
   private o[] b;
   private y.c.i c;

   public c(y.c.i var1) {
      this.c = var1;
      this.a = new n(var1.f());
      this.b = new o[var1.f()];
   }

   public void a(y.c.q var1, double var2) {
      o var4 = this.a.a(var2, var1);
      if(var1.d() < this.b.length) {
         this.b[var1.d()] = var4;
         if(!d.a) {
            return;
         }
      }

      o[] var5 = new o[Math.max(2 * this.b.length, var1.d() + 1)];
      System.arraycopy(this.b, 0, var5, 0, this.b.length);
      this.b = var5;
      this.b[var1.d()] = var4;
   }

   public void b(y.c.q var1, double var2) {
      o var4 = this.b[var1.d()];
      this.a.a(var4, var2);
   }

   public void c(y.c.q var1, double var2) {
      o var4 = this.b[var1.d()];
      this.a.b(var4, var2);
   }

   public void d(y.c.q var1, double var2) {
      this.a.c(this.b[var1.d()], var2);
   }

   public y.c.q a() {
      o var1 = this.a.b();
      this.a.a(var1);
      y.c.q var2 = (y.c.q)var1.b;
      this.b[var2.d()] = null;
      return var2;
   }

   public boolean a(y.c.q var1) {
      return this.b[var1.d()] != null;
   }

   public boolean b() {
      return this.a.c();
   }

   public void b(y.c.q var1) {
      this.a.a(this.b[var1.d()]);
      this.b[var1.d()] = null;
   }

   public void c() {
      boolean var2 = d.a;
      x var1 = this.c.o();

      c var10000;
      while(true) {
         if(var1.f()) {
            var10000 = this;
            if(var2) {
               break;
            }

            if(this.a(var1.e())) {
               this.b[var1.e().d()] = null;
            }

            var1.g();
            if(!var2) {
               continue;
            }
         }

         var10000 = this;
         break;
      }

      var10000.a.a();
   }
}
