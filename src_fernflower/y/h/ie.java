package y.h;

import y.h.aB;
import y.h.bu;
import y.h.fj;
import y.h.x;
import y.h.y;

class ie implements y {
   y.c.e a;
   y b;
   x c;
   bu d;

   ie(bu var1) {
      this.d = var1;
      this.a = var1.p();
      this.i();
   }

   public Object d() {
      return this.c;
   }

   public x a() {
      return this.c;
   }

   public void i() {
      boolean var2 = fj.z;
      this.a.i();

      while(this.a.f()) {
         aB var1 = this.d.i(this.a.a());
         if(var1.bendCount() > 0) {
            this.b = var1.bends();
            this.c = this.b.a();
            return;
         }

         this.c = null;
         this.a.g();
         if(var2) {
            break;
         }
      }

   }

   public void j() {
      boolean var2 = fj.z;
      this.a.j();

      while(this.a.f()) {
         aB var1 = this.d.i(this.a.a());
         if(var1.bendCount() > 0) {
            this.b = var1.bends();
            this.b.j();
            this.c = this.b.a();
            return;
         }

         this.c = null;
         this.a.h();
         if(var2) {
            break;
         }
      }

   }

   public void g() {
      boolean var2 = fj.z;
      this.b.g();
      if(this.b.f()) {
         this.c = this.b.a();
         if(!var2) {
            return;
         }
      }

      this.a.g();

      while(this.a.f()) {
         aB var1 = this.d.i(this.a.a());
         if(var2) {
            return;
         }

         if(var1.bendCount() > 0) {
            this.b = var1.bends();
            this.c = this.b.a();
            return;
         }

         this.a.g();
         if(var2) {
            break;
         }
      }

      this.c = null;
   }

   public void h() {
      boolean var2 = fj.z;
      this.b.h();
      if(this.b.f()) {
         this.c = this.b.a();
         if(!var2) {
            return;
         }
      }

      this.a.h();

      while(this.a.f()) {
         aB var1 = this.d.i(this.a.a());
         if(var2) {
            return;
         }

         if(var1.bendCount() > 0) {
            this.b = var1.bends();
            this.b.j();
            this.c = this.b.a();
            return;
         }

         this.a.h();
         if(var2) {
            break;
         }
      }

      this.c = null;
   }

   public boolean f() {
      return this.c != null;
   }

   public int k() {
      throw new UnsupportedOperationException();
   }
}
