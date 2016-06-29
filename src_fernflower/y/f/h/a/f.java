package y.f.h.a;

import java.util.Iterator;
import y.f.h.a.b;
import y.f.h.a.g;
import y.f.h.a.m;
import y.f.h.a.o;

class f {
   private o a = new o((m)null, (o)null, (o)null);
   private o b;

   f() {
      this.b = new o((m)null, (o)null, this.a);
      this.a.a(0, this.b);
   }

   boolean a() {
      return this.a.a((o)null) == this.b;
   }

   void b() {
      this.a.a(0, this.b);
      this.a.a(1, (o)null);
      this.b.a(1, this.a);
      this.b.a(0, (o)null);
   }

   void c() {
      o var1 = this.a;
      this.a = this.b;
      this.b = var1;
   }

   public Iterator d() {
      return new g(this);
   }

   o a(m var1) {
      o var2 = new o(var1, (o)null, (o)null);
      this.a(var2);
      return var2;
   }

   void a(o var1) {
      o var2 = this.b.a((o)null).a(this.b);
      this.b.a((o)null).b(var2, var1);
   }

   o b(m var1) {
      o var2 = new o(var1, (o)null, (o)null);
      this.b(var2);
      return var2;
   }

   void b(o var1) {
      this.a.b((o)null, var1);
   }

   void a(f var1) {
      o var2 = this.b.a((o)null).a(this.b);
      this.b.a((o)null).a(var2, var1);
   }

   void b(f var1) {
      this.a.a((o)null, (f)var1);
   }

   void c(f var1) {
      var1.c();
      this.a(var1);
   }

   void d(f var1) {
      var1.c();
      this.b(var1);
   }

   o e() {
      return this.a.a((o)null);
   }

   o f() {
      return this.b.a((o)null);
   }

   m g() {
      return this.a.a((o)null).a();
   }

   m h() {
      return this.b.a((o)null).a();
   }

   void c(o var1) {
      this.b.a((o)null).a(this.b, var1);
   }

   void d(o var1) {
      this.a.a((o)null).a(this.a, var1);
   }

   m c(m var1) {
      if(!this.a()) {
         if(this.a.a((o)null).a() == var1) {
            return this.b.a((o)null).a();
         } else if(this.b.a((o)null).a() == var1) {
            return this.a.a((o)null).a();
         } else {
            throw new RuntimeException("Element " + var1.toString() + " is not at one of the ends of the list " + this.toString() + "!");
         }
      } else {
         throw new RuntimeException("Cannot search for the opposite element if list is empty!");
      }
   }

   boolean i() {
      return !this.a() && this.a.a((o)null).a() != this.b.a((o)null).a();
   }

   public String toString() {
      boolean var3 = b.g;
      String var1 = "[";
      Iterator var2 = this.d();

      String var10000;
      while(true) {
         if(var2.hasNext()) {
            var10000 = var1;
            if(var3) {
               break;
            }

            if(var1 != "[") {
               var1 = var1 + ", ";
            }

            var1 = var1 + "(" + var2.next().toString() + ")";
            if(!var3) {
               continue;
            }
         }

         var10000 = var1 + "]";
         break;
      }

      return var10000;
   }

   static o e(f var0) {
      return var0.a;
   }

   static o f(f var0) {
      return var0.b;
   }
}
