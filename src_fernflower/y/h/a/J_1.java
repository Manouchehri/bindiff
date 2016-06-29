package y.h.a;

import y.h.a.G;
import y.h.a.v;

final class J extends G {
   private final v f;

   J(v var1, y.c.q var2) {
      super(var1, var2);
      this.f = var1;
      this.c = this.a(var2);
   }

   y.c.d a(y.c.q var1) {
      return var1.g();
   }

   y.c.d a(y.c.d var1) {
      return var1.h();
   }

   void a() {
      int var2 = v.a;

      y.c.d var10000;
      while(true) {
         if(this.c == null) {
            var10000 = this.b;
            if(var2 != 0) {
               break;
            }

            if(var10000 == this.a) {
               this.d = null;
               this.e = false;
               return;
            }

            this.c = this.b;
            this.b = this.c.d().f();
            this.c = this.a(this.c);
            if(var2 == 0) {
               continue;
            }
         }

         var10000 = this.c;
         break;
      }

      y.c.q var1 = var10000.c();
      this.d = (y.c.q)v.e(this.f).b(var1);
      this.e = true;
      if(var1.b() > 0 && !this.f.j(this.d)) {
         this.b = this.c;
         this.c = this.a(var1);
         if(var2 == 0) {
            return;
         }
      }

      this.c = this.a(this.c);
   }
}
