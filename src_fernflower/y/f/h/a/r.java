package y.f.h.a;

import y.f.h.a.f;
import y.f.h.a.m;
import y.f.h.a.n;
import y.f.h.a.o;

abstract class r {
   f a = new f();

   abstract String a();

   f r() {
      return this.a;
   }

   m c(m var1) {
      return this.a.c(var1);
   }

   m s() {
      return this.a.g();
   }

   m f(int var1) {
      return var1 == 0?this.a.g():this.a.h();
   }

   int a(m var1, int var2) {
      if(!this.a.i()) {
         return var2;
      } else if(this.a.g() == var1) {
         return 0;
      } else if(this.a.h() == var1) {
         return 1;
      } else {
         throw new RuntimeException("Edge " + var1.toString() + " not adjacent to the node" + this.toString() + "!");
      }
   }

   m t() {
      return this.a.g().c()?this.a.e().b().a():(this.a.h().c()?this.a.f().b().a():null);
   }

   boolean u() {
      return this.a.i();
   }

   o d(m var1) {
      return this.a.a(var1);
   }

   o e(m var1) {
      return this.a.b(var1);
   }

   abstract int f();

   boolean g() {
      return false;
   }

   abstract n b();
}
