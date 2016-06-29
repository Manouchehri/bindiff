package y.f.h.a;

import y.c.D;
import y.f.h.a.r;

class m {
   private D a = null;
   private r b;
   private r c;
   private boolean d = false;
   private int e = 1;

   m(r var1, r var2, y.c.d var3) {
      this.a = new D();
      this.a.add(var3);
      this.b = var1;
      this.c = var2;
   }

   m(r var1, r var2) {
      this.b = var1;
      this.c = var2;
   }

   public String toString() {
      String var1 = this.b.a() + "->" + this.c.a();
      if(this.e < 0) {
         var1 = "-" + var1;
      }

      if(this.b()) {
         var1 = var1 + "*";
      }

      if(!this.k()) {
         var1 = var1 + " (ne)";
      }

      return var1;
   }

   D d() {
      return this.a;
   }

   boolean b() {
      return this.a == null;
   }

   boolean c() {
      return this.a != null && !this.d;
   }

   r a(r var1) {
      if(this.b.g()) {
         this.b = this.b.b();
      }

      if(this.b == var1) {
         return this.c;
      } else if(this.c == var1) {
         return this.b;
      } else {
         throw new RuntimeException("The edge " + this.toString() + " is not connected to the node " + var1.toString() + "!");
      }
   }

   void b(r var1) {
      this.b = var1;
   }

   r e() {
      if(this.b.g()) {
         this.b = this.b.b();
      }

      return this.b;
   }

   r f() {
      return this.c;
   }

   void g() {
      this.e *= -1;
   }

   int h() {
      return this.e;
   }

   void a(y.c.d var1) {
      this.a.add(var1);
   }

   y.c.d i() {
      return (y.c.d)this.a.f();
   }

   void j() {
      this.d = true;
   }

   boolean k() {
      return this.d;
   }

   int a() {
      return 1;
   }
}
