package y.g.a;

import y.c.x;
import y.g.a.g;
import y.g.a.p;
import y.g.a.q;

public class d implements g {
   private p b;
   private q[] c;
   private y.c.i d;
   public static boolean a;

   public d(y.c.i var1) {
      this.d = var1;
      this.b = new p(var1.f());
      this.c = new q[var1.f()];
   }

   public void a(y.c.q var1, int var2) {
      q var3 = this.b.a(var2, (Object)var1);
      if(var1.d() < this.c.length) {
         this.c[var1.d()] = var3;
         if(!a) {
            return;
         }
      }

      q[] var4 = new q[Math.max(2 * this.c.length, var1.d() + 1)];
      System.arraycopy(this.c, 0, var4, 0, this.c.length);
      this.c = var4;
      this.c[var1.d()] = var3;
   }

   public void b(y.c.q var1, int var2) {
      q var3 = this.c[var1.d()];
      this.b.a(var3, var2);
   }

   public void c(y.c.q var1, int var2) {
      this.b.c(this.c[var1.d()], var2);
   }

   public y.c.q c() {
      q var1 = this.b.b();
      this.b.a(var1);
      y.c.q var2 = (y.c.q)var1.b;
      this.c[var2.d()] = null;
      return var2;
   }

   public y.c.q b() {
      return (y.c.q)this.b.b().b;
   }

   public int e() {
      return this.b.b().a;
   }

   public boolean a(y.c.q var1) {
      return this.c[var1.d()] != null;
   }

   public boolean a() {
      return this.b.c();
   }

   public int b(y.c.q var1) {
      return this.c[var1.d()].a;
   }

   public void c(y.c.q var1) {
      this.b.a(this.c[var1.d()]);
      this.c[var1.d()] = null;
   }

   public void d() {
      boolean var2 = a;
      x var1 = this.d.o();

      d var10000;
      while(true) {
         if(var1.f()) {
            var10000 = this;
            if(var2) {
               break;
            }

            if(this.a(var1.e())) {
               this.c[var1.e().d()] = null;
            }

            var1.g();
            if(!var2) {
               continue;
            }
         }

         var10000 = this;
         break;
      }

      var10000.b.a();
   }

   public void f() {
   }
}
