package y.f.h.a;

import y.f.h.a.h;
import y.f.h.a.n;
import y.f.h.a.r;

class i extends r {
   private n b;
   private n c;
   private h d;
   private boolean e = false;

   i(n var1, n var2) {
      this.b = var1;
      this.c = var2;
   }

   public String toString() {
      return this.a != null?this.f() + "^" + this.c.f() + ": " + this.a.toString():this.f() + "^" + this.c.f();
   }

   String a() {
      return this.f() + "^" + this.c.f();
   }

   n b() {
      return this.b;
   }

   n c() {
      return this.c;
   }

   void d() {
      this.a.c();
      if(this.c != null) {
         this.c.j().g();
      }

   }

   void e() {
      this.e = true;
      if(this.d != null) {
         this.d.b();
      }

      this.d = null;
   }

   void a(h var1) {
      this.d = var1;
   }

   int f() {
      return this.b.f();
   }

   boolean a(int var1) {
      return this.c.l() < var1;
   }

   boolean b(int var1) {
      return this.c.l() == var1;
   }

   boolean g() {
      return this.e;
   }
}
