package y.f.h;

import y.f.h.m;

class S implements m {
   private y.c.e a;
   private boolean b;

   public S(y.c.e var1) {
      this.a = var1;
      this.a.i();
      this.b = this.a.f();
   }

   public void a(y.c.d[] var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Parameter == null");
      } else if(var1.length < 2) {
         throw new IllegalArgumentException("Parameter Array Size < 2");
      } else if(!this.b) {
         throw new RuntimeException("Cursor is not valid");
      } else {
         var1[0] = this.a.a();
         this.a.b();
         var1[1] = this.a.a();
         this.a.c();
      }
   }

   public boolean f() {
      return this.b;
   }

   public void g() {
      this.a.g();
      this.b = this.a.f();
   }

   public void h() {
      this.a.h();
      this.b = this.a.f();
   }

   public void i() {
      this.a.i();
   }

   public void j() {
      this.a.j();
   }

   public Object d() {
      y.c.d[] var1 = new y.c.d[2];
      this.a(var1);
      return var1;
   }

   public int k() {
      return this.a.k();
   }
}
