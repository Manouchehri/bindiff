package y.h;

import y.h.bu;
import y.h.fj;
import y.h.hO;

final class X extends hO {
   private final y.c.e a;
   private final boolean b;

   X(bu var1, int var2, boolean var3) {
      super(var1, var2);
      this.a = var1.p();
      this.b = var3;
      if(!var3) {
         this.a.j();
      }

   }

   void a() {
      boolean var2 = fj.z;

      while(this.f.isEmpty() && this.a.f()) {
         y.c.d var1 = this.a.a();
         if(this.b) {
            this.a.g();
            this.a(var1);
            if(!var2) {
               continue;
            }
         }

         this.a.h();
         this.b(var1);
         if(var2) {
            break;
         }
      }

   }
}
