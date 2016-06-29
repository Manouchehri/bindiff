package y.d;

import y.d.m;
import y.d.s;
import y.d.t;
import y.d.u;

class x implements s {
   u a;
   t b = null;

   x(u var1) {
      this.a = var1;
      if(this.a.f()) {
         this.b = this.a.a();
         this.a.g();
      }

   }

   public boolean f() {
      return this.a.f();
   }

   public void g() {
      this.b = this.a.a();
      this.a.g();
   }

   public void h() {
      throw new UnsupportedOperationException();
   }

   public void i() {
      this.a.i();
      if(this.a.f()) {
         this.b = this.a.a();
         this.a.g();
      }

   }

   public void j() {
      this.a.j();
      this.a.h();
      if(this.a.f()) {
         this.b = this.a.a();
         this.a.g();
      }

   }

   public Object d() {
      return this.a();
   }

   public m a() {
      t var1 = this.a.a();
      if(this.b != null && var1 != null) {
         return new m(this.b, var1);
      } else {
         throw new NullPointerException();
      }
   }

   public int k() {
      return this.a.k() < 2?0:this.a.k() - 1;
   }
}
