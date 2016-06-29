package y.f.c.a;

import y.f.c.a.A;
import y.f.c.a.N;
import y.f.c.a.aV;
import y.f.c.a.bz;

class bF {
   private y.c.d a;
   private y.f.aE b;
   private y.f.aE c;
   private y.f.X d;
   private boolean e;

   private bF(y.c.d var1, y.f.X var2, aV var3, boolean var4) {
      this.a = var1;
      this.d = var2;
      A var5 = var3.a(var1);
      this.b = var4?var5.e():var5.c();
      this.c = var4?var5.c():var5.e();
      this.e = var4;
   }

   public y.c.q a() {
      return this.e?this.a.d():this.a.c();
   }

   public y.c.q b() {
      return !this.e?this.a.d():this.a.c();
   }

   public y.f.aE c() {
      return this.b;
   }

   public y.f.aE d() {
      return this.c;
   }

   public boolean a(y.c.d var1) {
      return this.a.equals(var1);
   }

   public y.d.t e() {
      return this.e?this.d.q(this.a):this.d.p(this.a);
   }

   public void a(y.d.t var1) {
      if(this.e) {
         this.d.d(this.a, var1);
         if(!N.x) {
            return;
         }
      }

      this.d.c(this.a, var1);
   }

   public y.d.t f() {
      return !this.e?this.d.q(this.a):this.d.p(this.a);
   }

   public void b(y.d.t var1) {
      if(!this.e) {
         this.d.d(this.a, var1);
         if(!N.x) {
            return;
         }
      }

      this.d.c(this.a, var1);
   }

   public y.d.t g() {
      return this.e?this.d.o(this.a):this.d.n(this.a);
   }

   public void c(y.d.t var1) {
      if(this.e) {
         this.d.b(this.a, var1);
         if(!N.x) {
            return;
         }
      }

      this.d.a(this.a, var1);
   }

   public y.d.t h() {
      return !this.e?this.d.o(this.a):this.d.n(this.a);
   }

   public void d(y.d.t var1) {
      if(!this.e) {
         this.d.b(this.a, var1);
         if(!N.x) {
            return;
         }
      }

      this.d.a(this.a, var1);
   }

   bF(y.c.d var1, y.f.X var2, aV var3, boolean var4, bz var5) {
      this(var1, var2, var3, var4);
   }
}
