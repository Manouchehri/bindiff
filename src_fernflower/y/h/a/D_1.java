package y.h.a;

import y.h.a.G;
import y.h.a.v;

final class D extends G {
   private final v f;

   D(v var1, y.c.q var2) {
      super(var1, var2);
      this.f = var1;
      this.c = this.a(var2);
   }

   y.c.d a(y.c.q var1) {
      int var4 = v.a;
      y.c.d var2 = null;
      y.c.q var10000 = (y.c.q)v.e(this.f).b(var1);
      if(var1.b() > 0) {
         var2 = var1.i();
         var1 = var2.c();
         y.c.q var3 = (y.c.q)v.e(this.f).b(var1);

         while(var1.b() > 0 && (var3 == null || !this.f.j(var3))) {
            var2 = var1.i();
            var1 = var2.c();
            var3 = (y.c.q)v.e(this.f).b(var1);
            if(var4 != 0) {
               break;
            }
         }
      }

      return var2;
   }

   y.c.d a(y.c.d var1) {
      return var1.j();
   }

   void a() {
      int var2 = v.a;
      y.c.q var1;
      if(this.c == null) {
         if(this.b == this.a) {
            this.d = null;
            this.e = false;
            if(var2 == 0) {
               return;
            }
         }

         this.c = this.b;
         var1 = this.c.c();
         this.d = (y.c.q)v.e(this.f).b(var1);
         this.e = true;
         this.b = this.c.d().h();
         this.c = this.a(this.c);
         if(var2 == 0) {
            return;
         }
      }

      var1 = this.c.c();
      if(var1.b() > 0 && !this.f.j((y.c.q)v.e(this.f).b(var1))) {
         this.c = this.a(var1);
      }

      var1 = this.c.c();
      this.d = (y.c.q)v.e(this.f).b(var1);
      this.e = true;
      this.b = this.c.d().h();
      this.c = this.a(this.c);
   }
}
