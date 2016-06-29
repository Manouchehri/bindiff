package y.c;

import y.c.d;
import y.c.e;
import y.c.q;

class s implements e {
   d a;
   private final q b;

   s(q var1) {
      this.b = var1;
      this.a = var1.b;
   }

   public boolean f() {
      return this.a != null;
   }

   public void g() {
      this.a = this.a.b;
   }

   public void h() {
      this.a = this.a.d;
   }

   public void b() {
      this.g();
      if(this.a == null) {
         this.i();
      }

   }

   public void c() {
      this.h();
      if(this.a == null) {
         this.j();
      }

   }

   public void i() {
      this.a = this.b.b;
   }

   public void j() {
      this.a = this.b.e;
   }

   public int k() {
      return this.b.g;
   }

   public Object d() {
      return this.a;
   }

   public d a() {
      return this.a;
   }
}
