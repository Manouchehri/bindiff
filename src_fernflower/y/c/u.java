package y.c;

import y.c.D;
import y.c.d;
import y.c.e;
import y.c.q;

class u implements e {
   boolean a;
   d b;
   private final q c;

   u(q var1) {
      this.c = var1;
      this.i();
   }

   public void g() {
      if(!this.a) {
         this.b = this.b.a;
         if(this.b != null) {
            return;
         }

         this.b = this.c.b;
         this.a = true;
         if(!D.e) {
            return;
         }
      }

      this.b = this.b.b;
   }

   public void h() {
      if(this.a) {
         this.b = this.b.d;
         if(this.b != null) {
            return;
         }

         this.b = this.c.d;
         this.a = false;
         if(!D.e) {
            return;
         }
      }

      this.b = this.b.c;
   }

   public void i() {
      this.b = this.c.c;
      if(this.b == null) {
         this.b = this.c.b;
         this.a = true;
         if(!D.e) {
            return;
         }
      }

      this.a = false;
   }

   public void j() {
      this.b = this.c.e;
      if(this.b == null) {
         this.b = this.c.d;
         this.a = false;
         if(!D.e) {
            return;
         }
      }

      this.a = true;
   }

   public boolean f() {
      return this.b != null;
   }

   public void b() {
      this.g();
      if(!this.f()) {
         this.i();
      }

   }

   public void c() {
      this.h();
      if(!this.f()) {
         this.j();
      }

   }

   public Object d() {
      return this.b;
   }

   public d a() {
      return this.b;
   }

   public int k() {
      return this.c.a();
   }
}
