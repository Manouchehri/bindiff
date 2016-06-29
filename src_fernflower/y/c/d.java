package y.c;

import y.c.I;
import y.c.i;
import y.c.q;

public class d extends I {
   d a;
   d b;
   d c;
   d d;
   q e;
   q f;
   int g;
   i h;

   protected d(i var1, q var2, d var3, q var4, d var5, int var6, int var7) {
      var1.a(this, var2, var3, var4, var5, var6, var7);
   }

   public d a(i var1, q var2, q var3) {
      return new d(var1, var2, (d)null, var3, (d)null, 0, 0);
   }

   public i a() {
      return this.h;
   }

   public int b() {
      if(this.h.f) {
         this.h.B();
      }

      return this.g;
   }

   public q c() {
      return this.e;
   }

   public q d() {
      return this.f;
   }

   public q a(q var1) {
      return this.e == var1?this.f:this.e;
   }

   public boolean e() {
      return this.f == this.e;
   }

   public String toString() {
      return this.c() + " -> " + this.d();
   }

   protected void f() {
      this.a = this.b = this.c = this.d = null;
   }

   public d g() {
      return this.a;
   }

   public d h() {
      return this.b;
   }

   public d i() {
      return this.c;
   }

   public d j() {
      return this.d;
   }

   void a(i var1, q var2, q var3, int var4) {
      this.a(var4);
      this.h = var1;
      this.e = var2;
      this.f = var3;
   }

   void a(i var1) {
      this.h = var1;
   }
}
